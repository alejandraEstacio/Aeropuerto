package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Airport implements Comparator<Flight>{

	private ArrayList<Flight> flights;
	
	public Airport() {
		
		flights = new ArrayList<Flight>();		
		
	}
	
	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

//ordenar por burbuja
	
	public void  orderFlightNumber() {
		
		for (int i = flights.size(); i > 0; i--) {
			for (int j = 1; j < flights.size()- i-1; j++) {
				
				Flight f1 = (Flight) flights.get(j);
				Flight  f2= (Flight) flights.get(j+1);
				
				if(f1.compareNumber(f2)>0) {
					
					flights.set(j, f2);
					flights.set(j+1, f1);	
				}	
			}	
		}
	}
// ordenar por insercion
	
	public void orderAirline() {
		
		for( int i = 1; i < flights.size( ); i++ )
        {
           Flight insert = (Flight) flights.get( i );
            boolean finish = false;
            for( int j = i; j > 0 && !finish; j-- )
            {
                Flight act = (Flight) flights.get( j - 1 );
                if( act.compareAirline(insert) > 0 )
                {
                    flights.set(j, act);
                    flights.set(j - 1,insert);
                }
                else
                    finish = true;
            }
        }
		
		System.out.println(""+ flights.toString());
	}
	
//ordenar por Seleccion
	
	public void orderDestination() {
		
		int i;
		for( i =0; i<flights.size(); i++) {
			int less = i;
			Flight flightLess =(Flight) flights.get(i);
		
			for(int j=i+1; j<flights.size(); j++) {
				
				Flight f1 = (Flight) flights.get(j);
				
				if(f1.compareDestination(flightLess)>0) {	
					flightLess = f1;
					less = j;
				}
			}	
			if(less != i) {
				Flight temp = (Flight) flights.get(i);
				flights.set(i, flightLess );
				flights.set(less, temp);
			}
		}
	}
	
//ordenar por insercion 
public void orderBoardingGate () {
		
		for( int i = 1; i < flights.size( ); i++ )
        {
           Flight insert = (Flight) flights.get( i );
            boolean finish = false;
            for( int j = i; j > 0 && !finish; j-- )
            {
                Flight act = (Flight) flights.get( j - 1 );
                if( act.compareBoardingGate(insert) > 0 )
                {
                    flights.set(j, act);
                    flights.set(j - 1,insert);
                    
                    System.out.println(""+flights.toString());
                }
                else
                    finish = true;
            }
        }
	}


	public void orderDateTime() {
		
		for( int i = 1; i < flights.size( ); i++ )
	    {
	       Flight insert = (Flight) flights.get( i );
	        boolean finish = false;
	        for( int j = i; j > 0 && !finish; j-- )
	        {
	            Flight act = (Flight) flights.get( j - 1 );
	            if( act.compareTo(insert) > 0 )
	            {
	                flights.set(j, act);
	                flights.set(j - 1,insert);
	            }
	            else
	                finish = true;
	        }
	    }
	}

//buscar Binario 
	

	public  ObservableList<Flight> loadTxt() throws IOException, NumberFormatException, ParseException {
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		
		BufferedReader in = new BufferedReader(new FileReader("./data/datos.txt"));
		String line = in.readLine();
		
		while(line != null) {
			
			String[] arr = line.split(",");
			Flight f = new Flight(LocalDate.parse(arr[0]), LocalTime.parse(arr[1]), arr[2],Integer.parseInt( arr[3]), arr[4],Integer.parseInt(arr[5]));
			flights.add(f);
			line = in.readLine();
		}
		in.close();
	return flights;
	}

	@Override
	public int compare(Flight f1, Flight f2) {
		// TODO Auto-generated method stub
		return 0;
	}
}


