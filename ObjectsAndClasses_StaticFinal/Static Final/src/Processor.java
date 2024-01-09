public class Processor {

    final double frequency;
    final int core;
    final ProceesorManufacturer manufacturer;
    final double weight;

    public Processor(double frequency, int core, ProceesorManufacturer manufacturer, double weight) {
        this.frequency = frequency;
        this.core = core;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCore() {
        return core;
    }

    public ProceesorManufacturer getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Processor: " +
                "frequency = " + frequency +
                ", core = " + core +
                ", manufacturer = " + manufacturer +
                ", weight = " + weight
                ;
    }

    public Processor SetFrequency(double frequency){
        return new Processor(frequency, core, manufacturer, weight);
    }

    public Processor SetCore(int core){
        return new Processor(frequency, core, manufacturer, weight);
    }
    public Processor SetManufacturer(ProceesorManufacturer manufacturer){
        return new Processor(frequency, core, manufacturer, weight);
    }
    public Processor SetWeight(double weight){
        return new Processor(frequency, core, manufacturer, weight);
    }
}
