Feature: To validate the file uploading Scenario

  Scenario: File Uploading
    Given user navigate to the fileupload application
    When user click on the choose file and upload
    When click upload button
    Then File upload should be successfully