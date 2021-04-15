Feature: Bookswagon Functionality Check
Background:
Given User navigates to homepage
Then Verify Bookswagon Logo displayed
Scenario: Check add to cart functionality
And verify cart has no items
When user search for "birds"
Then verify search results displayed for "birds"
Then Navigate to "Music" category
Then Verify sort option on that page
And user changes sort from discount "Discount - Low to High"
Then user clicks on buy now button for first book
And user clicls on shop more items
Then verify cart has 1 item
Then user sign out from website
