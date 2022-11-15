# Musala - Drone

 is a Java project to manage drones for as medication transportation.
 
# Usage
## REST API

The REST API to the example app is described below.

### Get available Drones

#### Request

`GET /drone/available`

    curl -i -H 'Accept: application/json' http://localhost:8080/drone/available

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

`GET /drone/{serial-number}`

    curl -i -H 'Accept: application/json' http://localhost:8080/drone/{serial-number}

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

`GET /drone/{serial-number}/medication`

    curl -i -H 'Accept: application/json' http://localhost:8080/drone/{serial-number}/medication

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

`GET /drone/{serial-number}/battery`

    curl -i -H 'Accept: application/json' http://localhost:8080/drone/{serial-number}/battery

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

`POST /drone/`

    curl -i -H 'Accept: application/json' -d 'serialNumber=serial-10&wight=350&capacity=50' http://localhost:8080/drone

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

`PUT /drone/{serialNumber}`

    curl -i -H 'Accept: application/json' -d '[]' http://localhost:8080/drone/{serialNumber}

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
  
  




    
