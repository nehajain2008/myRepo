1.Its a web application with endpoint “SearchFlights” that takes data from three separate
provider lists with the following interface:and  build tool to build the project.

2.Its a maven project ;I have specified spring related dependencies in the pom.xml and declared Dispatcher servlet in web.xml.

3.Created one Rest Controller called FlightController which returns the json response for the specified Rest.

4.Implemented a Service class which has two methods-
 a.getFlightDetails- this reads the 3 provider text files into a set and creates a list of flights for the given source and destination.
 b.getFlights method has the logic for reading the text files and is called by getFlightDetails method .
 
 5.I have attached the two screenshots of postman and the console output as because of time shortage 
 


