# NOAA_API

An API written with Java and Spring that allows you to search for NOAA weather observations for a given station id. This can also be used with [a simple UI I made for this.](https://github.com/adamb3ard/noaa-ui)

### Project setup
Download the NOAA weather readings [here](ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/by_year/2017.csv.gz) and move it into 
```
src/main/resources
```

### Compile and run the server
```
mvn clean install
mvn spring-boot:run
```

### Using the server and API
You can check the server is running by navigating here:
```
http://localhost:8080/actuator/health
```

The API endpoint for reading stations looks like this:
```
/api/v1/stations/<station id>
```

Example request:
```
GET http://localhost:8080/api/v1/stations/AFM00040948
```

Example response:
```
{
    "observations": [
        {
            "observationId": 7,
            "recordedDate": "2017-01-01T06:00:00.000+00:00",
            "type": "TAVG",
            "value": 69,
            "mflag": "H",
            "qflag": "",
            "sflag": "S"
        },
        {
            "observationId": 93971,
            "recordedDate": "2017-01-02T06:00:00.000+00:00",
            "type": "TAVG",
            "value": 52,
            "mflag": "H",
            "qflag": "",
            "sflag": "S"
        },
        {
            "observationId": 189593,
            "recordedDate": "2017-01-03T06:00:00.000+00:00",
            "type": "TAVG",
            "value": 12,
            "mflag": "H",
            "qflag": "",
            "sflag": "S"
        }
    ]
}
```