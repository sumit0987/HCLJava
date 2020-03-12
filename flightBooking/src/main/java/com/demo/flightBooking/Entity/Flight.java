package com.demo.flightBooking.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flighttable")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flightid")
	private int flightId;
	@Column(name = "carrier")
	private String carrier;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
	
	//@Column(name = "departuretime")
	//private LocalDate departureTime;
	@Column(name = "departuretime")
	private Date departureTime;
	
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	//public LocalDate getDepartureTime() {
	//	return departureTime;
	//}
	//public void setDepartureTime(LocalDate departureTime) {
	//	this.departureTime = departureTime;
	//}
	
	
}
