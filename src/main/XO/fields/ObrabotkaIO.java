package main.xo.fields;


public class ObrabotkaIO {
    private static final String ERROR_STRING = " Ошибка ввода ";
    private static final String RETRY_INPUT = " Повторите попытку ";

    public ObrabotkaIO(){

    };

    public void getOutErrorString(){
        System.out.println(ERROR_STRING);
    };
    public void getOutRetryInput(){
        System.out.println(RETRY_INPUT);
    };

    
}
