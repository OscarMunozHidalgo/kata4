package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardnessHistogramCalculator implements HistogramCalculator{

    private final List<Water> reservoir;
    private final int range;

    public HardnessHistogramCalculator(List<Water> reservoir, int range) {
        this.reservoir = reservoir;
        this.range = range;
    }


    @Override
    public Map<String, Integer> calculate() {
        Map<String,Integer> result = new HashMap<>();
        for(Water water:reservoir){
            String key = toRange(water.getHardness());
            result.put(key, result.getOrDefault(key, 0)+1);
        }
        return result;
    }

    private String toRange(float hardness) {
        return lowLimit(hardness) + "-" + highLimit(hardness);
    }

    private String highLimit(float hardness) {
        return Integer.toString((int) hardness/range*range + range);
    }

    private String lowLimit(float hardness) {
        return Integer.toString((int) hardness/range*range);
    }


}
