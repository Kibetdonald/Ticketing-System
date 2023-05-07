# Ticketing-System
This is a Spring Boot application for managing tickets for a large organization. It provides a web-based interface for administrators to manage tickets and users, as well as a set of RESTful APIs that can be consumed by a front-end application.


Sure, here's an updated version of the README.md file:

### Ticketing Management System
This is a Spring Boot application for managing tickets for a large organization. It provides a web-based interface for administrators to manage tickets and users, as well as a set of RESTful APIs that can be consumed by a front-end application.

#### Features
- User registration and authentication
- Ticket submission with attachments
- Ticket assignment to administrators and teams
- Ticket resolution and escalation
- Ticket feedback from users
- User and ticket search functionality
- Admin dashboard for managing tickets and users
- Admin user and team management

#### Technologies Used
- Spring Boot
- Spring Security
- Spring Data JPA
- Postgresql
- Spring MVC
- Docker
- AWS S3

#### End Points
User Registration
 ```
http://127.0.0.1:8000/api/auth/register
```
Authenticate User

```
http://127.0.0.1:8000/api/auth/authenticate
```

Fetch Registered Users
```
http://127.0.0.1:8000/api/auth/user/users
```

Fetch User details by Id
```
http://127.0.0.1:8000/api/auth/user/users/1
```
Edit user details
```
http://127.0.0.1:8000/api/auth/user/update/users/2
```

Delete user
```
http://127.0.0.1:8000/api/auth/user/delete/user/3
```




