import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParseStation {

    public static List<Station> parseStation() {

        String WHOLE_DOC = ParseWholeDoc.parseFile("data/code.html");
        Document listStations = Jsoup.parse(WHOLE_DOC);

        ArrayList<Station> stations = new ArrayList<>();

        Elements allStationsOnLine = listStations.select("div.js-metro-stations");

        for (Element line : allStationsOnLine) {
            for (Element element : line.select("span.name")) {
                String number = line.attr("data-line");
                String name = element.text();
                String date = "n/a";
                double depth = 0.0;
                boolean hasConnection = element.siblingElements().hasAttr("title");
                stations.add(new Station(number, name, date, depth, hasConnection));
            }
        }
        return stations;
    }

    public static List<Station> parseAllDepths() {
        List<Station> allStations = new ArrayList<>();
        allStations.addAll(LocalParse.parseDepth("data\\linesFolder\\data\\2\\4\\depths-1.json"));
        allStations.addAll(LocalParse.parseDepth("data\\linesFolder\\data\\4\\6\\depths-3.json"));
        allStations.addAll(LocalParse.parseDepth("data\\linesFolder\\data\\7\\1\\depths-2.json"));
        return allStations;
    }

    public static List<Station> parseAllDates() {
        List<Station> allStations = new ArrayList<>();
        allStations.addAll(LocalParse.parseCSV("data\\linesFolder\\data\\0\\5\\dates-2.csv"));
        allStations.addAll(LocalParse.parseCSV("data\\linesFolder\\data\\4\\6\\dates-1.csv"));
        allStations.addAll(LocalParse.parseCSV("data\\linesFolder\\data\\9\\6\\dates-3.csv"));
        return allStations;
    }

    public static List<Station> formatStations(List<Station> stationList) {

        HashMap<String, Station> hashStations = createHashMap(stationList);
        HashMap<String, Station> hashDepths = createHashMap(parseAllDepths());
        HashMap<String, Station> hashDates = createHashMap(parseAllDates());

        for (Station station : stationList) {
            if (hashDates.get(station.getName()) != null) {
                station.setDate(hashDates.get(station.getName()).getDate());
            }
        }

        for (Station station : stationList) {
            if (hashDepths.get(station.getName()) != null) {
                station.setDepth(hashDepths.get(station.getName()).getDepth());
            }
        }
        return stationList;
    }

    public static HashMap<String, Station> createHashMap(List<Station> stationList) {
        HashMap<String, Station> hashStations = new HashMap<>();
        for (Station station : stationList) {
            hashStations.put(station.getName(), station);
        }
        return hashStations;
    }


}
