package pe.elfuser;

/**
 * This class holds information about an airport.
 * @author juliofdiaz
 * @version 0.1
 *
 */
public class Airport {
    private String name;
    private String icao;
    private String iata;
    private String city;
    private String country;
    private String timeZone;

    public Airport(String line){
        String[] info = line.split(",");
        this.setName(info[0]);
        this.setIcao(info[1]);
        this.setIata(info[2]);
        this.setCity(info[3]);
        this.setCountry(info[4]);
        this.setTimeZone(info[5]);
    }

    public Airport(){
        this.name = "N/A";
        this.icao = "N/A";
        this.iata = "N/A";
        this.city = "N/A";
        this.country = "N/A";
        this.timeZone = "America/Lima";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){
        return "[name:"+this.name+", icao:"+this.icao+
                ", iata:"+this.iata+", city"+this.city+
                ", country:"+this.country+ "]";
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
