public class Computer {

    private final String vendor;
    private final String name;
    Processor processor;
    Ram ram;
    Storage storage;
    Screen screen;
    Keyboard keyboard;


    public Computer(String vendor, String name, Processor processor, Ram ram, Storage storage, Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public double getTotalWeight() {
        return
        processor.getWeight() +
        ram.getWeight() +
        storage.getWeight() +
        screen.getWeight() +
        keyboard.getWeight();
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Ram getRam() {
        return ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public Screen getScreen() {
        return screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    @Override
    public String toString() {
        return
                "Model: " + vendor + "\n" +
                "Name: " + name + "\n" +
                        processor + "\n" +
                        ram + "\n" +
                        storage + "\n" +
                        screen + "\n" +
                        keyboard + "\n";
    }
}
