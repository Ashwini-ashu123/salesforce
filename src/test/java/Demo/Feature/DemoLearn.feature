Feature: Login feature
  Login into the facebook account
  User should be able to login successfully

  Scenario: Login to the facebook account
    Given Open the browser and search for the facebook url
    When facebook url open for login enter the username and password
    Then click on the login button
    And user is successfully able to login to the account



  Scenario: Login to salesforce application with valid user
    Given user enter the salesforce application
    When user enter the username and password
    And user click on the login button
    And Click on the app Launcher and open the Torrent pharama
    And Verify the Home page of Torrent pharam is displayed

  Scenario: Login to SF application and add the new product for the organization
    Given user enter the salesforce application
    When user enter the username and password
    And user click on the login button
    And Click on the app Launcher and open the Torrent pharama
    And Verify the Home page of Torrent pharam is displayed
    And user click on the 'My Products' from the tab and verify user is in 'All Products' page
#    And click on the 'New' button
    And fill the details
     |Product Name  | Therapeutic Area   | Product Formulation | Dosage | Active | Manufacturing Company |
     | Genivia      | Immunology         | Capsule             | 50Mg   | True   | Cipla                 |
     | Paracetamol  | Analgesics         | Tablet              | 500Mg  | True   | Sun Pharma            |
     | Cetirizine   | Infectious Disease | Syrup               | 10ml   | False  | Dr. Reddy             |
#    And click on the save button and verify the product is added to all product



  Scenario: Login to the salesforce application and add product using csv file format
    Given user enter the salesforce application
    When user enter the username and password
    And user click on the login button
    And Click on the app Launcher and open the Torrent pharama
    And Verify the Home page of Torrent pharam is displayed
    And user click on the 'My Products' from the tab and verify user is in 'All Products' page
    And upload the form with the 'product1.csv'
    And verify the product is added successfully


    Scenario: Login to the saleforce application and add bulk organisation and bulk
      doctor
      Given user enter the salesforce application
      When user enter the username and password
      And user click on the login button
      And Click on the app Launcher and open the Torrent pharama
      And Verify the Home page of Torrent pharam is displayed
      And user click on the 'Clinical Info' from the tab and verify user is in 'All Products' page




