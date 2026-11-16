package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File file;

    /**
     * Construction of the class Controller.
     */
    public Controller() {
        final String user = System.getProperty("user.home");
        final String slash = System.getProperty("file.separator");
        this.file = new File(user + slash + "output.txt");
    }

    /**
     * Method for setting a File as current file.
     * 
     * @param newFile meaning the file to be used as current
     */
    public void setFile(final File newFile) {
        this.file = newFile;
    }

    /**
     * Method for getting the current File.
     * 
     * @return the current file
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Method for getting the path (in form of String) of the current File.
     * 
     * @return the path
     */
    public String getPath() {
        return this.file.getAbsolutePath();
    }

    /**
     * Method that gets a String as input and saves its content on the current file. This method may throw an IOException.
     * 
     * @param messagge to be written in the file
     * @throws IOException form the PrintStream print
     */
    public void writeString(final String messagge) throws IOException {
        try (PrintStream ps = new PrintStream(this.file.getAbsolutePath(), StandardCharsets.UTF_8)) {
            ps.print(messagge);
        }
    }
}
