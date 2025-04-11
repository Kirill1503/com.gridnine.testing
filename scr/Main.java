package scr;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightsFilter filter1 = new FlightsFilterWhenDepBeforeNow();
        FlightsFilter filter2 = new FlightsFilterWhenDateArrBeforeDateDep();
        FlightsFilter filter3 = new FlightsFilterWhenALotOfTimeOnEarth();

        List<Flight> result1 = filter1.filter(flights);
        List<Flight> result2 = filter2.filter(flights);
        List<Flight> result3 = filter3.filter(flights);

        System.out.printf("All flights which have departure before now time %s\n", result1);
        System.out.printf("All flights which have arrival date before departure date %s\n", result2);
        System.out.printf("All flights which have time on earth more than 2 hours %s", result3);
    }
}
