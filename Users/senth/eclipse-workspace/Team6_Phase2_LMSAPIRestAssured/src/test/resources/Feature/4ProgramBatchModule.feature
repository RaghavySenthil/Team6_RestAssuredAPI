#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@ProgramBatchModule
Feature: Post-Request-Batch_module
  Background: Admin sets Authorization to Bearer Token.

  @Batchmodule
  Scenario: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
    Given Admin creates POST Request  with valid data in request body
    When Admin sends HTTPS Request with endpoint for batchmodule 
    Then Admin receives 201 Created Status with response body for batchmodule.   
   
  @BatchExistingValue
  Scenario: Check if admin able to create a Batch with valid endpoint and request body (existing value in Batch Name)
   Given Admin creates POST Request  with existing value in request body 
    When Admin sends HTTPS Request with endpoint witheixisting value
    Then Admin receives 400 Bad Request Status with message and boolean success details
    
   @BatchInvalid
  Scenario: Check if admin able to create a Batch missing mandatory fields in request body
   Given Admin creates POST Request  with invalid data in request body 
    When Admin sends HTTPS Request with endpoint for batchmodule invalid request
    Then Admin receives 400 Bad Request Status with message and boolean success details invalid request
    
    @Batchmoduleinvalidendpoint
  Scenario: Check if admin able to create a batch with invalid endpoint
   Given Admin creates POST Request invalidendpoint
    When Admin sends HTTPS Request with invalid endpoint pgmbatch 
    Then Admin receives 404 not found  Status
    
        
     @InvalidpgmID
  Scenario: Check if admin able to create a batch  with inactive program ID
   Given Admin creates POST Request with inactive program id  
    When Admin sends HTTPS Request with endpoint with invalidpgmID   
    Then Admin receives 400 Bad Request Status with message and boolean success details with invalidpgmID                                                            
    
    @GetRequest
  Scenario: Check if admin able to retrieve all batches  with valid LMS API
   Given Admin creates GET Request in ProgramBatch  
    When Admin sends HTTPS Request with endpoint in get all request  
    Then Admin receives 200 OK Status with response body program batchmodule.

@GetRequest-invalidendpoint
  Scenario: Check if admin able to retrieve all batches with invalid Endpoint 
   Given Admin creates GET Request for invalid endpoint programbatch
    When Admin sends HTTPS Request with invalidendpoint in get all request  
    Then Admin receives 404 status with error message Not Found.
    
    @GETREQUESTbyBatch_ID 
Scenario: Check if admin able to retrieve a batch with valid BATCH ID
Given Admin creates GET Request with valid Batch ID
When Admin sends HTTPS Request with endpointof get by ID
Then Admin receives 200 OK Status with response body in batch ID.

@GETREQUESTbyRetriveBatch_ID 
Scenario: Check if admin able to retrive a batch after deleting the batch
Given Admin creates GET Request with valid Batch ID
When Admin sends HTTPS Request with endpointof get by ID 
Then Admin receives 200 OK Status with response body in batch ID. 

@GETREQUESTbyBatchName
Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
Given Admin creates GET Request with valid Batch Name
When Admin sends HTTPS Request with endpointof get by Batch name
Then Admin receives 200 OK Status with response body in batch Name.

@GETREQUESTbyInvalidBatchName
Scenario: Check if admin able to retrieve a batch with invalid BATCH NAME
Given Admin creates GET Request with invalid Batch Name
When Admin sends HTTPS Request with endpointof get by invalid Batch name
Then Admin receives 404 Not Found Status with message and boolean success details_InvalidBatchname

@GETREQUESTbyprogramId
Scenario: Check if admin able to retrieve a batch with valid Program ID
Given Admin creates GET Request with valid Program Id
When Admin sends HTTPS Request with endpointof get by valid Program ID
Then Admin receives 200 OK Status with response body Program ID.   

@GETREQUESTbyinvalidprogramId
Scenario: Check if admin able to retrieve a batch with invalid Program Id
Given Admin creates GET Request with invalid Program Id
When Admin sends HTTPS Request with endpointof get by invalid Program ID
Then Admin receives 404 Not Found Status with message and boolean success details invalid Program ID.   
	@PUTREQUEST_UpdateBatchbybatchID
Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
Given Admin creates PUT Request with valid BatchId and Data
When Admin sends HTTPS Request with endpointof get by invalid UpdatebatchID
Then Admin receives 200 OK Status with updated value in response body UpdatebatchID.  

@DELETEREQUESTbyBatchID
Scenario: Check if admin able to delete a Batch with valid Batch ID
Given Admin creates DELETE Request with valid BatchId
When Admin sends HTTPS Request with endpoint for Delete by ID 
Then Admin receives 200 Ok status with message for Delete by ID
@DELETEREQUESTbyBatchID-invalidendpoint
Scenario: Check if admin able to delete a Batch with invalid endpoint
Given Admin creates DELETE Request with valid BatchId invalidendpoint 
When Admin sends HTTPS Request with invalid endpoint for Delete by ID 
Then Admin receives 404 not found for Delete by ID
@DELETEREQUESTbyBatchID-invalidBatchid
Scenario: Check if admin able to delete a Batch with invalid Batch ID
Given Admin creates DELETE Request with invalid BatchId
When Admin sends HTTPS Request with valid endpoint for Delete by ID 
Then Admin receives 404 Not Found Status with message and boolean success details for Delete by ID

    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
       