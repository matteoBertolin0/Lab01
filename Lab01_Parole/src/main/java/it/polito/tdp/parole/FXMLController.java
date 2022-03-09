package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML
    void doInsert(ActionEvent event) {
    	long start=System.nanoTime();
    	txtResult.clear();
    	elenco.addParola(txtParola.getText());
    	for(String s : elenco.getElenco()) {    		
    		txtResult.appendText(s+"\n");
    	}
    	txtParola.clear();
    	long fine=System.nanoTime();
    	txtTime.appendText("L'operazione di inserimento ha impiegato "+Long.toString(fine-start)+" ns"+"\n");
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	long start=System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	long fine=System.nanoTime();
    	txtTime.appendText("L'operazione di reset ha impiegato "+Long.toString(fine-start)+" ns"+"\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long start=System.nanoTime();
    	elenco.cancella(txtResult.getSelectedText());
    	txtResult.clear();
    	for(String s : elenco.getElenco()) {    		
    		txtResult.appendText(s+"\n");
    	}
    	txtParola.clear();
    	long fine=System.nanoTime();
    	txtTime.appendText("L'operazione di cancellamento ha impiegato "+Long.toString(fine-start)+" ns"+"\n");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
