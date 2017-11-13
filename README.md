# Simple web application developed with java & jsf which consumes JSON API

JSON API:
https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel

# Website:

https://hotel-deals-shuqair.herokuapp.com/

# How It Works:

The user fill the "Hotel Deals" form then click on "Get Deals" button, a list of hotel deals will be displayed to the user, if the user wants to know more details, the user can click on the hotel image, and the hotel site will open.

# Languages used

I am basically working on C#.net and mvc technologies and have a good knowledge in Java, so I used Java, JSF and Tomcat technologies because java syntax is very similar to C# so I can get familiar with its code easier than other languages options.

I used google/gson to convert JSON url to java objects, then the java objects will be filtered according to user select criteria.

I used prime faces to display date fields as calendar and to display error validation messages

# What I learned

I have learned how to deal with JSF and how to deal with JSON

# How it can be enhanced

- To get results in the same page under the controls while the user type the destination (intelliSense)
- To display ratings in the list as stars which filled according to rating value
- To apply bootstrap technology to be responsive site.

# Assumptions

- if the user fills no data, all hotel deals will be retrieved

- Rating fields must be numeric

- Date format is displayed as yyyy-mm-dd

# Issues:

The gson convert JSON url into java objects, it convert the whole JSON then filter java objects according to user entry which affect site performance for large no. of hotel deals. 
