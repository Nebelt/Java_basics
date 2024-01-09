public class Screen {

    final int size; // diagonal
    final ScreenType type; // IPS, TN, VA
    final double weight;

    public static final String TYPE_IPS = "IPS";
    public static final String TYPE_TN = "TN";
    public static final String TYPE_VA = "VA";



    public Screen(int size, ScreenType type, double weight) {
        this.size = size;
        this.type = type;
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public ScreenType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Screen: " +
                "size=" + size +
                ", type=" + type +
                ", weight=" + weight
                ;
    }


    public Screen SetSize(int size){
        return new Screen(size, type, weight);
    }

    public Screen SetType(ScreenType type){
        return new Screen(size, type, weight);
    }
    public Screen SetWeight(double weight){
        return new Screen(size, type, weight);
    }
}
