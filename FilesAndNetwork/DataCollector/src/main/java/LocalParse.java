import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocalParse {

    public static List<Station> parseDepth(String jsonFile) {
        ArrayList<Station> stations = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(jsonFile);
            JSONArray jsonData = (JSONArray) parser.parse(reader);
            for (Object oneObject : jsonData) {
                JSONObject oneStation = (JSONObject) oneObject;
                String stationName = (String) oneStation.get("station_name");
                //formatting to nice numbers
                String buffer = (String) oneStation.get("depth");
                buffer = buffer.replaceAll("\\?", "0");
                double depth = Double.parseDouble(buffer.replaceAll(",", "."));

                Station station = new Station(stationName, depth);
                stations.add(station);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }


    public static List<Station> parseCSV(String csvFile) {
        ArrayList<Station> stations = new ArrayList<>();
        try {
            List<String> outputCSV = Files.readAllLines(Paths.get(csvFile));
            for (String string : outputCSV) {
                String[] oneStation = string.strip().split(",");
                if (!oneStation[0].equals("name")) {
                    stations.add(new Station(oneStation[0], oneStation[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stations;
    }
}