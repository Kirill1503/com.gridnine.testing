package scr;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FlightsFilterWhenALotOfTimeOnEarth implements FlightsFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().size() > 1)
                .filter(flight -> filterSegments(flight) > 120)
                .toList();
    }

    private static Long filterSegments(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long time = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            // We filter flights according to the requirements
            LocalDateTime localDateTimeArr = segments.get(i).getArrivalDate();
            LocalDateTime localDateTimeDep = segments.get(i + 1).getDepartureDate();
            time += ChronoUnit.MINUTES.between(localDateTimeArr, localDateTimeDep);
        }
        return time;
    }
}
