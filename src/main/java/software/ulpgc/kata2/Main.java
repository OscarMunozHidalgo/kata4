package software.ulpgc.kata2;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Water> data = new CsvFileWaterLoader(new File("water_potability.csv")).load();
        Map<String,Integer> hist = new HardnessHistogramCalculator(data,50).calculate();
        for(String key: hist.keySet().stream().sorted().toList()) {
            System.out.println(key + " " + hist.get(key));
        }
    }
}
