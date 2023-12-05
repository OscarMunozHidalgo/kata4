package software.ulpgc.kata4;

import software.ulpgc.kata2.Water;
import software.ulpgc.kata2.WaterLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqliteWaterLoader implements WaterLoader {
    private final Connection connection;

    public SqliteWaterLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Water> load() {
        try{
            return load(queryAll());
        }catch (SQLException e){
            return new ArrayList<>();
        }
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(
                "SELECT * from reservoir;");
    }

    public List<Water> load(ResultSet resultSet) throws SQLException {
        List<Water> reservoir = new ArrayList<>();
        while (resultSet.next()){
            reservoir.add(waterFrom(resultSet));
        }
        return reservoir;
    }

    private Water waterFrom(ResultSet resultSet) throws SQLException {
        return new Water(resultSet.getFloat("ph"),
                resultSet.getFloat("Hardness"),
                resultSet.getFloat("Solids"),
                resultSet.getInt("Potability"));
    }
}
