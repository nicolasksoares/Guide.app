# Documentação — Guide.app (MVP)

A documentação vem **antes do código**. Cada etapa usa a anterior como base.

## Documentos atuais

| Documento | Status | Conteúdo |
|-----------|--------|----------|
| [01 · Visão do produto](01-visao-produto.md) | 🟡 Rascunho v2 | Problema, pesquisa de mercado, diferencial, público, ciclo do produto, escopo do MVP, modelo de negócio, riscos e stack. |
| [Personas](ux/personas.pptx), [User Stories](ux/user-stories.pptx), [Journey Maps](ux/journey-maps.pptx) e [User Flow](ux/user-flow.pptx) (slides) | 🟡 Rascunho | **Fonte da verdade** de UX: 6 personas, 12 histórias, 6 jornadas atuais (sem o app) e 2 fluxos do MVP, nos templates Google UX. |
| [04 · Requisitos](04-requisitos.md) | 🟡 Rascunho v2 | **Fonte da verdade** dos requisitos: 54 funcionais e 17 não funcionais, com prioridade P0/P1. O [kanban](https://github.com/users/nicolasksoares/projects/9) acompanha só o andamento. |
| [BPMN do MVP](diagramas/bpmn-mvp.pdf) ([editável](diagramas/bpmn-mvp.drawio)) | 🟡 Rascunho | BPMN 2.0 em 6 páginas: visão geral + cadastro e verificação, inscrição e pagamento, montagem de grupo, rolê e pós-rolê, denúncia e moderação. Cada tarefa cita o requisito que atende. |
| [Classes UML](diagramas/classes-mvp.pdf) ([editável](diagramas/classes-mvp.drawio)) | 🟡 Rascunho | 22 classes e 16 enumerações, agrupadas nos pacotes dos módulos do back-end, com multiplicidades, composições e a interface `MontadorDeGrupos`. |
| [Banco de dados](diagramas/banco-mvp.pdf) ([editável](diagramas/banco-mvp.drawio)) | 🟡 Rascunho | Modelo físico em PostgreSQL 17 + PostGIS: 22 tabelas com tipos, PK/FK/UQ, checks, índices e cardinalidade (pé de galinha). Base para as migrações Flyway. |
| [Segurança do usuário](seguranca.md) | 🟡 Rascunho | 5 camadas de proteção, protocolo de incidente, LGPD. Origem dos requisitos RF-40 a RF-64. |
| [Decisões](decisoes.md) | 🟢 Vivo | Registro das decisões tomadas (D-01 a D-03) e do que ainda está em aberto. |

## Roteiro

A numeração segue a ordem de produção. Os números que faltam são as próximas etapas.

| # | Etapa | Status |
|---|-------|--------|
| 01 | Visão do produto | 🟡 |
| 02 | Personas · User Stories · Journey Maps · User Flow (templates Google UX) | 🟡 Pronto, aguardando validação |
| 03 | Competitive Audit (templates Google UX) | ⚪ |
| 04 | Requisitos funcionais e não funcionais | 🟡 |
| 05 | Diagrama de casos de uso | ⚪ |
| 06 | BPMN: visão geral + 5 subprocessos | 🟡 Pronto, aguardando validação |
| 07 | Protótipo no Figma | ⚪ |
| 08 | UML: classes ✅ · modelo do banco ✅ · sequência da montagem de grupos ⚪ | 🟡 Classes e banco prontos |
| 09 | Arquitetura (C4) e decisões técnicas (ADRs) | ⚪ |

## Convenções

- **Uma fonte da verdade por assunto.** UX/UI nos arquivos de design (`ux/*.pptx`, depois Figma), requisitos no `04-requisitos.md`, andamento no kanban. Markdown só para produto e engenharia.
- Diagramas em **draw.io** (`diagramas/*.drawio`, editável no diagrams.net ou no app desktop) com exportação em **PDF** ao lado, para apresentar. Notações: BPMN 2.0, UML e diagrama entidade-relacionamento.
- IDs rastreáveis: `US-xx` (história) → `RF-xx` / `RNF-xx` (requisito) → `UC-xx` (caso de uso). Medidas de segurança: `SEG-xx`.
- Status: ⚪ a fazer · 🟡 rascunho · 🟢 validado com o cliente.

## Como rodar o projeto

| Pasta | O que é |
|-------|---------|
| `backend/` | API em Java 21 + Spring Boot 4.2 (Maven Wrapper). Um pacote por módulo de domínio em `app.guide.*`. |
| `frontend/` | PWA em React + TypeScript + Vite + Tailwind CSS 4. |
| `docker-compose.yml` | Banco PostgreSQL 17 + PostGIS, API e front-end. |

**Tudo junto (precisa de Docker):**

```bash
docker compose up --build
```

Front-end em http://localhost:5173 · API em http://localhost:8080/api/status · saúde em http://localhost:8080/actuator/health.

**Separado, para desenvolver:**

```bash
cd backend && ./mvnw spring-boot:run      # precisa do banco: docker compose up db
cd frontend && npm install && npm run dev # /api é encaminhado para localhost:8080
```

**Testes:** `cd backend && ./mvnw test`. O teste que sobe a aplicação inteira usa Testcontainers (PostGIS real) e é **pulado** quando não há Docker na máquina.

## Protótipo original

O PDF de protótipos do cliente fica só localmente em `docs/legado/` (no `.gitignore`, 18 MB) e deve ser compartilhado por Drive. Serve apenas como referência do que foi imaginado antes da v2.
