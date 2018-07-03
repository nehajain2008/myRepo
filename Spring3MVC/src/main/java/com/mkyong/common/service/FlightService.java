package com.mkyong.common.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;


import com.mkyong.common.model.FlightDetail;

@Service
public class FlightService {

	public FlightService() {
	}

	public Set<FlightDetail> getFlightDetails(String source, String destination) {
		Set<FlightDetail> flightsList = new TreeSet<FlightDetail>(new FlightsComparator());
		Set<FlightDetail> providerList = new HashSet<FlightDetail>();
		getFlights("provider1.txt", providerList);
		getFlights("provider2.txt", providerList);
		getFlights("provider3.txt", providerList);
		
		for (FlightDetail flightDetails : providerList) {
			if (flightDetails.getOrigin().equals(source) && flightDetails.getDestination().equals(destination)) {
				flightsList.add(flightDetails);
				

		}
		}
		
		for (FlightDetail flightDetail : flightsList) {
			System.out.print(flightDetail.getOrigin());
			System.out.print(" "+flightDetail.getDestination());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			System.out.print(dateFormat.format(flightDetail.getDepartureTime()));
			System.out.print(" "+dateFormat.format(flightDetail.getDestinationTime()));
			System.out.println(" "+flightDetail.getPrice());
		}
			
		
		return flightsList;


	}

	public Set<FlightDetail> getFlights(String filename, Set<FlightDetail> providerList) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C://conf//" + filename));
			String line = reader.readLine();
			while (line != null) {
				// System.out.println(line);
				String[] tokens;
				if (!filename.equals("provider3.txt")) {
					tokens = line.split(",");

				} else
					tokens = line.split("\\|");

				FlightDetail flightDetails = new FlightDetail();
				flightDetails.setOrigin(tokens[0]);
				Date departuretime;
				try {
					if (!filename.equals("provider2.txt")) {
						departuretime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(tokens[1]);
						Date destinationTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(tokens[3]);
						flightDetails.setDestinationTime(destinationTime);
						flightDetails.setDepartureTime(departuretime);
					} else {
						departuretime = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").parse(tokens[1]);
						Date destinationTime = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").parse(tokens[3]);
						flightDetails.setDestinationTime(destinationTime);
						flightDetails.setDepartureTime(departuretime);

					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				flightDetails.setDestination(tokens[2]);
				flightDetails.setPrice(tokens[4]);
				providerList.add(flightDetails);

				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return providerList;

	}

}
