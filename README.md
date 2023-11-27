# Spring-JWTSecurity
**Custom Authentication and Authorization Mechanism using SpringBoot and JWT(JSON Web Token)**
We have 3 uers
Ravi - ADMIN - Can add Product to the Inventory
Rohit - Manager - can view all the Product Available and Prodct Sold
Ram - User - can view all the Products Available

**Workflow**
The user creates a JWT token using his name and then calls the product apis.
The Product Service validates the user first
If the user is valid and has role to access the api - the product api process the request
If the user is invalid - the product api throws UnAuthorized Exception
If the user is valid but does not have access to the role - the product api throws Forbidden Status.
