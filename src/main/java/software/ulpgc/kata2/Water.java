package software.ulpgc.kata2;

public class Water {
    private float ph;
    private float hardness;
    private float solids;
    private int potability;

    public Water(float ph, float hardness, float solids, int potability) {
        this.ph = ph;
        this.hardness = hardness;
        this.solids = solids;
        this.potability = potability;
    }

    public float getPh() {
        return ph;
    }

    public float getHardness() {
        return hardness;
    }

    public float getSolids() {
        return solids;
    }

    public int getPotability() {
        return potability;
    }
}
