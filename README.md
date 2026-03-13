# 🌙 Lunaris - API de Gestão Educacional

Backend robusto para o sistema de gestão educacional Lunaris, fornecendo serviços de autenticação, persistência de dados e lógica de negócio para os módulos de administração, professores e alunos.

## 📋 Sobre o Projeto

A **Lunaris API** é o coração do ecossistema Lunaris. Desenvolvida seguindo os princípios de arquitetura limpa e RESTful, ela garante que os dados educacionais sejam processados de forma segura e eficiente.

* **🔐 Segurança**: Implementação de autenticação e autorização para diferentes níveis de acesso.
* **📊 Persistência**: Gestão completa de banco de dados para alunos, professores, turmas e notas.
* **⚡ Escalabilidade**: Construída com Spring Boot para suportar o crescimento da instituição.

## 🚀 Tecnologias

* **Java 17** - Linguagem de programação principal
* **Spring Boot 3** - Framework para agilizar o desenvolvimento
* **Spring Security** - Controle de acesso e segurança
* **Spring Data JPA** - Abstração de persistência de dados
* **H2 Database / MySQL** - Banco de dados (desenvolvimento/produção)
* **Maven** - Gerenciador de dependências e build
* **Swagger/OpenAPI** - Documentação interativa da API

## 📁 Estrutura do Projeto

```
lunaris-api/
├── src/
│   ├── main/
│   │   ├── java/com/lunaris/api/
│   │   │   ├── config/          # Configurações (CORS, Security, Swagger)
│   │   │   ├── controller/      # Endpoints da API (Exposição de recursos)
│   │   │   ├── dto/             # Objetos de Transferência de Dados (Requests/Responses)
│   │   │   ├── model/           # Entidades do banco de dados
│   │   │   ├── repository/      # Interfaces de acesso ao banco (JPA)
│   │   │   ├── service/         # Camada de regras de negócio
│   │   │   └── exception/       # Tratamento de erros customizados
│   │   └── resources/
│   │       ├── application.properties  # Configurações do Spring
│   │       └── db/migration/           # Scripts de migração (se houver)
├── docs/                        # Documentação técnica e diagramas
└── pom.xml                      # Configuração do Maven e dependências

```

## 🛠️ Instalação

### Pré-requisitos

* Java JDK 17 ou superior
* Maven 3.6+
* IDE de sua preferência (IntelliJ, VS Code, Eclipse)

### Passo a passo

1. **Clone o repositório**

```bash
git clone https://github.com/Lunaris-School/lunaris-api.git
cd lunaris-api

```

2. **Configure as variáveis de ambiente**
Ajuste as configurações de banco de dados no arquivo `src/main/resources/application.properties` se necessário. Por padrão, o projeto está configurado para usar H2 (em memória).
3. **Instale as dependências e compile**

```bash
mvn clean install

```

4. **Inicie a aplicação**

```bash
mvn spring-boot:run

```

A API estará disponível em `http://localhost:8080`

## 📜 Endpoints Principais (Exemplos)

| Método | Endpoint | Descrição |
| --- | --- | --- |
| POST | `/api/auth/login` | Realiza o login e retorna o token |
| GET | `/api/admin/usuarios` | Lista todos os usuários (Admin apenas) |
| POST | `/api/notas` | Lança notas de alunos (Professor apenas) |
| GET | `/api/alunos/meu-desempenho` | Retorna o boletim do aluno logado |

> **Dica:** Após rodar o projeto, acesse `http://localhost:8080/swagger-ui.html` para visualizar a documentação completa e testar os endpoints.

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](https://www.google.com/search?q=LICENSE) para mais detalhes.

## 👥 Equipe

Desenvolvido com ❤️ pela equipe Lunaris

* Beatriz
* Breno
* Clara
* Giulia
* Isabela
* Maria Eduarda

## 📞 Contato

Para dúvidas ou sugestões, entre em contato:

* Email: lunaris.school@gmail.com

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!
