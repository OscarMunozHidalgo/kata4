package software.ulpgc.kata2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

public class CsvFileWaterLoader implements WaterLoader{
    private File file;

    public CsvFileWaterLoader(File file) {
        this.file = file;
    }


    @Override
    public List<Water> load() {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            return load(reader);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private List<Water> load(BufferedReader reader) throws IOException{
        return reader.lines().skip(1).map(this::toWater).collect(toList());
    }

    private Water toWater(String line) {
        return toWater(line.split(","));
    }

    private Water toWater(String[] line) {
        return new Water(
                parseFloat(nullToZero(line[0])),
                parseFloat(nullToZero(line[1])),
                parseFloat(nullToZero(line[2])),
                parseInt(nullToZero(line[line.length-1]))
        );
    }

    private String nullToZero(String word) {
        if(word.isEmpty()) return "0"; else return word;
    }
}
