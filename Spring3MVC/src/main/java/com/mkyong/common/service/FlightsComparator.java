package com.mkyong.common.service;

import java.util.Comparator;

import com.mkyong.common.model.FlightDetail;

public class FlightsComparator implements Comparator<FlightDetail>{

	@Override
	public int compare(FlightDetail f1, FlightDetail f2) {
		int returnVal = 0;
		 if(Double.parseDouble(f1.getPrice().substring(1)) > Double.parseDouble(f2.getPrice().substring(1))){
	            return 1;
	        } 
		 if(Double.parseDouble(f1.getPrice().substring(1)) < Double.parseDouble(f2.getPrice().substring(1))){
	            return -1;
	        }
		 
		 if(f1.getPrice().equals(f2.getPrice())){
			 if(f1.getDepartureTime().after(f2.getDepartureTime()))
				 returnVal=1;
			 
			 else 
				 returnVal=-1;
			 
		 
		 }
		 return returnVal;
		
	}

}
