# Simple web-application developed with jsf consumes JSON

a simple website built using JSF web framework cosumes the following API:
https://radiant-escarpment-30246.herokuapp.com/rest/trip/details

consist of:

1.TribBean: a java bean registered with JSF 

2.JsonConsumer: consumes json from an external API

3.TripDetails: an interface contains 2 methods used in tripBean // developed based on the assumption that those methods might be used by
more than one consumer in the future

4.TripDetailsImpl: implementation for the above interface

5.TripDetailsTest: implement test cases for the two methods implemented in tripDetailsImpl class (JUnit)

6.index.xhtml: contains a form to submit details of the trip

7.notfound.xhtml: 404 page displayed when an exception is thrown by JsonConsumer

8.result.xhtml: displays the result in a table

9.header.xhtml: links to used resources

10.default.css: handles application styling 

11.default.js: handles application js

# Live Demo:

https://arcane-waters-53518.herokuapp.com/

# How It Works:

Home page is displayed with a form -> users fill-in the form -> fields are mapped to the bean and added as URL params
-> the external service is requested and a JSON response is retrieved (if nothing wrong happened) -> result displayed in a table

# Prerequisite

-Java[1.8]

-Maven 3

-Tomcat v9.0

# Dependencies

          <dependencies>
                <!-- https://mvnrepository.com/artifact/org.json/json -->
              <dependency>
                  <groupId>org.json</groupId>
                  <artifactId>json</artifactId>
                  <version>20160810</version>
              </dependency>
                <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-impl -->
              <dependency>
                  <groupId>com.sun.faces</groupId>
                  <artifactId>jsf-impl</artifactId>
                  <version>2.1.4</version>
              </dependency>
                <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-api -->
              <dependency>
                  <groupId>com.sun.faces</groupId>
                  <artifactId>jsf-api</artifactId>
                  <version>2.1.5</version>
              </dependency>
              <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
              <dependency>
                  <groupId>org.apache.httpcomponents</groupId>
                  <artifactId>httpclient</artifactId>
                  <version>4.5</version>
              </dependency>
              <!-- https://mvnrepository.com/artifact/jstl/jstl -->
              <dependency>
                  <groupId>jstl</groupId>
                  <artifactId>jstl</artifactId>
                  <version>1.2</version>
              </dependency>
              <dependency>
                      <groupId>junit</groupId>
                      <artifactId>junit</artifactId>
                      <version>4.12</version>
              </dependency>
            </dependencies>

# Assumptions

-Empty fields are allowed -> display all

-Assuming that there are more than one consumer for the tripDetails

-Numbers of stars/guest/total that are more than 10 or
negative numbers if found won't be added to the request

-Empty strings are accepted but won't be added to the url

-If min and max start date are filled, travel start and end date will be disabled

-First date picker can't be in the past (Min start date > now)

-Second date picker is dependant on the first date picker (second date >= first date)

-Rating fields must be numeric

# Test-cases Assumptions

-Testing is done using JUnit

-TripDetails exist and has the fallowing methods: getDetailsUrl, getTripDetails.

-Assuming that the String (apiURL) in the method getDetailsUrl is empty and has no effect what so ever on test cases

-Dates validation is done on the client-side

# Issues:

The table displays one record only (trip details related to one JSON object)
