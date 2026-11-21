# Documentação — Guide.app (MVP)

A documentação vem **antes do código**. Cada etapa usa a anterior como base.

## Documentos atuais

| Documento | Status | Conteúdo |
|-----------|--------|----------|
| [01 · Visão do produto](01-visao-produto.md) | 🟡 Rascunho v2 | Problema, pesquisa de mercado, diferencial, público, ciclo do produto, escopo do MVP, modelo de negócio, riscos e stack. |
| [Personas](ux/personas.pptx), [User Stories](ux/user-stories.pptx), [Journey Maps](ux/journey-maps.pptx) e [User Flow](ux/user-flow.pptx) (slides) | 🟡 Rascunho | **Fonte da verdade** de UX: 6 personas, 12 histórias, 6 jornadas atuais (sem o app) e 2 fluxos do MVP, nos templates Google UX. |
| [04 · Requisitos](04-requisitos.md) | 🟡 Rascunho v2 | **Fonte da verdade** dos requisitos: 54 funcionais e 17 não funcionais, com prioridade P0/P1. O [kanban](https://github.com/users/nicolasksoares/projects/9) acompanha só o andamento. |
| [Segurança do usuário](seguranca.md) | 🟡 Rascunho | 5 camadas de proteção, protocolo de incidente, LGPD. Origem dos requisitos RF-40 a RF-64. |
| [Perguntas para o cliente](perguntas-cliente.md) | ⏳ Temporário | Decisões em aberto para a próxima reunião. Depois dela, vira `decisoes.md`. |

## Roteiro

A numeração segue a ordem de produção. Os números que faltam são as próximas etapas.

| # | Etapa | Status |
|---|-------|--------|
| 01 | Visão do produto | 🟡 |
| 02 | Personas · User Stories · Journey Maps · User Flow (templates Google UX) | 🟡 Pronto, aguardando validação |
| 03 | Competitive Audit (templates Google UX) | ⚪ |
| 04 | Requisitos funcionais e não funcionais | 🟡 |
| 05 | Diagrama de casos de uso | ⚪ |
| 06 | BPMN: onboarding, inscrição + montagem de grupo, denúncia | ⚪ |
| 07 | Protótipo no Figma | ⚪ |
| 08 | UML: classes, modelo ER, sequência da montagem de grupos | ⚪ |
| 09 | Arquitetura (C4) e decisões técnicas (ADRs) | ⚪ |

## Convenções

- **Uma fonte da verdade por assunto.** UX/UI nos arquivos de design (`ux/*.pptx`, depois Figma), requisitos no `04-requisitos.md`, andamento no kanban. Markdown só para produto e engenharia.
- Diagramas em **Mermaid** dentro do Markdown sempre que possível. BPMN em `.bpmn` (bpmn.io / Camunda Modeler).
- IDs rastreáveis: `US-xx` (história) → `RF-xx` / `RNF-xx` (requisito) → `UC-xx` (caso de uso). Medidas de segurança: `SEG-xx`.
- Status: ⚪ a fazer · 🟡 rascunho · 🟢 validado com o cliente.

## Protótipo original

O PDF de protótipos do cliente fica só localmente em `docs/legado/` (no `.gitignore`, 18 MB) e deve ser compartilhado por Drive. Serve apenas como referência do que foi imaginado antes da v2.
