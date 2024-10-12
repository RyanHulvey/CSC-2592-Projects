package application;
import java.io.IOException;

import javax.swing.JTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;



public class Main extends Application {
	
	  @FXML
	  private Label displayText;
	  @FXML
	  private Label outputText;
	  @FXML
	  private TextField inputField;
	  @FXML
	  private Button submitButton;
	  @FXML
	  private Pane AnchorPane;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Scene_Builder.fxml"));
		Scene primaryScene = new Scene(root);
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("Resturant Bill Calculator");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	 //The calculateTotals method calculates the 18% tip, the 7% sales tax, and the total bill.
	  public static void calculateTotals(Label label, double input) {
	    double tip = input * 0.18;
	    double tax = input * 0.07;
	    double total = input + tip + tax;
	    
	    tip = roundTwoDecimals(tip);
	    tax = roundTwoDecimals(tax);
	    total = roundTwoDecimals(total);
	    
	    label.setText("Tip: $" + tip + "\nTax: $" + tax + "\nTotal: $" + total);
	  }

	  //The roundTwoDecimals method rounds any double to two decimals.
	  public static double roundTwoDecimals(double input) {
	    input = input * 100;
	    input = Math.round(input);
	    input = input / 100;
	    
	    return input;
	  }
	  
	  public double isNumberCalculation(TextField inputField) {
		double num = 0;
	    if(isNumber(inputField)) {
	    	num = Double.parseDouble(inputField.getText());
	    	calculateTotals(outputText, num);
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
	  
	  //Upon pressing the submit button, the totals will be calculated and displayed.
	  public void submitButton(ActionEvent e) {
		  isNumberCalculation(inputField);
	  }

}
 