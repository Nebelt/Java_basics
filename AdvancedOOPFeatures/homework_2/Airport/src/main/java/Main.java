import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> voyage;
        long now = System.currentTimeMillis();
        long hourInMillis = 1000 * 60 * 60;

        voyage =
                airport
                        .getTerminals()
                        .stream()
                        .flatMap(f -> f.getFlights().stream())
                        .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                        .filter(f -> f.getDate().getTime() < (now + (2 * hourInMillis)))
                        .filter(f -> f.getDate().getTime() > (now))
                        .collect(Collectors.toList());
        System.out.println(voyage);
        return voyage;
    }

}