package Demo.utility;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class fileUtil {

    public static List<Map<String, String>> readCSV(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext(); // Read headers
            String[] row;

            while ((row = reader.readNext()) != null) {
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    rowMap.put(headers[i].trim(), row[i].trim());
                }
                data.add(rowMap);
            }

        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }
}
