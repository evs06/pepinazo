Feature: Login in page Todoist

  Scenario Outline:
  A_User Can log into todoist with Username and Password

    Given I have to open the browser
    When I open the todoist website
    And I login with the <username> and <password>
    Then I can see the Home Page

    Examples:
      | username               | password  |
      | jomarnavarro@gmail.com | Test@1234 |


#Scenario: Login button exists
#Scenario: Start session with Google
#Scenario: Start session with Facebook
#  Given I navigate to todoist.com
#  When I log into todoist with Facebook account
#  Then I should see the home page
#  And The list of projects will be visible
#
#Scenario: Login with Facebook that has same email as regular account

  #Inviable for the two factor authentication
#Scenario: Start session with Apple

#Scenario: Start session with User and Password
 # Given I navigate to todoist.com
 # When I log into todoist with valid credentials
 # Then I should see the home page
 # And The list of projects will be visible

#Scenario: Incorrect User
#Scenario: Incorrect Password
#
#
#Feature: Todoist Login
#
#  Scenario: Login button exists
#
#    Given I have open the browser
#
#    When I open Todoist website
#
#    Then Login button should exist
#
#
#Feature: Todoist Login
#
#  Scenario: Login button exists
#
#    Given I have open the browser
#
#    When I open Todoist website
#
#    Then Login button should exist
#
#
#Feature: Incorrect Password
#
#  Scenario: Login button exists
#
#    Given I have open the browser
#
#    When I open Todoist website
#
#    Then Login button should exist


