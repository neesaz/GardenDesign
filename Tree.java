/*
 * AUTHOR: Nees Abusaada
 * FILE: Tree.java
 * ASSIGNMENT: Programming Assignment - Tree plant
 * COURSE: CSc 210; fall 2021
 * DATE: October 3, 2021.
 * PURPOSE: This program is created to be extended from the Plant class.
 * It has a multiple methods to create the Tree plant. It has a method to
 * return the type , location grow, and remove the tree
 *  plant. It
 * keeps track of growing and removing by incrementing and decrementing
 * for removing.
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
 *
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
to the tree plant to be growing and removing from the garden.
 */
public class Tree extends Plant{
    /*
    String  to keep track of tree location.
    */
    private String location;
    /*
    String  to keep track of tree name plant.
    */
    private String nameTree;
    /*
    An integer to keep track of number the tree grew.
    */
    private  int countTree;

    /*
     This method constructs a new instance of Tree class.
     @param location : A string represent the location plant as (x,y).
     @param nameType : A string represent the plant type.
      */
    public Tree(String location, String nameType) {
        super(location, nameType);
        this.nameTree =  nameType;
        this.location = location;
        countTree = 0;

    }


    /*
    This method increment the variable that keeps track of the growing
    tree plant. If the number goes over 4 it will set it back to
    be 4 again.
    @returns countTree : An integer to keep track of the growing
    plants variable.
     */
    public int growing(){
        countTree += 1;
        if (countTree > 4){
            countTree=4;
        }
        return countTree ;
    }




    /*
    This method removes the tree plant and
    return the count tree.
    @returns countTree : An integer that kept track of the growing
    tree plant.

     */
    public int removing() {
        return countTree;
    }

    /*
    This method returns the first character of the name of the plant.
    @returns A string.
     */
    public String toString(){
        return Character.toString(nameTree.charAt(0));

    }
}
