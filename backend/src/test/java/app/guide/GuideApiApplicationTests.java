package app.guide;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Sobe a aplicação inteira contra um PostGIS real (Testcontainers).
 * Sem Docker na máquina, o teste é pulado em vez de falhar.
 */
@Testcontainers(disabledWithoutDocker = true)
@Import(TestcontainersConfiguration.class)
@SpringBootTest
class GuideApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
