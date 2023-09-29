# Challenge - Validation And Security

* Implemente as funcionalidades necessárias para que os testes passem;

##

## - Testes:

- City:

    - insertShouldReturn401WhenNoUserLogged()
    - insertShouldReturn403WhenClientLogged()
    - insertShouldInsertResourceWhenAdminLoggedAndCorrectData()
    - insertShouldReturn422WhenAdminLoggedAndBlankName()
    - findAllShouldReturnAllResourcesSortedByName()
 
- Event:

    - insertShouldReturn401WhenNoUserLogged()
    - insertShouldInsertResourceWhenClientLoggedAndCorrectData()
    - insertShouldInsertResourceWhenAdminLoggedAndCorrectData()
    - insertShouldReturn422WhenAdminLoggedAndBlankName()
    - insertShouldReturn422WhenAdminLoggedAndPastDate()
    - insertShouldReturn422WhenAdminLoggedAndNullCity()
    - findAllShouldReturnPagedResources()
