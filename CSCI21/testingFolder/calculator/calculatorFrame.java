package testingFolder.calculator;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class calculatorFrame {
    private JFrame calFrame;
    private Container cPane;
    private JPanel r1, r2, r3;
    private JPanel r1a, r3a, r3b, r3a1, r3a2;
    private JTextArea inputField;
    private ArrayList<JButton> buttons;

    public calculatorFrame(int w, int h) {
        calFrame = new JFrame();
        cPane = calFrame.getContentPane();
        cPane.setLayout(new GridLayout(3, 1));
        buttons = new ArrayList<JButton>();
        inputField = new JTextArea();
        createButtons();
        setUpPanels();

        calFrame.setSize(w, h);
        calFrame.setTitle("Calculator");
        calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calFrame.setVisible(true);
    }

    private void createButtons() {
        buttons.add(new JButton("MC"));
        buttons.add(new JButton("M+"));
        buttons.add(new JButton("/"));
        buttons.add(new JButton("*"));
        buttons.add(new JButton("7"));
        buttons.add(new JButton("8"));
        buttons.add(new JButton("9"));
        buttons.add(new JButton("-"));
        buttons.add(new JButton("4"));
        buttons.add(new JButton("5"));
        buttons.add(new JButton("6"));
        buttons.add(new JButton("+"));
        buttons.add(new JButton("1"));
        buttons.add(new JButton("2"));
        buttons.add(new JButton("0"));
        buttons.add(new JButton("3"));
        buttons.add(new JButton("."));
        buttons.add(new JButton("="));
    }

    private void setUpPanels() {
        r1 = new JPanel();
        r1.setLayout(new GridLayout(2, 1));
        r1.add(inputField);
        
        r1a = new JPanel();
        r1a.setLayout(new GridLayout(1, 4));
        for(int i = 0; i <= 3; i++) 
            r1a.add(buttons.get(i));
        r1.add(r1a);
        cPane.add(r1);

        r2 = new JPanel();
        r2.setLayout(new GridLayout(2, 4));
        for(int i = 4; i <= 11; i++)
            r2.add(buttons.get(i));
        cPane.add(r2);

        r3 = new JPanel();
        r3.setLayout(new GridLayout(1, 2));

        r3a = new JPanel();
        r3a.setLayout(new GridLayout(2, 1));

        r3a1 = new JPanel();
        r3a1.setLayout(new GridLayout(1, 2));
        r3a1.add(buttons.get(12));
        r3a1.add(buttons.get(13));

        r3a.add(r3a1);
        r3a.add(buttons.get(14));

        r3.add(r3a);
        
        r3b = new JPanel();
        r3b.setLayout(new GridLayout(1, 2));
        
        r3a2 = new JPanel();
        r3a2.setLayout(new GridLayout(2, 1));
        r3a2.add(buttons.get(15));
        r3a2.add(buttons.get(16));
        
        r3b.add(r3a2);
        r3b.add(buttons.get(17));
        
        r3.add(r3b);

        cPane.add(r3);
    }
}
