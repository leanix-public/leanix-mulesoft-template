Steps to take (based out of https://beta.docs.stgx.mulesoft.com/beta-mule-sdk/mule-sdk/1.1/rest-sdk/project-setup):

* Extract https://app.leanix.net/services/integration-api/v1/api-docs/swagger.json?t=1634711349416 (remove non-covered methods manually for now)
* ´´mvn com.mulesoft.connectivity:rest-sdk-mojo:createDescriptor -DapiSpec=swagger.json -DskipValidation=true´´
* ´´mvn com.mulesoft.connectivity:rest-sdk-mojo:createConnector -DapiSpec=swagger.json -Ddescriptor=descriptor-1.yaml -DskipValidation=true
