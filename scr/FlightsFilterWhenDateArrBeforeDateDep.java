package scr;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsFilterWhenDateArrBeforeDateDep implements FlightsFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                // We filter flights according to the requirements
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
