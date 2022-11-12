package org.example;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        CsvReader reader = new CsvReader();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        File dir = new File("src/main/resources/JavaAssignment");
        File[] files = dir.listFiles();
        for(File file:files){
            executor.execute(reader.getAverageOpenPrice(file.getName()));
        }
        executor.shutdown();
    }
}
