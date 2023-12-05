package software.ulpgc.kata4;

import software.ulpgc.kata2.*;

import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:kata4.db");
        List<Water> data = new SqliteWaterLoader(connection).load();
        Map<String,Integer> hist = new HardnessHistogramCalculator(data,50).calculate();
        for(String key: hist.keySet().stream().sorted().toList()) {
            System.out.println(key + " " + hist.get(key));
        }
    }

}
