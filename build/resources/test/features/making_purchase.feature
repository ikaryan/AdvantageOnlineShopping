Feature: Making a purchase
  I as user
  I need to buy a product in Advantage Online Shopping website
  and check the payment has been made successfully

  Scenario: Creating access for a new user
    Given a new user needs access to buy a new product
      | user  | password  |
      | karlo | Karlox123 |
    When the user is not registered and require being created
      | userName | email                | password    | firstName | lastName | phoneNumber | country  | city     | address       | state     | postalCode |
      | Charles     | karlox@advantage.com | Karlox123++ | Karlox    | Ortiz    | 45268978    | Colombia | Envigado | Av 33 # 15-36 | Antioquia | 5002356    |
    Then the new user is created successfully

  Scenario: Buying a new product
    Given an active user needs access to buy a new product
    When the product to buy is selected
      | productName | displayType | operatingSysType | processorType | colorType | productSelected | quantity |
      | laptops     | 2           | 1                | 8             | C3C3C3    | 4               | 2        |
    Then the product is bought
      | safepayuser | safepaypass |
      | joselito    | Joselito123 |