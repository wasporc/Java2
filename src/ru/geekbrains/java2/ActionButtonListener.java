package ru.geekbrains.java2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonListener implements ActionListener {
    private final JTextArea area;
    private final JTextField field;

    public ActionButtonListener(JTextArea area, JTextField field) {
        this.area = area;
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        area.append(field.getText() + "\n");
        field.setText("");
    }
}
