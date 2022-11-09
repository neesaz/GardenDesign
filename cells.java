/*
 * AUTHOR: Nees Abusaada
 * FILE: cells.java
 * ASSIGNMENT: Programming Assignment - create each cell in the garden.
 * COURSE: CSc 210; fall 2021
 * DATE: October 3, 2021.
 * PURPOSE: This program is created to the creation the cells of garden.
 * The garden will consist of a number of rows and columns of cells.
 * Within each cell there can exist a single plant, which is represented
 * with a five by five grid of cells. It creates the cells and be able to
 * add plant into the cells and remove the plants from the cells. Plants
 * are divided up into three different categories: trees, flowers, and
 * vegetables, all of which have unique characteristics. For example,
 * trees grow up, vegetables grow down, and flowers bloom as they grow.
 * There are few arraylists to check the name of the plant is related to
 *  which category. Also, it will grow each type of the plants in the cells.
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
 *
 *
 */

import java.util.ArrayList;



/*
This class is used to create the cells in the garden.
it has multiple method to take care of the growing and
removing plants.
*/
public class cells {
    /*
    A string to keep track of the plant type
    */
    private String typeName;
    /*
    A string to keep track of the plant location.
    */
    private String location;
    /*
    A string to keep track of the plant type
    */
    private String PlantType;
    /*
    A 2D array for plants.
    */
    private Plant[][] plants;
    /*
    An ArrayList to add all the plant tree names.
    */
    private ArrayList<String> trees;
    /*
    An ArrayList to add all the plant flowers names.
    */
    private ArrayList<String> flowers;
    /*
    An ArrayList to add all the plant vegetables names.
    */
    private ArrayList<String> vegetables;


    /*
    This constructs a new instance of the cells class.
    It has two parameters to initialize the location and plant
    type. Also, the plants which is a grid of five by five.
    The plant classify into three types, tree,flower,vegetable.
    Each plant has an arraylist that contains the names of the
    plant. Finally, it calls the method to add create the
    Arraylists and then call the method that adds plant.
    @param location : A string that keeps track of the location plant
    represented as (row, column).
    @param name : A string that keeps track of the plant's name.
     */
    public cells(String location, String name) {
        this.typeName = name;
        this.location = location;
        vegetables =  new ArrayList<String>();
        flowers = new ArrayList<String>();
        trees =  new ArrayList<String>();
        plants = new Plant[5][5];
        addAllPlants();
        addPlant();
    }

    /*
    This method returns the type of the plant name, which
    might be a name of plant tree or flower or vegetable.
    @returns typeName : A string of the plant name.
     */
    public String getPlantType(){
        return typeName;
    }


    /*
    This method returns the type of the plant, which
    might be a tree, flower, vegetable.
    @returns PlantType : A string of the plant name.
    */
    public String getTypePlant(){
        return PlantType;
    }



    /*
    This method adds all the plants into different arrays.
    It creates a list for the plant tree names and by using for loop
    it iterates through to get each name of the list and add it into the
    arraylist specified for tree. It creates a list for the plant flower
    names and by using for loop it iterates through to get each name in the
    list and add it into the arraylist specified for flowers. Finally,it does
    the same , but for the plant vegetable. It creates a list for the plant
    vegetables names and by using for loop it iterates through to get each name
    in the list and add it into the arraylist that specified for vegetables.
     */
    public void addAllPlants() {
        // trees
        String[] treeList =  new String[]
        {"oak", "willow", "banana", "coconut","pine" };
        for (String name : treeList)
            trees.add(name);
        // flowers
        String[] flowerList =  new String[]
        {"iris", "lily", "rose", "daisy","tulip","sunflower"};
        for (String name : flowerList)
            flowers.add(name);
        // vegetables
        String[] vegetablesList =  new String[]
                {"garlic", "zucchini", "tomato", "yam","lettuce"};
        for (String name : vegetablesList)
            vegetables.add(name);
    }



    /*
    This method adds the plants into the plants array.
    Using if statements to check if the plant will be added
    is tree or flower or vegetables. If the plant in the
    flower arraylist it will add it into the plant 2D array
    and call the flower class passing the location and type as well.
    Then set the plant type variable to be the plant type, which is flower.
    If the plant in the tree arraylist it will add it up into the plant 2D
    array and call the tree class passing the location and type as well.
    Then set the plant type variable to be the plant type, which is tree.
    If the plant in the vegetable's arraylist it will add it down into the
    plant 2D array and call the vegetables class passing the location and
    type as well.Then set the plant type variable to be the plant type,
    which is vegetables.

     */
    public void addPlant() {
        // flower plant
        if (flowers.contains(typeName)) {
            plants[2][2] = new Flower(location, typeName);
            PlantType = "flower";
        }
        // tree plant
        if (trees.contains(typeName)) {
            plants[4][2] = new Tree(location, typeName);
            PlantType = "tree";

        }
        // vegetables plant
        if (vegetables.contains(typeName)) {
            plants[0][2] = new Vegetables(location, typeName);
            PlantType = "vegetable";
        }
    }


    /*
    This method grows each plant by specific way for each plant type.
    Starting off by using nested loops to iterate through the  plant
    2D array and using if statements to check if the spot is not empty(null).
    It has an integer variable that stored how many times the plant supposed
    to grow. Using another if statements to check if the plant is Flower or
    Tree Or vegetables by using instanceof which compares the object is an
    instance of the specified type (class or subclass). If the type was flower
    ,it will use additional for statements because growing the flower will be
    blooming with goes to the right, left, up, and down to design the blooming
    flower shape. It adds the location and x row ,y column to the arraylist.
    If the plant type was tree it will grow up and passing name type and
    location to the tree class. If the plant type was Vegetables it will grow
    down and passing name type and location to the tree class.
     */
    public void growEachPlant() {
        ArrayList flowerGrowArray = new ArrayList<Integer>();
        for (int x = 0; x < plants.length; x++) {
            for (int y = 0; y < plants[x].length; y++) {
                if (plants[x][y] != null){
                    int growCount = plants[x][y].growing();
                    // instanceof it compares the instance with type.
                    if(plants[x][y]  instanceof  Flower){
                        // If statements to check the down direction and the
                        //spot is not empty (null).
                        if ((x-1) >= 0 && plants [x-1][y] == null){
                            flowerGrowArray.add(x-1);
                            flowerGrowArray.add(y);
                        }
                        // If statements to check the up direction and the
                        //spot is not empty (null).
                        if ((x+1) < 5  && plants [x+1][y] == null){
                            flowerGrowArray.add(x+1);
                            flowerGrowArray.add(y);
                        }
                        // If statements to check the down direction and the
                        //spot is not empty (null).
                        if ((y+1) < 5  && plants [x][y+1] == null){
                            flowerGrowArray.add(x);
                            flowerGrowArray.add(y+1);

                        }
                        // If statements to check the left direction and the
                        //spot is not empty (null).
                        if ((y-1) >= 0 && plants[x][y-1] == null){
                            flowerGrowArray.add(x);
                            flowerGrowArray.add(y-1);
                        }
                    }
                    // grow tree up
                    if (plants[x][y]  instanceof Tree){
                        plants[(2+2) - growCount][2] =
                                new Tree(location, typeName);
                    }
                    // grow Vegetables down
                    if (plants[x][y] instanceof  Vegetables){
                        plants[growCount][2] =

                                new Vegetables(location, typeName);
                    }

                }
            }
        }
        // calling the helper method iterate through it and complete
        // growing flower
        additionalGrowFlower(flowerGrowArray);
    }



    /*
    This method helps with growing the flower that it can iterate
    through the arraylist and add flowers. By indexing through the
    arraylist and the plants of 2D array and create a new flower.
    IT takes the size of the arraylist and iterate through and get
    the index and keep track of the location the  flower should
    grow in.
    @param growArray : ArrayList of integers.
     */
    private void additionalGrowFlower(ArrayList<Integer> growArray) {
        int arraySize = growArray.size();
        int i = 0 ;
        while ( i  < arraySize ){
            int indexing = growArray.get(i);
            plants[indexing][growArray.get(i+1)] =
                    new Flower(location, typeName);
            i+=2;
        }
    }


    /*
    The method saves the lines of the plants to help
    with printing the garden. It creates an empty String
    then using a for loop to iterate through the number
    that passed as a parameter and get the line on that number.
    Using if statements to check if the 2D array plants on
    the location is not null then it will add the
    character of the plant name to the string. Otherwise,
    it will add dot which represent an empty spot.
    @param number : An integer to keep track of number line.
     */
    public String printEachLine(int number) {
        String saveLine = "";
        for (int i = 0; i < plants[number].length; i++) {
            if (plants[number][i] != null) {
                saveLine += plants[number][i].toString();

            } else {
                saveLine += ".";
            }
        }
        return saveLine;
    }


    /*
    This method can remove all the names of type plant flower.
    Removing for flower will consider a pick command. By using
    nested loop to iterate through the plants 2D array and using if
    statements to check if it not empty (null) it will continue to
    check if whether the object is an instance of the specified type
    then it will set it to be null which is empty.
     */
        public void pickFlower() {
            int sizeCell = 5;
            for (int i = 0 ;  i < sizeCell ; i++){
                for (int j = 0 ; j < sizeCell ; j++){
                    if (plants[i][j] != null){
                        if (plants[i][j] instanceof Flower){
                            plants[i][j] = null;
                        }
                    }
                }
            }
        }
    /*
    This method can remove all the names of type plant tree.
    Removing for tree will consider a cut command. Using if
    statements to check if it not empty (null) it will continue.
    Then, using another if statements to check if the plant exist
    for the type plant tree, it will create an integer variable to
    remove and use a for loop to iterate through based on the removing
    times. If that is valid it will set the position by indexing row and
    column on the plants to be empty (null).
     */
    public void cutTree() {
        if (plants[4][2] != null){
            if (plants[4][2] instanceof Tree){
                int cutCount = plants[4][2].removing();
                for (int i = 0 ; i < cutCount+1; i++){
                    plants[4-i][2]=null;
                }

            }
        }
    }


    /*
    This method can remove all the names of type plant vegetables.
    Removing for vegetables will consider a harvest command. Using if
    statements to check if it not empty (null) it will continue.
    Then, using another if statements to check if the plant exist
    for the type plant vegetables, it will create an integer variable to
    remove and use a for loop to iterate through based on the removing
    times. If that is valid it will set the position by indexing row and
    column on the plants to be empty (null).
     */
    public void harvestVegetables() {
        if (plants[0][2] != null){
            if (plants[0][2] instanceof Vegetables){
                int cutCount = plants[0][2].removing();
                for (int i = 0 ; i < cutCount + 1; i++){
                    plants[i][2]=null;
                }
            }
        }
    }


}