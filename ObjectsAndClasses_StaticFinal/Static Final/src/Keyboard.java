public class Keyboard {

    final KeyboardType type; // IPS, TN, VA
    final boolean light;
    final double weight;

    public Keyboard(KeyboardType type, boolean light, double weight) {
        this.type = type;
        this.light = light;
        this.weight = weight;
    }

    public KeyboardType getType() {
        return type;
    }

    public boolean isLight() {
        return light;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Keyboard: " +
                "type=" + type +
                ", light=" + light +
                ", weight=" + weight;
    }


     public Keyboard SetType(KeyboardType type){
        return new Keyboard(type, light, weight);
    }

    public Keyboard SetLight(boolean light){
        return new Keyboard(type, light, weight);
    }

    public Keyboard SetWeight(double weight){
        return new Keyboard(type, light, weight);
    }
}
