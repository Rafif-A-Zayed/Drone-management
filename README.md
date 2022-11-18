# Musala - Drone

 is a Java project to manage drones for as medication transportation.

- All APIs are "self-documented" by Swagger2 using annotations
- a RESTful service using annotation: supports JSON request / response

# Assumptions
- Support fleet of 10 drone
- 5 Drones will be loaded in app startup 
  - one with medication 
  - serial number as "serial-i" i = 1 to 5
  - medication code MED_CODE_i_j , i drone number , j index
  - medication code MED_NAME-i-j , i drone number , j index
- Update API work only for Drone in IDLE state
- For daily job 
  - battery threshold to consider it has problem is 30% 
  - run daily at 12:00 AM
  - publish event with drones data, and it should be handled by another service (Ex. notification service) to send alert via (Ex. email)
- Audit table added for Drone ( capacity , state ) changes c, it can be used for history changes and reports 

Run 
- Clone this repository
- Make sure you have JDK 8+ , gradle
- to run
  - build the app gradle clean build
  - go to build dir 
  - run java -jar  Musala-1.0.0.jar in build path
- DB consol http://localhost:8080/musala/h2-console 
- Swagger http://localhost:8080/musala/swagger-ui/index.html
- Health check: http://localhost:8080/musala/actuator/health

# Requirement 
- Gradle 7.5.1
- Java 8+ 
# Usage
## REST API

The REST API to the example app is described below.

### Get available Drones

#### Request

`GET /musala/v1/drone/available`

    curl -i -H 'Accept: application/json' http://localhost:8080/musala/v1/drone/available

#### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2
     [
          {
              "serialNumber": "serial-1",
              "state": "IDLE",
              "model": "Middleweight",
              "wight": 327.7181448366422,
              "capacity": 100,
              "medications": []
          }
      ]
   
    

### Get a specific Drone

#### Request

`GET /musala/v1/drone/{serial-number}`

    curl -i -H 'Accept: application/json' http://localhost:8080/musala/v1/drone/{serial-number}

#### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2

     {
        "serialNumber": "serial-1",
        "state": "IDLE",
        "model": "Middleweight",
        "wight": 327.7181448366422,
        "capacity": 100,
        "medications": []
     }
    
### Get a specific Drone medication for loaded drones

#### Request

`GET /musala/v1/drone/{serial-number}/medication`

    curl -i -H 'Accept: application/json' http://localhost:8080/musala/v1/drone/{serial-number}/medication

#### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2
    [
        {
            "code": "MED-CODE-4-0",
            "name": "MED-NAME-4=0",
            "wight": 90,
            "image": null
        }
    ]
    
### Get a specific Drone capacity
#### Request

`GET /musala/v1/drone/{serial-number}/battery`

    curl -i -H 'Accept: application/json' http://localhost:8080/musala/v1/drone/{serial-number}/battery

#### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2
    100
    

### Create a new Drone

### Request

`POST /musala/v1/drone/`

    curl -i -H 'Accept: application/json' -d 'serialNumber=serial-10&wight=350&capacity=50' http://localhost:8080/musala/v1/drone

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36
    {
      "serialNumber": "serial-11",
      "state": "IDLE",
      "model": "Lightweight",
      "wight": 300,
      "capacity": 50,
      "medications": null
      }
### Load Drone medication

### Request

`PUT /musala/v1/drone/{serialNumber}`

    curl -i -H 'Accept: application/json' -d '[]' http://localhost:8080/musala/v1/drone/{serialNumber}

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36
    {
      "serialNumber": "serial-11",
      "state": "IDLE",
      "model": "Lightweight",
      "wight": 300,
      "capacity": 50,
      "medications": null
      }
  
  




    
