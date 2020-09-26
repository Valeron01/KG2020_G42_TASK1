package com.company;

import javafx.scene.shape.Circle;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        Drawer d = new Drawer();
        add(d);
    }
}
