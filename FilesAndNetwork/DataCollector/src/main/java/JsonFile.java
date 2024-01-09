import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonFile {

    public static String getJsonFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> jsonLines = Files.readAllLines(Paths.get(path));
            for (String line : jsonLines) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static void deleteOldFiles(String path) {
        try {
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //не получается перегрузить

    public static void writeJsonStations(List<Station> objects, String path) throws Exception {
        deleteOldFiles(path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), objects);
    }

    public static void writeJsonLines(List<Line> objects, String path) throws IOException {
        deleteOldFiles(path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), objects);
    }

}
