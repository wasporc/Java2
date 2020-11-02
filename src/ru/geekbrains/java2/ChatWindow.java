package ru.geekbrains.java2;

import javax.swing.*;
import java.awt.*;

public class ChatWindow {
    private final JFrame mainFrame;
    private final JTextArea mainField;
    private final JTextField outField;


    public ChatWindow() {
        mainFrame = new JFrame();

        mainFrame.setTitle("ChatWindow");
        mainFrame.setBounds(100, 100, 500, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        mainField = new JTextArea();
        mainField.setEditable(false);
        mainFrame.add(mainField, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        outField = new JTextField();

        JButton button = new JButton();
        ActionButtonListener listener = new ActionButtonListener(mainField, outField);
        KeyButtonListener keyListener = new KeyButtonListener(mainField, outField);
        button.addActionListener(listener);
        button.addKeyListener(keyListener);
        button.setText("Отправить");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(outField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(button);

        leftPanel.add(panel, BorderLayout.SOUTH);

        mainFrame.add(leftPanel, BorderLayout.EAST);

        mainFrame.setVisible(true);
    }
}
