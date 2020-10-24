Feature: Search Random Post (from JsonPlaceholder) in Google

  Scenario: 1.1 - Search Title of Random Post in Google
    Given random post from JSONPlaceholder fake Online REST API
    Given navigate to google page
    When research Title of random post in Google Search
    Then verify is there key word of title in the first result