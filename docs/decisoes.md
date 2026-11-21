# Decisões do projeto

Registro curto das decisões já tomadas: o que foi decidido, por quê e o que muda. Decisões novas entram no topo.

| ID | Data | Decisão | Quem decidiu |
|----|------|---------|--------------|
| D-03 | 21/11/2026 | Exclusão de conta = **anonimização**, nunca apagar | Time |
| D-02 | 21/11/2026 | Diagramas em draw.io + PDF; UX nos templates Google UX | Time |
| D-01 | 21/11/2026 | Conceito "rolê com gente nova" aprovado | Cliente |

---

## D-03 · Exclusão de conta é anonimização

**Contexto.** A LGPD garante ao usuário o direito de excluir a conta (RF-06). Ao mesmo tempo, os dados de uso (inscrições, presença, avaliações, grupos) são a base dos KPIs e de uma IA de métricas no futuro.

**Decisão.** Quando o usuário pede para sair, a conta é **anonimizada de forma irreversível**; nenhuma linha é apagada.

| O que acontece | Campos |
|----------------|--------|
| Apagado (vira nulo) | nome¹, e-mail, telefone, senha, foto, CPF² |
| Reduzido | data de nascimento → só o ano |
| Mantido | gênero, perfil (interesses e vibe), inscrições, presença, avaliações, pagamentos, interações |
| Marcado | `status = ANONIMIZADA`, `anonimizado_em` |

¹ O nome vira "Usuário anonimizado".
² O hash do CPF é mantido **apenas** para contas banidas, para impedir que a pessoa volte (legítimo interesse, SEG-04).

**Consequências no modelo.**
- Nenhuma chave estrangeira usa `ON DELETE CASCADE`. Usuários nunca são apagados do banco.
- Colunas de dados pessoais em `usuarios` passam a aceitar nulo, com um `CHECK` exigindo que estejam preenchidas enquanto a conta não estiver anonimizada.
- O CPF é guardado como **HMAC-SHA256 com chave secreta**, não como hash simples. Hash simples de CPF pode ser revertido testando todos os CPFs possíveis.
- Sessões e inscrições de push do usuário são revogadas na anonimização.

**Ponto de atenção.** Textos livres (mensagens de chat, comentários de avaliação, descrição de denúncia) podem conter dados pessoais. Precisam de prazo de retenção definido com o advogado.

---

## D-02 · Formato dos artefatos

UX/UI nos templates Google UX (`ux/*.pptx`, depois Figma). Diagramas técnicos em draw.io com PDF ao lado (`diagramas/`). Markdown só para produto e engenharia.

## D-01 · Conceito aprovado

O cliente aprovou o conceito da [visão do produto v2](01-visao-produto.md): rolês curados em grupo de 4 a 6 pessoas compatíveis, mais identidade de rolê.

---

## Em aberto

| Tema | Origem | Impacto |
|------|--------|---------|
| Reembolso quando não fecha grupo só de mulheres | US-05 | BPMN 4, `StatusInscricao.NAO_ALOCADA` |
| App guarda só o resultado da verificação de identidade | US-11 | BPMN 2, `verificacoes_identidade` |
| Inscrição em dupla com um amigo | US-12 | Montagem de grupos, ainda fora dos diagramas |
| Prazo de retenção de textos livres | D-03 | Rotina de limpeza no banco |
