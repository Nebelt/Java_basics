import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesFinder {
    public static ArrayList<String> paths = new ArrayList<>();


    public static List<String> findFiles(String path) {
        File folder = new File(path);
        if (!folder.exists()) System.out.println("something wrong with path");
        return openFolder(folder.listFiles());
    }

    public static ArrayList<String> openFolder(File[] folder) {
        for (File file : folder) {
            if (file.isFile()) {
                paths.add(file.getPath());
            } else if (file.isDirectory()) {
                openFolder(file.listFiles());
            } else {
                System.out.println("Something wrong");
            }
        }
        return paths;
    }

}

