package ru.job4j.chapter_006.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.List;
import java.util.ArrayList;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> startList = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(startList::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int index = 0;
        for(String str : startList) {
            StringBuilder keyOfMap = new StringBuilder();
            StringBuilder valueOfMap = new StringBuilder();
            if(str.length() == 0) {
                continue;
            }
            if(str.charAt(0) =='#' && str.charAt(1) == '#') {
                continue;
            }
            while (str.charAt(index) != '=') {
                keyOfMap.append(str.charAt(index));
                ++index;
            }
            ++index;
            while (index != str.length()) {
                valueOfMap.append(str.charAt(index));
                ++index;
                if(index == str.length() - 1) {
                    valueOfMap.append(str.charAt(index));
                    break;
                }
                /*
                if(str.charAt(index) == '/' && str.charAt(index + 1) != '/' && str.charAt(index - 1) != '/') {
                    break;
                }
                 */
            }
            index = 0;
            values.put(keyOfMap.toString(), valueOfMap.toString());
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main (String[] args) {
        Config config = new Config("chapter_002/data/app.properties");
        config.load();
        System.out.println(config.value("hibernate.connection.url"));
    }
}
