@tag

Feature: Purchase ordr from Eccommerce
 

Background:
Given Launch URL

@Regression
Scenario Outline: Verifying the positive flow of purchasing the order 
Given Enter login details with username <Username> and pwd <Pwd>
And  I add a <Product> in Cart
Then CheckOut <Product> and submit the order
And Verify the confirmation message "Thankyou for the order."


Examples:

|Username          |  |Pwd     |  | Product       |
|mansa123@gmail.com|  |Mansa123|  |ADIDAS ORIGINAL|
|Rinki456@gmail.com|  |Rinki@123|   |ZARA COAT 3|
