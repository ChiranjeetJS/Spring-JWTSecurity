# Spring-JWTSecurity
**Custom Authentication and Authorization Mechanism using SpringBoot and JWT(JSON Web Token)**
We have 3 uers
Ravi - ADMIN
Ram - User
Rohit - Manager

The user creates a JWT token using his name and then calls the product apis.
The Product Service validates the user first
If the user is valid and has role to access the api - the product api process the request
If the user is invalid - the product api throws UnAuthorized Exception
If the user is valid but does not have access to the role - the product api throws Forbidden Status.
