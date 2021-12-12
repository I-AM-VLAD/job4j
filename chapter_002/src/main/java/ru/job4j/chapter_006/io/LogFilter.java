package ru.job4j.chapter_006.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        List<String> rsl = new ArrayList<>();
        int i = 1;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(String line : lines) {
            List<Character> smb = new ArrayList<>();
            while(line.charAt(line.length() - i) != ' ') {
                ++i;
            }
            while(line.charAt(line.length() - i - 1) != ' ') {
                smb.add(line.charAt(line.length() - i - 1));
                ++i;
            }
            if(smb.size() == 3 && smb.get(0) == '4' && smb.get(1) == '0' && smb.get(2) == '4') {
                rsl.add(line);
            }
            i = 1;
        }
        return rsl;
    }
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for(String elem : log) {
                out.write(elem + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for(String el : log) {
            System.out.println(el);
        }
        save(log, "404.txt");
    }
}
