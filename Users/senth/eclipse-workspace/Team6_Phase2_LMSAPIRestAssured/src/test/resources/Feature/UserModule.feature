
@tag
Feature: POST REQUEST-Create new user
 Background: Admin sets authorization to bearer token

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
  
  @tag1
      Scenario: Check if admin able to retrieve all active Admins
      Given Admin creates GET Request
      When  Admin sends HTTPS Request with endpoint
      Then  Admin receives 200 OK
    
  @tag2
       Scenario: Check if admin able to retrieve all active Admins with invalid endpoint
       Given Admin creates GET Request 
       When Admin sends HTTPS Request with endpoint
       Then Admin receives 200 OK
    
  @tag3
       Scenario: Check if admin is able to get the Admins by program batches for valid batch ID
       Given Admin creates GET Request with valid batch Id
       When  Admin sends HTTPS Request with endpoint
      Then Admin receives 200 OK
  
  @tag4
     Scenario: Check if admin is able to get the Admins by program batches for invalid batch ID
     Given Admin creates GET Request  with invalid batchId
     When Admin sends HTTPS Request with endpoint
     Then Admin receives 404
     
  @tag5
     Scenario: Check if admin is able to retreive Admins by valid role ID
     Given Admin creates GET Request with valid role ID 
     When  Admin sends HTTPS Request with endpoint
     Then  Admin receives 200 OK
     
  @tag6
     Scenario: Check if admin is able to retreive Admins by invalid role ID
     Given Admin creates GET Request for GET with invalid role ID
     When Admin sends HTTPS Request with endpoint
     Then Admin receives 404
     
  @tag7
     Scenario: Check if admin is able to update role id of a Admin by valid Admin id
     Given Admin creates PUT Request with valid request body
     When Admin sends HTTPS Request with endpoint
     Then Admin receives 200 OK  Status with response body.                                                           
     
  @tag8
     Scenario: Check if admin is able to update a Admin with Admin Role Id with already existing Admin role ID
     Given Admin creates PUT Request with request body
     When Admin sends HTTPS Request with endpoint
     Then Admin receives 400 Bad Request Status with message and boolean success details
     
     
     
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    

    
    
    
    
    
    