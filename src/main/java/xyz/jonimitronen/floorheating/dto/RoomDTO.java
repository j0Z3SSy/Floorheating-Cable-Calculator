// RoomDTO.java
// Tämä luokka edustaa huonetta, jossa lattiakaapeli asennetaan. 
// Tämä luokka toimii tiedonsiirtomallina (Data Transfer Object). Se on tarkoitettu erityisesti API-vastauksille ja pyynnöille.
package xyz.jonimitronen.floorheating.dto;

import org.springframework.stereotype.Component;

@Component
public class RoomDTO {

    // Attribuutit.
    private double pituus;
    private double leveys;
    private double pinta_ala;
    private double kylmä_pinta_ala;

    // Getterit ja Setterit.
    public double getPituus() {
        return pituus;
    }

    public void setPituus(double pituus) {
        this.pituus = pituus;
        // Päivitetään pinta-ala.
        päivitäPintaAla();
    }

    public double getLeveys() {
        return leveys;
    }

    public void setLeveys(double leveys) {
        this.leveys = leveys;
        // Päivitetään pinta-ala.
        päivitäPintaAla();
    }

    // Ei setteriä, koska pinta-ala lasketaan aina automaattisesti.
    public double getPinta_ala() {
        return pinta_ala;
    }

    public double getKylmä_pinta_ala() {
        return kylmä_pinta_ala;
    }

    public void setKylmä_pinta_ala(double kylmä_pinta_ala) {
        this.kylmä_pinta_ala = kylmä_pinta_ala;
    }

    // Ei setteriä, koska lämmin pinta-ala lasketaan aina automaattisesti.
    public double getLämmin_pinta_ala() {
        return this.pinta_ala - this.kylmä_pinta_ala;
    }

    // Konstructorit.
    public RoomDTO() {
    }

    public RoomDTO(double pituus, double leveys) {
        this.pituus = pituus;
        this.leveys = leveys;
        this.kylmä_pinta_ala = 0;
        päivitäPintaAla();
    }

    // Muut metodit.
    // Metodi pinta-alan päivittämiseksi.
    private void päivitäPintaAla() {
        this.pinta_ala = this.pituus * this.leveys;
    }

    // Metodi, jolla lisätään uusi kylmä pinta-ala kokonais könttään.
    public void lisääKylmää(double kylmäPituus, double kylmäLeveys) {
        kylmä_pinta_ala = kylmä_pinta_ala + (kylmäPituus * kylmäLeveys);
    }

    // Metodi jolla kysytään ja lasketaan kaikki kylmät alueet.
    public void laskeKylmäPintaAla(int onSeinat, int onWc, int onLattiakaivo,
            Double kylmaPituus,
            Double kylmaLeveys) {
        // Kysytään, onko tilassa seinät.
        if (onSeinat == 1) {
            lisääKylmää(0.10, 0.10);
            System.out.println("Seinien alue lisätty.");
        }

        // Kysytään, tuleeko tilaan wc pönttö.
        if (onWc == 1) {
            lisääKylmää(0.45, 0.45);
            System.out.println("Wc pöntön alue lisätty.");
        }

        // Kysytään, tuleeko tilaan lattiakaivo.
        if (onLattiakaivo == 1) {
            lisääKylmää(0.10, 0.10);
            System.out.println("Lattiakaivon alue lisätty.");
        }

        // Kysytään, onko tilassa alueita, joita ei saa tai haluta lämmittää.
        if (kylmaPituus != 0 && kylmaLeveys != 0) {
            lisääKylmää(kylmaPituus, kylmaLeveys);
            System.out.println("Kylmä alue lisätty.");
        }
    }

    // Tulostetaan huoneen tiedot.
    @Override
    public String toString() {
        return "\nHUONEEN TIEDOT:\n" +
                "- Huoneen pituus (m) = " + pituus + "\n" +
                "- Huoneen leveys (m) = " + leveys + "\n" +
                "- Pinta-ala (m²) = " + pinta_ala + "\n" +
                "- Kylmä pinta-ala (m²) = " + kylmä_pinta_ala + "\n" +
                "- Lämmitetty pinta-ala (m²) = " + getLämmin_pinta_ala() + "\n";
    }

}
