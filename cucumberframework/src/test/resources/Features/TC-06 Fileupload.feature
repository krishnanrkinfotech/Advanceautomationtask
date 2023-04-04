Feature: To validate the file uploading Scenario

  Scenario: File Uploading
    Given User navigate to the fileupload application
    When User click on the choose file and upload
    When Click upload button
    Then File upload should be successfully