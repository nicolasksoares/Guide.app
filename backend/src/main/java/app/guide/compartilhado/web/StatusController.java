package app.guide.compartilhado.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint simples para o front-end confirmar que a API está no ar.
 * A saúde detalhada (inclusive do banco) fica em /actuator/health.
 */
@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final String nomeAplicacao;

    public StatusController(@Value("${spring.application.name}") String nomeAplicacao) {
        this.nomeAplicacao = nomeAplicacao;
    }

    @GetMapping
    public StatusResponse status() {
        return new StatusResponse(nomeAplicacao, "ok");
    }

    public record StatusResponse(String aplicacao, String status) {
    }
}
