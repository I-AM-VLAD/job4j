package ru.job4j.chapter_006.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public static void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
               new BufferedOutputStream(
                       new FileOutputStream(target)
               ))) {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).length() == 0) {
                    continue;
                }
                StringBuilder statusStrOut = new StringBuilder();
                StringBuilder start = new StringBuilder();
                StringBuilder finish = new StringBuilder();
                statusStrOut.append(list.get(i).charAt(0));
                statusStrOut.append(list.get(i).charAt(1));
                statusStrOut.append(list.get(i).charAt(2));
                int statusIntOut = Integer.parseInt(statusStrOut.toString());
                int index = 4;
                if(statusIntOut == 400 || statusIntOut == 500) {
                    while(index != list.get(i).length()) {
                        start.append(list.get(i).charAt(index));
                        ++index;
                    }
                    StringBuilder statusStrIn = new StringBuilder();
                    int statusIntIn = 0;
                    while (i != list.size()) {
                        if(statusIntIn == 200 || statusIntIn == 300) {
                            break;
                        }
                        if(list.get(i).length() == 0) {
                            ++i;
                            continue;
                        }
                        statusStrIn.append(list.get(i).charAt(0));
                        statusStrIn.append(list.get(i).charAt(1));
                        statusStrIn.append(list.get(i).charAt(2));
                        statusIntIn = Integer.parseInt(statusStrIn.toString());
                        StringBuilder temp = new StringBuilder();
                        statusStrIn = temp;
                        ++i;
                    }
                    --i;
                    index = 4;
                    if(i != list.size() && (statusIntIn == 200 || statusIntIn == 300)) {
                        while (index != list.get(i).length()) {
                            finish.append(list.get(i).charAt(index));
                            ++index;
                        }
                    }
                    out.println(start.toString() + ";" + finish.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy.unavailable("source2.log", "target.csv");
    }
}
