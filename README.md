# Plantis - Server

## Description
Plantis is an app where users can track the plants that have at home, you can choose the plant you have, add it to your profile and then add notes. Also as an admin you can delete plants, upload pictures and edit them.
 
## User Stories
 
 
- **Homepage** - As a user I want to be able to access the homepage so that I see what the app is about and login and signup
- **Sign up** - As a user I want to sign up on the webpage so that I can see all the plants.
- **Login** - As a user I want to be able to log in on the webpage so that I can get back to my
account.
- **Logout** - As a user I want to be able to log out from the webpage so that I can make sure no one will access my account
- **Login/Signup Validations** - As a user I want to see a well described message if I add wrong the login and signup.
- **404**- As a user I want to see a nice 404 page when I go to a page that doesn’t exist so that I know it was my fault.
- **My plants** - As a user I want to see my plants and add notes.
- **Add plants** - As an admin I want to upload an image and add a new plant into the database.
- **Edit plants** - As an admin I want to update the current plants.
- **Delete plants** - As an admin I want to delete the plants from the database.

 ## Technologies Used
- Java
- IntelliJ
- MySQL
- REST API

 

  

## Models

User model

```javascript
{
  id: {type: Long },
  name: {type: String, required: true },
  email: {type: String, required: true, unique: true},
  password: {type: String, required: true},
  roles: [ { OneToOne } ],
  userFavorites: [{ManyToMany}]
},
```
Role model

```javascript
{
  id: {type: Long },
  name: {type: String, required: true },
},
```

Plant model

```javascript
{
  id: {type: Long },
  name: {type: String, required: true },
  image: {type: String, required: true},
  description: {type: String, required: true},
  lightRequirement: {type: String, required: true},
  waterRequirement: {type: String, required: true},
  users: [{ManyToMany}]
},
```


GeneralPlant model

```javascript
{
   id: {type: Long },
  name: {type: String, required: true },
  image: {type: String, required: true},
  description: {type: String, required: true},
  lightRequirement: {type: String, required: true},
  waterRequirement: {type: String, required: true},
  users: [{ManyToMany}]
},
```


<br>


## API Endpoints (backend routes)

| HTTP Method | URL                         |                                                 
| ----------- | --------------------------- | 
| POST        | `/auth/signup`                | 
| GET       | `/auth/verify`                 | 
| GET       | `/api/generalplants/{id}`                | 
| GET         | `/api/generalplants`               |                        
| POST         | `/api/generalplants`           | 
| PUT         | `/api/generalplants/{id}`               | 
| DELETE       | `/api/generalplants/{id}`               | 
| GET         | `/api//plants/{id}`           | 
| GET      | `/api/plants`          | 
| GET         | `/api/plants/favourite/{plantId}`                 | 
| DELETE         | `/api/favourite/{plantId}`                  | 
| PATCH        | `/api/favourite/{plantId}`                  |



<br>
 ## Future Work
 - Implement water calendar

 ## Resources
 - Google
  
  
  ## Links
 
### Trello

https://trello.com/b/VoT43A4O/plantis
