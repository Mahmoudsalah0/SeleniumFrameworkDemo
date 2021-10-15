Feature: User Registeration
   I want to check that the user can register in our e-commerce website.

Scenario Outline: User Registeration 
 Given The user in the home page
 When I click on register link 
 And I enterd "<firstname>","<lastname>","<email>","<passwprd>"
 Then The Registeration page displayed successfully
 
Examples:
| firstname | lastname | email | password |
| Ahmed | Mohamed | tes122@gmail.com | 123212 |
| Mohsen | Ahmed | test123@gmail.com | 872653 |
| Sara | Samy | test0oi1@gmail.com | 768654 |
| Shrouk | Farag | test124@gmail.com | 876254 |