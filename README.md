List of API url and request body (if available).
Before each url there will be code (JVX) that means available response types: J for json, V for html views, X for xml. Example of urls: url.json, url.xml, url

	Get all users
	MVC: http://localhost:8080/mentorship2-presentation/users (GET)
	REST: http://localhost:8080/mentorship2-rest/api/users (GET)

	Get user by id
	MVC: http://localhost:8080/mentorship2-presentation/users/5 (GET)
	REST: http://localhost:8080/mentorship2-rest/api/users/5 (GET)

	Create user
	MVC: http://localhost:8080/mentorship2-presentation/users (POST)
	REST: http://localhost:8080/mentorship2-rest/api/users (POST)
	MVC/REST body example: 	{
							"firstName" : "John",
							"lastName": "Doe",
							"dateOfBirth": 154619484949,
							"jobTitle": "MIDDLE"
						}

	Create mentor
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/18/mentor?userId=15 (POST)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/18/mentor?userId=15 (POST)

	Get mentor
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentor/19 (GET)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentor/19 (GET)

	Assign mentees for mentor
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentor/19/mentees?menteesId=20,21 (POST)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentor/19/mentees?menteesId=20,21 (POST)

	Remove mentee from mentor
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentor/19/mentees/20 (GET)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentor/19/mentees/20 (DELETE)

	Get mentee
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentee/22 (GET)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentee/22 (GET)

	Create mentee
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/18/mentee?userId=9 (POST)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/18/mentee?userId=9 (POST)

	Assign mentor
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentee/21?mentorId=19 (POST)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentee/20?mentorId=19 (PUT)

	Change mentee state (active, started, finished)
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentee/20/state (POST)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentee/20/state (PUT)
	Body example: 	{
						"active": true,
						"start": true
					}

	Get list of mentors who mentors more than 2 mentees at this moment (only active). 
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentors?menteesAmount=0&onlyActive=true (GET)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentors?menteesAmount=0&onlyActive=true (GET)

	Get list of mentees who are currently without mentors in user-selected location. 
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentees?location=KYIV (GET)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentees?location=KYIV (GET)

	Get list of all mentees and duration of their overall mentorship (counted in mentor-weeks) ordered descending with pagination. 
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/mentees/filter?desc=false&start=2&amount=1 (GET)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/mentees/filter?desc=false&start=2&amount=1 (GET)

	Get statistic of success completions (e.g. % of people who completed the whole phase and not ended up in the middle) per user-selected period of time.
	MVC: http://localhost:8080/mentorship2-presentation/mentorship/participants/statistic (GET)
	REST: http://localhost:8080/mentorship2-rest/api/mentorship/participants/statistic (GET)
