package app.guide.compartilhado.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/** As regras precisam bater com as do Docker Compose, senão API e banco enxergam senhas diferentes. */
class LeitorDotenvTest {

    private static Map<String, String> ler(String... linhas) {
        return LeitorDotenv.ler(List.of(linhas));
    }

    @Test
    void valorSemAspas() {
        assertThat(ler("DB_PASSWORD=segredo")).containsEntry("DB_PASSWORD", "segredo");
    }

    @Test
    void aspasDuplasSaoRemovidas() {
        assertThat(ler("DB_PASSWORD=\"segredo\"")).containsEntry("DB_PASSWORD", "segredo");
    }

    @Test
    void aspasSimplesSaoRemovidasEOConteudoELiteral() {
        assertThat(ler("DB_PASSWORD='a\\nb #c'")).containsEntry("DB_PASSWORD", "a\\nb #c");
    }

    @Test
    void escapesEntreAspasDuplas() {
        assertThat(ler("V=\"linha1\\nlinha2 \\\"citado\\\" barra\\\\\""))
                .containsEntry("V", "linha1\nlinha2 \"citado\" barra\\");
    }

    @Test
    void comentarioNoFimDaLinhaSoValeSemAspas() {
        assertThat(ler("A=valor # comentario", "B=\"valor # nao e comentario\"", "C=senha#sem-espaco"))
                .containsEntry("A", "valor")
                .containsEntry("B", "valor # nao e comentario")
                .containsEntry("C", "senha#sem-espaco");
    }

    @Test
    void ignoraComentariosLinhasVaziasELinhasSemIgual() {
        assertThat(ler("# comentario", "", "   ", "SEM_IGUAL", "=sem_chave", "OK=1"))
                .containsOnlyKeys("OK");
    }

    @Test
    void aceitaPrefixoExportEEspacosEmVolta() {
        assertThat(ler("export  DB_USER = guide  ")).containsEntry("DB_USER", "guide");
    }

    @Test
    void sinalDeIgualNoValorEValorVazio() {
        assertThat(ler("URL=jdbc:postgresql://h:5433/db?a=b", "VAZIO="))
                .containsEntry("URL", "jdbc:postgresql://h:5433/db?a=b")
                .containsEntry("VAZIO", "");
    }

    @Test
    void ultimaDefinicaoVence() {
        assertThat(ler("A=1", "A=2")).containsEntry("A", "2");
    }
}
