/*
 * Drone class 
 * Assignment 8: Promises, Promises...
 * @author Vivian Wei
 * @version 10 November 2022
 */

import java.awt.*;
/* A Drone class that create a drone with all the required methods from the Contract interface */
public class Drone implements Contract {
    public String name;
    public int age;//number of years since produced
    private Point location;//a (x,y) coordinate of the drone location
    public boolean turnON;//true if the drone is turned ON, false otherwise
    public int battery;//the capacity of battery, default to 100

    /*Constructors */
    public Drone(String name, int age){
        this.name = name;
        this.age = age;
        location = new Point(0,0);//all drone starts with position(0,0)
        this.turnON = false;//starts with the drone turned OFF
        this.battery = 100;
    }

    /* To grab a specified item using drone 
     * @param item
     */
    public void grab(String item){
        //only able to pick up item when the drone is turned on, otherwise throw an run time error
        if (this.turnON==true){
            System.out.println(this.name+" grabbed "+item);
        }else{
            throw new RuntimeException("Drone is not turned on.");
        }
    }

    /* Dropped the drone to the ground, method is called within the fly() method
     * @param item: the drone's name
     * @return a message indicating the item has dropped to the ground
     */
    public String drop(String item){
        return item+" dropped to the ground";
    }

    /* Examine whether the drone is in good condition based on its age
     * @param item: the drone's name
     */
    public void examine(String item){
        System.out.println("Examining "+item);
        if (this.age>10){
            System.out.println(this.name+" is outdated, please trade-in for newer version.");
        }else{
            System.out.println(this.name+" is "+this.age+" years old, still in good condition.");
        }
    }
    
    /* Turn on the drone when in use 
     * @param item: the drone's name
    */
    public void use(String item){
        this.turnON = true;
        System.out.println(item+" has turned ON.");
    }
    
    /* Check if the drone is walking in a specified direction
     * @param direction: only checks for left/right/up/down
     * @return boolean b: true if the drones' current position relative to the initial (0,0) is consistent with the specified direction, false otherwise
     */
    public boolean walk(String direction){
        boolean b =false;
        if (direction.equals("left")){
            if(location.getX()<0){//if the x coordinate is to the left of 0 x-coordinate
                return true;
            }
        }
        if(direction.equals("right")){
            if(location.getX()>0){//if the x coordinate is to the right of 0 x-coordinate
                return true;
            }
        }
        if(direction.equals("up")){
            if(location.getY()>0){//if the y coordinate is above 0 y-coordinate
                return true;
            }
        }
        if(direction.equals("down")){
            if(location.getY()<0){//if the y coordinate is below the 0 y-coordinate
                return true;
            }
        }
        else{//if the string is not left/right/up/down
            throw new RuntimeException("Please enter a direction: left/right/up/down.");
        }
        return b;
    }
    /* Fly the drone by moving its coordinate location only when it is turned on, then update the drone's available battery
     * @param x, y: coordinates 
     * @return true if there's still remaining battery, false otherwise
     */
    public boolean fly(int x, int y){
        if (this.turnON==true){//First check if drone is turned on
            location.move(x,y);
            System.out.println("Flying to coordinate ("+x+","+y+")");
            this.battery-= (Math.abs(x)+y);//amt decreased equals to the sum of the coordinates
            if (this.battery>0){
                System.out.println("Remaining battery: "+this.battery);
                return true;
            }else{//drop the drone if battery is less than or equal to 0
                System.out.println("Insufficient battery, "+this.drop(this.name));
                return false;
            }
        }else{
            throw new RuntimeException("Drone is not turned on.");
        } 
    }
    /* Shrink the drone's battery capacity by 50
     * @return number: drone's battery after shrunken in capacity
     */
    public Number shrink(){
        this.battery-=50;
        if (this.battery<0){
            throw new RuntimeException("Cannot shrink battery to negative number");
        }
        return this.battery; 
    }
    /* Grow the drone's battery capacity by 50
     * @return number: drone's battery after grown in capacity
     */
    public Number grow(){
        this.battery+=50;
        return this.battery;
    }

    /* Put drone to rest by turning it off and charging*/
    public void rest(){
        this.turnON = false;
        System.out.println("Shutting down "+ this.name+"...");
        this.charge();
    }

    /* Change the battery to default capacity of 100 regardless of whether the battery capacity has changed*/
    public void charge(){
        System.out.println("Charging "+this.name+" to 100...");
        this.battery=100;
    }
    /* "Undo" the drone's flying by setting its location to (0,0) */
    public void undo(){
        System.out.println("Resetting location to (0,0).");
        location.setLocation(0,0);
    }
    
    /* Main method for testing */
    public static void main(String[] args) {
        System.out.println("Test");
        Drone myDrone = new Drone("alpha", 5);
        myDrone.examine("alpha");
        myDrone.use("alpha");
        myDrone.grab("a package");
        System.out.println("Can this drone fly to the specified coordinates? "+myDrone.fly(-50,50));
        System.out.println("direction "+myDrone.walk("left"));
        myDrone.rest();
        System.out.println("battery "+myDrone.shrink());
        System.out.println("battery "+myDrone.grow());
        myDrone.undo();

    }
}
   
    


