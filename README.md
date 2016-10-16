List of API url and request body (if available).
Before each url there will be code (JVX) that means available response types: J for json, V for html views, X for xml. Example of urls: url.json, url.xml, url

	Get all users
	JV: http://localhost:8080/mentorship2-presentation/api/users.json (GET)

	Get user by id
	JVX: http://localhost:8080/mentorship2-presentation/api/users/5.xml (GET)

	Create user
	J: http://localhost:8080/mentorship2-presentation/api/users (POST)

	Create mentor
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/18/mentor?userId=10 (POST)

	Get mentor
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentor/19.json (GET)

	Assign mentees for mentor
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentor/19/mentees (PUT)

	Remove mentee from mentor
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentor/19/mentees/20 (DELETE)

	Get mentee
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentee/22 (GET)

	Create mentee
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/18/mentee?userId=10 (POST)

	Assign mentor
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentee/20.json?mentorId=19 (PUT)

	Change mentee state (active, started, finished)
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentee/20/state.json (PUT)

	Get list of mentors who mentors more than 2 mentees at this moment (only active). 
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentors.xml?menteesAmount=0&onlyActive=true (GET)

	Get list of mentees who are currently without mentors in user-selected location. 
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentees?location=KYIV (GET)

	Get list of all mentees and duration of their overall mentorship (counted in mentor-weeks) ordered descending with pagination. 
	JV: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/mentees/filter?desc=false&start=1&amount=5 (GET)

	Get statistic of success completions (e.g. % of people who completed the whole phase and not ended up in the middle) per user-selected period of time.
	J: http://localhost:8080/mentorship2-presentation/api/mentorship/participants/statistic.json (GET)
