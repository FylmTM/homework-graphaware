# Hawaiian pizza

## How to run locally
The application requires docker to be installed locally (or to install all the dependand services manually). Start up the docker-compose with the file in the root and the app is ready to run.
 
## Sample HTTP requests
There are sample HTTP requests in the root of the project in the `sampleRequests.http` file. The requests contain correct auth headers. They can be ran from the IntelliJ Idea Http client (only part of the paid version).

## Sample data
Default users and pizzas are created using SQL load script. Other data should be created using sample HTTP request

## Authentication
Authentication is based on Basic Auth, so with every request to a protected endpoint, username and password must be added as headers.
