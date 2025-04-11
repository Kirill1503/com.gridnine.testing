package scr;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FlightFilterTest {
    @Test
    void testFlightsFilterWhenDepBeforeNow() {
        FlightsFilter filter = new FlightsFilterWhenDepBeforeNow();

        List<Flight> flights = FlightBuilder.createFlights();

        List<Flight> filteredFlights = filter.filter(flights);

        assertEquals(1, filteredFlights.size());

        Flight testFlight = filteredFlights.getFirst();

        assertTrue(testFlight.getSegments().getFirst().getDepartureDate().isBefore(LocalDateTime.now()));
    }

    @Test
    void testFlightsFilterWhenDateArrBeforeDateDep() {
        FlightsFilter filter = new FlightsFilterWhenDateArrBeforeDateDep();

        List<Flight> flights = FlightBuilder.createFlights();

        List<Flight> filteredFlights = filter.filter(flights);

        assertEquals(1, filteredFlights.size());

        Flight testFlight = filteredFlights.getFirst();

        assertTrue(testFlight.getSegments().getFirst().getArrivalDate().isBefore(testFlight.getSegments().getFirst().getDepartureDate()));
    }

    @Test
    void testFlightsFilterWhenALotOfTimeOnEarth() {
        FlightsFilter filter = new FlightsFilterWhenALotOfTimeOnEarth();

        List<Flight> flights = FlightBuilder.createFlights();

        List<Flight> filteredFlights = filter.filter(flights);

        assertEquals(2, filteredFlights.size());

        Flight testFlight = filteredFlights.getFirst();

        assertTrue(filteredFlights.getFirst().getSegments().size() > 1);
        assertFalse(filteredFlights.getFirst().getSegments().isEmpty());
    }
}
