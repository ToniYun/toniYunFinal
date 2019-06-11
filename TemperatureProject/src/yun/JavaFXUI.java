package yun;

import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author 955331921
 */
public class JavaFXUI extends Application {

    private Temperatures temps = new Temperatures();
    VBox bx;
    StackPane centerPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootPane = new BorderPane();
        rootPane.setTop(getTopPane());
        rootPane.setLeft(getLeftPane());
        rootPane.setCenter(getCenterPane());
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        setStage(primaryStage);
        primaryStage.show();
    }

    private void setStage(Stage primaryStage) {
        primaryStage.setX(300);
        primaryStage.setY(200);
        primaryStage.setHeight(400);
        primaryStage.setWidth(500);
        primaryStage.setTitle("Temperatures");
    }

    private FlowPane getTopPane() {
        FlowPane pane = new FlowPane();
        TextField txtTemp = new TextField();
        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(e -> {
            int temp = Integer.valueOf(txtTemp.getText());
            long time = System.currentTimeMillis();
            temps.addTemperature(temp, System.currentTimeMillis());
            bx.getChildren().add(new Label(new Date(time) + " - "+
                    (temp)));
        });
        Button btnAvg = new Button("Average");
        btnAvg.setOnAction(e -> {
            Label lblAvg = new Label("Average = " + temps.getAverageTemperature());
            centerPane.getChildren().clear();
            centerPane.getChildren().add(lblAvg);
        });
        pane.getChildren().addAll(txtTemp, btnAdd, btnAvg);
        return pane;
    }

    private ScrollPane getLeftPane() {
        ScrollPane pane = new ScrollPane();
        bx = new VBox();
        pane.setContent(bx);
        return pane;
    }

    private StackPane getCenterPane() {
        centerPane  = new StackPane();
        return centerPane;
    }

}
