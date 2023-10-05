# :construction: - Challenge - Validation And Security

* Implemente as funcionalidades necessárias para que os testes passem;
* Desenvolvimento TDD de API Rest com Java e Spring Boot;
* Implementação de segurança com Spring Security e OAuth2;
* Controle de acesso por rotas e perfis de usuário;
* Validação de dados com Bean Validation;

##

## :clipboard: - Diagrama:

![validacao drawio](https://github.com/carloshenriquefs/validation-and-security/assets/54969405/5cb57358-d2a7-4985-a585-745c4da048f9)

##

## :gear: - Endpoints:

#### :house: - City:

- findAll()
- insert()

##

#### :microphone: - Event:

- findAll()
- insert()

##

## :hourglass: - Testes:

#### :derelict_house: - City:

    - insertShouldReturn401WhenNoUserLogged()
    - insertShouldReturn403WhenClientLogged()
    - insertShouldInsertResourceWhenAdminLoggedAndCorrectData()
    - insertShouldReturn422WhenAdminLoggedAndBlankName()
    - findAllShouldReturnAllResourcesSortedByName()
 
#### :microphone: - Event:

    - insertShouldReturn401WhenNoUserLogged()
    - insertShouldInsertResourceWhenClientLoggedAndCorrectData()
    - insertShouldInsertResourceWhenAdminLoggedAndCorrectData()
    - insertShouldReturn422WhenAdminLoggedAndBlankName()
    - insertShouldReturn422WhenAdminLoggedAndPastDate()
    - insertShouldReturn422WhenAdminLoggedAndNullCity()
    - findAllShouldReturnPagedResources()

##

### :white_check_mark: - Critérios:

##

- [x] - POST /events deve retornar 401 Unauthorized para usuário não logado;
- [x] - POST /events deve retornar 201 Created para CLIENT logado e dados corretos;
- [x] - POST /events deve retornar 201 Created para ADMIN logado e dados corretos;
- [x] - POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e nome em branco;
- [x] - POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e data no passado;
- [x] - POST /events deve retornar 422 Unprocessable Entity para ADMIN logado e cidade nula;
- [x] - GET /events deve retornar 200 Ok com página de recursos;
- [x] - POST /cities deve retornar 401 Unauthorized para usuário não logado;
- [x] - POST /cities deve retornar 403 Forbidden para CLIENT logado;
- [x] - POST /cities deve retornar 201 Created para ADMIN logado e dados corretos;
- [x] - POST /cities deve retornar 422 Unprocessable Entity para ADMIN logado e nome em branco;
- [x] - GET /cities deve retornar 200 Ok com todos recursos ordenados por nome;
