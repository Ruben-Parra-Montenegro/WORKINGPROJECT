import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.apache.poi.ss.usermodel.Sheet;


public class DataEntry {

    ObservableList<String> ExerciseList = FXCollections.observableArrayList("Please pick Exercise","Squat","Bench Press", "Back Extentions","Front Squat", "Back Squat", "Push Press", "Shoulder Press", "Snatch Pulls", "Snatch", "Clean and Jerk",
    "Clean Pulls", "Jerk", "Deadlift");
    
    
   
    //         "Squat", "Bench Press", "Pull Up", "Barbell Rows", "Cable Rows", "Lat Pulldowns", "Dumbell Curls",
    //         "Tricep Pull downs", "Sit ups", "Hip Adductor", "Hip Abductor", "Leg Press", "Leg Curl", "Leg Extension",
    //         "Other", "None");
    ObservableList<String> CardioList = FXCollections.observableArrayList("Please pick Exercise", "Running", "Cycling");
            // "Rowing",
            // "Other", "None");

    @SuppressWarnings("unchecked")
    @FXML
    private void initialize() {
        E1.setValue("Please pick Exercise");
        E1.setItems(ExerciseList);
        E2.setValue("Please pick Exercise");
        E2.setItems(ExerciseList);
        E3.setValue("Please pick Exercise");
        E3.setItems(ExerciseList);
        E4.setValue("Please pick Exercise");
        E4.setItems(ExerciseList);
        E5.setValue("Please pick Exercise");
        E5.setItems(ExerciseList);
        E6.setValue("Please pick Exercise");
        E6.setItems(ExerciseList);
        Cardiotype.setValue("Please pick Exercise");
        Cardiotype.setItems(CardioList);

    }

    @FXML
    private TextField Weight;

    @FXML
    private Button MainMenu;

    @FXML
    private Button Analytics;

    @FXML
    private TextField CardioTime;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox Cardiotype;

    @FXML
    private DatePicker DateInput;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E1;

    

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E2;

    

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E3;

   

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E4;

    

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E5;

    

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E6;

   
    
    @FXML
    private Button SavetoFile;

    @FXML
    private TextField Set1input;

    @FXML
    private TextField Set2input;

    @FXML
    private TextField Set3input;

    @FXML
    private TextField Set4input;

    @FXML
    private TextField Set5input;

    @FXML
    private TextField Set6input;

    @FXML
    void MainMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Workout Tracker");
            stage.show();

            // Close the current window
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void AnalyticsClicked(ActionEvent event) {
        try {
            // Load the FXML file for the Analytics window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Analytics.fxml"));
            Parent root = loader.load();
    
            // Create a new scene and stage for the Analytics window
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Analytics"); // Set the title of the stage here
            stage.show(); // Show the new stage
    
            // Close the current window
            Stage currentStage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            currentStage.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SaveToFileClicked(ActionEvent event) {
        // Get the file path from the Singleton class
        String filePath = SharedFilePath.getInstance().getFilePath();

        try {
            // Open the existing Excel file
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            // Get the sheet where you want to write the data
            Sheet sheet = workbook.getSheetAt(0);

            // Find the first empty row in the specified column
            int rowNum = 0;
            while (true) {
                Row row = sheet.getRow(rowNum);
                if (row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue().isEmpty()) {
                    break;
                }
                rowNum++;
            }

            // Write the data to the empty row in the specified column
            String[] data = { DateInput.getValue().toString(), Weight.getText(), Cardiotype.getValue().toString(),
                    CardioTime.getText(),Set1input.getText(), Set2input.getText(), Set3input.getText(),
                    Set4input.getText(), Set5input.getText(), Set6input.getText(), 
                   
                    E1.getValue().toString(), E2.getValue().toString(),
                    E3.getValue().toString(), E4.getValue().toString(), E5.getValue().toString(),
                    E6.getValue().toString()
                   
                    
                                  };
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            int colNum = 0;
            for (String value : data) {
                row.createCell(colNum).setCellValue(value);
                colNum++;
            }

            // Write the workbook back to the file
            fileInputStream.close();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
