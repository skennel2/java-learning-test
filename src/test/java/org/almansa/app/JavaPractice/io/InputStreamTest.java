package org.almansa.app.JavaPractice.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class InputStreamTest {

    @Test
    public void likeUsingStatementByCsharp() {
        // AutoCloseable interface
        // java7 new feature

        File file = new File("./tmp.txt");
        try (FileInputStream inputStream = new FileInputStream(file); FileReader reader = new FileReader(file);) {
            // use the inputStream to read a file

        } catch (FileNotFoundException e) {
            // log.error(e);
        } catch (IOException e) {
            // log.error(e);
        }
    }

}
