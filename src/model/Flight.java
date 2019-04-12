package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Flight implements Comparable<Flight>{

	private LocalDate date;
	private LocalTime time;

	private String airline;
	private int flightNumber;
	private String destination;
	private int boardingGate;
	
	

	public Flight(LocalDate date, LocalTime time, String airline, int flightNumber, String destination,
			int boardingGate) {
		
		this.date = date;
		this.time = time;
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.boardingGate = boardingGate;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airlime) {
		this.airline = airlime;
	}


	public int getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getBoardingGate() {
		return boardingGate;
	}


	public void setBoardingGate(int boardingGate) {
		this.boardingGate = boardingGate;
	}


	public int compareNumber(Flight f) {
		
		if(flightNumber == f.flightNumber)
			return 0;
		else if(flightNumber > f.flightNumber)
			return 1;
		else 
			return -1;
		
	}
	
	public int compareAirline(Flight f) {
		int valor = 0;
		if(airline.compareTo(f.airline)==0) {
			valor =0;
		}else if(airline.compareTo(f.airline)>0) {
			
			valor = 1;
		}else {
			valor = -1;
		}
		return valor;
	}
	
	public int compareDestination(Flight f) {
		int valor = 0;
		if(destination.compareTo(f.destination)==0) {
			valor =0;
		}else if(destination.compareTo(f.destination)>0) {
			
			valor = 1;
		}else {
			valor = -1;
		}
		return valor;
	}
	
	
	public int compareBoardingGate(Flight f) {
		
		if(boardingGate == f.boardingGate)
			return 0;
		else if(boardingGate > f.boardingGate)
			return 1;
		else 
			return -1;
	}

	@Override
	public int compareTo(Flight arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	

	
}
