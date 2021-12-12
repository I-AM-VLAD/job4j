package ru.job4j.chapter_006.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answer = new ArrayList<>();
        boolean flagStop = false;
        try (BufferedReader read = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            read.lines().forEach(answer::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path)
                ))) {
            int a = 10;
            while(a-- != 0) {
                Scanner scanner = new Scanner(System.in);
                String question = scanner.nextLine();
                int random = new Random().nextInt(answer.size());
                if(question.contains(OUT)) {
                    break;
                }
                if(question.contains(STOP)) {
                    flagStop = true;
                }
                if (question.contains(CONTINUE)) {
                    flagStop = false;
                }

                if(!flagStop) {
                    System.out.println(answer.get(random));
                    out.println(question);
                    out.println(answer.get(random));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/chat.log", "data/botAnswers.txt");
        cc.run();
    }
}
