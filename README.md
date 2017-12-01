# eip
Example enterprise integration patterns

## Prerequisits
Start activemq

console avalable at http://localhost:8161/admin/ 

## ToolInfo

### Spring
Use generator for initial maven pom
- https://start.spring.io/

### Camel
- [timer](http://camel.apache.org/timer.html)
- [example](https://github.com/apache/camel/examples/camel-example-spring-boot-activemq/)
- [setup example](https://access.redhat.com/documentation/en-us/red_hat_jboss_fuse/6.3/html/fuse_integration_services_2.0_for_openshift/camel-spring-boot) 

### HermesJMS
A JMS queue brouwser
To get started copy xercesImpl version 2.11.0 into $HERMES_HOME/lib
- [download](https://sourceforge.net/projects/hermesjms/files/)
- [setup](https://blogs.oracle.com/jamesbayer/hermes-jms-open-source-jms-console)
- [configuration](https://stackoverflow.com/questions/34855960/trying-to-configure-hermes-jms-for-activemq-error-is-thrown-when-queue-is-brows)

### Database
To use a datasource:
- create a database with the proper user
- define the datasource in the application.properties. 

#### Setup datasource
Example:
```
# Datasource
spring.datasource.url=jdbc:postgresql://localhost/mydb
spring.datasource.name=mydb
spring.datasource.username=xxxx
spring.datasource.password=yyyy
```

#### Define tables using liquibase
```
databaseChangeLog:
  - changeSet:
      id: 2
      author: bvpelt
      changes:
        - createTable:
            tableName: data_object
            columns:
              - column:
                  name: id
                  type: bigint
                  constraints:
                    primaryKey: true
                    nullable: false
        - createTable:
            tableName: datatest
            columns:
              - column:
                  name: id
                  type: bigint
                  constraints:
                    primaryKey: true
                    nullable: false
              - addAutoIncrement:
                  columnDataType: int
                  columnName: id
                  incrementBy: 1
                  startWith: 1
                  tableName: 
```

## Rest
```
2017-12-01 21:40:33.438  INFO 13242 --- [tlet-1536863362] org.restlet.Component.LogService         : 2017-12-01	21:40:33	127.0.0.1	-	localhost	8888	GET	/users/	-	200	300	0	14	http://localhost:8888	Mozilla/5.0 (X11; Fedora; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57.0	-

```
# References
- https://www.concretepage.com/spring-boot/spring-boot-logging-example
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html

