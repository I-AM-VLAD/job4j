package ru.job4j.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int player1;
        int player2;

        int allMatches = 11;

        System.out.println("ВЫБЕРИТЕ КОЛИЧЕСТВО СПИЧЕК ОТ 1 ДО 3");
        while(allMatches != 0) {

            System.out.print("Берет player_1: ");
            player1 =  Integer.valueOf(input.nextLine());
            allMatches = allMatches - player1;

            System.out.println("Осталось спичек: " + allMatches);
            if(allMatches <= 3) {
                System.out.print("ПОБЕДИТЕЛЬ PLAYER_2");
                break;
            }

            System.out.print("Берет player_2: ");
            player2 =  Integer.valueOf(input.nextLine());
            allMatches = allMatches - player2;

            System.out.println("Осталось спичек: " + allMatches);
            if(allMatches <= 3) {
                System.out.print("ПОБЕДИТЕЛЬ PLAYER_1");
                break;
            }
            System.out.println();
        }
    }
}
