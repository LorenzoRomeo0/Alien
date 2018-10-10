package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public class AlienController {

	
	private AlienModel alien=new AlienModel();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputText;

    @FXML
    private Button translateButton;

    @FXML
    private TextArea outputText;

    @FXML
    private Button buttonClear;

    @FXML
    void doClear(ActionEvent event) {
    	outputText.setText("");
    }
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String text=inputText.getText();
    	if(!text.isEmpty())
    		if(text.split(" ").length==2)
    			outputText.setText(alien.wordCheck(text.split(" ")[0],text.split(" ")[1]));
    		else if(text.split(" ").length==1)
    				outputText.setText(alien.wordCheck(text.split(" ")[0],""));
    }

    @FXML
    void initialize() {
        assert inputText != null : "fx:id=\"inputText\" was not injected: check your FXML file 'Alien.fxml'.";
        assert translateButton != null : "fx:id=\"translateButton\" was not injected: check your FXML file 'Alien.fxml'.";
        assert outputText != null : "fx:id=\"outputText\" was not injected: check your FXML file 'Alien.fxml'.";
        assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
