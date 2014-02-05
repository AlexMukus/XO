
package main.xo;
import main.xo.fields.*;
import java.util.*;


public class Main {

    private int tempX=0;
    private int tempY=0;

    public static void main(String[] args) {
        FieldOut field = new FieldOut(0);
        Scanner testSc = new Scanner(System.in);

        System.out.print("Input text: ");
        String temp="";
        temp = testSc.next() ;
        testSc.close();


        System.out.println(temp);
        System.out.println(temp.length());
        if (temp.charAt(1)== '1') {
            System.out.println("Ok!");
        }
        else{
            System.out.println("Fail!!");
        }


        field.clearField();
        field.setCellX(1,1);
        field.showField();
        if (field.getCell(1,0) == ' ') {
            field.setCellO(1,0);
        }
        field.showField();
    }
}
