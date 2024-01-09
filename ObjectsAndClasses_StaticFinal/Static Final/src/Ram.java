public class Ram {

    final RamType type; // DDR
    final int capacity;
    final double weight;

    public Ram(RamType type, int capacity, double weight) {
        this.type = type;
        this.capacity = capacity;
        this.weight = weight;
    }

    public RamType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Ram: " +
                "type=" + type +
                ", capacity=" + capacity +
                ", weight=" + weight;
    }

    public Ram SetRamType(RamType type){
        return new Ram(type, capacity, weight);
    }

    public Ram SetCapacity(int capacity){
        return new Ram(type, capacity, weight);
    }

    public Ram SetWeight(double weight){
        return new Ram(type, capacity, weight);
    }

}
