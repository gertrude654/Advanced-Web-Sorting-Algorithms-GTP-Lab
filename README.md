# Advanced Web Sorting Algorithms
## Project Objectives
### Design and Implement RESTful API:
1.Follow HATEOAS principles using Spring Framework.
2.Configure and deploy the application on an Apache Tomcat web server.
3.Ensure proper handling of HTTP protocols.
### Develop a Spring-based Web Application:
1.Utilize Spring modules, dependency injection, autowiring
### Implement and Integrate Sorting Algorithms:
1.Implement Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort algorithms.
2.Integrate these algorithms within the application for data manipulation.
### Features
- HTTP Protocols & Apache Tomcat Web Server:
oConfigure and deploy the web application on Apache Tomcat.
oEnsure proper handling of HTTP requests and responses.
- API Design:
1.Design a RESTful API adhering to HATEOAS principles.
2.Implement API endpoints for CRUD operations on a sample dataset.
- Spring Framework:
1.Utilize Spring modules for building the application.
2.Implement dependency injection, autowiring, and inversion of control.
- Sorting Algorithms:
1.Implement Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort algorithms.
2.Integrate these sorting algorithms into the application for data manipulation.
  .Provide an interface to select and execute different sorting algorithms on a sample dataset.
### Setup Instructions
- Clone the Repository:
https://github.com/gertrude654/Advanced-Web-Sorting-Algorithms-GTP-Lab.git

- Video link:
https://www.loom.com/share/94fd84699c77408e95c5ce94f210c85f

Configure Apache Tomcat:
Copy the generated WAR file (target/sorting.war) to the Tomcat webapps directory.
### API Endpoints:
#### Get All Students:
 GET http://localhost/sorting/api/students
#### Get Student by ID:
 GET http://localhost/sorting/api/students/{id}
#### Add Student:
 POSTGET http://localhost/sorting/api/students

 Content-Type: application/json
Body: {
  "id": 1,
  "name": "John Doe"
}
Update Student:
o
PUT http://localhost/sorting/api/students/{id}

Content-Type: application/json
Body: {
  "name": "Jane Doe"
}
#### Delete Student:
DELETE http://localhost/sorting/api/students/{id}
#### Sort Students:
- GET /sorting/api/students/sort/heap
- GET /sorting/api/students/sort/quick
- GET /sorting/api/students/sort/merge
- GET /sorting/api/students/sort/radix
- GET /sorting/api/students/sort/bucket

