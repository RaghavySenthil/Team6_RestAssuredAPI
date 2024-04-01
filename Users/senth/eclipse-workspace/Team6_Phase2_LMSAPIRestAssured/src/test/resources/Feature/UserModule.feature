@usermodule3
Feature: User Module Post and Delete operations

  Background: 
     Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 200 created with auto generated token

  @userROLEID_PUT1
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request with valid request body FOR USERROLEID
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with response body for usermodule3 update.

  @userROLEID_PUT2
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id with no authorization
    Given Admin creates PUT Request with request body and sets authorization to bearer token to No Auth
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with Unauthorized message for usermodule3 update

  @userROLEID_PUT3
  Scenario: Check if admin is able to update a Admin role ID with valid Admin role ID with invalid endpoint
    Given Admin creates PUT Request with request body for invalid endpoint
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives  status code and Not Found Status for usermodule3 update

  @userROLESTATUS_PUT4
  Scenario: Check if admin is able to update role status of a Admin with valid and invalid Admin id or invalid role status
    Given Admin creates PUT Request with valid data in request body
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with response body for usermodule3 update.

  @userROLESTATUS_PUT5
  Scenario: Check if admin is able to update role status of a Admin with valid Admin id with no authorization
    Given Admin creates PUT Request with valid data in request body with no authorization
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with Unauthorized message for usermodule3 update

  @userROLESTATUS_PUT6
  Scenario: Check if admin is able to update role status of a Admin with invalid endpoint
    Given Admin creates PUT Request with valid data in request body  for invalid endpoint
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives  status code and Not Found Status for usermodule3 update

  @userLOGINSTATUS_PUT7
  Scenario: Check if admin is able to update the Admin login status by valid or invalid Admin ID with different request body
    Given Admin creates PUT Request with valid data in request body for USerLOGINSTATUS
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with response body for usermodule3 update.

  @userLOGINSTATUS_PUT8
  Scenario: Check if admin is able to update the Admin login status by Admin ID with no Auth
    Given Admin creates PUT Request with valid data in request body but no Auth for USerLOGINSTATUS
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with Unauthorized message for usermodule3 update

  @userLOGINSTATUS_PUT9
  Scenario: Check if admin is able to update the Admin login status by Admin ID with invalid endpoint
    Given Admin creates PUT Request with invalid enpoint and valid request body for USerLOGINSTATUS
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives  status code and Not Found Status for usermodule3 update

  @userURPBS_PUT10
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id with different request body
    Given Admin creates PUT Request with valid data in request body for userrolePBS
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with response body for usermodule3 update.
    
     @userURPBS_PUT11
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id with no AUTH
    Given Admin creates PUT Request with valid data in request body for userrolePBS with NoAUTH
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with Unauthorized message for usermodule3 update
    
      @userURPBS_PUT12
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id with invalid endpoint
    Given Admin creates PUT Request with valid data in request body for userrolePBS with invalid endpoint
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives  status code and Not Found Status for usermodule3 update

  @userLOGINSTATUS_DELETE13
  Scenario: Check if Admin able to delete a Admin with VALID OR INVALID Admin Id
    Given Admin creates DELETE Request to delete Admin details for USERMODULE
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with response body for usermodule3 update.

  @userLOGINSTATUS_DELETE14
  Scenario: Check if Admin able to delete a Admin with No authorization
    Given Admin creates DELETE Request to delete Admin details without Auth
    When Admin sends HTTPS Request with endpoint UPDATE USERMODULE3
    Then Admin receives statuscode with Unauthorized message for usermodule3 update
    
    
  @tag1
  Scenario: Create a new Admin with valid endpoint and request body with mandatory fields
    Given Admin creates POST request with all mandatory fields 
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 201 Created Status with response body.  

  @tag2
  Scenario: Create a new Admin with valid endpoint and request body with mandatory and additional fields
    Given Admin creates POST request with all mandatory fields and additional fields 
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 201 Created Status with response body.  

  @tag3
  Scenario: Create a Admin with valid endpoint and invalid values in request body
    Given Admin creates POST request with invalid values in request body 
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 400 Bad Request Status with message and boolean success details  

  @tag4
  Scenario: Create a Admin with missing mandatory fields in request body
    Given Admin creates POST request with missing mandatory fields in request body 
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 400 Bad Request Status with error message  

  @tag5
  Scenario: Create a new Admin with request body without authorization
    Given Admin creates POST request with all mandatory fields and additional fields 
    When Admin sends HTTPS Request with endpoint without authorization
    Then Admin receives status 401 with Unauthorized message  

  @tag6
  Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with GET All Roles endpoint
    Then Admin receives 200 OK  

  @tag7
  Scenario: Check if admin is able to retreive all the available roles without Authorization
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with GET All Roles endpoint without Authorization
    Then Admin receives status 401 with Unauthorized message  

  @tag8
  Scenario: Check if admin is able to retreive all the available roles with invalid End point
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with invalid endpoint
    Then Admin receives status 404 with Not Found error message  
        
  @tag9
  Scenario: Check if admin able to retrieve all Admin with valid endpoint
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with valid endpoint
    Then Admin receives 200 OK Status with response body  

  @tag10
  Scenario: Check if admin able to retrieve all Admin without Authorization
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with valid endpoint without Authorization
    Then Admin receives status 401 with Unauthorized message  
    
  @tag11
  Scenario: Check if admin able to retrieve all Admin with invalid endpoint
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with invalid endpoint
    Then Admin receives status 404 with Not Found error message  
    
  @tag12
  Scenario: Check if admin able to retrieve a Admin with valid Admin ID
    Given Admin creates GET Request with valid AdminId 
    When Admin sends HTTPS Request to retrieve a Admin with valid Admin ID with valid endpoint
    Then Admin receives 200 OK Status with response body  

  @tag13
  Scenario: Check if admin able to retrieve a Admin with valid Admin ID and invalid endpoint
    Given Admin creates GET Request with valid AdminId 
    When Admin sends HTTPS Request to retrieve a Admin with valid Admin ID with invalid endpoint
    Then Admin receives status 404 with Not Found error message  

  @tag14
  Scenario: Check if admin able to retrieve a Admin with valid Admin ID with No authorization
    Given Admin creates GET Request with valid AdminId 
    When Admin sends HTTPS Request to retrieve a Admin with valid Admin ID with valid endpoint without Authorization
    Then Admin receives status 401 with Unauthorized message  

  @tag15
  Scenario: Check if Admin able to retrieve a Admin with invalid Admin ID
    Given Admin creates GET Request with invalid AdminId 
    When Admin sends HTTPS Request to retrieve a Admin with invalid Admin ID with valid endpoint
    Then Admin receives status 404 with Not Found error message  

  @tag16
  Scenario: Check if admin able to retrieve all active Admins
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to retrieve all active Admins with endpoint
    Then Admin receives 200 OK  

  @tag17
  Scenario: Check if admin able to retrieve all active Admins with no authorization
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to retrieve all active Admins with endpoint without Authorization
    Then Admin receives status 401 with Unauthorized message  

  @tag18
  Scenario: Check if admin able to retrieve all active Admins with invalid endpoint
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to retrieve all active Admins with invalid endpoint
    Then Admin receives status 404 with Not Found error message  

  @tag19
  Scenario: Check if admin is able to get count of active and inactive Admins
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to get count of active and inactive Admins with endpoint
    Then Admin receives 200 OK  

  @tag20
  Scenario: Check if admin is able to get count of active and inactive Admins with no authorization
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to get count of active and inactive Admins with no authorization
    Then Admin receives status 401 with Unauthorized message  

  @tag21
  Scenario: Check if admin is able to get count of active and inactive Admins with invalid endpoint
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to get count of active and inactive Admins with invalid endpoint
    Then Admin receives status 404 with Not Found error message  

  @tag22
  Scenario: Check if admin is able to get count of active and inactive Admins by role id
    Given Admin creates GET Request with role id 
    When Admin sends HTTPS Request to get count of active and inactive Admins by role id with endpoint
    Then Admin receives 200 OK  

  @tag23
  Scenario: Check if admin is able to get count of active and inactive Admins by invalid role ID
    Given Admin creates GET Request with invalid role id 
    When Admin sends HTTPS Request to get count of active and inactive Admins by invalid role ID
    Then Admin receives status 404 with Not Found error message  
      
        
    
    
 