#Author: your.email@your.domain.com
Feature: Get Assigned Program/Batch(es) of All Users
Background: Admin sets Authorization to bearer token
@GetAllRoles
 Scenario: Check if admin is able to retreive all Admins with assigned program batches
  Given Admin creates GET Request to retrieve all Admins assigned to programs/batches
  When Admin sends HTTPS Request
  Then Admin receives 200 OK
  @GetuserRole
  Scenario: Check if admin is able to retreive assigned program batches for valid AdminId
  Given Admin creates GET Request to retrieve Admin assigned to Program/Batch by AdminId
  When Admin sends HTTPS Request
  Then Admin receives 200 OK
  @DeleteAllPrograms
  Scenario: Check if admin is able to delete the program batch for a Admin
  Given Admin creates DELETE Request to delete Admin assigned to program/batch by AdminId
  When  Admin sends HTTPS Request
  Then  Admin receives 200 OK