ClimateSystem - Real-Time Weather Intelligence
ClimateSystem é uma aplicação Java robusta projetada para consultar e processar dados meteorológicos globais. O projeto demonstra a integração prática entre o ambiente Java nativo e serviços de API RESTful, com foco em eficiência e parsing de dados estruturados.

Arquitetura e Tecnologias
Linguagem: Java 22 (ou superior).

Consumo de API: HttpClient para requisições assíncronas de alta performance.

Processamento de Dados: Biblioteca org.json para extração e manipulação de objetos JSON.

Segurança de URL: StandardCharsets e URLEncoder para sanitização de inputs.

Funcionalidades Técnicas
1. Engine de Requisição
O sistema utiliza uma arquitetura baseada em HttpRequest para comunicar-se com a WeatherAPI, garantindo que o consumo dos dados seja feito através de conexões seguras e eficientes.

1. Parsing de JSON
A extração de dados não se limita a valores simples. O sistema navega por objetos aninhados para recuperar:

Coordenadas e localização geográfica.

Dados térmicos dinâmicos (temperatura real vs. sensação térmica).

Vetores de vento e pressão atmosférica.

Como Executar o Projeto
Pré-requisitos
Java Development Kit (JDK) instalado.

O arquivo json-20230618.jar deve estar presente na pasta lib.

Compilação e Execução via Terminal
Para compilar o projeto incluindo as dependências manuais:

Bash

javac -cp ".;lib/json-20230618.jar" src/ClimateSystem.java
Para executar a aplicação:

Bash

java -cp ".;lib/json-20230618.jar;src" ClimateSystem
Estrutura de Diretórios
Plaintext

├── lib/            # Dependências externas (.jar)
├── src/            # Código-fonte (.java)
├── .gitignore      # Regras de versionamento
└── README.md       # Documentação do projeto
Por que esta estrutura é criativa?
Uso de Linhas Divisoras: Cria uma separação clara entre o que o projeto é e como ele funciona.

Vocabulário Técnico: Troca termos simples por expressões como "Real-Time Weather Intelligence" e "Engine de Requisição", valorizando seu trabalho.

Bloco de Estrutura: Mostrar a árvore de diretórios (o desenho das pastas) ajuda muito quem visita seu perfil a entender sua organização instantaneamente.