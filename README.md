**NuLogic Automation Framework**

Update to main branch on feb-07-2024
Added below features
- Name the reports current date and time
- Use Excel datasheet to read and write user credentials and other data
- Moved the results folder out of project folder into order to reduce file size. Results will be stored in C:// drive.
- Read both .xls and .xlsx files format in datasheet folder.


Update to main branch on feb-12-2024
Added below features
- Added sheetname in read excel function. The sheetname should be provided with filename.
- Added firefox and edge browser support for web pages. Browser option can be changed in datasheet.
- Updated script to read browser properties from excel instead of config.properties files.
- Read mobile device specification from datasheet instaed of config.properties. All the mobile specific details can be updated in datasheet.
- Set the drivers folder as default. All the browser driver files should be saved in drivers folder.


Update to main branch on Mar-8-2024
Added below features
- Added API testing feature

Update to main branch on Mar-20-2024
Added below features
- Added feature to run in Azure pipeline by taking inputs through variables.
- Added feature to run in browserstack. Update the remote option in datasheet.xlsx to run in browserstack.
- Added a new "testsheet.xlsx" which contains all the webElements.
