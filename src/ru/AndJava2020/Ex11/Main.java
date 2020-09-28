package ru.AndJava2020.Ex11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene=new Scene(group,1000,500);
        primaryStage.setScene(scene);
        primaryStage.show();

        TextField txt=new TextField();
        BorderPane mainPane=new BorderPane();
        VBox vbox =new VBox();
        vbox.setSpacing(5);
        mainPane.setMinHeight(300);
        mainPane.setMinWidth(300);
        vbox.setMinHeight(50);
        vbox.setMinWidth(50);
        vbox.setMaxHeight(200);
        vbox.setMaxWidth(200);
        mainPane.setCenter(vbox);

        Button btn=new Button("Press");
        Text hint=new Text("2 attempts left");
        Text hint2=new Text();
        Text gameName=new Text("Game: number from 0 to 20. You have 3 attempts");
        vbox.getChildren().addAll(gameName,hint2,txt,btn,hint);
        vbox.setSpacing(5);

        group.getChildren().addAll(mainPane);

        Game game = new Game();
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int a = Integer.parseInt(txt.getText());
                    if(game.getValue()>1) {
                        btn.setOnMouseClicked(null);
                        hint.setText("Poor human\nMachines will rule the world ^^");
                    }
                    else {

                        if (!game.tryGuess(a, hint)) {
                           // System.out.println("try");
                        } else {
                            btn.setOnMouseClicked(null);
                        }
                    }

                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                    hint2.setText("\n Write numbers here");

                }
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
