# SFG Spring Boot Pet Clinic

## History
* Implement Pet Clinic POJO Data Model. Closes #2.
* Create Multi-Module Project for Data Model. Closes #1.
    * Create module `sfgpcdata`
        * Add dependencies: 
            * `spring-boot-starter-data-jpa`
            * `h2`
            * `mysql-connector-java`
            * `lombok`
            * `spring-boot-starter-test`
        * Configure `spring-boot-maven-plugin` to skip repackage goal
        * Add `<spring-boot.repackage.skip>true</spring-boot.repackage.skip>` property to skip making fat jar.
    * Create module `sfgpcweb`
        * Add dependencies: 
            * `sfgpcdata`
            * `spring-boot-starter-actuator`
            * `spring-boot-starter-thymeleaf`
            * `spring-boot-starter-web`
            * `spring-boot-devtools`
            * `spring-boot-starter-test`
* Add Maven Release Plugin. Closes #3.
    * Add config property `<autoVersionSubmodules>true</autoVersionSubmodules>`.
    * Config `scm` section with `developerConnection` and `tag` elements.
* Create Interfaces for Pet Clinic Services. Closes #4.
* Create BaseEntity and add id to model objects. Closes #9.
* Implement Map based Services. Closes #5.
* Use an image for custom banner.
    * Just add to application.properties: `spring.banner.image.location=pet-clinic.png`
* Create Index Page and Controller. Closes #7.
    * templates/index.html
    * learn.sfg.sfgpc.controllers.IndexController
* Create Vet Index page and Controller. Closes #6.
    * templates/vets/index.html
    * learn.sfg.sfgpc.controllers.VetController
