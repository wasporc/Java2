package ru.geekbrains.java2;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyButtonListener implements KeyListener {
    private final JTextArea area;
    private final JTextField field;

    public KeyButtonListener(JTextArea area, JTextField field) {
        this.area = area;
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            area.append(field.getText() + "\n");
            field.setText("");
        }
    }
}
