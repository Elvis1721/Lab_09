package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame;
    private final JPanel canva;
    private final JPanel buttonsCanva;
    private final JTextField field;
    private final JTextArea area;
    private final JButton print;
    private final JButton showHistory;
    private final SimpleController controller;

    /**
     * Construction of the class SimpleGUI.
     * Sets up the whole view.
     */
    public SimpleGUI() {
        frame = new JFrame();
        canva = new JPanel();
        buttonsCanva = new JPanel();
        field = new JTextField();
        area = new JTextArea();
        print = new JButton("Print");
        showHistory = new JButton("Show history");
        controller = new SimpleController();

        canva.setLayout(new BorderLayout());
        buttonsCanva.setLayout(new BorderLayout());
        canva.add(field, BorderLayout.NORTH);
        canva.add(area, BorderLayout.CENTER);
        buttonsCanva.add(print, BorderLayout.WEST);
        buttonsCanva.add(showHistory, BorderLayout.EAST);
        canva.add(buttonsCanva, BorderLayout.SOUTH);
        frame.add(canva);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(
            new ActionListener() {
                @Override 
                public void actionPerformed(final ActionEvent e) {
                    final String string = field.getText();
                    controller.setString(string);
                    controller.printString();
                }
            }
        );

        showHistory.addActionListener(
            new ActionListener() {
                @Override 
                public void actionPerformed(final ActionEvent e) {
                    area.setText(controller.getHistory().toString());
                }
            }
        );
    }

    /**
     * Main method.
     * 
     * @param args of the main.
     */
    public static void main(final String[] args) {
        new SimpleGUI();
    }

}
