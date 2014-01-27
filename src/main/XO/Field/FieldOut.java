package main.XO.Field;

public class FieldOut {

    private static final int MAX_SIZE=3;// Максимальный размер поля крестиков ноликов
    private static final char EMPTY_CELL=' ';// Вид пустого поля
    private static final char CELL_X='X';
    private static final char CELL_O='O';
    private char[][] field = new char[MAX_SIZE][MAX_SIZE]; //Создайв массив для поля крестиков ноликов размером макс сайзе.

    public void clearField(){
        for(int i=0; i<MAX_SIZE; i++){
            for(int i2=0; i2<MAX_SIZE; i2++){
                clearCell(i,i2);
            }
        }
    }
    public void showField(){
        for(int i=0; i< MAX_SIZE; i++){
            showCellLine(i);
        }
    }
    private void showCellLine(int x){
        for(int i=0; i< MAX_SIZE; i++){
            showCell(x,i);
        }
        System.out.println();
    }
    private void showCell(int x, int y){
        System.out.print("[ " + field[x][y] + " ]");
    }
    private void clearCell(int x, int y){
        field[x][y]= EMPTY_CELL;
    }

    public void setCellX(int x, int y){
        field[x][y]=CELL_X;
    }

    public void setCellO(int x, int y){
        field[x][y]=CELL_O;
    }
    public char getCell(int x, int y){
        return field[x][y];
    }
}
