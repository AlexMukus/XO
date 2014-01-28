package main.XO;
import main.XO.Field.*;


public class Main {
    public static void main(String[] args) {
        FieldOut field = new FieldOut();

        field.clearField();
        field.setCellX(1,1);
        field.showField();
        System.out.print(field.getCell(1,1));
    }
}
