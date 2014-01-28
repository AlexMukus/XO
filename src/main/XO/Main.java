package main.xo;
import main.xo.fields.*;


public class Main {
    public static void main(String[] args) {
        FieldOut field = new FieldOut(1);

        field.clearField();
        field.setCellX(1,1);
        field.showField();
        System.out.print(field.getCell(1,1));
    }
}
