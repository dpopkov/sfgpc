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
* Create Owner Index page and Controller. Closes #10.
    * templates/owners/index.html
    * learn.sfg.sfgpc.controllers.OwnerController
* Load Bootstrap Data on Startup. Closes #11.
    * learn.sfg.sfgpc.bootstrap.DataLoader implements CommandLineRunner.
* Implement Spring Config for Services. Closes #19.
    * __@Service__ public class OwnerMapService
* List all Owners on Owner Index Page. Closes #13.
    * Update the OwnerController - inject OwnerService.
    * Update owners/index.html - add table and iterate owners.
* List all Vets on Vet index page. Closes #12.
    * Update the VetController - inject VetService.
    * Update vets/index.html - add table and iterate vets.
* Copy all Static Resources from Spring Pet Clinic. Closes #14.
    * Copy resources/static/resources/fonts and images.
* Copy Master Template from Spring Pet Clinic. Closes #15.
    * resources/templates/fragments/layout.html
* Implement WRO4J Maven Plugin and Spring Pet Clinic resources. Closes #20.
    * add wro4j-maven-plugin to pom
    * add main/less files
    * add main/wro files
* Apply master layout to Index Page. Closes #16.
    * apply `th:replace="~{fragments/layout :: layout (~{::body},'home')}"`
* Add missing i18n properties files. Closes #21.
    * add messages properties files
    * add `spring.messages.basename=messages/messages` to application.properties
* Apply master layout to Owners List Page. Closes #17.
    * apply `th:replace="~{fragments/layout :: layout (~{::body},'owners')}"`
