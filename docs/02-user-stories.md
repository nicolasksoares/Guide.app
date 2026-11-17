# 02 · User Stories

> Status: 🟡 Rascunho. Duas histórias por [persona](02-personas.md), no formato do template Google UX.
> Versão para apresentar: [`ux/user-stories.pptx`](ux/user-stories.pptx).

**Formato:** *Como* [tipo de usuário], *eu quero* [ação], *para que* [benefício].

## Resumo

| ID | Persona | História | Requisitos | Cobertura |
|----|---------|----------|------------|-----------|
| US-01 | Lucas | Entrar num grupo pequeno de pessoas parecidas para ir a um rolê | RF-14, RF-20 | ✅ |
| US-02 | Lucas | Ver os rolês da semana ordenados pelo que combina comigo | RF-03, RF-04, RF-12 | ✅ |
| US-03 | Marina | Escolher entre poucos rolês curados por semana | RF-11, RF-12, RF-13 | ✅ |
| US-04 | Marina | Marcar quem do grupo eu gostaria de rever | RF-31, RF-50 | ✅ |
| US-05 | Júlia | Participar apenas de grupos só de mulheres | RF-47, RF-16 | ⚠️ Parcial |
| US-06 | Júlia | Ver nome, foto e interesses do grupo sem expor meu contato | RF-49, RF-51, RF-52 | ✅ |
| US-07 | Rafael | Ver o preço total e o que está incluso antes de me inscrever | RF-13 | ✅ |
| US-08 | Rafael | Ser avisado quando abrirem rolês compatíveis comigo | RF-38 | ⚠️ Parcial |
| US-09 | Thiago | Indicar que prefiro rolês tranquilos com gente da minha idade | RF-04, RF-20 | ⚠️ Parcial |
| US-10 | Thiago | Receber sugestão de assunto quando o chat abrir | RF-26 (P1) | ⚠️ Fora do lançamento |
| US-11 | Bruno | Saber quais dados meus são guardados, por quem e por quanto tempo | RNF-09 | ❌ Lacuna |
| US-12 | Bruno | Me inscrever num rolê junto com um amigo de confiança | — | ❌ Lacuna |

---

## 🧳 Lucas Andrade · o recém-chegado

### US-01
**Como** recém-chegado na cidade, **eu quero** entrar num grupo pequeno de pessoas com interesses parecidos para ir a um rolê, **para que** eu não precise sair sozinho e consiga fazer amigos.

**Critérios de aceite**
- Ao me inscrever num rolê, sou colocado em um grupo de 4 a 6 pessoas.
- O grupo é formado no prazo definido antes do rolê e eu sou avisado quando isso acontece.
- Os membros do grupo têm interesses e vibe compatíveis com os meus.

### US-02
**Como** recém-chegado na cidade, **eu quero** ver os rolês da semana ordenados pelo que combina comigo, **para que** eu descubra a cidade sem precisar pesquisar em vários lugares.

**Critérios de aceite**
- Depois do onboarding, a tela inicial mostra os rolês da semana.
- Os rolês aparecem do mais para o menos compatível com meus interesses e minha vibe.
- Só aparecem rolês futuros, ativos e com vagas.

---

## 🎨 Marina Costa · quem quer sair da bolha

### US-03
**Como** frequentadora que quer sair da rotina, **eu quero** escolher entre poucos rolês curados por semana, **para que** eu viva experiências novas sem perder tempo garimpando.

**Critérios de aceite**
- A semana tem uma lista curta de rolês (2 a 3 no MVP), cadastrados pela curadoria.
- Cada rolê mostra descrição, data, bairro, categoria e vibe.

### US-04
**Como** usuária que acabou de voltar de um rolê, **eu quero** marcar quais pessoas do grupo eu gostaria de rever, **para que** eu mantenha contato só com quem também quiser manter comigo.

**Critérios de aceite**
- Na avaliação pós-rolê, posso marcar "quero manter contato" em cada participante.
- O contato só é liberado quando os dois lados marcam.
- Quem não marcou não fica sabendo que eu marquei.

---

## 🛡️ Júlia Ribeiro · quem só vai se for seguro

### US-05
**Como** mulher que tem receio de encontrar desconhecidos, **eu quero** participar apenas de grupos formados só por mulheres, **para que** eu me sinta mais segura no primeiro encontro.

**Critérios de aceite**
- No perfil, posso ativar a preferência "só grupos de mulheres".
- Com a preferência ativa, nunca sou colocada em grupo com homens.
- Se não houver mulheres suficientes num rolê, sou avisada antes do prazo e recebo reembolso.

> ⚠️ **Lacuna:** RF-16 reembolsa quando o rolê não atinge o mínimo de inscritos no total, mas **não** quando falta gente para formar um grupo só de mulheres.

### US-06
**Como** participante de um rolê, **eu quero** ver primeiro nome, foto e interesses do grupo sem expor meu contato, **para que** eu saiba com quem vou estar sem abrir mão da minha privacidade.

**Critérios de aceite**
- Depois que o grupo é formado, vejo primeiro nome, foto e interesses de cada membro.
- Sobrenome, telefone e redes sociais não aparecem para ninguém.
- O endereço exato do rolê só aparece para quem está no grupo.

---

## 🎉 Rafael Souza · o extrovertido de orçamento curto

### US-07
**Como** estudante com orçamento curto, **eu quero** ver o preço total e o que está incluso antes de me inscrever, **para que** eu planeje meus gastos sem ter surpresa no dia.

**Critérios de aceite**
- O detalhe do rolê mostra o preço final e o que ele inclui (ex.: entrada, drink).
- Fica claro se há custos extras no local.
- A política de cancelamento, reembolso e taxa de no-show aparece antes do pagamento.

### US-08
**Como** usuário que costuma descobrir eventos tarde, **eu quero** ser avisado quando abrirem rolês da semana compatíveis comigo, **para que** eu garanta minha vaga antes de esgotar.

**Critérios de aceite**
- Recebo uma notificação quando os rolês da semana são publicados.
- A notificação destaca o rolê mais compatível com meu perfil.
- Posso desligar esse aviso nas configurações.

> ⚠️ **Lacuna:** RF-38 cobre notificações de grupo formado, chat, lembrete e avaliação, mas **não** a abertura de rolês novos.

---

## 🎧 Thiago Martins · o introvertido recomeçando

### US-09
**Como** pessoa introvertida, **eu quero** indicar que prefiro rolês tranquilos com gente da minha faixa de idade, **para que** eu caia em grupos onde me sinta à vontade.

**Critérios de aceite**
- No onboarding e no perfil, indico minha energia (tranquilo ↔ agitado).
- Posso indicar a faixa de idade preferida para o grupo.
- A montagem dos grupos considera essas preferências.

> ⚠️ **Lacuna:** RF-04 registra a vibe, mas **não** a preferência de faixa de idade.

### US-10
**Como** pessoa tímida, **eu quero** receber uma sugestão de assunto quando o chat do grupo abrir, **para que** puxar conversa com desconhecidos fique mais fácil.

**Critérios de aceite**
- Quando o chat abre, aparece um quebra-gelo baseado nos interesses em comum do grupo.
- O quebra-gelo não expõe nenhuma informação privada dos membros.

> ⚠️ RF-26 está como **P1** (depois do lançamento). Duas personas pedem isso; vale reavaliar a prioridade.

---

## 🚫 Bruno Carvalho · o cético que já foi vítima

### US-11
**Como** pessoa que já teve dados usados num golpe, **eu quero** saber quais dados meus são guardados, por quem e por quanto tempo, **para que** eu decida, antes da verificação, se confio no app.

**Critérios de aceite**
- Antes de enviar documento e selfie, vejo em linguagem simples: o que é coletado, quem processa, onde fica e por quanto tempo.
- Fica claro se o app guarda o documento ou só o resultado da verificação.
- Posso desistir nesse ponto sem que nenhum dado tenha sido enviado.

> ❌ **Lacuna:** nenhum RF cobre essa transparência. RNF-09 protege o dado, mas não explica nada ao usuário.

### US-12
**Como** pessoa que só sai com quem conhece, **eu quero** me inscrever num rolê junto com um amigo de confiança, **para que** eu tenha alguém conhecido no grupo.

**Critérios de aceite**
- Ao me inscrever, posso convidar um amigo que também tenha conta verificada.
- Nós dois caímos no mesmo grupo.
- O grupo continua com 4 a 6 pessoas e respeita as regras de segurança.

> ❌ **Lacuna:** não existe. Mexe na montagem de grupos (duplas reduzem a mistura) e precisa de decisão do cliente.

---

## Lacunas que as histórias revelaram

| Lacuna | História | Ação sugerida |
|--------|----------|---------------|
| Reembolso quando não fecha grupo só de mulheres | US-05 | Ampliar RF-16 |
| Aviso de rolês novos | US-08 | Ampliar RF-38 |
| Preferência de faixa de idade no grupo | US-09 | Novo RF na seção Conta e perfil |
| Quebra-gelo só depois do lançamento | US-10 | Avaliar RF-26 de P1 para P0 |
| Transparência sobre dados antes da verificação | US-11 | Novo RF de segurança |
| Inscrição em dupla | US-12 | Decisão do cliente; se aprovado, novo RF de grupos |

> Nenhuma dessas lacunas foi levada para o kanban ou para os requisitos ainda.
