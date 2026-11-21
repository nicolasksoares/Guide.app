package app.guide.compartilhado.config;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.EnvironmentPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

/**
 * Carrega o {@code .env} do projeto quando a API roda fora do Docker (ex.: {@code ./mvnw spring-boot:run}
 * dentro de {@code backend/}). Procura o arquivo na pasta atual e na pasta acima.
 *
 * <p>Os valores entram com a <b>menor prioridade</b>: variáveis de ambiente reais e propriedades
 * passadas na linha de comando sempre vencem. Dentro do Docker não há {@code .env}, então nada muda.
 *
 * <p>Registrado em {@code META-INF/spring.factories}.
 */
public class DotenvEnvironmentPostProcessor implements EnvironmentPostProcessor {

    static final String NOME_FONTE = "dotenv";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Path pastaAtual = Path.of(System.getProperty("user.dir"));
        localizar(pastaAtual).ifPresent(arquivo -> {
            Map<String, String> valores = LeitorDotenv.ler(lerLinhas(arquivo));
            environment.getPropertySources()
                    .addLast(new MapPropertySource(NOME_FONTE, Map.copyOf(valores)));
        });
    }

    static Optional<Path> localizar(Path pastaAtual) {
        Path naPasta = pastaAtual.resolve(".env");
        if (Files.isRegularFile(naPasta)) {
            return Optional.of(naPasta);
        }
        Path pai = pastaAtual.getParent();
        if (pai != null && Files.isRegularFile(pai.resolve(".env"))) {
            return Optional.of(pai.resolve(".env"));
        }
        return Optional.empty();
    }

    private static List<String> lerLinhas(Path arquivo) {
        try {
            return Files.readAllLines(arquivo, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException("Não foi possível ler " + arquivo, e);
        }
    }
}
