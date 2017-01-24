import pe.elfuser.*;

import java.io.FileNotFoundException;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by Purnima on 1/12/17.
 *
 */
public class Sandbox {
    public static void main(String[] args) throws FileNotFoundException {
/*        String AIRLINE_FILE = "/Users/juliofdiaz/Documents/airlines.tsv";
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
            ZoneId inZone = ZoneId.of(in.getTimeZone());

            if(route.getDays().contains(LocalDate.now(outZone).getDayOfWeek())){
                if( LocalTime.now(outZone).isAfter(route.getTakeOff()) ) {
                    Long timeLapsed = ChronoUnit.MINUTES.between(route.getTakeOff(),LocalTime.now(outZone));
                    Long duration = ChronoUnit.MINUTES.between(LocalTime.of(0,0),route.getDuration());
                    if(timeLapsed<duration){
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
            //if the flight leaves today, has todays flight taken off
            //if the flight leaft yesterdayhas yesterdays landed


        }*/


    }

/*    private static String graphProgress(Long lapsed, long duration){
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

    private static Airline getAirline(String carrier, AirlineList airlines){
        if(airlines.contains(carrier)){
            return airlines.get(carrier);
        }else {
            //some error
            return null;
        }
    }

    private static Airport getAirport(String location, AirportList airports){
        if(airports.contains(location)){
            return airports.get(location);
        }else {
            //some error
            return null;
        }
    }*/

}
