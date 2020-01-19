package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String word = "Неизвестное слово. " + eng;
        return word;
    }

    public static void main(String[] args) {
        DummyDic result = new DummyDic();
        String dic = result.engToRus("Vocabulary");
        System.out.println(dic);
    }
}