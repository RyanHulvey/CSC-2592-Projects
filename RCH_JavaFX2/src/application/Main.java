package application;
import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;



public class Main extends Application {
	
	  @FXML
	  private CheckBox introBox;
	  @FXML
	  private CheckBox webBox;
	  @FXML
	  private CheckBox programBox;
	  @FXML
	  private CheckBox securityBox;
	  @FXML
	  private TextField nonStudentField;
	  @FXML
	  private TextField studentField;
	  @FXML
	  private TextField dinnerField;
	  @FXML
	  private Pane AnchorPane;
	  @FXML
	  private Button submitButton;
	  @FXML
	  private Label outputText;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Scene_Builder.fxml"));
		Scene primaryScene = new Scene(root);
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("Registration Fee Calculator");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	  public int isNumberCalculation(TextField inputField) {
		int num = 0;
	    if(isNumber(inputField)) {
	    	num = Integer.parseInt(inputField.getText());
	    	
	    } else {
	      inputField.clear();
	      inputField.setPromptText("Invalid");
	    }
	    return num;
	  }

	  
	  public static boolean isNumber(TextField inputField){
	      try{
	        Double.parseDouble(inputField.getText());
	      }
	      catch(Exception e){
	        return false;
	      }
	      return true;
	  }
	  
	  // The checkRegistrationFee checks the total number of people, students, and people attending the speech, then adds the amount to the total.
	    public int checkRegistrationFee(int speechPeople, int numPeople, int numStudents) {
	    	int total = 0;
	        total += numPeople * 895;
	        total += numStudents * 495;
	        total += speechPeople * 30;
	        return total;
	        }    
	    
	    //The validateCheckBoxes checks the optional workshops and adds the money if their selected.
	    public int validateCheckBoxes(boolean introBoolean, boolean webBoolean, boolean programBoolean, boolean networkBoolean) {
	        int total = 0;
	        if (introBoolean) {
	            total += 295;
	        }
	        
	        if (webBoolean) {
	            total += 295;
	        }
	        
	        if (programBoolean) {
	            total += 395;
	        }
	        
	        if (networkBoolean) {
	            total += 395;
	        }
	        return total;
	    }
	    
	  
	    int total = 0;
	  //Upon pressing the submit button, the totals will be calculated and displayed.
	  public void submitButton(ActionEvent e) {
		  int numPeople = isNumberCalculation(nonStudentField);
		  int numStudents = isNumberCalculation(studentField);
		  int numDinner = isNumberCalculation(dinnerField);
		  total = checkRegistrationFee(numDinner, numPeople, numStudents);
		  total += validateCheckBoxes(introBox.isSelected(), webBox.isSelected(), programBox.isSelected(), securityBox.isSelected());
		  outputText.setText("Your current total is: $" + total);
	  }
	  
	  public void checkBoxes(ActionEvent e) {
		  
	  }
	
		  
	
}