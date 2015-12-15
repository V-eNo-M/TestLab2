package TestLab2.controller;

import TestLab2.SearchPath;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by 1 on 24.11.2015.
 */
public class MainController {

    @FXML
    private TextField tf00, tf10, tf20, tf30, tf40, tf50, tf01, tf11, tf21, tf31, tf41, tf51, tf02, tf12, tf22, tf32, tf42, tf52, tf03, tf13, tf23, tf33, tf43, tf53, tf04, tf14, tf24, tf34, tf44, tf54, tf05, tf15, tf25, tf35, tf45, tf55;

    private int size;

    private ArrayList<TextField> m = new ArrayList();

    @FXML
    private TextField tfSize;


    @FXML
    private TextField tfStart;

    @FXML
    private TextField tfEnd;

    @FXML
    private Label lbinfo;

    @FXML
    private Label lbResult;

    @FXML
    private GridPane gp;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnResult;


    @FXML
    public void addTextField() {
        if (size == 2) {
            m.add(tf00);
            m.add(tf10);
            m.add(tf01);
            m.add(tf11);
        }
        if (size == 3) {
            m.add(tf00);
            m.add(tf10);
            m.add(tf20);
            m.add(tf01);
            m.add(tf11);
            m.add(tf21);
            m.add(tf02);
            m.add(tf12);
            m.add(tf22);
        }
        if (size == 4) {
            m.add(tf00);
            m.add(tf10);
            m.add(tf20);
            m.add(tf30);
            m.add(tf01);
            m.add(tf11);
            m.add(tf21);
            m.add(tf31);
            m.add(tf02);
            m.add(tf12);
            m.add(tf22);
            m.add(tf32);
            m.add(tf03);
            m.add(tf13);
            m.add(tf23);
            m.add(tf33);
        }
        if (size == 5) {
            m.add(tf00);
            m.add(tf10);
            m.add(tf20);
            m.add(tf30);
            m.add(tf40);
            m.add(tf01);
            m.add(tf11);
            m.add(tf21);
            m.add(tf31);
            m.add(tf41);
            m.add(tf02);
            m.add(tf12);
            m.add(tf22);
            m.add(tf32);
            m.add(tf42);
            m.add(tf03);
            m.add(tf13);
            m.add(tf23);
            m.add(tf33);
            m.add(tf43);
            m.add(tf04);
            m.add(tf14);
            m.add(tf24);
            m.add(tf34);
            m.add(tf44);
        }
        if (size == 6) {
            m.add(tf00);
            m.add(tf10);
            m.add(tf20);
            m.add(tf30);
            m.add(tf40);
            m.add(tf50);
            m.add(tf01);
            m.add(tf11);
            m.add(tf21);
            m.add(tf31);
            m.add(tf41);
            m.add(tf51);
            m.add(tf02);
            m.add(tf12);
            m.add(tf22);
            m.add(tf32);
            m.add(tf42);
            m.add(tf52);
            m.add(tf03);
            m.add(tf13);
            m.add(tf23);
            m.add(tf33);
            m.add(tf43);
            m.add(tf53);
            m.add(tf04);
            m.add(tf14);
            m.add(tf24);
            m.add(tf34);
            m.add(tf44);
            m.add(tf54);
            m.add(tf05);
            m.add(tf15);
            m.add(tf25);
            m.add(tf35);
            m.add(tf45);
            m.add(tf55);
        }
        for (TextField i : m) {
            i.setVisible(true);
        }

        lbinfo.setVisible(true);
    }

    @FXML
    public void clickResult() {
        boolean[][] n = new boolean[(int) Math.sqrt(m.size())][(int) Math.sqrt(m.size())];
        int num = 0;
        for (int i = 0; i < (int) Math.sqrt(m.size()); i++) {
            for (int j = 0; j < (int) Math.sqrt(m.size()); j++) {
                if (m.get(num).getText().charAt(0) == '1') {
                    n[j][i] = true;
                }
                else
                    n[j][i]= false;
                num++;
            }
        }
        SearchPath my = new SearchPath(n,Integer.valueOf(tfStart.getText()) , Integer.valueOf(tfEnd.getText()));
        lbResult.setText("Результат = " + my.Main());
    }

    @FXML
    public void keyChange() {
        int buf = 0;
        int start = 0;
        int end = 0;
        if(!tfStart.getText().equals("") && tfStart.getText().length()==1&& tfStart.getText().charAt(0) >= '1' && tfStart.getText().charAt(0) <= '6')
            start = Integer.valueOf(tfStart.getText());
        if(!tfEnd.getText().equals("") && tfEnd.getText().length()==1 && tfEnd.getText().charAt(0) >= '1' && tfEnd.getText().charAt(0) <= '6')
            end = Integer.valueOf(tfEnd.getText());
        if(start > 0 && start <= size && end!=start)
            buf++;
        else
            tfStart.setText("");
        if(end >0 && end<=size && end!=start)
            buf++;
        else
            tfEnd.setText("");

        for (TextField i : m) {
            if (i.getText().equals("1") || i.getText().equals("0")) {
                buf++;
            }
            else
                i.setText("");
        }


        if (buf == size*size + 2) {
            btnResult.setDisable(false);
        }
        else {btnResult.setDisable(true);
            }
    }

    @FXML
    public void textChange() {
        if (!tfSize.getText().equals(""))
            if ((tfSize.getText().length() < 2)) {
                if ((tfSize.getText().charAt(0) >= '2' && tfSize.getText().charAt(0) <= '6')) {
                    btnConfirm.setDisable(false);
                }
            } else {
                String buff = "";
                tfSize.setText(buff);
                if (!btnConfirm.isDisabled())
                    btnConfirm.setDisable(true);
            }

    }


    @FXML
    public void cancelClick() {
        for (TextField i : m) {
            i.setVisible(false);
        }
        btnConfirm.setDisable(false);
        tfSize.setDisable(false);
        lbinfo.setVisible(false);
        tfStart.setDisable(true);
        tfEnd.setDisable(true);
    }


    @FXML
    public void confMousClick() {
        if ((tfSize.getText().charAt(0) == '2')) {
            tfSize.setDisable(true);
            //gp.setVisible(true);
            size = 2;
            addTextField();
            btnConfirm.setDisable(true);
            btnCancel.setDisable(false);
            tfStart.setDisable(false);
            tfEnd.setDisable(false);
        }else
        if ((tfSize.getText().charAt(0) == '3')) {
            tfSize.setDisable(true);
            //gp.setVisible(true);
            size = 3;
            addTextField();
            btnConfirm.setDisable(true);
            btnCancel.setDisable(false);
            tfStart.setDisable(false);
            tfEnd.setDisable(false);
        }else
        if ((tfSize.getText().charAt(0) == '4')) {
            tfSize.setDisable(true);
            // gp.setVisible(true);
            size = 4;
            addTextField();
            btnConfirm.setDisable(true);
            btnCancel.setDisable(false);
            tfStart.setDisable(false);
            tfEnd.setDisable(false);
        }else
        if ((tfSize.getText().charAt(0) == '5')) {
            tfSize.setDisable(true);
            //gp.setVisible(true);
            size = 5;
            addTextField();
            btnConfirm.setDisable(true);
            btnCancel.setDisable(false);
            tfStart.setDisable(false);
            tfEnd.setDisable(false);
        }else
        if ((tfSize.getText().charAt(0) == '6')) {
            tfSize.setDisable(true);
            //gp.setVisible(true);
            size = 6;
            addTextField();
            btnConfirm.setDisable(true);
            btnCancel.setDisable(false);
            tfStart.setDisable(false);
            tfEnd.setDisable(false);

        }else {
            btnConfirm.setDisable(true);
            lbinfo.setVisible(false);
            tfStart.setDisable(true);
            tfEnd.setDisable(true);
        }
    }
}

