package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVUtil {
    public static List<String> readCSV(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.collect(Collectors.toList());
        }
    }
    public static void writeCSV(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }
}
