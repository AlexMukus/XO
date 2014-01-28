package main.xo.fields;

public class FieldOut {

    private static final int DEFAULT_FIELD_SIZE = 3;
    private static final int MINIMUM_FIELD_SIZE = 0;
    private static final int MAXIMUM_FIELD_SIZE = 100;
    private static final char EMPTY_CELL = ' ';// Вид пустого поля
    private static final char CELL_X = 'X';
    private static final char CELL_O = 'O';
    private char[][] field ; //Создайв массив для поля крестиков ноликов размером макс сайзе.
    private int fieldsize;

    public FieldOut(){
        this(DEFAULT_FIELD_SIZE);
    }
    public FieldOut(int size){
        if ((size > MINIMUM_FIELD_SIZE) && (size < MAXIMUM_FIELD_SIZE)) {
            fieldsize = size;
        }
        else {
            fieldsize = DEFAULT_FIELD_SIZE;
        }
        field = new char[fieldsize][fieldsize];
    }

    public void clearField(){
        for(int i=0; i< fieldsize; i++){
            for(int i2=0; i2< fieldsize; i2++){
                clearCell(i,i2);
            }
        }
    }
    public void showField(){
        for(int i=0; i< fieldsize; i++){
            showCellLine(i);
        }
    }
    private void showCellLine(int x){
        for(int i=0; i< fieldsize; i++){
            showCell(x,i);
        }
        System.out.println();
    }
    private int failedCell(int x){
        if (x >= fieldsize) {
            return fieldsize-1;
        }
        else{
            return x;
        }
    }
    private void showCell(int x, int y){
        System.out.print("[ " + field[failedCell(x)][failedCell(y)] + " ]");
    }
    private void clearCell(int x, int y){
        field[failedCell(x)][failedCell(y)]= EMPTY_CELL;
    }

    public void setCellX(int x, int y){
        field[failedCell(x)][failedCell(y)]=CELL_X;
    }

    public void setCellO(int x, int y){
        field[failedCell(x)][failedCell(y)]=CELL_O;
    }
    public char getCell(int x, int y){
        return field[failedCell(x)][failedCell(y)];
    }
}
