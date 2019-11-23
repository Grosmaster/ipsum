## Rest API
* end point: http://localhost:8080/api/exec
* method: POST
* Content-Type: application/json
* body:
```json
{ 
   "distributionCenter":{ 
      "latitude":1.0,
      "longitude":1.0,
      "sizeResources":2,
      "startTime":"08:00:00",
      "endTime":"22:00:00"
   },
   "orders":[ 
      { 
         "id":"a4c66b12-24cf-479a-90fc-2c7924f86219",
         "weight":1,
         "latitude":2.0,
         "longitude":2.0,
         "startTime":"15:00",
         "endTime":"22:00",
         "shippingTime":"00:05",
         "dischargingTime":"00:05"
      },
      { 
         "id":"6bb72622-7def-4790-93ec-72f1c863ad7e",
         "weight":1,
         "latitude":3.0,
         "longitude":2.7,
         "startTime":"08:00",
         "endTime":"22:00",
         "shippingTime":"00:05",
         "dischargingTime":"00:05"
      },
      { 
         "id":"2e876e5d-e503-423c-b551-653f03e5274c",
         "weight":1,
         "latitude":2.5,
         "longitude":2.5,
         "startTime":"08:00",
         "endTime":"22:00",
         "shippingTime":"00:05",
         "dischargingTime":"00:05"
      }
   ],
   "resource":{ 
      "capacity":20,
      "speed":60.0,
      "speedMetersSecond":16.666666666666668
   }
}

```