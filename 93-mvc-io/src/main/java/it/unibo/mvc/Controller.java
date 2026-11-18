package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    /**
     * Method for setting the next string to print. Null values are not acceptable, 
     * and an exception should be produced.
     * 
     * @param next string to be printed.
     */
    void setString(String next);

    /**
     * Method for getting the next string to print.
     * 
     * @return the next string to be printed.
     */
    String getNextString();

    /**
     * Method for getting the history of the printed strings.
     * 
     * @return the list of the string that have been printed.
     */
    List<String> getHistory();

    /**
     * method that prints the current string. 
     * If the current string is unset, an IllegalStateException should be thrown.
     */
    void printString();

}
