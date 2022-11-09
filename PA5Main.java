/*
 * AUTHOR: Nees Abusaada
 * FILE: PA5Main.java
 * ASSIGNMENT: Programming Assignment - PA5Main.java
 * COURSE: CSc 210; fall 2021
 * DATE: October 3, 2021.
 * PURPOSE: This program is created to the mange the garden
 * by reading the file that passed as a command line. It will
 * read through the file and store the first two lines to be
 * row and column.The simulation will read commands like PLANT,
 * PRINT, GROW, and HARVEST from a file and execute those commands.
 * Then it will pass the information to the method that checks the
 * commands and call the methods based on the command required.
 * Also, it will check the column to be less than 16 otherwise
 * it will print an error message saying "Too many plot columns."
 * Also, there are two methods that created to check the location
 * and the type of plant provided. There is method for growing plants
 * and the other method to remove plant. It prints what the command
 * is doing before it grows/ removes/ print.
 *
 *
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
This class reads a file and check each line by calling
the specified methods and check the boundaries of the garden.
 */
public class PA5Main {
        /*
        This method reads a file by a command line and use a scanner
        to read the first two lines to get the row and column. Using
        if statement to check that the column is less than 16. Otherwise,
        it will print a message because the column is greater than 16 saying
        "Too many plot columns." Finally, it will convert the row and column to
        be an integer and pass it into the garden class and pass it into the
        checkCommands method.
        @param arg : A string of the file name.
        @returns boolean : true or false.

         */
    public static boolean readFile(String arg) throws FileNotFoundException {
        int convertRow;
        int convertCol;
        boolean vaild = true;

        Scanner lines = new Scanner(new File(arg));
        String[] row = lines.nextLine().trim().split(" ");
        String[] column = lines.nextLine().split(" ");
        if (Integer.parseInt(column[1]) > 16){
            System.out.println("Too many plot columns.");
            return vaild;
        }
        convertRow =  Integer.parseInt(row[1]);
        convertCol = Integer.parseInt(column[1]);
        Garden garden = new Garden(convertRow,convertCol);
        checkCommands(lines, garden);
        return false;
    }

    /*
    This method checks the commands from the file and call the method.
    Using while loop to iterate through each line in the file and check
    if the command be as plant, print, grow, cut, harvest, and pick.
    if the command equals to plant it will call the garden and add
    plant by calling the plant element. if the command equals to print
    it will print the garden. if the command equals to grow it will
    call the growth garden method and passing the location and type name.
    if the command equals to remove (cut, harvest, pick) it will call the
    remove method.
    @param Scanner scan
    @param Garden garden : access to Garden class.
     */
    public static void checkCommands(Scanner scan, Garden garden) {
        while (scan.hasNext()){
            String lines =  scan.nextLine();
            String [] command= lines.split(" ");
            if (command[0].equalsIgnoreCase("plant")){
                garden.plantElement(command[1], command[2].toLowerCase());
            }
            if (command[0].equalsIgnoreCase("print")){
                System.out.println("> " + "PRINT");
                System.out.println(garden);
            }
            if (command[0].equalsIgnoreCase("grow")){
                growGarden(garden, command);
            }
            if (command[0].equalsIgnoreCase("cut")
             || command[0].equalsIgnoreCase("harvest")
             || command[0].equalsIgnoreCase("pick")){
                removeGarden(garden, command);
            }
        }
    }


    /*
    This method has multiple parameters to grow the plant in the garden.
    It checks if the growth has to be with a specific location or type and
    get the count of how many times the plant will grow. Using if statement
    to check if the lines is equals 2 that means it is growing by the number
    count. Then it will call the method to grow by number. Using if statement
    to check if it is growing by location that represented as (x,y). Finally it
    grows by checking the name of type plant.
    @param garden: Access to Garden class.
    @param lines : A list of Strings from the file.
    */
    public static void growGarden(Garden garden, String[] lines){
            int countGrow = Integer.parseInt(lines[1]);
            if(lines.length == 2){
                garden.growNum(countGrow);
            }
            else if(Character.isDigit(lines[2].charAt(1))) {
                System.out.println("> "+ "GROW " + countGrow+ " "+ lines[2]);
                String coordinates = lines[2].substring(1,lines[2].length()-1);
                String[] array = coordinates.split(",");
                garden.growByPosition(array[0], array[1], countGrow);
            }
            else{
                garden.growSpecifiedPlant(countGrow, lines[2]);
            }
            System.out.println();
        }



        /*
        This method has two parameters to remove the plant that already
        exist in the garden. It checks if the file line has a length equals
        to 1 it will call the remove all method. If the removing was provided
        by a location that represented as (x,y) it will pass it to the
        removeBoundaries method to check that is existed and in the garden
        then remove it. Otherwise, it will remove the plant by the name of
        the plant.
        @param garden : Access to Garden class
        @param lines : A list of Strings from the file.
        */
        public static void removeGarden( Garden garden , String[] lines) {
            if (lines.length == 1) {
                garden.removeAllPlants(lines[0].toLowerCase());
            }
            else if (Character.isDigit(lines[1].charAt(1))) {
                String points = lines[1].substring(1, lines[1].length() - 1);
                String[] cords = points.split(",");
                System.out.println("> "+ lines[0].toUpperCase()+ " " + lines[1]);
                garden.removeBoundaries(cords[0], cords[1]
                        , lines[0].toLowerCase());
            } else {
                System.out.println("> "+ lines[0].toUpperCase()+ " " + lines[1]);
                garden.removeSelectedPlant(lines[1].toLowerCase());
            }
            System.out.println();
        }


        public static void main(String[] args) throws FileNotFoundException {
            // read a file by command line
            readFile(args[0]);
        }
    }