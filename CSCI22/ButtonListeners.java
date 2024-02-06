package CSCI22;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ButtonListeners {
    private JFrame frame;
    private ArrayList<JButton> buttons;
    private ArrayList<String> messages;
    private JTextArea output;

    public ButtonListeners() {
        frame = new JFrame();
        buttons =  new ArrayList<JButton>();
        for(int i = 1; i <= 3; i++)
            buttons.add(new JButton("Button " + i));

        messages = new ArrayList<String>();
        messages.add("HELLO 1");
        messages.add("HELLO 2");
        messages.add("HELLO 3");

        output = new JTextArea();
    
    }

    public void setUpGUI() {
        Container cp = frame.getContentPane();
        frame.setSize(500, 400);
        cp.setLayout(new GridLayout(4, 1));
        for(JButton button : buttons)
            cp.add(button);
        cp.add(output);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private class buttonListener implements ActionListener {
        private String message;

        public buttonListener(String msg) {
            message = msg;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            output.setText(message);
        }
    }

    public void setUpListeners() {
        for (int i = 0; i < buttons.size(); i++) 
            buttons.get(i).addActionListener(new buttonListener(messages.get(i)));
    }

    public void setUpButtonListener() {
        ActionListener a1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                String bLabel = b.getText();
                char last = bLabel.charAt(bLabel.length() - 1);
                int bNum = Character.getNumericValue(last);
                output.setText(messages.get(bNum - 1));
                output.append("\n1");
            }
        };
        for (JButton button: buttons)
            button.addActionListener(a1);
    }

    public static void main(String[] args) {
        ButtonListeners bm = new ButtonListeners();
        bm.setUpGUI();
        // bm.setUpListeners();
        bm.setUpButtonListener();
    }
}
