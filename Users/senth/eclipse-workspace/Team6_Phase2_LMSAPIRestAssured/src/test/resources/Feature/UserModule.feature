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
Feature: POST REQUEST-Create new user
 Background:Admin sets authorization to bearer token

  @Create_User-all_mandatoryfields
  Scenario: Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields
    Given Admin creates POST request with all mandatory fields 
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 201 Created Status with response body.    
    

 @Create_User-all_mandatory-additional_fields
  Scenario: Check if admin able to create a new Admin with valid endpoint and request body with mandatory and additional fields
    Given Admin creates POST request with all mandatory fields and additional fields
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 201 Created Status with response body. 
    
  @Create_User-Negative_Scenario_400
  Scenario: Check if admin is able to create a Admin with valid endpoint and invalid values in request body
    Given Admin creates POST request with all mandatory fields and additional fields
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 400 Bad Request Status with message and boolean success details. 
  
 @Create_User-Negative2_Scenario_400
  Scenario: Check if Admin able to create a Admin missing mandatory fields in request body
    Given Admin creates POST request with missing mandatory fields in request body
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 400 Bad Request Status with error message.
 @Create_User-Negative4_Scenario_401_No_Auth
    Scenario: Check if admin able to create a new Admin with request body without authorization
    Given Admin creates POST request with all mandatory fields and additional fields
    When Admin sends HTTPS Request with endpoint
    Then Admin receives status 401 with Unauthorized message.   
          
    
    
    
    
    