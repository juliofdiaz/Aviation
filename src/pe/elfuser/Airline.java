package pe.elfuser;

/**
 *
 * This class holds the information about an airport
 * @author juliofdiaz
 * @version 0.1
 *
 */
public class Airline {
    private String name;
    private String icao;
    private String iata;
    private String country;

    public Airline(String line){
        String[] info = line.split(",");
        this.setName(info[0]);
        this.setIcao(info[1]);
        this.setIata(info[2]);
        this.setCountry(info[3]);
    }

    public Airline(){
        this.name="N/A";
        this.icao="N/A";
        this.iata="N/A";
        this.country="N/A";
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){
        return "[name:"+this.name+", icao:"+this.icao+
                ", iata:"+this.iata+", country:"+this.country+
                "]";
    }
}
