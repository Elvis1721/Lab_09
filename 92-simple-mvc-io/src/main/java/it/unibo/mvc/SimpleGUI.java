package it.unibo.mvc;

import java.awt.BorderLayout;
//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//import javax.swing.border.Border;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame;

    /**
     * Constructior of the class SimpleGUI.
     */

    public SimpleGUI() {

        this.frame = new JFrame("My first Java graphical interface");
        final JPanel canva = new JPanel();
        final JButton button = new JButton("Save");
        final JTextArea label = new JTextArea();
        final Controller controller = new Controller();
        canva.setLayout(new BorderLayout());
        canva.add(button, BorderLayout.SOUTH);
        canva.add(label, BorderLayout.CENTER);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(canva);
        this.frame.pack();
        this.frame.setVisible(true);

        button.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    try {
                        controller.writeString(label.getText());
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace(); // NOPMD: allowed as this is just an exercise
                    }
                }
            }
        );
    }

    /**
     * Main.
     * 
     * @param args of the main
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser();
    }

}
