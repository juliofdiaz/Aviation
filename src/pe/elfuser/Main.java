package pe.elfuser;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * This main interface.
 *
 * @author juliofdiaz
 * @version 0.1b
 *
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Aviation 0.1");

        String AIRLINE_FILE = "/Users/juliofdiaz/Documents/airlines.tsv";
        String AIRPORT_FILE = "/Users/juliofdiaz/Documents/airports.tsv";
        String ROUTE_FILE = "/Users/juliofdiaz/Documents/routes.tsv";

        AirlineList airlines = new AirlineList(AIRLINE_FILE);
        AirportList airports = new AirportList(AIRPORT_FILE);
        RouteList routes = new RouteList(ROUTE_FILE);


        for(Route route : routes.getRoutes()){
            Airline airline = getAirline(route.getCarrier(),airlines);
            Airport out = getAirport(route.getOrigin(),airports);
            Airport in = getAirport(route.getDestination(),airports);

            ZoneId outZone = ZoneId.of(out.getTimeZone());

            Long timeLapsed;
            if(route.getArrivalOffset()==0){
                timeLapsed = ChronoUnit.MINUTES.between(route.getTakeOff(),LocalTime.now(outZone));
            }else{
                timeLapsed = ChronoUnit.MINUTES.between(route.getTakeOff(),LocalTime.now(outZone))+1440;
            }
            Long duration = ChronoUnit.MINUTES.between(LocalTime.of(0,0),route.getDuration());
            if(route.isOnAir(out.getTimeZone())){
                System.out.println( airline.getName() );
                System.out.print( airline.getIata()+" "+route.getNumber() );
                System.out.print( "\t"+out.getCity()+"("+out.getIata() );
                System.out.println( ") - "+in.getCity()+"("+in.getIata()+")" );
                System.out.println( route.getTakeOff()+" "+graphProgress(timeLapsed,duration)+
                        " "+route.getLanding() );
                System.out.println( );
            }


        }

    }

    /**
     * This method represents the progress of the flight since it took-off
     * in a simple String.
     *
     * @param lapsed The time lapsed since the flight left.
     * @param duration The duration of the flight.
     * @return A String representing the progress of the flight.
     */
    private static String graphProgress(Long lapsed, long duration){
        Double progressDouble = ((lapsed+0.0)/(duration+0.0)*20)+0.5;
        Integer progressInteger = progressDouble.intValue();

        String result = "";
        for(int i=0;i<20;i++){
            if(i==progressInteger-1) {
                result = result + "*";
            }else{
                result = result + "-";
            }
        }
        return result;
    }

    /**
     * This method retrieves information about an airline based on its iata
     * code and it returns an Airline object with that information.
     *
     * @param carrier The iata code of the airline.
     * @param airlines The list of all airlines in the database.
     * @return An Airline object corresponding to the iata code.
     */
    private static Airline getAirline(String carrier, AirlineList airlines){
        if(airlines.contains(carrier)){
            return airlines.get(carrier);
        }else {
            //some error
            return new Airline();
        }
    }

    /**
     * This method retrieves information about an airport based on its iata
     * code and it returns an Airport object with that information.
     *
     * @param location The iata code of the airport.
     * @param airports The list of all airport in the database.
     * @return An Aiport object corresponding to the iata code.
     */
    private static Airport getAirport(String location, AirportList airports){
        if(airports.contains(location)){
            return airports.get(location);
        }else {
            //some error
            return new Airport();
        }
    }
}
