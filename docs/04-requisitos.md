# 04 · Requisitos Funcionais e Não Funcionais

> Status: 🟡 Rascunho v2 — alinhado à [Visão do produto v2](01-visao-produto.md) (rolês em grupo + identidade de rolê) e ao [documento de segurança](seguranca.md).
> Prioridade: **P0** = obrigatório no lançamento do MVP · **P1** = logo após o lançamento.
> A coluna *Origem* aponta para a visão do produto (V2), o documento de segurança (SEG) e as [user stories](ux/user-stories.pptx) (US) que cada requisito atende.
> Cada requisito é um card no [kanban do MVP](https://github.com/users/nicolasksoares/projects/9).

## Requisitos Funcionais (RF)

### Conta e perfil

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-01 | O sistema deve permitir cadastro com nome, e-mail, senha, data de nascimento, CPF e telefone. | P0 | V2 |
| RF-02 | O sistema deve autenticar usuários e manter sessão via token (JWT), com papéis de usuário e admin. | P0 | V2 |
| RF-03 | O onboarding deve exigir a escolha de no mínimo 3 categorias de interesse. | P0 | V2, US-02 |
| RF-04 | O onboarding deve registrar a vibe do usuário: energia (tranquilo ↔ agitado), faixa de preço, introvertido ↔ extrovertido e dias/horários preferidos. | P0 | V2, US-02, US-09 |
| RF-05 | O usuário deve poder editar interesses, vibe e foto a qualquer momento. | P0 | V2 |
| RF-06 | O usuário deve poder exportar seus dados e excluir a conta. | P0 | V2 (LGPD) |

### Rolês

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-10 | O admin deve poder cadastrar locais com nome, endereço e coordenadas geográficas. | P0 | V2 |
| RF-11 | O admin deve poder cadastrar rolês com: evento, local, data/hora, preço, capacidade, mínimo de inscritos, categorias e tags de vibe. | P0 | V2, US-03 |
| RF-12 | O sistema deve listar os rolês da semana ordenados por compatibilidade com o perfil do usuário. | P0 | V2, US-02, US-03 |
| RF-13 | O usuário deve ver o detalhe do rolê: descrição, data/hora, bairro, preço, vagas restantes e o que está incluso. | P0 | V2, US-03, US-07 |
| RF-14 | O usuário deve poder se inscrever em um rolê e pagar pelo app, via gateway de pagamento. | P0 | V2, US-01 |
| RF-15 | O usuário deve poder cancelar a inscrição com reembolso até um prazo definido antes do rolê. | P0 | V2 |
| RF-16 | Se um rolê não atingir o mínimo de inscritos no prazo, o sistema deve cancelá-lo e reembolsar os inscritos automaticamente. | P0 | V2, US-05 |
| RF-17 | O usuário deve poder pedir "me surpreenda" e ser inscrito no rolê da semana mais compatível com o perfil. | P1 | V2 |

### Grupos

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-20 | O sistema deve montar automaticamente grupos de 4–6 pessoas por rolê, maximizando a compatibilidade de interesses e vibe e respeitando as regras de segurança (RF-45 a RF-48). | P0 | V2, US-01, US-09 |
| RF-21 | A montagem dos grupos deve ocorrer em um prazo fixo antes do rolê (ex.: 48h) e ser definitiva após a abertura do chat. | P0 | V2 |
| RF-22 | O sistema deve notificar o usuário quando o grupo for formado. | P0 | V2 |

### Chat

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-25 | O sistema deve oferecer chat em tempo real entre os membros do grupo, na janela definida em RF-51. | P0 | V2 |
| RF-26 | Ao abrir o chat, a IA deve sugerir um quebra-gelo com base nos interesses em comum do grupo. | P1 | V2, US-10 |

### Pós-rolê

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-30 | Após o rolê, o sistema deve solicitar avaliação do rolê (nota) e de cada participante. | P0 | V2 |
| RF-31 | Na avaliação, o usuário deve poder marcar "quero manter contato" com cada participante (liberação conforme RF-50). | P0 | V2, US-04 |
| RF-32 | O sistema deve registrar a presença do usuário no rolê a partir da confirmação dele e dos demais membros. | P0 | V2 |
| RF-33 | O sistema deve cobrar taxa de no-show quando a ausência for reportada por pelo menos 2 membros do grupo, com aviso prévio no momento da inscrição. | P0 | V2 |
| RF-34 | O sistema deve registrar interações (visualização, inscrição, cancelamento, presença, avaliações, contatos mantidos) para uso futuro pela IA. | P0 | V2 |

### Identidade de rolê

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-35 | O perfil deve exibir um calendário com os rolês dos quais o usuário participou. | P0 | V2 |
| RF-36 | O perfil deve exibir um mapa da cidade com os locais visitados. | P0 | V2 |
| RF-37 | O sistema deve gerar todo mês um card (imagem) com o resumo de rolês do usuário, pronto para compartilhar no Instagram. | P0 | V2 |

### Notificações e administração

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-38 | O sistema deve enviar notificações (push do PWA e e-mail): grupo formado, chat aberto, lembrete do rolê, pedido de avaliação. | P0 | V2, US-08 |
| RF-39 | O admin deve ter painel com inscrições, grupos formados e status de cada rolê. | P0 | V2 |

### Segurança

| ID | Requisito | Prior. | Origem |
|----|-----------|--------|--------|
| RF-40 | O sistema deve verificar a identidade do usuário (documento + selfie com prova de vida) por meio de fornecedor externo antes de liberar a inscrição em rolês. | P0 | SEG-01 |
| RF-41 | O sistema deve confirmar idade mínima de 18 anos a partir do documento verificado. | P0 | SEG-02 |
| RF-42 | O sistema deve permitir apenas uma conta por CPF e exigir telefone verificado. | P0 | SEG-03 |
| RF-43 | O sistema deve impedir que usuários banidos criem nova conta (bloqueio por CPF e biometria). | P0 | SEG-04 |
| RF-44 | O sistema deve exigir aceite ativo do código de conduta no cadastro. | P0 | SEG-05 |
| RF-45 | A montagem de grupos deve formar grupos de no mínimo 4 pessoas. | P0 | SEG-10 |
| RF-46 | A montagem de grupos não deve colocar uma única mulher em um grupo de homens. | P0 | SEG-11 |
| RF-47 | O usuário deve poder optar por participar apenas de grupos só de mulheres. | P0 | SEG-12, US-05 |
| RF-48 | A montagem de grupos nunca deve juntar usuários que se bloquearam. | P0 | SEG-13 |
| RF-49 | Dentro do grupo, o sistema deve exibir apenas primeiro nome, foto e interesses de cada membro. | P0 | SEG-20, US-06 |
| RF-50 | O sistema só deve liberar dados de contato entre dois usuários quando ambos marcarem "quero manter contato". | P0 | SEG-21, US-04 |
| RF-51 | O chat do grupo deve abrir ~24h antes do rolê e fechar após o término. | P0 | SEG-22, US-06 |
| RF-52 | O endereço exato do rolê deve ser visível apenas aos membros do grupo; o sistema não deve expor localização em tempo real. | P0 | SEG-23, US-06 |
| RF-53 | Rolês só podem ser cadastrados em locais públicos registrados pelo admin. | P0 | SEG-30 |
| RF-54 | O usuário deve poder sair de um rolê a qualquer momento, sem justificativa e sem penalidade. | P0 | SEG-31 |
| RF-55 | O app deve oferecer botão de ajuda com atalho para 190, Ligue 180 e denúncia rápida. | P0 | SEG-32 |
| RF-56 | A avaliação pós-rolê deve incluir, por participante, a pergunta privada "você se sentiu seguro(a)?". | P0 | SEG-40 |
| RF-57 | O usuário deve poder denunciar outro participante a qualquer momento, inclusive após o rolê. | P0 | SEG-41 |
| RF-58 | Uma denúncia classificada como grave deve suspender preventivamente o denunciado de forma automática. | P0 | SEG-42 |
| RF-59 | O sistema nunca deve revelar ao denunciado a identidade de quem denunciou. | P0 | SEG-44 |
| RF-60 | O admin deve ter painel de moderação com fila de denúncias, histórico do usuário e ações de advertir, suspender e banir. | P0 | SEG-43, SEG-45 |
| RF-61 | Usuários novos devem começar por rolês classificados como risco baixo; rolês de risco maior só após avaliações positivas. | P1 | SEG-14 |
| RF-62 | A reputação do usuário deve influenciar a montagem de grupos. | P1 | SEG-15 |
| RF-63 | O chat deve ter moderação automática por IA (assédio, pedido de dados pessoais, insistência para sair do app). | P1 | SEG-24 |
| RF-64 | O usuário deve poder compartilhar o rolê (onde, quando, com quem) com um contato de confiança. | P1 | SEG-33 |

## Requisitos Não Funcionais (RNF)

| ID | Categoria | Requisito | Prior. |
|----|-----------|-----------|--------|
| RNF-01 | Usabilidade | Interface mobile-first, responsiva, instalável como PWA. | P0 |
| RNF-02 | Usabilidade | Onboarding (interesses + vibe) concluível em menos de 60 segundos. | P0 |
| RNF-03 | Desempenho | Lista de rolês responde em < 500 ms (p95). | P0 |
| RNF-04 | Desempenho | Mensagens do chat entregues em < 1 s. | P0 |
| RNF-05 | Desempenho | Montagem de grupos de um rolê com até 200 inscritos em < 30 s. | P0 |
| RNF-06 | Segurança | Senhas com hash (BCrypt); comunicação apenas via HTTPS; endpoints admin protegidos por papel. | P0 |
| RNF-07 | Segurança | Pagamentos processados por gateway certificado PCI-DSS; o sistema não armazena dados de cartão. | P0 |
| RNF-08 | Privacidade (LGPD) | Consentimento explícito no cadastro; localização opcional; política de privacidade publicada. | P0 |
| RNF-09 | Privacidade (LGPD) | Dados biométricos e de documento tratados como dados sensíveis: consentimento específico, criptografia em repouso, retenção mínima e acesso restrito. | P0 |
| RNF-10 | Segurança | Denúncias graves revisadas por humano em até 24h. | P0 |
| RNF-11 | Auditoria | Toda ação de moderação fica registrada com autor, data e motivo. | P0 |
| RNF-12 | Manutenibilidade | Back-end em monólito modular por domínio; front-end organizado por features; testes automatizados nas regras de montagem de grupos e de segurança. | P0 |
| RNF-13 | Escalabilidade | Algoritmo de montagem de grupos isolado atrás de uma interface, para ser trocado na fase 2 sem alterar o resto. | P0 |
| RNF-14 | Portabilidade | Ambiente completo sobe com `docker compose up`. | P0 |
| RNF-15 | Observabilidade | Logs estruturados e health check da API. | P0 |
| RNF-16 | Disponibilidade | 99% de disponibilidade, com prioridade nas janelas de rolê (noites e fins de semana). | P1 |
| RNF-17 | Acessibilidade | Contraste e navegação por teclado conforme WCAG 2.1 AA nas telas principais. | P1 |
