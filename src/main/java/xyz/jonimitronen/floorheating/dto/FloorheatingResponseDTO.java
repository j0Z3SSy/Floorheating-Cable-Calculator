// FloorheatingResponseDTO.java
// Tämä luokka edustaa oliota joka muodostettiin kaapelinValinta-metodissa ja se sisältää tiedot kaapelin, huoneen, teho per neliön ja asennusvälin tulostukseen.
// Tämä luokka toimii tiedonsiirtomallina (Data Transfer Object). Se on tarkoitettu erityisesti API-vastauksille ja pyynnöille.
// Se toimii myös ikään kuin "raamina" datan esittämiseen API-vastauksissa.
package xyz.jonimitronen.floorheating.dto;

public class FloorheatingResponseDTO {

    // Attribuutit.
    private RoomDTO roomDTO;
    private CableDTO cableDTO;
    private double teho_per_neliö;
    private double asennusväli_toteuma;

    // Konstructori.
    public FloorheatingResponseDTO(RoomDTO roomDTO, CableDTO cableDTO, double teho_per_neliö,
            double asennusväli_toteuma) {
        this.roomDTO = roomDTO;
        this.cableDTO = cableDTO;
        this.teho_per_neliö = teho_per_neliö;
        this.asennusväli_toteuma = asennusväli_toteuma;
    }

    // Getterit
    public RoomDTO getRoomDTO() {
        return roomDTO;
    }

    public CableDTO getCableDTO() {
        return cableDTO;
    }

    public double getTeho_per_neliö() {
        return teho_per_neliö;
    }

    public double getAsennusväli_toteuma() {
        return asennusväli_toteuma;
    }

}
