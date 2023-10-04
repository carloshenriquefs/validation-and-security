# :construction: - Challenge - Validation And Security

* Implemente as funcionalidades necessárias para que os testes passem;

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
