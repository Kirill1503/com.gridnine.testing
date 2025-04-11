package scr;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsFilterWhenDepBeforeNow implements FlightsFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                // We filter flights according to the requirements
                .filter(flight -> !flight.getSegments().isEmpty())
                .filter(flight -> flight.getSegments().getFirst().getDepartureDate().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}
