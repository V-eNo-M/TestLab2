package TestLab2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by 1 on 15.12.2015.
 */
public class Main extends Application {

    private static Optional<Callback<Parent>> callback = Optional.empty();

    private Set<String> inserted = new HashSet<>();

    private final int x = 20;
    private final int y = 20;
    private final int stepX = 40;
    private final int stepY = 40;

    private TextField tf00;
    private TextField tf01;
    private TextField tf02;
    private TextField tf03;
    private TextField tf10;
    private TextField tf11;
    private TextField tf12;
    private TextField tf13;
    private TextField tf20;
    private TextField tf21;
    private TextField tf22;
    private TextField tf23;
    private TextField tf30;
    private TextField tf31;
    private TextField tf32;
    private TextField tf33;
    private TextField Start;
    private TextField End;

    private TextField[][] matrix = {{tf00,tf01,tf02,tf03},
                                    {tf10,tf11,tf12,tf13},
                                    {tf20,tf21,tf22,tf23},
                                    {tf30,tf31,tf32,tf33}};



    private Button btnResult;
    private Button btnClear;
    private Text lbRes;
    private Label lbStart;
    private Label lbEnd;

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        initialize();

        primaryStage.setTitle("Lab 3");
        Group root = new Group();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                root.getChildren().add(matrix[i][j]);
            }
        }

        root.getChildren().add(lbStart);
        root.getChildren().add(lbEnd);
        root.getChildren().add(Start);
        root.getChildren().add(End);
        root.getChildren().add(btnClear);
        root.getChildren().add(btnResult);
        root.getChildren().add(lbRes);


        primaryStage.setScene(new Scene(root, 185, 340));
        primaryStage.show();
    }

    public static void onLoad(Callback<Parent> r)
    {
        callback = Optional.of(r);
    }

    private void initialize()
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                matrix[i][j] = new TextField();
                matrix[i][j].setLayoutX(x+stepX*j);
                matrix[i][j].setLayoutY(y + stepY * i);
                matrix[i][j].setPrefWidth(25);


                matrix[i][j].setId("tf" + i + j);

                matrix[i][j].textProperty().addListener((observable, oldValue, newValue) -> {
                    int allWrite = 0;
                    for (int k = 0; k < 4; k++) {
                        for (int m = 0; m < 4; m++) {
                            if (matrix[k][m].getText().equals("0") || matrix[k][m].getText().equals("1"))
                                allWrite++;
                            else {
                                matrix[k][m].setText("");
                                btnResult.setDisable(true);}
                            if(allWrite == 16 && (Start.getText().length()==1 && End.getText().length()==1)
                                    &&(Start.getText().charAt(0) >='1' && Start.getText().charAt(0) <='4')
                                    &&(End.getText().charAt(0) >='1' && End.getText().charAt(0) <='4')
                                    && !End.getText().equals(Start.getText()))
                                btnResult.setDisable(false);
                        }
                    }

                });
            }
        }

        lbStart = new Label("Начало");
        lbStart.setLayoutX(matrix[3][0].getLayoutX());
        lbStart.setLayoutY(matrix[3][0].getLayoutY() + 50);


        lbEnd = new Label("Конец");
        lbEnd.setLayoutX(lbStart.getLayoutX() + 100);
        lbEnd.setLayoutY(lbStart.getLayoutY());


        Start = new TextField("");
        Start.setId("Start");
        Start.setLayoutX(lbStart.getLayoutX());
        Start.setLayoutY(lbStart.getLayoutY() + 20);
        Start.setPrefWidth(25);
        Start.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Start.getText().length() == 1 && End.getText().length() == 1
                    && (Start.getText().charAt(0) >= '1' && Start.getText().charAt(0) <= '4')
                    && !End.getText().equals(Start.getText())) {
                int allWrite = 0;
                for (int k = 0; k < 4; k++) {
                    for (int m = 0; m < 4; m++) {
                        if (matrix[k][m].getText().equals("0") || matrix[k][m].getText().equals("1"))
                            allWrite++;
                        else {
                            matrix[k][m].setText("");
                            btnResult.setDisable(true);
                        }
                        if (allWrite == 16)
                            btnResult.setDisable(false);
                    }
                }
            } else if (Start.getText().length() == 1
                    && (Start.getText().charAt(0) >= '1' && Start.getText().charAt(0) <= '4')
                    && !End.getText().equals(Start.getText()))
                ;
            else
                Start.setText("");

        });


        End = new TextField("");
        End.setId("End");
        End.setLayoutX(Start.getLayoutX() + 100);
        End.setLayoutY(Start.getLayoutY());
        End.setPrefWidth(25);
        End.textProperty().addListener((observable, oldValue, newValue) -> {
            if (End.getText().length() == 1 && Start.getText().length() == 1
                    && (End.getText().charAt(0) >= '1' && End.getText().charAt(0) <= '4')
                    && !End.getText().equals(Start.getText())) {
                int allWrite = 0;
                for (int k = 0; k < 4; k++) {
                    for (int m = 0; m < 4; m++) {
                        if (matrix[k][m].getText().equals("0") || matrix[k][m].getText().equals("1"))
                            allWrite++;
                        else {
                            matrix[k][m].setText("");
                            btnResult.setDisable(true);
                        }
                        if (allWrite == 16)
                            btnResult.setDisable(false);
                    }
                }
            } else {
                if (End.getText().length() == 1
                        && (End.getText().charAt(0) >= '1' && End.getText().charAt(0) <= '4')
                        && !End.getText().equals(Start.getText()))
                    ;
                else
                    End.setText("");
            }
        });


        btnClear = new Button("Clear");
        btnClear.setId("btnClear");
        btnClear.setLayoutX(Start.getLayoutX());
        btnClear.setLayoutY(Start.getLayoutY() + 50);
        btnClear.setOnAction((event) -> {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j].setText("");
                }
            }
            lbRes.setText("");
            Start.setText("");
            End.setText("");
            btnResult.setDisable(true);
        });

        lbRes = new Text("");
        lbRes.setId("Res");
        lbRes.setLayoutX(btnClear.getLayoutX());
        lbRes.setLayoutY(btnClear.getLayoutY() + 50);


        btnResult = new Button("Result");
        btnResult.setId("btnResult");
        btnResult.setLayoutX(btnClear.getLayoutX() + 90);
        btnResult.setLayoutY(btnClear.getLayoutY());
        btnResult.setDisable(true);

        btnResult.setOnAction((event) -> {
            boolean[][] mat = new boolean[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (matrix[i][j].getText().equals("1"))
                        mat[i][j] = true;
                    else
                        mat[i][j] = false;
                }
                SearchPath my = new SearchPath(mat, Integer.parseInt(Start.getText().toString()), Integer.parseInt(End.getText().toString()));
                lbRes.setText(my.Main());
            }
        });


    }

    /*public static void main(String[] args)
    {
        launch(args);
    }*/
}
