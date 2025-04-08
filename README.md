# FÁBRICA DE SOFTWARE

## Nome da Equipe
- Lorenzo Poncio
- Carlos Augusto Brazão da Silva

### Sistema de Gestão de Fila de Produção da MP Multipedidos
    - CRUD para etapa de coleta de informações para produção do cardápio;
    - CRUD para etada de produção do cardápio;
    - CRUD para etapa de implantação do cardápio;
    - CRUD para clientes e funcionários da MP;
    - Dashboard com metricas do andamento do processo;

## Estrutura do Projeto
O projeto é composto pelas seguintes classes que representam as entidades do sistema de gestão de fila de produção:

- **Client**: Representa um cliente no sistema, com propriedades como `id`, `name`, `contactInfo` e métodos para acessar e modificar essas informações.
  
- **Employee**: Representa um funcionário envolvido no processo de produção, com propriedades como `id`, `name`, `role` e métodos para acessar e modificar essas informações.
  
- **Demand**: Representa uma demanda na fila de produção, com propriedades como `id`, `establishment`, `responsible`, `status`, `deadline` e métodos para acessar e modificar essas informações.
  
- **Establishment**: Representa um estabelecimento comercial, com propriedades como `id`, `name`, `address` e métodos para acessar e modificar essas informações.
  
- **ProductionStage**: Representa uma etapa no processo de produção, com propriedades como `id`, `name`, `description` e métodos para acessar e modificar essas informações.
  
- **Status**: Representa o status de uma demanda, com propriedades como `id`, `name` e métodos para acessar e modificar essas informações.

## Histórias de Usuário
- Desejo que os usuários possam cadastrar demandas relacionadas às diferentes etapas do processo (coleta, montagem e implantação), de forma que o fluxo de trabalho seja claramente identificado desde o início.

- No momento do cadastro, deve ser possível vincular um estabelecimento à demanda, garantindo que cada solicitação esteja corretamente associada ao local correspondente.

- É importante que o sistema permita registrar as dificuldades encontradas em cada demanda, possibilitando uma análise mais detalhada dos obstáculos enfrentados em cada etapa do processo.

- O cadastro deve incluir campos para informar datas relevantes, como a data de pagamento e a data de finalização prevista ou realizada, permitindo o controle do ciclo de vida da demanda.

- Cada demanda precisa ter responsáveis definidos, para que fique claro quem está à frente de cada atividade ou etapa.

- O sistema deve permitir selecionar o status de andamento da demanda, facilitando o acompanhamento do progresso das atividades.

- Deve ser possível informar prazos para cada demanda, permitindo o controle de tempo e a gestão da produtividade.

- Quando houver atrasos, o sistema deve permitir o registro do motivo, para que seja possível analisar e entender os fatores que impactam na entrega.