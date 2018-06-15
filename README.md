Problem Statement 
==============

To create an end-to-end rest api which generates a product name and price from a given product id, inserts and updates price in a noSQL data source. The product name does not resides in noSQL data source rather it is fetched from another rest api based on passed product id. On get request the service creates a response JSON combining Price from noSQL data source and Name from other api. 

Technology Used 
=============

Spring Boot, jersey framework, MongoDB and Intellij IDE has been used to create the project. 

Project Structure
=============

Step 1: 
An initial maven project using spring Initialzr adding dependencies web, MongoDBa and Jersey has been created.

Step 2: 
The project has been added to Intellij IDE and dependency json-simple has been added. 

Step 3: 
Following folders has been created to project structure: 

	-controller
	-document (to store data models)
	-DocumentVO(To create custom data model and interact with view layer to service layer)
	-service (to implement business logics)
	-repository (creating interface to datasource) 
	-exception 
  
Step 4:
Apart from creating a GET and PUT request a POST request has been created to add data in Mongo DB.

Project Flow 
===========

ProductdetailsApplication.java initiates the project and all the requests managed in productController.java. productController.java uses objects of DocumentVo type and interacts with RetailLogics.java(service layer) and saves Documents in Database or returns desired response. 

The response has been fetched from RetailLogics/covertJSON(id)function. And the response object is pretty big, so recursive function recurseKeys() is used to find the field required for this project rather that creating a  whole model class for response.

In application.properties MongoDB details are mentioned and desired port for server to run(8091 is used here) 

Project Testing: 
===============

Step 1:
Initialize MongoDB instance and build the project using pom.xml.

Step 2 :
Inserting some data in MongoDB (POST)

Request URL: http://localhost:8092/product/save

Request Body:

  {
  "productId": 17,
      "price": {
          "value": 6000,
          "currency_cd": "USD"
      }
      }

Step 3:
Read the value (GET)

Request URL: http://localhost:8092/product/13860428

Response: 


{
    "productId": 13860428,
    "productName": "The Big Lebowski (Blu-ray)",
    "price": {
        "value": 6000,
        "currency_cd": "USD"
    }
}


Step 4: 
Updating the Price

Request URL: http://localhost:8092/product/13860428

Request Body: 


{ 
    "productId": 13860428,
    "price": {
        "value": 5000,
        "currency_cd": "USD"
    }
}


