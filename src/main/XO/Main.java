
package main.xo;
import main.xo.fields.*;
import java.util.*;
import main.xo.user.*;


public class Main {


    public static void main(String[] args) {
        FieldOut field = new FieldOut(3);
        ObrabotkaIO testString = new ObrabotkaIO();
        Gamers gamers = new Gamers(2);
        Scanner testSc = new Scanner(System.in);

        gamers.setNamesPlayer();

        String temp="";
        field.showField();
        do {
            testString.getinputtext();
            temp = testSc.nextLine() ;
               if (!temp.isEmpty()){
                if (testString.findData(temp)){
                    testString.publicKoordinate();
                }
            }
        }while (!temp.isEmpty());
        testSc.close();
        field.clearField();
        field.setCellX(1,1);
        field.showField();
        if (field.getCell(1,0) == ' ') {
            field.setCellO(1,0);
        }
        field.showField();
    }
}
