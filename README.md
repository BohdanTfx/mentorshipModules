========================Spring MVC endpoints=========================

List of API url and request body (if available).

	Get all users
	MVC: http://localhost:8080/users (GET)
	REST: http://localhost:8081/api/users (GET)

	Get user by id
	MVC: http://localhost:8080/users/5 (GET)
	REST: http://localhost:8081/api/users/5 (GET)

	Create user
	MVC: http://localhost:8080/users (POST)
	REST: http://localhost:8081/api/users (POST)
	MVC/REST body example: 	{
							"firstName" : "John",
							"lastName": "Doe",
							"dateOfBirth": 154619484949,
							"jobTitle": "MIDDLE"
						}

	Create mentor
	MVC: http://localhost:8080/mentorship/participants/18/mentor?userId=15 (POST)
	REST: http://localhost:8081/api/mentorship/participants/18/mentor?userId=15 (POST)

	Get mentor
	MVC: http://localhost:8080/mentorship/participants/mentor/19 (GET)
	REST: http://localhost:8081/api/mentorship/participants/mentor/19 (GET)

	Assign mentees for mentor
	MVC: http://localhost:8080/mentorship/participants/mentor/19/mentees?menteesId=20,21 (POST)
	REST: http://localhost:8081/api/mentorship/participants/mentor/19/mentees?menteesId=20,21 (POST)

	Remove mentee from mentor
	MVC: http://localhost:8080/mentorship/participants/mentor/19/mentees/20 (GET)
	REST: http://localhost:8081/api/mentorship/participants/mentor/19/mentees/20 (DELETE)

	Get mentee
	MVC: http://localhost:8080/mentorship/participants/mentee/22 (GET)
	REST: http://localhost:8081/api/mentorship/participants/mentee/22 (GET)

	Create mentee
	MVC: http://localhost:8080/mentorship/participants/18/mentee?userId=9 (POST)
	REST: http://localhost:8081/api/mentorship/participants/18/mentee?userId=9 (POST)

	Assign mentor
	MVC: http://localhost:8080/mentorship/participants/mentee/21?mentorId=19 (POST)
	REST: http://localhost:8081/api/mentorship/participants/mentee/20?mentorId=19 (PUT)

	Change mentee state (active, started, finished)
	MVC: http://localhost:8080/mentorship/participants/mentee/20/state (POST)
	REST: http://localhost:8081/api/mentorship/participants/mentee/20/state (PUT)
	Body example: 	{
						"active": true,
						"start": true
					}

	Get list of mentors who mentors more than 2 mentees at this moment (only active). 
	MVC: http://localhost:8080/mentorship/participants/mentors?menteesAmount=0&onlyActive=true (GET)
	REST: http://localhost:8081/api/mentorship/participants/mentors?menteesAmount=0&onlyActive=true (GET)

	Get list of mentees who are currently without mentors in user-selected location. 
	MVC: http://localhost:8080/mentorship/participants/mentees?location=KYIV (GET)
	REST: http://localhost:8081/api/mentorship/participants/mentees?location=KYIV (GET)

	Get list of all mentees and duration of their overall mentorship (counted in mentor-weeks) ordered descending with pagination. 
	MVC: http://localhost:8080/mentorship/participants/mentees/filter?desc=false&start=2&amount=1 (GET)
	REST: http://localhost:8081/api/mentorship/participants/mentees/filter?desc=false&start=2&amount=1 (GET)

	Get statistic of success completions (e.g. % of people who completed the whole phase and not ended up in the middle) per user-selected period of time.
	MVC: http://localhost:8080/mentorship/participants/statistic (GET)
	REST: http://localhost:8081/api/mentorship/participants/statistic (GET)

===========================JMS task===============================

	1.Install and run ActiveMQ
		1.1.JMS task consist from two parts: Consumer app (jms-consumer-app module) and Publisher app (tracker package in api-client module)
		1.2.In case if topics were not created automatically create them manually (authDestination, activityDestination topics)
		1.3.Create durable subscriber fro authDestination topic with following name: default_auth_subscriber
	2.New endpoints:
		2.1.http://localhost:8080/auth/login to login
		2.2.http://localhost:8080/auth/logout to logout
	3.You may call any API endpoint from presentation module (MVC) endpoint to check page loading activity logic
	4.You may review all logs catched by JMS listeners into log_entry table

=============================Spring Boot================================

	To run any of applications (rest or presentation) execute "mvn spring-boot:run" on it.
	New database dump attached.
	Presentation module support authentication and JMS features.

==============================Mongo DB======================================

To run project follow next steps:
	
	1. Install MongoDB and launch it
	2. Launch MySQL, ActiveMQ as described in previous topics
	3. Create 'mentorship_logs' database. If you want to use another database name please change appropriate property in application.properties
	4. Import dump using following command: mongoimport --db mentorship_logs --collection logEntry --file logs.json. You can find dump into 'database' folder of parent project
	5. Run presentation project via Spring Boot
	6. You can access logs by next URL: http://localhost:8080/logs?type=auth. Note that 'type' parameter is optional

==============================AngularJS=========================================

In order to run application follow next steps:

	1. Run Rest module (Note: it running on 8081 port now)
	2. Run mentorship-ng module as simple Spring Boot application
	3. Open your browser and go to http://localhost:8080/
	
	Note: You may need to recreate DB in order to make application works correctly. There is new dump attached in 'database' folder.