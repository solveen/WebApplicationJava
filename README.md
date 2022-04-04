# WebLevi
  It is a web application built with Java that demonstrates the simple CRUD opertations and user search function. 
  

  To see **WebLevi** live in action, open a browser tab and go to  https://web-application-project-dwit.herokuapp.com/. 
  


## How to run the app on localhost
   
   1. Install intellij 2021 ultimate edition and XAMMP.  
   2. Clone the project into your desired directory.
   3. Open the project with intellij.
   4. You need to add External libraries such as MySQL connector and JavaServer Pages Standard Tag Library(JSTL).
   * You can download JSTL from https://tomcat.apache.org/taglibs/standard/ and MySQL connector from https://dev.mysql.com/downloads/connector/j/.
   * After the files are downloaded you need to place both jar files inside the lib directory of both tomcat and intellij.
   * Then, open intellij and go to file and click on project structure.
   * Click on the libraries tab and then on plus sign located in the top-middle of the tab and select java.
       <p align="center" width="100%">
         <img src="https://user-images.githubusercontent.com/41668152/161547728-29ca211d-676a-411d-ac39-ed50c0415be3.png" width="400" height="300">
       </p>
   
   * From then, you can add the two libraries that you have downloaded and placed in the tomcat lib directory.   
        <p align="center" width="100%">
         <img src="https://user-images.githubusercontent.com/41668152/161548080-17863cbd-ec2e-4703-a55a-51b700341f82.png" width="400" height="300">
        </p>
   5. Open XAMMP control panel and then, start MySQL and Apcahe services.
   6. Configure the tomcat server in the edit configurations of intellij.
      <p align="center" width="100%">
         <img src="https://user-images.githubusercontent.com/41668152/161539448-3fb71b67-0bba-4a7f-b0f3-7a56fff816a7.png" width="400" height="300">
       </p>
   7. Then, click on the configure button as shown in the picture below.
       <p align="center" width="100%">
         <img src="https://user-images.githubusercontent.com/41668152/161539767-d2cb65a4-eaee-4a0c-8231-e4fd83824a9c.png" width="400" height="300">
       </p>
   8. After, that you need to configure the home and base directory of the tomcat server which can be found inside the XAMMP folder.

## User Stories
   1. A user can add new users.
   2. A user can view other user details
   3. A user can update details of other users.
   4. A user can delete other users.
 
## Features 
  * Add users and Update user
    * User adds new user or update new user
    * The user details are validated, no empty details allowed
    * The user details are sent to the database
  * User listing
    * The updated or added users are shown in the list along with other users.
  * Searching user
    * The user searches username to get the details of the other users.
  * Deleting user
    * User deletes other user with their id which will erase them from the database. 
  
## Technical
   * The front end of the app is built with HTML/CSS, Javascript and Bootstrap 4.
   * The back end is built with JAVA EE 8 and it uses XAMMP with MySQL as a database. 
   * The external libraries used for this project are MySQL Connector/J (used for JDBC connection to MySQL) and JSTL.
  
## Future developments of the app will include:
  * Admin Login and Dashboard
  * Social Login
  * Able to message other users
  * Topic discussion and comment section
  * Like and dislike of comments
  * Ability to rate user's profile
  * Top rated comments and top discussion of the months


## User interface of the web application
  <p align="left" width="100%">
    <img src="https://user-images.githubusercontent.com/41668152/161559870-40b014c6-5a9c-4f68-8459-b25d9077662b.png" width="500" height="300">
    <img src="https://user-images.githubusercontent.com/41668152/161560409-e4c8b563-d9b3-4856-8f25-afb8e7e3d5e3.png" width="500" height="300">
  </p> 

  <p align="left" width="100%">
    <img src="https://user-images.githubusercontent.com/41668152/161560766-e218b283-8748-4f8f-bd85-68549233051b.png" width="500" height="300">
    <img src="https://user-images.githubusercontent.com/41668152/161560892-5df17d08-95f4-4c54-a5eb-1acf0fcfbec3.png" width="500" height="300">
  </p> 
  
  <p align="left" width="100%">
    <img src="https://user-images.githubusercontent.com/41668152/161560966-8be7d8dd-16cc-4a56-a6a4-59720b7aa961.png" width="500" height="300">
    <img src="https://user-images.githubusercontent.com/41668152/161561265-4118e200-e01b-4011-9e1f-fddb7a6d404e.png" width="500" height="300">
  </p> 
