package main.xo.fields;

public class ObrabotkaIO {
    private static final String INPUT_TEXT = "Введите координаты вашей отметки в формате [горизонт][пробел][вертикаль]: ";
    private static final String TEXT_MAX_FIELD = "Максимальный размер поля:";
    private static final String ILLEGAL_SIZE_FIELD = "Указанные координаты превышают размер поля";
    private static final String ERROR_STRING = "[ Ошибка ввода ]";
    private static final String RETRY_INPUT = "< Повторите попытку >";
    private static final String LIST_CIFR = "0123456789";
    private static final String LIST_RAZDELITEL = " ,.;:-_";
    private static final int NO_DATA = -1;
    private static final int RAZDELITEL = -2;
    private int koordinataX =0;
    private int koordinataY =0;
    FieldOut field = new FieldOut();

    public ObrabotkaIO(){

    }
    public void getinputtext(){
        System.out.println();
        System.out.println(TEXT_MAX_FIELD + " [" + field.getFieldSize() + "]x[" + field.getFieldSize() + "]");
        System.out.print(INPUT_TEXT);
    }
    public void getOutErrorString(){
        System.out.println(ERROR_STRING);
    }
    public void getOutRetryInput(){
        System.out.println(RETRY_INPUT);
    }
    private int findDec(char oneElement){
        for(int i=0; i<LIST_CIFR.length(); i++){
            if (LIST_CIFR.charAt(i) == oneElement) {
                return i;
            }
        }
        return NO_DATA;
    }
    private int findZpt(char oneElement){
        for(int i=0; i<LIST_RAZDELITEL.length(); i++){
            if (LIST_RAZDELITEL.charAt(i) == oneElement) {
                return RAZDELITEL;
            }
        }
        return NO_DATA;
    }
    public int getX(){
        return koordinataX;
    }
    public int getY(){
        return koordinataY;
    }
    private void setX(int X){
        koordinataX = X;
    }
    private void setY(int Y){
        koordinataY = Y;
    }
    public boolean findData(String findingLine){
        int poisk =0;
        int poiskzpt=0;
        int dlinnastroki=findingLine.length();

        for (int i=0; i< dlinnastroki;i++){
            // Проверка на наличие цифры или знака препинания
            if ( (findDec(findingLine.charAt(i))<0) && (findZpt(findingLine.charAt(i)) != -2)  ){
                getOutRetryInput();
                getOutErrorString();
                return false;
            }
            if (findDec(findingLine.charAt(i))>=0){
                poisk++;
            } else if ( (poisk > 0) && ( findZpt(findingLine.charAt(i)) == -2) ) {
                poiskzpt++;
                poisk=0;
                }
        }
        if ((poisk !=0) && (poiskzpt == 1 )){
            if (koordinate(findingLine)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            getOutRetryInput();
            getOutErrorString();
            return false;
        }
    }
    private boolean legalKoordinateSize (int koordinate){
        if (koordinate >= field.getFieldSize()){
            System.out.println(ILLEGAL_SIZE_FIELD);
            System.out.println(RETRY_INPUT);
            return false;
        }
        else return true;
    }
    public void publicKoordinate(){
        System.out.println("Ваша координата [" + getX() + "]x[" + getY() + "]");
    }
    private boolean koordinate(String stringline){
        int[] cifir = {-1,-1};
        int[] dlinna = {-1,-1};
        int dlinnastroki = stringline.length();
        int[] dataKoordinate={0,0};


        for(int i=0; i<dlinnastroki;i++){
            if ( (findDec(stringline.charAt(i))>=0) && (cifir[0] == -1) ) {
                cifir[0]=i;
            }
            if ( (findZpt(stringline.charAt(i)) == -2) && (cifir[0]!=-1) && (dlinna[0] == -1) ){
                dlinna[0]=i-cifir[0];
            }
            if ( (findZpt(stringline.charAt(dlinnastroki-i-1)) == -2) && (cifir[1] != -1) && (dlinna[1] == -1 ) ){
                dlinna[1]=i;
                cifir[1]=dlinnastroki-i;
            }
            if ( (findDec(stringline.charAt(dlinnastroki-i-1)) >= 0) && (cifir[1] == -1)  ){
                cifir[1]=dlinnastroki-i;
            }
        }

        for (int c=0; c<2; c++){
            for(int i=cifir[c]; i<cifir[c]+dlinna[c];i++){

                dataKoordinate[c]+=findDec(stringline.charAt(i))*Math.pow(10,(dlinna[c]-1-(i-cifir[c]) ) ) ;
            }
        }
        if (legalKoordinateSize(dataKoordinate[0])) {
            setX(dataKoordinate[0]);
        }
        else {
            return false;
        }
        if (legalKoordinateSize(dataKoordinate[1])) {
            setY(dataKoordinate[1]);
        }else{
            return false;
        }
        return true;
    }
}
