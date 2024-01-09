public class Main {


    public static void main(String[] args) throws Exception {

        System.out.println(FilesFinder.findFiles("data/linesFolder"));

        JsonFile.writeJsonStations(ParseStation.formatStations(ParseStation.parseStation()), "export//stations.json");
        JsonFile.writeJsonLines(ParseLine.parseLine(), "export//lines.json");

    }
}
