## Assumptions 
 - I've deliberately used lombok
 - As there is no endpoint for customer creation one is inserted during startup. 
 - OpenAPI is used. 
   - docs: http://localhost:8080/v3/api-docs
   - swagger: http://localhost:8080/swagger-ui/index.html
 - I've still kept GET methods for all resources

## Doubts
 - _"Endpoint for updating Customer should be able to update and/or remove existing values of any/all attributes."_
    Didn't understand that request. It sounds like customer field can be set to null which sounds a bit counterintuitive to me.
 - Maybe it is an intention create a customer during quotation creation, but then the same user could be created multiple times.
