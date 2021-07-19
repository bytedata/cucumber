Feature: Check home page functionality

  Background: user is logged in
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to home page

  Scenario: check logout link
   # Given user is loged in                         #his line is taken care by background
    When user clicks on welcome link
    Then logout link is displayed

  Scenario: verify quick launch tool bar is present
    # Given user is logged in                        #his line is taken care by background
    When user clicks on dashboard link
    Then quick launch toolbar is displayed
