// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
// import javafx.scene.chart.ScatterChart;
// import javafx.scene.control.Button;
// import javafx.scene.control.ChoiceBox;

// import java.net.URL;
// import java.util.ResourceBundle;

// import javafx.scene.chart.XYChart;

// public class Analytics implements Initializable {

//     @SuppressWarnings("rawtypes")
//     @FXML
//     private ChoiceBox ChooseCardio;

//     @FXML
//     private ScatterChart<?, ?> ScatterChartYourWeight;

//     @FXML
//     private ScatterChart<?, ?> ScatterChartC;

//     @FXML
//     void ClearData(ActionEvent event) {

//     }

//     @FXML
//     void LoadData(ActionEvent event) {

//     }

//     @FXML
//     void MainMenu(ActionEvent event) {

//     }

//     @SuppressWarnings("unchecked")
//     @Override
//     public void initialize(URL url, ResourceBundle rb) {

//         XYChart.Series series = new XYChart.Series();
//         series.getData().add(new XYChart.Data("1", 2));
//         series.getData().add(new XYChart.Data("2", 3));
//         series.getData().add(new XYChart.Data("3", 4));
//         series.getData().add(new XYChart.Data("4", 5));
//         series.getData().add(new XYChart.Data("5", 6));
//         series.getData().add(new XYChart.Data("6", 7));
//         series.getData().add(new XYChart.Data("7", 8));
//         series.getData().add(new XYChart.Data("8", 9));
//         ScatterChartYourWeight.getData().add(series);

//     }

// }
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Analytics implements Initializable {

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox ChooseCardio;

    @FXML
    private ScatterChart<String, Number> ScatterChartC;

    @FXML
    private ScatterChart<String, Number> ScatterChartYourWeight;

    @FXML
    void ClearData(ActionEvent event) {

    }

    @FXML
    void LoadData(ActionEvent event) {
        String selectedCardioType = ChooseCardio.getValue().toString();
        populateChart2(ScatterChartC, SharedFilePath.getInstance().getFilePath(), 1,
        56, 57);

        // System.out.println("Selected Cardio Type: " + ChooseCardio.getValue());
        System.out.println("Chart Data: " + ScatterChartC.getData());
    }

    @FXML
    void MainMenu(ActionEvent event) {

    }

    ObservableList<String> CardioList = FXCollections.observableArrayList("Please pick Exercise", "Running", "Cycling",
            "Rowing",
            "Other", "None");

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ChooseCardio.setValue("Please pick Exercise");
        ChooseCardio.setItems(CardioList);
        // ...
        populateChart(ScatterChartYourWeight, SharedFilePath.getInstance().getFilePath(), 0, 1);
        // ...
        populateChart2(ScatterChartC, SharedFilePath.getInstance().getFilePath(), 0, 2, 3);
        // System.out.println("File Path: " +
        // (SharedFilePath.getInstance().getFilePath()));
        // System.out.println("Chart Data: " + ScatterChartYourWeight.getData());
        printData((SharedFilePath.getInstance().getFilePath()), 0, 1, 2, 3);

    }

    private void updateYAxisRange(ScatterChart<String, Number> chart, double maxYValue) {
        NumberAxis yAxis = (NumberAxis) chart.getYAxis();
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(maxYValue + 200);
    }

    private void populateChart(ScatterChart<String, Number> chart, String filePath, int xColumn, int yColumn) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        double maxYValue = Double.MIN_VALUE;
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            // Skip the first row
            if (iterator.hasNext()) {
                iterator.next();
            }

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Cell xCell = currentRow.getCell(xColumn);
                Cell yCell = currentRow.getCell(yColumn);

                if (xCell != null && xCell.getCellType() == CellType.STRING && yCell != null
                        && yCell.getCellType() == CellType.STRING) {
                    double yValue = Double.parseDouble(yCell.getStringCellValue());
                    series.getData().add(new XYChart.Data<>(xCell.getStringCellValue(), yValue));
                    // System.out.println("X: " + xCell.getStringCellValue() + " Y: " + yValue);
                    if (yValue > maxYValue) {
                        maxYValue = yValue;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the y-axis range
        updateYAxisRange(chart, maxYValue);

        chart.getData().add(series);
    }

    private void populateChart2(ScatterChart<String, Number> chart, String filePath, int dateColumn,
            int cardioTypeColumn, int cardioTimeColumn) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        double maxYValue = Double.MIN_VALUE;
        String selectedCardioType = ChooseCardio.getValue().toString();
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            // Skip the first row
            if (iterator.hasNext()) {
                iterator.next();
            }

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Cell dateCell = currentRow.getCell(dateColumn);
                Cell cardioTypeCell = currentRow.getCell(cardioTypeColumn);
                Cell cardioTimeCell = currentRow.getCell(cardioTimeColumn);

                if (dateCell.getCellType() == CellType.STRING
                        && cardioTypeCell.getCellType() == CellType.STRING
                        && cardioTimeCell.getCellType() == CellType.NUMERIC) {
                    double cardioTimeValue = cardioTimeCell.getNumericCellValue();
                    System.out.println(cardioTimeCell.getNumericCellValue());
                    series.getData().add(new XYChart.Data<>(dateCell.getStringCellValue(), cardioTimeValue));
                    if (cardioTimeValue > maxYValue) {
                        maxYValue = cardioTimeValue;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the y-axis range
        updateYAxisRange(chart, maxYValue);

        chart.getData().add(series);
    }

    private void printData(String filePath, int... columns) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                for (int column : columns) {
                    Cell cell = currentRow.getCell(column);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case CellType.STRING:
                                // System.out.println("Column " + (column + 1) + ": " +
                                // cell.getStringCellValue());
                                break;
                            case CellType.NUMERIC:
                                // System.out.println("Column " + (column + 1) + ": " +
                                // cell.getNumericCellValue());
                                break;
                            default:
                                // System.out.println("Column " + (column + 1) + ": " + cell.getCellType());
                                break;
                        }
                    } else {
                        // System.out.println("Column " + (column + 1) + ": null");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
