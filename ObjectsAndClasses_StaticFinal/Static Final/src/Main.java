public class Main {
    public static void main(String[] args) {

        Processor notepadProcessor = new Processor(2.6, 6, ProceesorManufacturer.Intell, 20);
        Ram notepadRam = new Ram(RamType.DDR4, 16384, 5);
        Storage notepadStorage = new Storage(StorageType.SDD, 512, 300);
        Screen notepadScreen = new Screen(19, ScreenType.IPS, 1000);
        Keyboard notepadKeyboard = new Keyboard(KeyboardType.scissor, true, 250);

        Computer notepad = new Computer("Hasee", "NH5x", notepadProcessor, notepadRam, notepadStorage, notepadScreen, notepadKeyboard);
        System.out.print(notepad);
        System.out.println("Total weight: " + notepad.getTotalWeight() + "\n" + "\n" + "\n");


        Processor compProcessor = new Processor(1.3, 2, ProceesorManufacturer.AMD, 25);
        Ram compRam = new Ram(RamType.DDR2, 4096, 10);
        Storage compStorage = new Storage(StorageType.HDD, 256, 450);
        Screen compScreen = new Screen(21, ScreenType.TN, 2500);
        Keyboard compKeyboard = new Keyboard(KeyboardType.membrane, false, 370);

        Computer comp = new Computer("Dell", "Prima", compProcessor, compRam, compStorage, compScreen, compKeyboard);
        System.out.print(comp);
        System.out.println("Total weight: " + comp.getTotalWeight());
    }
}
