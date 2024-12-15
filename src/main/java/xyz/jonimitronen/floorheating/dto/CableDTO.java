// CableDTO.java
// Tämä luokka edustaa kaapelia ja sisältää sen attribuutit sekä metodit kaapelin tietojen hallintaan.
// Tämä luokka toimii tiedonsiirtomallina (Data Transfer Object). Se on tarkoitettu erityisesti API-vastauksille ja pyynnöille.
// DTO voi sisältää attribuutteja, joita ei ole CableEntity-luokassa, ja se on suunniteltu helpottamaan tiedon siirtämistä käyttäjän ja sovelluksen välillä.
// Se toimii myös ikään kuin "raamina" datan esittämiseen API-vastauksissa.
package xyz.jonimitronen.floorheating.dto;

import org.springframework.stereotype.Component;

@Component
public class CableDTO {
    // Attribuutit.
    private int id;
    private String tyyppi;
    private int sähkönumero;
    private double pituus;
    private double teho;
    private double vastus_per_metri;
    private int vastus_toleranssi;
    private int halkaisija;

    // Getterit ja Setterit.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public int getSähkönumero() {
        return sähkönumero;
    }

    public void setSähkönumero(int sähkönumero) {
        this.sähkönumero = sähkönumero;
    }

    public double getPituus() {
        return pituus;
    }

    public void setPituus(double pituus) {
        this.pituus = pituus;
    }

    public double getTeho() {
        return teho;
    }

    public void setTeho(double teho) {
        this.teho = teho;
    }

    public double getVastus_per_metri() {
        return vastus_per_metri;
    }

    public void setVastus_per_metri(double vastus_per_metri) {
        this.vastus_per_metri = vastus_per_metri;
    }

    public int getVastus_toleranssi() {
        return vastus_toleranssi;
    }

    public void setVastus_toleranssi(int vastus_toleranssi) {
        this.vastus_toleranssi = vastus_toleranssi;
    }

    public int getHalkaisija() {
        return halkaisija;
    }

    public void setHalkaisija(int halkaisija) {
        this.halkaisija = halkaisija;
    }

    // Konstructorit.
    public CableDTO() {
    }

    public CableDTO(int id, String tyyppi, int sähkönumero, double pituus, double teho, double vastus_per_metri,
            int vastus_toleranssi, int halkaisija) {
        this.id = id;
        this.tyyppi = tyyppi;
        this.sähkönumero = sähkönumero;
        this.pituus = pituus;
        this.teho = teho;
        this.vastus_per_metri = vastus_per_metri;
        this.vastus_toleranssi = vastus_toleranssi;
        this.halkaisija = halkaisija;
    }

    // Muut metodit.
    // Tulostetaan kaapelin tiedot.
    @Override
    public String toString() {
        return "\nKAAPELIN TIEDOT:\n" +
                "- ID = " + id + "\n" +
                "- Sähkönumero = " + sähkönumero + "\n" +
                "- Tyyppi (PST xx m/W) = " + tyyppi + " " + pituus + "/" + teho + "\n" +
                "- Pituus (m) = " + pituus + "\n" +
                "- Vastus (Ohmi/m) = " + vastus_per_metri + "\n" +
                "- Vastustoleranssi (Ohmi) = " + vastus_toleranssi + "\n" +
                "- Halkaisija (mm) = " + halkaisija + "\n";
    }

}
