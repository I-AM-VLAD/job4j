package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        int difference = word.length - post.length;
        for (int i = 0; i < post.length; i++) {
            if (post[i] != word[difference])
                result = false;
            ++difference;
        }
        return result;
    }
}
