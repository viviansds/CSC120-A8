/*
 * Contract class 
 * Assignment 8: Promises, Promises...
 * @author Vivian Wei
 * @version 10 November 2022
 */

/*A interface class that contains following methods for other classes to implements.*/
public interface Contract {

    void grab(String item);
    String drop(String item);
    void examine(String item);
    void use(String item);
    boolean walk(String direction);
    boolean fly(int x, int y);
    Number shrink();
    Number grow();
    void rest();
    void undo();

}