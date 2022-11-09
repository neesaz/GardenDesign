/*
 * AUTHOR: Nees Abusaada
 * FILE: Plant.java
 * ASSIGNMENT: Programming Assignment - Plant
 * COURSE: CSc 210; fall 2021
 * DATE: October 3, 2021.
 * PURPOSE: This program is created to be abstract class and have
 * a growth and remove methods that override to all the plants classes.
 * which is tree, flower, vegetables.
 *
 * USAGE:
 * java PA5Main
 *
 * where the file input looks like the example below

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
This class to abstract the grow and remove methods.
 */
abstract class Plant{
    /*
    This method constructs a new instance of Plant class
    @param location : A string represent the location plant as (x,y).
    @param name : A string represent the plant type.
     */
    public Plant(String location,String name){
    }
    /*
    This method is related to the three
    classes, Tree, Flower, Vegetables.
     */
    abstract int growing();
    /*
    This method is related to the three
    classes, Tree, Flower, Vegetables.
     */
    abstract int removing();




}
