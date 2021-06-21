# ScimTestApi

This is a Spring boot application made to simulate a SCIM server returning users and groups in JSON format.

It is made to be embedded in selenium tests and embarks an embedded tomcat server.

Use mvn clean package to create a jar

URL: 
  http://localhost:8088/SCIM/users : return a list of users
  http://localhost:8088/SCIM/groups : return a list of groups
  http://localhost:8088/service/toggleServerInError : SCIM request will return error message HTTP 404 (revert by ping the url again)
  http://localhost:8088/service/updateRepo : SCIM request will return an updated content (revert by ping the url again)
