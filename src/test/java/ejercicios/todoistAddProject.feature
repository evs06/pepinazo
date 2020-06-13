Feature: Add a project in todoist

  Scenario Outline: Can create new projects

  Given I have to open the browser
  When I open the todoist website
  And I login with the <username> and <password>
  And I can create a new project with the <nameproject> and the <color>
  Then I can see the created project <nameproject> with the <color> and the list projects

  Examples:
  | username               | password  | nameproject  | color |
  | jomarnavarro@gmail.com | Test@1234 | testProjectV | Teal  |




  #Scenario: Delete project

  #Scenario: No possible add project with color fucsia


  #Scenario: Add a project with color rosa mexican