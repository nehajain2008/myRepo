package com.mkyong.common.model;

import java.util.Date;

public class FlightDetail {
private String price;
private String origin;
private String destination;
private Date destinationTime;
private Date departureTime;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
	result = prime * result + ((destination == null) ? 0 : destination.hashCode());
	result = prime * result + ((destinationTime == null) ? 0 : destinationTime.hashCode());
	result = prime * result + ((origin == null) ? 0 : origin.hashCode());
	result = prime * result + ((price == null) ? 0 : price.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	FlightDetail other = (FlightDetail) obj;
	if (departureTime == null) {
		if (other.departureTime != null)
			return false;
	} else if (!departureTime.equals(other.departureTime))
		return false;
	if (destination == null) {
		if (other.destination != null)
			return false;
	} else if (!destination.equals(other.destination))
		return false;
	if (destinationTime == null) {
		if (other.destinationTime != null)
			return false;
	} else if (!destinationTime.equals(other.destinationTime))
		return false;
	if (origin == null) {
		if (other.origin != null)
			return false;
	} else if (!origin.equals(other.origin))
		return false;
	if (price == null) {
		if (other.price != null)
			return false;
	} else if (!price.equals(other.price))
		return false;
	return true;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public Date getDestinationTime() {
	return destinationTime;
}
public void setDestinationTime(Date destinationTime) {
	this.destinationTime = destinationTime;
}
public Date getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(Date departureTime) {
	this.departureTime = departureTime;
}

}
