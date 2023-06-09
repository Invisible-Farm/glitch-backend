## glitch-backend Service.

This is a RestAPI server implemented based on the Spring Framework.
It is a backend server for the IVFM service.
This server manages basic data for IVFM and communicates with the corresponding data through REST API.

PropertiesFile
------------
To run the service, please create an application.properties file under the resources directory, based on the application.properties.tmp template file. Fill in the empty fields with the following information:

	# Database configuration
    spring.datasource.url=
	spring.datasource.username=
    spring.datasource.password=


Dependencies
------------
This service has dependencies on other services.
    
- IVFM Front: https://github.com/Invisible-Farm/glitch-frontend
- IVFM Contract: https://github.com/Invisible-Farm/glitch-contract
- IVFM Verifier: https://github.com/Invisible-Farm/glitch-verifier-server
- PostgreSQL: https://www.postgresql.org/

Building
--------
	mvn clean
	mvn install
    java -jar -Dspring.profiles.active=prod /root/ivfm-0.0.1-SNAPSHOT.jar

