package flightSim;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UILauncher extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<String> outputTable = new TableView();
        outputTable.setEditable(true);
        TableColumn<String,String> eventCol = new TableColumn("Event");
        ObservableList<String> outputList = FXCollections.observableArrayList();
        eventCol.prefWidthProperty().bind(outputTable.widthProperty().subtract(2));
        eventCol.setResizable(false);
        eventCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        outputTable.setItems(outputList);
        outputTable.getColumns().addAll(eventCol);
        Label label = new Label("Please check your scenario.txt file for potential errors before running the simulator.");
        Button button = new Button("Generate simulation");

        button.setOnAction(action -> {
            Simulator.main(new String[]{"input/scenario.txt"});
            Scanner in = null;
            String s;
            try {
                in = new Scanner(new File("simulation.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(in.hasNextLine()) {
                s = in.nextLine();
                outputList.add(s);
            }
            in.close();
        });

        VBox vbox = new VBox(label,button,outputTable);
        StackPane layout = new StackPane();
        layout.getChildren().add(vbox);
        Scene scene = new Scene(layout, 800, 475);
        primaryStage.setTitle("Flight Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
