package application;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Airport;
import model.Flight;

public class Controller implements Initializable{
	
	private Airport air;

	@FXML
	private AnchorPane pane;
    
    @FXML
    private TextField textSearch;
    
    @FXML
	private TableColumn fechas, horas, aerolineas, num, destinos, puertas ;
	
	@FXML
	private TableView<Flight> table;
	

    @FXML
    void ordenarDateTime(ActionEvent event) throws NumberFormatException, ParseException {
    	
    	list();
    }

    @FXML
    void orderAirline(ActionEvent event) {
    	


    }

    @FXML
    void orderBoardingGates(ActionEvent event) {
    	
    	air.orderBoardingGate();
    	
    }

    @FXML
    void orderDestination(ActionEvent event) {

    }

    @FXML
    void orderFlightNumber(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }
    
    
    public void list() throws NumberFormatException, ParseException {
    	try {
    		ObservableList<Flight> listas =  air.loadTxt();
    	fechas.setCellValueFactory(new PropertyValueFactory<Flight,LocalDate>("Fecha"));
		horas.setCellValueFactory( new PropertyValueFactory<Flight, LocalTime>("Hora"));
		aerolineas.setCellValueFactory( new PropertyValueFactory<Flight, String>("Aerolinea"));
		num.setCellValueFactory( new PropertyValueFactory<Flight, Integer>("Vuelo"));
		destinos.setCellValueFactory( new PropertyValueFactory<Flight, String>("Destino"));
		puertas.setCellValueFactory( new PropertyValueFactory<Flight, Integer>("Puerta de embarque"));
		
		table.setItems(listas);
	
		System.out.print(" "+ listas.toString());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		air=new Airport();
	}

}

