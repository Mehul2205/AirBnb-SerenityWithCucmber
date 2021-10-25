Feature: Hotel Booking
  As a user you should
  Get Input Location SDate and EndDate and num of people
  So that I should get the respective result

  Scenario Outline: SumOfNumbers
    Given Open the url
    When enter <input> in the search box
    When enter <startdate> as startdate
    When enter <enddate> as endDate
    When enter <elder> as elder
    When enter <children> as children
    When enter <infant> as infant
    Then I should get the result as <result>
    Examples:
    |input|startdate|enddate|elder|children|infant|result|
    |Goa  |30/10/2021|1/11/2021|2 |1       |1     |20    |
    |Jaipur|28/10/2021|8/11/2021|4|2       |2     |20    |
