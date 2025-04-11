package scr;

import java.util.List;

public interface FlightsFilter {
    List<Flight> filter(List<Flight> flights);
}
