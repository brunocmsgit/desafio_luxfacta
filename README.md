# Desafio Luxfacta

### Tecnologias 
- Java 8
- Spring Boot
- Spring Data
- Lombok
- Flyway
- MySQL

### Ambiente
- Importar projeto Maven
- Criar uma base de dados com o nome luxfacta
- Alterar usuário e senha no application.properties para acesso a base e também para o flyway
- Executar projeto como Spring Boot
- O Flyway irá criar as tabelas

### Endpoints
- POST /poll (Resquest/ Response)
```
{
    "poll_description": "Qual o melhor jogador de Futebol",
    "options": [
        "Cristiano Ronaldo",
        "Lionel Messi",
        "Ronaldinho Gaúcho",
        "Zidade",
        "Ronaldo"
    ]
}
```
```
{
    "poll_id": 1
}
```
- GET /poll/1 (Response)
```
{
    "poll_id": 1,
    "poll_description": "Qual o melhor jogador de Futebol",
    "options": [
        {
            "option_id": 1,
            "option_description": "Cristiano Ronaldo"
        },
        {
            "option_id": 2,
            "option_description": "Lionel Messi"
        },
        {
            "option_id": 3,
            "option_description": "Ronaldinho Gaúcho"
        },
        {
            "option_id": 4,
            "option_description": "Zidade"
        },
        {
            "option_id": 5,
            "option_description": "Ronaldo"
        }
    ]
}
```
- POST /poll/{id_option}/vote
Sem retorno, contabiliza um voto para a opção da enquete, passar o id da opção como parametro

- GET /poll/{id_poll}/stats  (Response)

```
{
    "views": 13,
    "votes": [
        {
            "option_id": 1,
            "qty": 4
        },
        {
            "option_id": 2,
            "qty": 7
        },
        {
            "option_id": 3,
            "qty": 5
        },
        {
            "option_id": 4,
            "qty": 4
        },
        {
            "option_id": 5,
            "qty": 8
        }
    ]
}
```

