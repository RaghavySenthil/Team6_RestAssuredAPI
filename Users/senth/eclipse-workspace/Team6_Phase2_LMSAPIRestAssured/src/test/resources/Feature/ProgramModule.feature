#Author: Aswini

@ProgramModule
Feature: GetRequest
  To validate GetRequest feature
	
	
	@createProgram
	Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
	Given Admin creates POST Request for the LMS with request body
	|programDescription|programName|programStatus|
	|Test Program Module|TestProgram11|active|
	
	When Admin sends HTTPS Request and  request Body with endpoint
	
	Then Admin receives 201 Created Status with response body.
	
  @getAllPrograms
  Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body                                                    

	@getProgram
  Scenario: Check if Admin able to retrieve given programs with valid Endpoint
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint by programid
    Then Admin receives 200 OK Status with response body and getschema validation                                                   
	
	
	@updateProgram
	Scenario: Check if Admin able to update a program with valid endpoint and request body with Authorization
	Given Admin creates UPDATE Request for the LMS with request body
	|programDescription|programName|programStatus|
	|Test Program Module updated|TestProgram11|active|
	
	When Admin sends HTTPS Request and  request Body with valid endpoint
	
	Then Admin receives 200 OK Status with response body and Schema Validation.
	
	@createProgramExcel
  Scenario: Check if Admin able to create a program
   Given Admin creates POST Request for the LMS with request body from given sheetname "<SheetName>" and rowNumber <RowNumber> as in testdata
	 When Admin sends HTTPS Request and request Body with endpoint as in testdata
	 Then Admin receives Status with response body as in testdata 
		
@getProgramExcel
  Scenario: Check if Admin able to get a program
    Given Admin creates GET Request for the LMS with request body from given sheetname "<SheetName>" and rowNumber <RowNumber> as in testdata
		When Admin sends HTTPS Request and request Body with endpoint as in testdata
		Then Admin receives Status with response body as in testdata 
		
	@updateProgramExcel
  Scenario: Check if Admin able to update a program
   Given Admin creates PUT Request for the LMS with request body from given sheetname "<SheetName>" and rowNumber <RowNumber> as in testdata
	 When Admin sends HTTPS Request and request Body with endpoint as in testdata
	 Then Admin receives Status with response body as in testdata 

@deleteProgramExcel
  Scenario: Check if Admin able to delete a program
   Given Admin creates DELETE Request for the LMS with request body from given sheetname "<SheetName>" and rowNumber <RowNumber> as in testdata
		When Admin sends HTTPS Request and request Body with endpoint as in testdata
		Then Admin receives Status with response body as in testdata 
