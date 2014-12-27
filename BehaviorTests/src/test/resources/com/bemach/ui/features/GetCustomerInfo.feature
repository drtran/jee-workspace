@wip
Feature: Getting Customer Information Application
    As a partner application, 
    I want to get information of a customer by a customer ID
    So that, I can send promotion information to that customer.
    
  Scenario Outline: Getting a customer record by a given customer ID
    Given that I am an authorized user "ws_user" with password "user1234"
    And that the customer exists with "<customer_id>", "<company_name>", "<contact_name>", "<contact_title>", and "<phone>":
    When I am at Customer Information page
    And I enter the "<customer_id>"
    And I click on a retrieve button
    Then I should see a customer record with "<customer_id>", "<company_name>", "<contact_name>", "<contact_title>", and "<phone>"
    
    Examples:
      | customer_id | company_name       | contact_name   | contact_title | phone          |      
      | EASTC       | Eastern Connection | Ann Devon      | Sales Agent   | (171) 555-0297 |
      | DUMON       | Du monde entier    | Janine Labrune | Owner         | France         |