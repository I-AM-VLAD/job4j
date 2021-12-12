package ru.job4j.chapter_006.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    @Test
    public void when2Periods() throws IOException {
        File source = new File("source1.log");
        File target = folder.newFile("target.csv");
        Analizy.unavailable(source.getPath(), target.getPath());
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(
                result.get(0) + result.get(1),
                is("10:57:01;10:59:01" + "11:01:02;11:02:02")
        );
    }
    @Test
    public void whenNotEnd() throws IOException {
        File source = new File("source2.log");
        File target = folder.newFile("target.csv");
        Analizy.unavailable(source.getPath(), target.getPath());
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(
                result.get(0),
                is("10:57:01;")
        );
    }
}

