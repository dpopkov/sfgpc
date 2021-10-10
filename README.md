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
