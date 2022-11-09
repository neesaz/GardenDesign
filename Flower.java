/*
 * AUTHOR: Nees Abusaada
 * FILE: Flower.java
 * ASSIGNMENT: Programming Assignment - flower plant
 * COURSE: CSc 210; fall 2021
 * DATE: October 3, 2021.
 * PURPOSE: This program is created to be extended from the Plant class.
 * It has a multiple methods to the flower plant. It has a method to
 * return the type , location grow, and remove the flower
 * plant. It keeps track of growing and removing by incrementing and
 * returning zero.
 *
 * Usage : java PA5Main
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
to the flower plant to be growing and removing from the garden.
 */
public class Flower extends Plant{
    /*
    String  to keep track of flower location.
    */
    private String location;
    /*
    String  to keep track of flower name plant.
    */
    private String nameFlower;
    /*
    An integer to keep track of number the flower grew.
    */
    private int countFlowers;
    /*
     This method constructs a new instance of flower class.
     @param location : A string represent the location plant as (x,y).
     @param nameType : A string represent the plant type.
     */
    public Flower(String location, String nameType) {
        super(location, nameType);
        this.nameFlower =  nameType;
        this.location = location;
    }


    /*
    This method to grow the flower in garden. It increments
    the countFlowers by one.
    @returns countFlowers : An integer that kept track of  how many
    times the flower grew.
     */
    public int growing(){
        countFlowers += 1;
        return countFlowers ;
    }

    @Override

    /*
    The removing method returns zero for counting flowers.
    @returns int.
     */
    public int removing() {
        return 0;
    }

    /*
    This method returns the first character of the name of the plant.
    @returns A string.
     */
    public String toString(){
        return Character.toString(nameFlower.charAt(0));

    }
}


