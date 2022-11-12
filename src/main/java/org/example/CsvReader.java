package org.example;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class CsvReader {
    public Runnable getAverageOpenPrice(String filename) throws IOException {
        return () -> {
            Path path  = Path.of("src","main","resources","JavaAssignment",filename);
            List<String> lines = null;
            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int openIndx = -1;
            List<Double> openPrices = new ArrayList<>();
            for (String line : lines) {
                String[] array = line.split(",");
                if(openIndx == -1) {
                    for(int i = 0;i < array.length;i++) {
                        if(array[i].equals("Open"))
                        {
                            openIndx = i;
                            break;
                        }
                    }
                }
                else{
                    openPrices.add(Double.parseDouble(array[openIndx]));
                }
            }
            DoubleSummaryStatistics dss = openPrices.stream().mapToDouble((a)->a).summaryStatistics();
            System.out.println("Average of "+filename+" is "+dss.getAverage() + " and Calculated by "+Thread.currentThread().getName());

        };
    }
}
