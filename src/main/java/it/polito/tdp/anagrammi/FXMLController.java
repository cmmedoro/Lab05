/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCorrectResult"
    private TextArea txtCorrectResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtWord"
    private TextField txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="txtWrongResult"
    private TextArea txtWrongResult; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	//eventualmente, cancella tutto
    	this.txtCorrectResult.clear();
    	this.txtWrongResult.clear();
    	//ottieni la parola da anagrammare
    	String anagramma = this.txtWord.getText();
    	//esegui anagramma
    	Set<String> sol = this.model.anagramma(anagramma);
    	//distinguo
    	for(String ss : sol) {
    		if(this.model.isCorrect(ss)) {
    			this.txtCorrectResult.appendText(ss+"\n");
    		}
    		else {
    			this.txtWrongResult.appendText(ss+"\n");
    		}
    	}
    	/*
    	//stampa a video
    	for(String s : sol) {
    		this.txtCorrectResult.appendText(s+"\n");
    	}
    	 */
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtWord.clear();
    	this.txtCorrectResult.clear();
    	this.txtWrongResult.clear();
    }
    
    void setModel(Model model) {
    	this.model=model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCorrectResult != null : "fx:id=\"txtCorrectResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWrongResult != null : "fx:id=\"txtWrongResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
