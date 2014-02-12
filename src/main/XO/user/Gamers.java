package main.xo.user;

import java.io.IOException;
import java.util.Scanner;

public class Gamers {
    private static final int DEFAULT_PLAYERS = 2;

    private static final int MAX_PLAYERS = 3;
    private static final int MIN_PLAYERS = 1;
    private static final String DEFAULT_NAME="Gamers";
    private static final String ERROR_NPLAYERS="Неверный ввод номера игрока";
    private static final String INPUT_NAME_PLAYER = "Введите имя игрока № ";
    private int players;
    private String[] name;

    public Gamers(){
        this(DEFAULT_PLAYERS);
    }
    public Gamers(int players_number){
        if ( (players_number >= MIN_PLAYERS) && (players_number <= MAX_PLAYERS) ){
            players=players_number;
        }
        else{
            players=DEFAULT_PLAYERS;
        }
        name = new String[players];
    }
    public void setName(String players_name,int number_players){
        if (players_name.length()!=0){
            name[number_players] = players_name;
        }
        else{
            name[number_players] = DEFAULT_NAME + "_" + number_players;
        }
    }
    public String getName(int number_players){
        return name[number_players];
    }
    public void setNamesPlayer(){
        Scanner inputLine = new Scanner(System.in);
        char simvol;
        String temp;
        for(int index=0; index<players; index++){
            do{
                System.out.print(INPUT_NAME_PLAYER + (index + 1) + " :");
                setName(inputLine.nextLine() ,index);
                System.out.println("Имя игрока " + (index + 1) + " :" + getName(index)) ;
                System.out.print("Имя принимается? Да(Y), Нет(N) - ");
                temp= inputLine.nextLine().toUpperCase();
                if ( !temp.isEmpty() ){
                    simvol = temp.charAt(0);
                }else {
                    simvol='n';
                }

            }while ( simvol != 'Y');
        }

        for(int index=0; index<players; index++){
            System.out.println( "Имя игрока " + (index+1) + " : " + getName(index)) ;
        }

    }
}
