@usermodule3
Feature: User Module Post and Delete operations

  Background: 
    Given Admin sets authorization to bearer token

  @userROLEID_PUT1
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request with valid request body
    When Admin sends HTTPS Request with endpoint PUT ROLEID
    Then Admin receives statuscode with response body for usermodule update userRoleid.

  @userROLEID_PUT2
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id with no authorization
    Given Admin creates PUT Request with request body and sets authorization to bearer token to No Auth
    When Admin sends HTTPS Request with endpoint PUT ROLEID
    Then Admin receives statuscode with Unauthorized message for usermodule update userroleid

  @userROLEID_PUT3
  Scenario: Check if admin is able to update a Admin role ID with valid Admin role ID with invalid endpoint
    Given Admin creates PUT Request with request body for invalid endpoint
    When Admin sends HTTPS Request with invalid endpoint
    Then Admin receives  status code and Not Found Status for usermodule update userroleid

  @userROLESTATUS_PUT4
  Scenario: Check if admin is able to update role status of a Admin with valid and invalid Admin id or invalid role status
    Given Admin creates PUT Request with valid data in request body
    When Admin sends HTTPS Request with endpoint PUT ROLESTATUS
    Then Admin receives statuscode with response body for usermodule update userrolestatus.

  @userROLESTATUS_PUT5
  Scenario: Check if admin is able to update role status of a Admin with valid Admin id with no authorization
    Given Admin creates PUT Request with valid data in request body with no authorization
    When Admin sends HTTPS Request with endpoint PUT ROLESTATUS
    Then Admin receives statuscode with Unauthorized message for usermodule for userrolestatus

  @userROLESTATUS_PUT6
  Scenario: Check if admin is able to update role status of a Admin with invalid endpoint
    Given Admin creates PUT Request with valid data in request body  for invalid endpoint
    When Admin sends HTTPS Request with invalid endpoint ROLESTATUS
    Then Admin receives  status code and Not Found Status for usermodule update ROLESTATUS

  @userLOGINSTATUS_PUT7
  Scenario: Check if admin is able to update the Admin login status by valid or invalid Admin ID with different request body
    Given Admin creates PUT Request with valid data in request body for USerLOGINSTATUS
    When Admin sends HTTPS Request with endpoint of USerLOGINSTATUS
    Then Admin receives statuscode with response body for usermodule update loginstatus.

  @userLOGINSTATUS_PUT8
  Scenario: Check if admin is able to update the Admin login status by Admin ID with no Auth
    Given Admin creates PUT Request with valid data in request body but no Auth for USerLOGINSTATUS
    When Admin sends HTTPS Request with endpoint of USerLOGINSTATUS
    Then Admin receives statuscode with Unauthorized message for usermodule update userloginstatus
    
   @userLOGINSTATUS_PUT9
  Scenario: Check if admin is able to update the Admin login status by Admin ID with invalid endpoint
    Given Admin creates PUT Request with invalid enpoint and valid request body for USerLOGINSTATUS
    When Admin sends HTTPS Request with endpoint of USerLOGINSTATUS
    Then Admin receives  status code and Not Found Status for usermodule update userloginstatus
