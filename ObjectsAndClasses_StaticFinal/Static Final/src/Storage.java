public class Storage {

    final StorageType type; // HDD/SSD
    final int capacity;
    final double weight;

    public Storage(StorageType type, int capacity, double weight) {
        this.type = type;
        this.capacity = capacity;
        this.weight = weight;
    }

    public StorageType getType() {
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
        return "Storage: " +
                "type=" + type +
                ", capacity=" + capacity +
                ", weight=" + weight
                ;
    }

    public Storage SetStorageType(StorageType type){
        return new Storage(type, capacity, weight);
    }

    public Storage SetCapacity(int capacity){
        return new Storage(type, capacity, weight);
    }

    public Storage SetWeight(double weight){
        return new Storage(type, capacity, weight);
    }
}
