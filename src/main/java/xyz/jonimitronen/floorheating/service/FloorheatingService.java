// FloorheatingService.java
// Tämä luokka toimii palvelukerroksena, joka käsittelee liiketoimintalogiikkaa ja sovelluksen toimintojen hallintaa.
// Se kommunikoi CableRepository-luokan kanssa tiedon hakemiseksi. 
// Palvelukerros voi myös tehdä tietojen validointia ja muuntaa DTO- ja entity-objekteja keskenään.
// Tämä luokka on enemmän "utility"-tyyppinen, koska se yhdistää eri komponentteja ja suorittaa monimutkaisempia toimintoja.
package xyz.jonimitronen.floorheating.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.jonimitronen.floorheating.dto.CableDTO;
import xyz.jonimitronen.floorheating.dto.FloorheatingResponseDTO;
import xyz.jonimitronen.floorheating.dto.RoomDTO;
import xyz.jonimitronen.floorheating.entity.CableEntity;
import xyz.jonimitronen.floorheating.repository.CableRepository;
import xyz.jonimitronen.floorheating.utility.MathUtils;

@Component
public class FloorheatingService {

    @Autowired
    private CableRepository cableRepository;

    // Metodi joka hakee tietokannasta kaapelin pituuden ID:n mukaan.
    public CableDTO getCableLengthById(int id) {
        System.out.println("Hakee kaapelin pituuden ID:n mukaan...");
        // Hakee kaapelin, joka vastaa annettua ID:tä.
        Optional<CableEntity> cableEntityOptional = cableRepository.findById(id);
        // Haetaan kaapeliobjekti Optionalista.
        CableEntity cableEntity = cableEntityOptional.get();
        // Luodaan uusi CableDTO-olio, johon tallennetaan kaapelin tiedot.
        CableDTO cableDTO = new CableDTO();
        // Asetetaan kaapelin tiedot DTO-objektiin
        cableDTO.setId(cableEntity.getId());
        cableDTO.setTyyppi(cableEntity.getTyyppi());
        cableDTO.setSähkönumero(cableEntity.getSahkonumero());
        cableDTO.setPituus(cableEntity.getPituus());
        cableDTO.setTeho(cableEntity.getTeho());
        cableDTO.setVastus_per_metri(cableEntity.getVastusPerMetri());
        cableDTO.setVastus_toleranssi(cableEntity.getVastusToleranssi());
        cableDTO.setHalkaisija(cableEntity.getHalkaisija());
        // Palautetaan täytetty CableDTO-objekti
        return cableDTO;
    }

    // Metodi joka hakee tietokannasta kaikki kaapelit.
    public List<CableEntity> getAllCables() {
        System.out.println("Haetaan kaikki kaapelit...");
        // Palautetaan lista kaikista kaapeleista, jotka löytyvät tietokannasta.
        return (List<CableEntity>) cableRepository.findAll();
    }

    // Metodi joka aloittaa soveltuvimman kaapelin laskemisen lomakkeen tuloksien
    // mukaan.
    public FloorheatingResponseDTO calculateFloorheating(double pituus, double leveys,
            int onSeinat, int onWc, int onLattiakaivo,
            double kylmaPituus, double kylmaLeveys,
            int asennusTapa, int tehoAlue, int tehoPerNelio) {

        // Tilan olion luominen ja pinta-alan laskeminen käyttäjän tietojen perusteella.
        RoomDTO roomDTO = new RoomDTO(pituus, leveys);
        // Kylmän pinta-alan laskeminen käyttäjän tietojen perusteella.
        roomDTO.laskeKylmäPintaAla(onSeinat, onWc, onLattiakaivo, kylmaPituus, kylmaLeveys);
        // Asennustavan valinta.
        String asennustapa = asennustavanValinta(asennusTapa);
        // Tehoalueen valinta asennustavan ja käyttäjän mukaan.
        int tehoalue = tehoalueenValinta(asennustapa, tehoAlue, tehoPerNelio);
        // Kaapelin valinta tietokannasta joka seulonnan jälkeen päätyy
        // floorheatingResponseDTO-olioon. Kaapelin valintaan työnnetään roomDTo-olio,
        // asennutapa, tehoalue ja mahdollinen custom teho per neliö.
        FloorheatingResponseDTO floorheatingResponseDTO = kaapelinValinta(roomDTO, asennustapa, tehoalue, tehoPerNelio);
        // Tarkistetaan, onko floorheatingResponseDTO null ja palautetaan mahdollinen
        // epäonnistuminen.
        if (floorheatingResponseDTO == null) {
            System.out.println("Kaapelia ei löytynyt!");
            return null;
        }
        return floorheatingResponseDTO;
    }

    // Metodi jossa valitaan miten lämmityskaapeli asennetaan.
    public String asennustavanValinta(int asennusTapa) {
        switch (asennusTapa) {
            case 1:
                System.out.println("Asennustavaksi on valittu tasoite.");
                return "tasoite";
            case 2:
                System.out.println("Asennustavaksi on valittu betonivalu.");
                return "betonivalu";
            default:
                throw new IllegalArgumentException("Virheellinen valinta.");
        }
    }

    // Metodi jossa valitaan haluttu tehoalue.
    public int tehoalueenValinta(String asennustapa, int tehoAlue, int tehoPerNelio) {
        if (asennustapa.equals("tasoite") && (tehoAlue >= 1 && tehoAlue <= 3)) {

            System.out.println("Tehoalue " + tehoAlue + " hyväksytty tasoitteelle.");
            return tehoAlue;

        } else if (asennustapa.equals("tasoite") && tehoAlue == 5 && (tehoPerNelio >= 40 && tehoPerNelio <= 160)) {

            System.out.println("Teho " + tehoPerNelio + " W/m² hyväksytty tasoitteelle.");
            return tehoAlue;

        } else if (asennustapa.equals("betonivalu") && (tehoAlue >= 2 && tehoAlue <= 4)) {

            System.out.println("Tehoalue " + tehoAlue + " hyväksytty betonivalulle.");
            return tehoAlue;

        } else if (asennustapa.equals("betonivalu") && tehoAlue == 5 && (tehoPerNelio >= 70 && tehoPerNelio <= 200)) {

            System.out.println("Teho " + tehoPerNelio + " W/m² hyväksytty betonivalulle.");
            return tehoAlue;

        } else {
            throw new IllegalArgumentException("Virheellinen asennustapa = " + asennustapa
                    + " joka ei sovi yhteen tehoalueen kanssa = " + tehoAlue);
        }

    }

    // Metodi jossa valitaan kaapeli ja tulostetaan sen tiedot.
    public FloorheatingResponseDTO kaapelinValinta(RoomDTO roomDTO, String asennustapa, int tehoalue,
            int tehoPerNelio) {
        // Haetaan kaapelit pituuden mukaan järjestyksessä.
        List<CableEntity> cables = cableRepository.findAllByPituusInDescOrder();
        // Alustetaan arraylist haun epäonnistumisen analysointia varten.
        ArrayList<String> epäonnistumiset = new ArrayList<String>();

        // Kaapelin valinta.
        for (CableEntity cable : cables) {

            // Määritetään customille tehoalue mistä kaapelia etsitään.
            double[] custom_teho_per_neliö = MathUtils.laskePlusMiinusProsenttia(tehoPerNelio);
            // Määritetään teho per neliö ja pyöristetään se lähimpään kokonaislukuun.
            double teho_per_neliö = MathUtils.pyöristaDouble(cable.getTeho() / roomDTO.getLämmin_pinta_ala());
            // Määritetään asennusväli ja pyöristetään se lähimpään kokonaislukuun.
            // (Kukaan asentaja ei mittaa millilleen.)
            double asennusväli_toteuma = MathUtils
                    .pyöristaDouble((roomDTO.getLämmin_pinta_ala() / (cable.getPituus() - roomDTO.getLeveys()))
                            * 100);

            // Tarkista asennustapa ja laita epäonnistumiset listaan merkintä jos tarve.
            if ((asennustapa.equals("tasoite")
                    && (cable.getTyyppi().equals("PST 10") || cable.getTyyppi().equals("PST-C"))) ||
                    (asennustapa.equals("betonivalu") && cable.getTyyppi().equals("PST 18"))) {

                // Tarkista tehoalue ja laita epäonnistumiset listaan merkintä jos tarve.
                if ((tehoalue == 1 && teho_per_neliö > 40 && teho_per_neliö < 100) ||
                        (tehoalue == 2 && teho_per_neliö > 70 && teho_per_neliö < 130) ||
                        (tehoalue == 3 && teho_per_neliö > 100 && teho_per_neliö < 160) ||
                        (tehoalue == 4 && teho_per_neliö > 120 && teho_per_neliö < 190) ||
                        (tehoalue == 5 && teho_per_neliö >= custom_teho_per_neliö[0]
                                && teho_per_neliö <= custom_teho_per_neliö[1]) && teho_per_neliö <= 200) {

                    // Tarkista asennusväli ja laita epäonnistumiset listaan merkintä jos tarve.
                    if (asennusväli_toteuma > 7 && asennusväli_toteuma < 25) {

                        // Luodaan CableDTO-olio tietokannasta haetusta kaapelista.
                        CableDTO cableDTO = new CableDTO();
                        cableDTO.setId(cable.getId());
                        cableDTO.setTyyppi(cable.getTyyppi());
                        cableDTO.setSähkönumero(cable.getSahkonumero());
                        cableDTO.setPituus(cable.getPituus());
                        cableDTO.setTeho(cable.getTeho());
                        cableDTO.setVastus_per_metri(cable.getVastusPerMetri());
                        cableDTO.setVastus_toleranssi(cable.getVastusToleranssi());
                        cableDTO.setHalkaisija(cable.getHalkaisija());

                        // Palauttaa CableDTO-olion, tehon per neliö ja asennusvälin
                        // floorheatingResponse-olion muodossa.
                        return new FloorheatingResponseDTO(roomDTO, cableDTO, teho_per_neliö, asennusväli_toteuma);

                    } else {
                        epäonnistumiset
                                .add("ID =" + cable.getId() + " | Asennusväli " + asennusväli_toteuma
                                        + " ei ole sallituissa rajoissa (7-25).");
                    }
                } else {
                    epäonnistumiset.add(
                            "ID =" + cable.getId() + " | Teho per neliö " + teho_per_neliö
                                    + " ei vastaa vaadittua tehoaluetta " + tehoalue + ".");
                }
            } else {
                epäonnistumiset.add(
                        "ID =" + cable.getId() + " | Kaapelin tyyppi " + cable.getTyyppi()
                                + " ei sovellu asennustavalle " + asennustapa + ".");
            }
        }
        // Jos sopivaa kaapelia ei löytynyt, tulostetaan kaikki ongelmat.
        if (epäonnistumiset.size() > 0) {
            System.out.println("Sopivaa kaapelia ei löytynyt seuraavista syistä:");
            for (int i = 0; i < epäonnistumiset.size(); i++) {
                System.out.println(epäonnistumiset.get(i));
            }
        }

        return null;
    }

}
