package app.guide.compartilhado.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Lê linhas de um arquivo {@code .env} com as mesmas regras do Docker Compose, para que a API
 * rodando fora do Docker enxergue exatamente os mesmos valores que os containers.
 *
 * <ul>
 *   <li>linhas vazias e linhas que começam com {@code #} são ignoradas;</li>
 *   <li>o prefixo {@code export } é aceito e descartado;</li>
 *   <li>entre aspas duplas, as aspas saem e os escapes {@code \n \r \t \" \\} são interpretados;</li>
 *   <li>entre aspas simples, as aspas saem e o conteúdo é literal;</li>
 *   <li>sem aspas, um comentário no fim da linha ({@code  # ...}) é removido, assim como os espaços.</li>
 * </ul>
 */
public final class LeitorDotenv {

    private LeitorDotenv() {
    }

    public static Map<String, String> ler(List<String> linhas) {
        Map<String, String> valores = new LinkedHashMap<>();
        for (String bruta : linhas) {
            String linha = bruta.replace("﻿", "").trim();
            if (linha.isEmpty() || linha.startsWith("#")) {
                continue;
            }
            if (linha.startsWith("export ")) {
                linha = linha.substring("export ".length()).trim();
            }
            int igual = linha.indexOf('=');
            if (igual <= 0) {
                continue;
            }
            String chave = linha.substring(0, igual).trim();
            String valor = linha.substring(igual + 1).trim();
            valores.put(chave, interpretar(valor));
        }
        return valores;
    }

    private static String interpretar(String valor) {
        if (valor.startsWith("\"")) {
            return entreAspasDuplas(valor);
        }
        if (valor.startsWith("'")) {
            int fim = valor.indexOf('\'', 1);
            return fim < 0 ? valor.substring(1) : valor.substring(1, fim);
        }
        return semAspas(valor);
    }

    private static String entreAspasDuplas(String valor) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i < valor.length(); i++) {
            char c = valor.charAt(i);
            if (c == '"') {
                break;
            }
            if (c == '\\' && i + 1 < valor.length()) {
                char proximo = valor.charAt(++i);
                switch (proximo) {
                    case 'n' -> resultado.append('\n');
                    case 'r' -> resultado.append('\r');
                    case 't' -> resultado.append('\t');
                    case '"', '\\' -> resultado.append(proximo);
                    default -> resultado.append('\\').append(proximo);
                }
                continue;
            }
            resultado.append(c);
        }
        return resultado.toString();
    }

    private static String semAspas(String valor) {
        for (int i = 1; i < valor.length(); i++) {
            if (valor.charAt(i) == '#' && Character.isWhitespace(valor.charAt(i - 1))) {
                return valor.substring(0, i).trim();
            }
        }
        return valor;
    }
}
