Feature:
 Descriping The purpose of this feature is to test End 2 End integration.
 
 Scenario Outline: Customer place an order by purshasing an item from search 

 Given user is on Home Page 
 When he search for "<ProductName>"
 And choose to buy two items
 And Moves to checkout cart and enter personal information on checkout page and place the order 
 Then He can view the order and download the invoice 
 
 Examples:
   | ProductName |
   | Apple MacBook Pro 13-inch |
