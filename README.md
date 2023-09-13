# Challenge-FIAP - NourishMe <!-- Listagem dos endpoints -->

# Integrantes

RM96269 - Bianca Dos Santos Pereira
RM95854 - Eduarda Nicoli Cavalheiro
RM93535 - Erik Siarkowski Salafia
RM95396 - Ingrid Vieira de Oliveira
RM95749 - João Vitor Santiago de Oliveira Braz
RM95384 - Leonardo Dantas Marques

## Objetivo do projeto:
Facilitar o processo de tratamento dos transtornos alimentares, o aplicativo irá monitorar as refeições que o usuario está fazendo, seja a quantidade do que comeu e o que comeu.

Vamos utilizar a API do GPT para criar um assistente emocional. Através dela, será possível integrar o modelo de linguagem natural do GPT em um aplicativo e desenvolver um assistente que possa conversar com usuários sobre seus sentimentos, problemas emocionais, estresse, ansiedade e outros temas relacionados à saúde mental. Além disso, o chat oferecerá sugestões, dicas e atividades que possam ajudar a pessoa a lidar melhor com suas emoções e sentimentos

------------------------

## Endpoints 
# Refeicao- api/v1/refeicoes
 
- [Cadastrar refeição](#cadastrar-refeicao)
- [Cadastrar Motivo]
- [Atualizar refeição](#Atualizar-refeição)
- [Apagar refeição](#Apagar-refeição)
- [Listar refeição]

# Motivo/api/v1/motivo
- [Cadastrar motivo]
- [Apagar motivo]
- [Atualizar motivo]
- [Listar motivo]

<!-- Endereço do recurso -->

`GET`/api/v1/refeicao
**Exemplo de Entrada** 
```js
    {
 	"Id": '1',
 	"Nome": 'Clara',
 	"Café da manha": 'Pao com ovo',
 	"Almoço": 'Macarrao com feijao',
 	"Cafe da Tarde": 'Pao com manteiga e café',
 	"Jantar": 'Arroz feijão e carne',
 	"Sentimentos":{
        "id": 1,
        "me sentindo": 'Estou me sentido mal, pois não me alimentei bem hoje'
    }
     
   }
```
**Códigos da Resposta**

|código|Descrição
|-|-
200 | Dados Retornados com sucesso

--------------------

`POST`/api/v1/refeicao

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-----------:|-----------|
|Nome   |String|Sim          |Texto com o nome da pessoa com no máximo 300 caracteres
|Café da manha|String|Sim    |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Almoço |String|Sim          |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Cafe da Tarde|String|Não    |Texto com o que comeu no café da tarde, com no máximo 300 caracteres
|Jantar|String|Sim           |Texto com o que comeu na janta, com no máximo 300 caracteres
|Motivacao|String|Não        |Texto contando o que sentiu após cada refeição, com no máximo 300 caracteres
||||


# Exemplo de corpo de requisição
```js
    {
 	"Nome": 'Clara',
 	"Café da manha": 'Pao com ovo',
 	"Almoço": 'Macarrao com feijao',
 	"Cafe da Tarde": 'Pao com manteiga e café',
 	"Jantar": 'Arroz feijão e carne',
 	"Sentimentos": 'Estou me sentido mal, pois não me alimentei bem hoje'

   }
```
-------------------------

`PUT` /api/v1/ refeicao/{id}

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-----------:|-----------|
|Café da manha|String|Sim    |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Almoço |String|Sim          |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Cafe da Tarde|String|Não    |Texto com o que comeu no café da tarde, com no máximo 300 caracteres
|Jantar|String|Sim           |Texto com o que comeu na janta, com no máximo 300 caracteres
|Motivacao|String|Não        |Texto contando o que sentiu após cada refeição, com no máximo 300 caracteres
||||


# Exemplo de corpo de requisição
```js
    {
 	"Café da manha": 'Pao com ovo',
 	"Almoço": 'Macarrao com feijao',
 	"Cafe da Tarde": 'Pao com manteiga e café',
 	"Jantar": 'Arroz feijão e carne',
 	"Sentimentos": 'Estou me sentido mal, pois não me alimentei bem hoje'

   }
```

|código|Descrição
|-|-
200 | Dados Retornados com sucesso
400 | Dados atualizados
4004| Usuario não encontrado, com o id informado

--------------------------

### Cadastrar refeição
`POST` api/v1/ refeicao

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-----------:|-----------|
|Café da manha|String|Sim    |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Almoço |String|Sim          |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Cafe da Tarde|String|Não    |Texto com o que comeu no café da tarde, com no máximo 300 caracteres
|Jantar|String|Sim           |Texto com o que comeu na janta, com no máximo 300 caracteres
|Motivacao|String|Não        |Texto contando o que sentiu após cada refeição, com no máximo 300 caracteres
||||

```js
    {
 	"Café da manha": 'Pao com ovo',
 	"Almoço": 'Macarrao com feijao',
 	"Cafe da Tarde": 'Pao com manteiga e café',
 	"Jantar": 'Arroz feijão e carne',
 	"Sentimentos": 'Estou me sentido mal, pois não me alimentei bem hoje'
   }
```

|código|Descrição
|-|-
201 | Refeição cadastrada com sucesso
400 | Os campos enviados estão inválidos

-------------------------------------------

### Atualizar refeição
`PUT` api/v1/refeicao/{id}

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-----------:|-----------|
|Café da manha|String|Sim    |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Almoço |String|Sim          |Texto com o que comeu no café da manhã, com no máximo 300 caracteres
|Cafe da Tarde|String|Não    |Texto com o que comeu no café da tarde, com no máximo 300 caracteres
|Jantar|String|Sim           |Texto com o que comeu na janta, com no máximo 300 caracteres
|Motivacao|String|Não        |Texto contando o que sentiu após cada refeição, com no máximo 300 caracteres
||||

# Exemplo de corpo de requisição
# neste exemplo os sentimentos  seria o campo de preecncher a motivaçao que sentiu após a refeição

```js
    {
 	"Café da manha": 'Pao com ovo',
 	"Almoço": 'Macarrao com feijao',
 	"Cafe da Tarde": 'Pao com manteiga e café',
 	"Jantar": 'Arroz feijão e carne',
 	"Sentimentos": 'Estou me sentido mal, pois não me alimentei bem hoje'

   }
```
|código|Descrição
|-|-
200 | Refeições atualizadas com sucesso
400 | Os campos enviados são inválidos
404 | Não existe usuário com o id informado

----------------------------------

### Apagar refeição
`DELETE` /api/v1/ refeicao/{id}

|código|Descrição
|-|-
204 | Refeição apagada com sucesso
404 | Não existe refeição com o id informado

---------------------------
