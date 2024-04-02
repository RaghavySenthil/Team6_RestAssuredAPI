#Author: 
@UserRoleProgramBatchMapController
Feature: Get Assigned Program/Batch(es) of All Users

@GetAllRoles
 Scenario: Check if admin is able to retreive all Admins with assigned program batches
  Given Admin creates GET Request to retrieve all Admins assigned to programs/batches
  When Admin sends HTTPS Request map
  Then Admin receives 200 OK map
  
   Scenario: Check if admin is able to retreive all Admins with assigned program batches with No Authorization
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches without authorization
    When Admin sends HTTPS Request without authorization
    Then Admin receives status 401 with Unauthorized message map
    
    Scenario: Check if admin is able to retreive all Admins with assigned program batches with invalid endpoint
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches for ProgramBatchMap
    When Admin sends HTTPS Request with invalid endpoint for ProgramBatchMap
    Then Admin receives status 404 map
    
    Scenario Outline: Check if admin is able to retreive assigned program batches for valid AdminId
    Given Admin creates GET Request to retrieve Admin assigned to Program/Batch by AdminId
    When Admin sends HTTPS Request to get assigned program by adminId "<adminId>" endpoint
    Then Admin receives <status> in response body map
    Examples: 
      | adminId|status|
      | U230		|200	|
      |U@1489		 |404		|
      |143			 |404		|
    	|null				|404	|
    	
    Scenario Outline: Check if admin is able to delete the program batch for valid Admin and No Authorization
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by valid AdminId and no auth
    When Admin sends HTTPS Request to delete endpoint  by "<adminId>"
    Then Admin receives status 401 with Unauthorized map1
   	Examples: 
      | adminId| 
      | U1596	|
 			
   
 Scenario Outline: Check if admin is able to delete the program batch for a Admin
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by AdminId
    When Admin sends HTTPS Request to delete endpoint  by "<adminId>"
    Then Admin receives <status> in response body
    Examples: 
      | adminId| status|
      | U230	| 200|
 			| 157 | 404|