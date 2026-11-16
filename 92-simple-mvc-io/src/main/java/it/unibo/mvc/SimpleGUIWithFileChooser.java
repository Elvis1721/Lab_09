package it.unibo.mvc;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public final class SimpleGUIWithFileChooser {

    private final JFrame frame;

    /**
     * Constructior of the class SimpleGUI.
     */
    public SimpleGUIWithFileChooser() {
        this.frame = new JFrame("My second Java graphical interface");
        final JPanel canva = new JPanel();
        final JPanel browseCanva = new JPanel();
        final JButton button = new JButton("Save");
        final JButton browseButton = new JButton("Browse...");
        final JTextArea label = new JTextArea();
        final JTextField browseLabel = new JTextField();
        final Controller controller = new Controller();
        browseLabel.setText(controller.getPath());
        browseLabel.setEditable(false);
        canva.setLayout(new BorderLayout());
        browseCanva.setLayout(new BorderLayout());
        canva.add(button, BorderLayout.SOUTH);
        canva.add(label, BorderLayout.CENTER);
        browseCanva.add(browseLabel, BorderLayout.CENTER);
        browseCanva.add(browseButton, BorderLayout.LINE_END);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canva.add(browseCanva, BorderLayout.NORTH);
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

        browseButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    final JFileChooser chooser = new JFileChooser();
                    final int result = chooser.showSaveDialog(browseLabel);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        controller.setFile(chooser.getSelectedFile());
                    } else if (result != JFileChooser.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(frame, "An error has occurred");
                    }
                    browseLabel.setText(controller.getPath());
                }
            }
        );
    }
}
