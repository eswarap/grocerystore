Feature:login functionality
@Test
Scenario:As a user I should be able to login to my account.
Given Navigate to login page.
When User logs in with the username and password.
Then Home page should be displayed.