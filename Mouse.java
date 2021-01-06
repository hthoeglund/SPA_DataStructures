import java.util.*;

public class Mouse {
    private String name;
    private int xCoord;
    private int yCoord;
    private ArrayList<ArrayList<Integer>> coordinateHistoryStack = new ArrayList<ArrayList<Integer>>();
    

    public Mouse(String iName, int iXCoord, int iYCoord){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        name = iName;
        xCoord = iXCoord;
        yCoord = iYCoord;
        coords.add(4);
        coords.add(2);
        coordinateHistoryStack.add(coords);
    }
    public String getName(){
        return name;
    }

    public int getXCoordinate(){
        return xCoord;
    }
    
    public int getYCoordinate(){
        return yCoord;
    }

    public void printInformation(){
        System.out.println(name + " is at (" + xCoord + ", " + yCoord + "), and the history of his movement is " + coordinateHistoryStack);
    }

    //The arrayList must be re-initialized every time to prevent coordinateHistoryStack from overwriting previous values.
    public void moveUp(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        yCoord++;
        coords.add(xCoord);
        System.out.println(coords);
        coords.add(yCoord);
        System.out.println(coords);
        coordinateHistoryStack.add(coords);
        System.out.println(coordinateHistoryStack);
    }

    public void moveDown(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        yCoord--;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveRight(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord++;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveLeft(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord--;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
}