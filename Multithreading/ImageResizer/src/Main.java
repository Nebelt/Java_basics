import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "D:\\Хи (не сихрон)\\Фотки\\Ланос";
        String dstFolder = "C:\\Users\\Nebelt\\Desktop\\readyPhoto";

        long start = System.currentTimeMillis();
        int fileNumber = 0;
        int newWidth = 300;
        int cores = getCores();
        File srcDir = new File(srcFolder);
        File[] originalPhotos = srcDir.listFiles();
        assert originalPhotos != null;
        int extraPhotos = originalPhotos.length % cores;

        HashMap<Integer, String> originalMap = new HashMap<>();
        for (int i = 0; i < originalPhotos.length; i++) {
            originalMap.put(i, originalPhotos[i].getPath());
        }

        //firstWave
        HashMap<Integer, String> firstWave = new HashMap<>();
        for (int i = 0; i < cores; i++) {
            for (int j = 0; j < originalMap.size() / cores; j++) {
                firstWave.put(fileNumber, originalMap.get(fileNumber));
                fileNumber++;
            }
            File[] filesForOneCore = new File[firstWave.size()];
            for (int j = 0; j < filesForOneCore.length; j++) {
                filesForOneCore[j] = Paths.get(firstWave.get(j)).toFile();
            }
            new ImageResizer(filesForOneCore, newWidth, dstFolder).start();
        }

        //secondWave
        for (int i = 0; i < extraPhotos; i++) {
            File[] filesForOneCore = {Paths.get(originalMap.get(fileNumber)).toFile()};
            new ImageResizer(filesForOneCore, newWidth, dstFolder).start();
            fileNumber++;
        }


        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }

    public static int getCores() {
        int cores = Runtime.getRuntime().availableProcessors();
        if (cores < 2) {
            System.out.println("Why are we doing this?");
        }
        return cores;
    }

}
