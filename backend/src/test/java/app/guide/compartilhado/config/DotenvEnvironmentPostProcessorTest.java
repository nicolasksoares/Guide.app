package app.guide.compartilhado.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class DotenvEnvironmentPostProcessorTest {

    @TempDir
    Path raiz;

    @Test
    void encontraOEnvNaPastaDeCimaQuandoRodaDeDentroDeBackend() throws IOException {
        Path backend = Files.createDirectory(raiz.resolve("backend"));
        Files.writeString(raiz.resolve(".env"), "A=1");

        assertThat(DotenvEnvironmentPostProcessor.localizar(backend)).contains(raiz.resolve(".env"));
    }

    @Test
    void prefereOEnvDaPastaAtual() throws IOException {
        Path backend = Files.createDirectory(raiz.resolve("backend"));
        Files.writeString(raiz.resolve(".env"), "A=1");
        Files.writeString(backend.resolve(".env"), "A=2");

        assertThat(DotenvEnvironmentPostProcessor.localizar(backend)).contains(backend.resolve(".env"));
    }

    @Test
    void semEnvNaoFazNada() throws IOException {
        Path backend = Files.createDirectory(raiz.resolve("backend"));

        assertThat(DotenvEnvironmentPostProcessor.localizar(backend)).isEmpty();
    }
}
