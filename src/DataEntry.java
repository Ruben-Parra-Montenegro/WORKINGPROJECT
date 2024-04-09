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
//import org.apache.poi.ss.usermodel.Cell;

public class DataEntry {

    ObservableList<String> ExerciseList = FXCollections.observableArrayList("Please pick Exercise", "Back Extentions",
            "Lu Raises",
            "Front Squat", "Back Squat", "Push Press", "Shoulder Press", "Snatch Pulls", "Snatch", "Clean and Jerk",
            "Clean Pulls", "Jerk", "Deadlift",
            "Squat", "Bench Press", "Pull Up", "Barbell Rows", "Cable Rows", "Lat Pulldowns", "Dumbell Curls",
            "Tricep Pull downs", "Sit ups", "Hip Adductor", "Hip Abductor", "Leg Press", "Leg Curl", "Leg Extension",
            "Other", "None");
    ObservableList<String> CardioList = FXCollections.observableArrayList("Please pick Exercise", "Running", "Cycling",
            "Rowing",
            "Other", "None");

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

    @FXML
    private TextField E1S1W;

    @FXML
    private TextField E1S2W;

    @FXML
    private TextField E1S3W;

    @FXML
    private TextField E1S4W;

    @FXML
    private TextField E1S5W;

    @FXML
    private TextField E1S6W;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E2;

    @FXML
    private TextField E2S1W;

    @FXML
    private TextField E2S2W;

    @FXML
    private TextField E2S3W;

    @FXML
    private TextField E2S4W;

    @FXML
    private TextField E2S5W;

    @FXML
    private TextField E2S6W;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E3;

    @FXML
    private TextField E3S1W;

    @FXML
    private TextField E3S2W;

    @FXML
    private TextField E3S3W;

    @FXML
    private TextField E3S4W;

    @FXML
    private TextField E3S5W;

    @FXML
    private TextField E3S6W;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E4;

    @FXML
    private TextField E4S1W;

    @FXML
    private TextField E4S2W;

    @FXML
    private TextField E4S3W;

    @FXML
    private TextField E4S4W;

    @FXML
    private TextField E4S5W;

    @FXML
    private TextField E4S6W;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E5;

    @FXML
    private TextField E5S1W;

    @FXML
    private TextField E5S2W;

    @FXML
    private TextField E5S3W;

    @FXML
    private TextField E5S4W;

    @FXML
    private TextField E5S5W;

    @FXML
    private TextField E5S6W;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox E6;

    @FXML
    private TextField E6S1W;

    @FXML
    private TextField E6S2W;

    @FXML
    private TextField E6S3W;

    @FXML
    private TextField E6S4W;

    @FXML
    private TextField E6S5W;

    @FXML
    private TextField E6S6W;

    @FXML
    private TextField Rep1input;

    @FXML
    private TextField Rep2input;

    @FXML
    private TextField Rep3input;

    @FXML
    private TextField Rep4input;

    @FXML
    private TextField Rep5input;

    @FXML
    private TextField Rep6input;

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
                    CardioTime.getText(),
                    E1.getValue().toString(), E2.getValue().toString(),
                    E3.getValue().toString(), E4.getValue().toString(), E5.getValue().toString(),
                    E6.getValue().toString(), Set1input.getText(), Set2input.getText(), Set3input.getText(),
                    Set4input.getText(), Set5input.getText(), Set6input.getText(), Rep1input.getText(),
                    Rep2input.getText(), Rep3input.getText(), Rep4input.getText(), Rep5input.getText(),
                    Rep6input.getText(), E1S1W.getText(),
                    E1S2W.getText(),
                    E1S3W.getText(),
                    E1S4W.getText(),
                    E1S5W.getText(),
                    E1S6W.getText(),
                    E2S1W.getText(),
                    E2S2W.getText(),
                    E2S3W.getText(),
                    E2S4W.getText(),
                    E2S5W.getText(),
                    E2S6W.getText(),
                    E3S1W.getText(),
                    E3S2W.getText(),
                    E3S3W.getText(),
                    E3S4W.getText(),
                    E3S5W.getText(),
                    E3S6W.getText(),
                    E4S1W.getText(),
                    E4S2W.getText(),
                    E4S3W.getText(),
                    E4S4W.getText(),
                    E4S5W.getText(),
                    E4S6W.getText(),
                    E5S1W.getText(),
                    E5S2W.getText(),
                    E5S3W.getText(),
                    E5S4W.getText(),
                    E5S5W.getText(),
                    E5S6W.getText(),
                    E6S1W.getText(),
                    E6S2W.getText(),
                    E6S3W.getText(),
                    E6S4W.getText(),
                    E6S5W.getText(),
                    E6S6W.getText()/*
                                    * , add
                                    * more
                                    * data
                                    * here
                                    */ };
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
