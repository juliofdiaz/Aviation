package pe.elfuser;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * This class holds information about a commercial route
 * @author juliofdiaz
 * @version 0.1
 *
 */
public class Route {
    private Integer number;
    private String carrier;
    private String origin;
    private String destination;
    private LocalTime takeOff;
    private LocalTime landing;
    private LocalTime duration;
    private Integer arrivalOffset;
    private ArrayList<DayOfWeek> days;

    public Route(String line){
        String[] info = line.split(",");
        this.setNumber(Integer.parseInt(info[0]));
        this.setCarrier( info[1] );
        this.setOrigin( info[2] );
        this.setDestination( info[3] );
        this.setTakeOff( getLocalTime(info[4]));
        this.setLanding( getLocalTime(info[5]) );
        this.setDuration( getLocalTime(info[6]));
        this.setArrivalOffset( Integer.parseInt(info[7]) );
        this.setDays( getDaysOfWeek(info[8]) );
    }

    /**
     * This method tests if the current route is on the air according to when
     * the flight took off and the duration of the route.
     *
     * @param outTimeZone A String containing the time zone of the departure
     *                    city. The String has to meet java time zone
     *                    standards.
     * @return True if the flight is on the air.
     *
     */
    public Boolean isOnAir( String outTimeZone ){
        ZoneId outZone = ZoneId.of(outTimeZone);

        if( this.days.contains(LocalDate.now(outZone).getDayOfWeek()) ){
            if( LocalTime.now(outZone).isAfter(this.takeOff) ) {
                Long timeLapsed = ChronoUnit.MINUTES.between(this.takeOff,LocalTime.now(outZone));
                Long duration = ChronoUnit.MINUTES.between(LocalTime.of(0,0),this.duration);
                if(timeLapsed<duration){
                    return true;
                }
            }
        }
        return false;
        //if the flight left yesterday has yesterdays landed
    }

    /**
     * This method takes a String representing days of the week and returns a
     * list of DaysOfWeek.
     *
     * @param days A String including numbers from 1 to 7 where each number
     *             corresponds to a day of the week (Monday=1, Tuesday=2,
     *             Wednesday=3, Thursday=4, Friday=5, Saturday=6 and Sunday=7).
     * @return A List of containing the DayOfWeek items represented in days.
     *
     */
    private static ArrayList<DayOfWeek> getDaysOfWeek(String days){
        ArrayList<DayOfWeek> result = new ArrayList<>();
        for(int i=0; i<days.length(); i++){
            result.add(DayOfWeek.of(Character.getNumericValue(days.charAt(i))));
        }
        return result;
    }

    /**
     * This method evaluates a String representing a time including hour and minutes
     * and it returns a LocalTime object with that information.
     *
     * @param simpleTime A String made up of 4 integers where the first two
     *                   represent hours and the last two represent minutes. When
     *                   representing hour of day, the 24h system should be used.
     * @return A LocalTime time object set to the time specified in a String.
     */
    private static LocalTime getLocalTime(String simpleTime){
        Integer hour = Integer.parseInt(simpleTime.substring(0,2));
        Integer minute = Integer.parseInt(simpleTime.substring(2,4));
        return LocalTime.of(hour,minute);
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(LocalTime takeOff) {
        this.takeOff = takeOff;
    }

    public LocalTime getLanding() {
        return landing;
    }

    public void setLanding(LocalTime landing) {
        this.landing = landing;
    }

    public ArrayList<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(ArrayList<DayOfWeek> days) {
        this.days = days;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getArrivalOffset() {
        return arrivalOffset;
    }

    public void setArrivalOffset(Integer arrivalOffset) {
        this.arrivalOffset = arrivalOffset;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public LocalTime getDuration() {
        return duration;
    }
}
