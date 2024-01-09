import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class RouteCalculatorTest extends TestCase {

    List<Station> stationsRoute;

    StationIndex stationIndex = new StationIndex();

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //Создание Линий
        Line line1 = new Line(1, "Кировско-Выборгская");
        Line line3 = new Line(3, "Невско-Василеостровская");
        Line line4 = new Line(4, "Правобережная");


        //Создание станций
        List<Station> stationList = new ArrayList<>();
        stationList.add(new Station("Пролетарская", line3));            //0
        stationList.add(new Station("Ломоносовская", line3));           //1
        stationList.add(new Station("Елизаровская", line3));            //2
        stationList.add(new Station("пл. Ал. Невского I", line3));      //3
        stationList.add(new Station("пл. Ал. Невского II", line4));     //4
        stationList.add(new Station("Лиговский проспект", line4));      //5
        stationList.add(new Station("Достоевская", line4));             //6
        stationList.add(new Station("Владимировская", line1));          //7
        stationList.add(new Station("пл. Восстания", line1));           //8
        stationList.add(new Station("Чернышевская", line1));            //9

        for (Station station : stationList) {
            stationIndex.addStation(station);
        }

        stationIndex.addLine(line1);
        stationIndex.addLine(line3);
        stationIndex.addLine(line4);

        //Все станции сажаем на лайны
        for (int i = 0; i < stationList.size() - 1; i++) {
            Station currentStation = stationList.get(i);
            if (currentStation.getLine() == line1) {
                line1.addStation(currentStation);
            } else if (currentStation.getLine() == line3) {
                line3.addStation(currentStation);
            } else if (currentStation.getLine() == line4) {
                line4.addStation(currentStation);
            }

        }

        //Создание маршрута
        stationsRoute = new ArrayList<>(stationList);

        //Создание коннектов
        ArrayList<Station> connections1 = new ArrayList<>();
        ArrayList<Station> connections2 = new ArrayList<>();

        connections1.add(stationList.get(4));
        connections1.add(stationList.get(3));

        connections2.add(stationList.get(6));
        connections2.add(stationList.get(7));

        stationIndex.addConnection(connections1);
        stationIndex.addConnection(connections2);


    }

    public void testCalculateDuration() {
        List<Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Пролетарская"));
        route.add(stationIndex.getStation("Ломоносовская"));
        route.add(stationIndex.getStation("Елизаровская"));
        route.add(stationIndex.getStation("Пл. Ал. Невского I"));
        route.add(stationIndex.getStation("Лиговский проспект"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = stationIndex.getStation("Ломоносовская");
        Station to = stationIndex.getStation("Достоевская");

        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Ломоносовская"));
        expected.add(stationIndex.getStation("Елизаровская"));
        expected.add(stationIndex.getStation("Пл. Ал. Невского I"));
        expected.add(stationIndex.getStation("Пл. Ал. Невского II"));
        expected.add(stationIndex.getStation("Лиговский проспект"));
        expected.add(stationIndex.getStation("Достоевская"));

        assertEquals(expected, routeCalculator.getShortestRoute(from, to));
    }

    public void testGetRouteOnTheLine() {
        List<Station> test1 = new ArrayList<>();
        List<Station> test2 = new ArrayList<>();


        test1.add(stationsRoute.get(2));
        test1.add(stationsRoute.get(3));
        test1.add(stationsRoute.get(4));
        Station from1 = test1.get(0);
        Station to1 = test1.get(test1.size() - 1);

        test1 = RouteCalculator.getRouteOnTheLine(from1, to1);
        assertNull(test1);

        test2.add(stationsRoute.get(0));
        test2.add(stationsRoute.get(1));
        test2.add(stationsRoute.get(2));
        List<Station> expected = new ArrayList<>(test2);
        Station from2 = test2.get(0);
        Station to2 = test2.get(test2.size() - 1);
        test2 = RouteCalculator.getRouteOnTheLine(from2, to2);
        assertEquals(expected, test2);
    }

    public void testGetRouteWithOneConnection() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        List<Station> actual = new ArrayList<>();
        actual.add(stationsRoute.get(2));
        actual.add(stationsRoute.get(3));
        actual.add(stationsRoute.get(4));
        actual.add(stationsRoute.get(5));
        List<Station> expected = new ArrayList<>(actual);

        Station from = stationIndex.getStation("Елизаровская");
        Station to = stationIndex.getStation("Лиговский проспект");

        assertEquals(expected, routeCalculator.getShortestRoute(from, to));

    }

    public void testGetRouteWithTwoConnections() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        List<Station> test1 = new ArrayList<>();


        test1.addAll(stationsRoute);
        Station from = stationIndex.getStation("Пролетарская");
        Station to = stationIndex.getStation("Чернышевская");
        List<Station> expected = new ArrayList<>(test1);
        assertEquals(expected, routeCalculator.getShortestRoute(from, to));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
