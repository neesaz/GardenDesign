/*
 * AUTHOR: Nees Abusaada
 * FILE: Vegetables.java
 * ASSIGNMENT: Programming Assignment - Vegetables plant
 * COURSE: CSc 210; fall 2021
 * DATE: October 3, 2021.
 * PURPOSE: This program is created to be extended from the Plant class.
 * It has a multiple methods to the Vegetables plant. It has a method to
 * return the type , location grow, and remove the vegetable plant. It
 * keeps track of growing and removing by incrementing and decrementing
 * for removing.
 *
 *
 * Usage : java PA5Main
 *
 *
 * where the file input looks like the example below
 * -----------------------------------------
 * Example of the file : test.txt
 * -----------------------------------------
 * rows: 1
 * cols: 1
 * PLANT (0,0) banana
 * PRINT
 * GROW 1
 * print
 * -----------------------------------------
 * Example of the output file : test.out
 *
 *  > PRINT
 *   .....
 *   .....
 *   .....
 *   .....
 *   ..b..
 *   > GROW 1
 *
 *   > PRINT
 *   .....
 *   .....
 *   .....
 *   ..b..
 *   ..b..
 *
 */


/*
This class extends from plant and have the information
to the vegetable plant to be growing and removing from the garden.
 */
public class Vegetables extends Plant{
    /*
    String  to keep track of  vegetable location.
    */
    private String location;
    /*
    String  to keep track of  vegetable name.
     */
    private String vegetableName;
    /*
    An integer to keep track of number the vegetables grew.
    */
    private  int vegetablesCounter;
    /*

    This method constructs a new instance of Vegetables class.
    @param location : A string represent the location plant as (x,y).
    @param nameType : A string represent the plant type.
     */
    public Vegetables(String location, String nameType) {
        super(location, nameType);
        this.vegetableName =  nameType;
        this.location = location;
    }

    /*
    A method that gets the type of the vegetables name.
    @returns vegetableName : A string that represent the plant type.
     */
    public String getNameVege(){
        return vegetableName;
    }

    /*
    This method increment the variable that keeps track of the growing
    vegetables plant. If the number goes over limit it will set it back to
    be 4 again.
    @returns vegetablesCounter : An integer to keep track of the growing variable
     */
    public int growing(){
        int limit = 4;
        vegetablesCounter += 1;
        if (vegetablesCounter > limit ){
            vegetablesCounter = 4;
        }
        return vegetablesCounter;

    }

    /*
    This method return the count vegetables.
    @returns vegetablesCounter : An integer that kept track of the counting vegetables
     */
    public int removing(){
        return vegetablesCounter;
    }

    /*
    This method returns the first character of the name of the plant.
    @returns A string.
     */
    public String toString(){
        return Character.toString(vegetableName.charAt(0));

    }

}
