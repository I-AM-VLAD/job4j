package ru.job4j.chapter_006.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char)read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for(String line : lines) {
                int num = Integer.parseInt(line);
                boolean rsl = num % 2 == 0;
                System.out.println(rsl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
