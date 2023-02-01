import java.util.ArrayList;
import java.util.Scanner;

public class TwoPoints {
    public static void computePointofIntersection(Integer currPosOfX, Integer currPosOfY){
        while(!currPosOfY.equals(currPosOfX)) {
            currPosOfX = (currPosOfX + 2 ) % 12;
            currPosOfY =  (currPosOfY + 1) % 12;
        }
        System.out.println("Pos at which X and Y will meet will be " + (currPosOfX + 1));
    }
    public static void takeInput(ArrayList<Integer> pos){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the pos of X");
        pos.add(input.nextInt());
        System.out.println("Enter the pos ob Y");
        pos.add(input.nextInt());
    }
    public static void main(String[] args){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        takeInput(pos);
        /** 0 based indexing */
        Integer currPosOfX = pos.get(0) - 1;
        Integer currPosOfY = pos.get(1) - 1;
        computePointofIntersection(currPosOfX, currPosOfY );
    }
}

