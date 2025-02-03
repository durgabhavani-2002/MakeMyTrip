Feature: Login Page Functional Testing

	Background:
		Given User is on the MakeMyTrip
		
	#This is for selecting the seat of bus in MakeMyTrip 
  @PositiveTesting 
  Scenario: Testing the selecting the seat of bus in MakeMyTrip 
    When User clicks on the bus
    And User enters the fromcity
    | makeMyTrip.xlsx |
    And User enters the destination city
    | makeMyTrip.xlsx |
    And User selects the date
    | makeMyTrip.xlsx |
    And User clicks on the search button
    And User redirected to bus list page
    And User selects the preferd bus 
    And User selcts the pickup and drop point locations
    And User click on the continue button 
    And User redirected to the complete your booking page
    And User fills the personal detils
    | makeMyTrip.xlsx |
    And User clicks on the continue button
    Then User is redirected to Payment page