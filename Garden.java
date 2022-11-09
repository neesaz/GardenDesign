/*
 * AUTHOR: Nees Abusaada
 * FILE: Garden.java
 * ASSIGNMENT: Programming Assignment - Build a garden
 * COURSE: CSc 210; fall 2021
 * DATE: October 3, 2021.
 * PURPOSE: This program is created to control the garden by removing or adding
 * plants. It has multiple methods, and each method does a specific task.There
 * are various methods such as adding the plant into the 2D array from the
 * cells class, grow a particular type of plant (Flower, tree, vegetable ) by
 * the number, grow a specific type of plant with a specific location, remove
 * all the plants from the garden, remove the plant from the garden by
 * selected location and print the garden based on the 2D array. The
 * garden has two parameters for row and column. The plant can grow
 * inside the size of the row and column and can't plant in taken
 * place. Plants are divided up into three different categories:
 * trees, flowers, and vegetables, all of which have unique characteristics.
 * For example, trees grow up, vegetables grow down, and flowers bloom
 * as they grow.
 *

 * USAGE:
 * java PA5Main
 *
 * where the file input looks like the example below
 *-----------------------------------------
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
This class is used to create a garden and
be able to remove/add plant.
*/
public class Garden {
    /*
    A 2DArray from cells class.
     */
    private cells[][] twoArrayCells;
    private int growCount;
    /*
    An integer to get the row number.
    */
    private int convertedRow;
    /*
    An integer to get the column number.
    */
    private int convertedColumn;

    /*
    This method constructs a new instance of the Garden class
    with the specified row and column number. It creates
    a 2D Array based on the row and column numbers with using
    cells class.
    @param row : An integer to get the row number.
    @param col : An integer to get the column number.
     */
    Garden(int row, int col) {
        this.convertedColumn = col;
        this.convertedRow = row;
        twoArrayCells = new cells[convertedRow][convertedColumn];
        growCount = 0;
    }


    /*
    This method takes a data of the plant which is location
    and the plant type. It adds the plant into the 2D Array
    by the specified location that represented as (3,3).
    It takes the coordinates of the location and separated each number,
    then convert it to be an integer then create the plant.
    @param location : A string of the location points.
    @param type : A string of the plant type name.
     */
    public void plantElement(String location, String type) {
        int size = location.length();
        location = location.substring(1, size - 1 );
        String[] locationArray = location.split(",");
        int xRow =  Integer.parseInt(locationArray[0]);
        int yColumn = Integer.parseInt(locationArray[1]);
        twoArrayCells[xRow][yColumn] = new cells(location, type);
    }


    /*
    This method takes a number from the file which represents
    how many times wants to grow the plant. Using nested loop
    to iterate through the 2D array and using if statement to check
    if the spot is not taken (null) then it calls the growth method
    to grow the plant.
    @param counter : An integer of how many times the plant should grow.
     */
    public void growNum(int counter){
        System.out.println("> " + "GROW " + counter);
        // iterate based on the size of 2D Array.
        for (int x = 0; x < twoArrayCells.length; x++) {
            // iterate based on the size of each row in the 2D Array.
            for (int y = 0; y < twoArrayCells[x].length; y++) {
                if (twoArrayCells[x][y] != null) {
                    for(int num = 0; num < counter ; num++){
                        twoArrayCells[x][y].growEachPlant();
                    }
                }
            }
        }
    }


    /*
    This method grow the specific plant by the location provided as (3,3).
    Using if statement to check if the position is valid where it is inside the
    garden. If there is nothing at this position or the position is outside
    the size of the garden, it will print a message,” Can’t grow there.”
    If the position is valid it will call growEachPlant to grow plant.
    @param row : An String of row number.
    @param col : An String of column number.
    @param growCounting : An integer of growing number.
    */
    public void growByPosition(String row , String col, int growCounting) {
        // convert the strings number to an integers.
        int indexX = Integer.parseInt(row);
        int indexY = Integer.parseInt(col);
        if ((indexX < convertedRow &&  indexX >= 0 )&&
                (indexY < convertedColumn && indexY >= 0)){
            if (twoArrayCells[indexX][indexY] != null){
                for (int j =0 ; j < growCounting ; j++ ){
                    twoArrayCells[indexX][indexY].growEachPlant();
                    }
                }
            else if (twoArrayCells[indexX][indexY] == null){
                // print a message because the spot is empty.
                System.out.println("Can't grow there.");
            }
        }
        else {
            System.out.println("Can't grow there.");
        }
    }



    /*
    This method grow the specific plant by the specific type of plant.
    Using nested loop to iterate through the 2D Array and check if the
    spot reached is not empty(null). Using if statement to check the
    SpecifiedPlant string is equal to which plant type is related to.
    Using if statements to check if the Type is equal to the name type
    of the plant then it will call the method to grow the plant.
    @param growNumber : An integer of number growth.
    @param SpecifiedPlant : A String of the plant type.
     */
    public void growSpecifiedPlant(int growNumber , String SpecifiedPlant) {
        System.out.println("> "+ "GROW " + growNumber+ " "+ SpecifiedPlant);
        for (int i = 0; i < twoArrayCells.length; i++) {
            for (int j = 0; j < twoArrayCells[i].length; j++) {
                if (twoArrayCells[i][j] != null ){
                    for ( int num = 0 ; num < growNumber; num ++ ){
                        String specificType = twoArrayCells[i][j].getPlantType();
                        String specificClass= twoArrayCells[i][j].getTypePlant();
                        // checks if the plant type is equals SpecifiedPlant
                        if (specificType.equals(SpecifiedPlant)){
                            twoArrayCells[i][j].growEachPlant();
                        }
                        else if (specificClass.equals(SpecifiedPlant)){
                            twoArrayCells[i][j].growEachPlant();
                        }
                    }
                }
            }
        }
    }

    /*
    This method removes the plants from the garden. Using nested loop
    to iterate through the 2D Array to get each location. Using if
    statements to check if the spot is not empty(null), then
    it will check which remove type is this for. The cut
    for tree, the harvest for vegetables, the pick for followers.
    Each type of removing has method and by checking the type is from
    the cut commands, which cut or harvest or pick. it will call
    the correct method.
    @param removeType : A string of the remove type.
     */
    public void removeAllPlants(String removeType) {
        System.out.println("> "+ removeType.toUpperCase());
        for (int i = 0; i < twoArrayCells.length; i++){
            for (int j = 0; j < twoArrayCells[i].length; j++ ){
                if (twoArrayCells[i][j]!= null){
                    if(removeType.equals("cut")){
                        twoArrayCells[i][j].cutTree();
                    }
                    if(removeType.equals("harvest")){
                        twoArrayCells[i][j].harvestVegetables();
                    }
                    if(removeType.equals("pick")){
                        twoArrayCells[i][j].pickFlower();
                    }
                }
            }
        }
    }

    /*
    This method checks boundaries of the remove where the location
    has to be inside the garde. It converts the row and column to
    be integers. Using if statements to check if the (x,y) x is less than
    the row and greater or equal to zero. Also, check y to be
    less than the column number and greater or equal to zero.
    @param row : A String of x in the location (x,y).
    @param column : A String of y in the location (x,y).
    @param removingType : A string with selected type of removing.
     */
    public void removeBoundaries(String row, String column,
                                 String removingType) {
        int rowNumber = Integer.parseInt(row);
        int columnNumber = Integer.parseInt(column);
        if((rowNumber < convertedRow && rowNumber >= 0) &&
                (columnNumber < convertedColumn && columnNumber >= 0)){
          removeByPosition(rowNumber, columnNumber, removingType);
        }
    }


    /*
    This method removes the plant that is in the garden by location
    that provided as (x,y). It gets the type by call the getClassType
    from cells class. Using if statements to check if the removing
    type is related to the plant type. The cut is associated with
    tree, the harvest associated with  vegetables, the pick
    associated with followers. If the checking resulted true,
    it will call the location in the 2D Array with calling the
    method to remove the plant. Each type of plant has method to
    remove the plant. So the checking will lead it to the correct
    removing method. If  it was empty or out of the garden it will
    print Can't pick or harvest or pick there.

    @param numberX : An integer of x in the location (x,y).
    @param numberY : An integer of y in the location (x,y).
    @param removingType : A string with selected type of removing.
     */
    private void removeByPosition(int numberX, int numberY,
                                  String removingType) {
        if (twoArrayCells[numberX][numberY] !=null){
            String getType = twoArrayCells[numberX][numberY].getTypePlant();
            if  (removingType.startsWith("c") && getType.startsWith("t")){
                twoArrayCells[numberX][numberY].cutTree();
            }
            else if (removingType.equals("harvest")
                    && getType.equals("vegetable")){
                twoArrayCells[numberX][numberY].harvestVegetables();
            }
            else if (removingType.equals("pick")
                    && getType.equals("flower")){
                twoArrayCells[numberX][numberY].pickFlower();
            }
            else {
                System.out.println("Can't "+ removingType +" there.");
            }
        }
        else {
            System.out.println("Can't "+ removingType +" there.");
        }
    }

    /*
    This method removes the plant by taking one parameter which is the
    name of the plant. Using nested loop to iterate through the 2D Array
    and with using if statements to check if the spot is not empty(null).
    Then, it will check for the type of the plant then will call the method
    to remove the plant. Each plant has its own way of removing, The cut is
    associated with tree, the harvest associated with  vegetables, the pick
    associated with followers. Also, the if statements made sure that the
    type of plant and the name of the plant are related to each others.
    @param plantRemove : A string of the plant name that will be removed.
     */
    public void removeSelectedPlant(String plantRemove) {
        for (int i = 0; i< twoArrayCells.length; i++){
            for (int j = 0; j < twoArrayCells[i].length; j++){
                if (twoArrayCells[i][j] != null){
                    String namePlantRemove = twoArrayCells[i][j].getPlantType();
                    String typePlantRemove = twoArrayCells[i][j].getTypePlant();
                    if (namePlantRemove.equals(plantRemove)
                       && typePlantRemove.startsWith("t")){
                        twoArrayCells[i][j].cutTree();
                    }
                    if (namePlantRemove.equals(plantRemove) &&
                        typePlantRemove.startsWith("v")){
                        twoArrayCells[i][j].harvestVegetables();
                    }
                    if (namePlantRemove.equals(plantRemove)
                        && typePlantRemove.startsWith("f")){
                        twoArrayCells[i][j].pickFlower();
                    }
                }
            }
        }
    }

    /*
    This method is to print out the garden. It has an empty string
    and by using nested loops to iterate through each plot in the
    2D Array of garden to get reach all the spots. Using if statements
    to check if the spot is not taken (null) it will create an empty String
    that adds the dots into an empty string. By using while loop it will
    iterate by the size of the cell which is 5 by 5. The string will have 
    all dots. Otherwise, it will add the name
    of the plant by calling the printEachLine function to get the
    line and add it. Finally, it adds a new line after the third loop.
    @ returns holder :  A string contains the printed garden.
     */
    public String toString() {
        String holder = "";
        for (int i = 0; i < twoArrayCells.length; i++) {
            for (int index = 0; index < 5; index ++) {
                for (int j = 0; j < twoArrayCells[i].length; j++) {
                    if (twoArrayCells[i][j] == null) {
                        String emptySpot = "";
                        int number = 0;
                        while (number < 5 ){
                            emptySpot += ".";
                            number+=1;
                        }
                        holder += emptySpot;
                    } else {
                        holder += twoArrayCells[i][j].printEachLine(index);
                    }
                }
                holder += "\n";
            }
        }
        return holder;
    }

}

