Feature: Searching for terms
As a User
I want to search for a particular term
So that I can see information about it

   Scenario Outline: Search bing for google
   Given I go to "<website>" website
   When I search for "<searchTerm>"
   Then I can see the "<searchResult>"
   
Examples:
    | website   | searchTerm | searchResult |
    | https://www.bing.com | QAConsulting | QAConsulting |
    | https://www.bing.com | Guru99 | Guru99 |
    | https://www.bing.com | BlazeDemo | BlazeDemo |
    | https://www.bing.com | AutomatedTesting | AutomatedTesting |