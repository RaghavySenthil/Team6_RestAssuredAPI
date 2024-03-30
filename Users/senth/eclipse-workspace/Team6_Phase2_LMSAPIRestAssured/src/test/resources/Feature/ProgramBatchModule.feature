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
@tag
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
    
   @tag3
  Scenario: Check if admin able to create a Batch missing mandatory fields in request body
   Given Admin creates POST Request  with invalid data in request body 
    When Admin sends HTTPS Request with endpoint 
    Then Admin receives 400 Bad Request Status with message and boolean success details 
    
    @tag4
  Scenario: Check if admin able to create a batch with invalid endpoint
   Given Admin creates POST Request  
    When Admin sends HTTPS Request with invalid endpoint  
    Then Admin receives 404 not found  Status
    
     @tag5
  Scenario: Check if admin able to create a batch with missing additional fields
   Given Admin creates POST Request with missing additional fields  
    When Admin sends HTTPS Request with endpoint   
    Then Admin receives 201 Created Status with response body.    
    
     @tag6
  Scenario: Check if admin able to create a batch with invalid data in request body
   Given Admin creates POST Request with invalid data in request body  
    When Admin sends HTTPS Request with endpoint   
    Then Admin receives 400 Bad Request Status with message and boolean success details     
    
     @tag7
  Scenario: Check if admin able to create a batch  with inactive program ID
   Given Admin creates POST Request with inactive program id  
    When Admin sends HTTPS Request with endpoint   
    Then Admin receives 400 Bad Request Status with message and boolean success details                                                           
    
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       