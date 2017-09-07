See my referencing blog post for this coding challenge assignment [here](http://davidpaulweber.com/post/2017-09-07-coin-dispense-coding-challenge/).

### REST Web Service
Tools: NetBeans (IDE), Postman (API Testing)

Frameworks / Libraries:  

* Spark (Web Framework)
* Guice (Dependency Injection)
* Gson (JSON)
* JUnit (Testing)
* Nimbus JWT (Authentication)
* JBCrypt (Hashing)

Endpoints:

* api/v1/public/authenticate - accepts and verifies credentials then returns a user profile as well as a JSON Web Token to authenticate future requests.
* api/v1/authenticated/payment - accepts a payment amount, subtracts the payment amount from the user's account, updates the user profile and returns a breakdown of any change to be dispensed.

Assumptions:

* If an amount owed as change is less than the lowest denomination (2 cents), ignore that remainder.
