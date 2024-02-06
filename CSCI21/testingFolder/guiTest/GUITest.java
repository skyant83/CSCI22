package testingFolder.guiTest;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

public class GUITest {
    
    private JFrame frame;
    private JLabel label;
    private JTextField input;
    private JButton b1, b2, b3, b4, b5;
    private int width, height;


    public GUITest(int w, int h) {
        frame = new JFrame();
        // label = new JLabel("Test");
        // input = new JTextField(10);
        b1 =  new  JButton("Button1");
        b2 =  new  JButton("Button2");
        b3 =  new  JButton("Button3");
        b4 =  new  JButton("Button4");
        b5 =  new  JButton("Button5");
        width = w;
        height = h;

        Container c = frame.getContentPane();
        // FlowLayout flow = new FlowLayout();
        // c.setLayout(flow);

        frame.setSize(width, height);
        frame.setTitle("GUI Test");

        // c.add(input);
        // c.add(label);
        c.add(b3, BorderLayout.CENTER);
        // c.add(b2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ActionListener buttonListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.add(b1, BorderLayout.NORTH);
                c.add(b2, BorderLayout.WEST);
                c.add(b4, BorderLayout.EAST);
                c.add(b5, BorderLayout.SOUTH);
                c.remove(b3);
                c.revalidate();
                c.repaint();
                
                JButton o = (JButton) e.getSource();
                System.out.printf("%s clicked!\n", o.getText());
            }
        };

        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b3.addActionListener(buttonListener);
    }

    // alternate option for creating a actionListener
    // must be instantiated
    // button.addActionListener(new myActionListener())
    private class myActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    
}
