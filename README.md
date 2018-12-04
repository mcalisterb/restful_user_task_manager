RESTful User Details and Task Manager

______________
INSTALLATION:
______________

Docker build:

$<INSTALL_DIR> $ docker build -t restful_user_task_manager build/

_______
TO RUN:
_______

1) Start the service:

$<INSTALL_DIR> $ docker run -d -it -p 8080:8080 restful_user_task_manager

_______
TO TEST:
________
Test using curl from command line, as shown below:

-- List current users --
curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/api/user

-- Add a user --
curl -i -H "Content-Type: application/json" -X POST -d '{"username":"jsmith","first_name" : "John", "last_name" : "Smith"}' http://localhost:8080/api/user

-- Get an existing users Info --
curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/api/user/1

-- Update an existing user -- 
curl -i -H "Content-Type: application/json" -X PUT -d '{"first_name" : "John", "last_name" : "Doe"}' http://localhost:8080/api/user/1

-- Add a task to an existing user --
curl -i -H "Content-Type: application/json" -X POST -d '{"name":"My task","description" : "Description of task", "date_time" : "2016-05-25 14:25:00"}' http://localhost:8080/api/user/1/task

-- Update existing task --
curl -i -H "Content-Type: application/json" -X PUT -d '{"name":"My updated task"}' http://localhost:8080/api/user/6/task/1

-- Delete an existing task --
curl -i -H "Content-Type: application/json" -X DELETE http://localhost:8080/api/user/1/task/1

-- Get all tasks for a user --
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/user/1/task

-- Get task info for specific task and user --
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/user/1/task/3

-- Get all tasks for all users
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/user/task





