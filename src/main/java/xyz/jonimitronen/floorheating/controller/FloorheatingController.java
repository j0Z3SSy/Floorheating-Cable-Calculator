// FloorheatingController.java
// Tässä luokassa määritellään HTTP-osoitteet (endpoints) ja mitä tapahtuu, kun pyyntöjä tehdään näihin osoitteisiin. 
// Se toimii linkkinä asiakkaan (kuten selaimen, front-end) ja palvelimen (kuten palvelusovelluksen, back-end) välillä.
package xyz.jonimitronen.floorheating.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.jonimitronen.floorheating.dto.CableDTO;
import xyz.jonimitronen.floorheating.dto.FloorheatingResponseDTO;
import xyz.jonimitronen.floorheating.entity.CableEntity;
import xyz.jonimitronen.floorheating.service.FloorheatingService;

@RestController
@RequestMapping("/api/floorheating")
public class FloorheatingController {

    @Autowired
    private FloorheatingService floorheatingService;

    @GetMapping("/")
    public String getIndex() {
        System.out.println("/...käynnissä");
        // Palautetaan tervetuloviesti.
        return "Tervetuloa Lattialämmitys-palveluun!";
        // http://localhost:8080/api/floorheating/
    }

    @GetMapping("/get/cable-length/{id}")
    public String getCableLengthById(@PathVariable int id) {
        System.out.println("/get/cable-length/{id}...käynnissä");
        // Hakee kaapelin tiedot annetun ID:n perusteella.
        CableDTO cableDTO = floorheatingService.getCableLengthById(id);
        // Tulostaa ID:tä vastaavan kaapelin tiedot terminaaliin.
        cableDTO.toString();
        // Palautetaan viesti, jossa kerrotaan kaapelin id ja pituus.
        return cableDTO.getId() + ". kaapelin pituus on = " + cableDTO.getPituus();
        // http://localhost:8080/api/floorheating/get/cable-length/NUMERO!

    }

    @GetMapping("/get/all-cables")
    public List<CableEntity> getAllCables() {
        System.out.println("/get/all-cables...käynnissä");
        // Palautetaan lista kaikista kaapeleista, joita löytyy tietokannasta.
        return floorheatingService.getAllCables();
        // http://localhost:8080/api/floorheating/get/all-cables
    }

    @PostMapping("/post/cable-form")
    public ResponseEntity<FloorheatingResponseDTO> postCableForm(
            @RequestParam("pituus") double pituus,
            @RequestParam("leveys") double leveys,
            @RequestParam(value = "on_seinat", required = false, defaultValue = "0") int onSeinat,
            @RequestParam(value = "on_wc", required = false, defaultValue = "0") int onWc,
            @RequestParam(value = "on_lattiakaivo", required = false, defaultValue = "0") int onLattiakaivo,
            @RequestParam(value = "kylma_pituus", required = false, defaultValue = "0.0") double kylmaPituus,
            @RequestParam(value = "kylma_leveys", required = false, defaultValue = "0.0") double kylmaLeveys,
            @RequestParam("asennus_tapa") int asennusTapa,
            @RequestParam("teho_alue") int tehoAlue,
            @RequestParam(value = "teho_per_neliö", required = false, defaultValue = "0") int tehoPerNelio) {
        System.out.println("/post/calculate-cable...käynnissä");
        // Viedään saadut tiedot FloorheatingServiceen.
        FloorheatingResponseDTO floorheatingResponseDTO = floorheatingService.calculateFloorheating(pituus, leveys,
                onSeinat,
                onWc, onLattiakaivo, kylmaPituus,
                kylmaLeveys, asennusTapa, tehoAlue, tehoPerNelio);
        return ResponseEntity.ok(floorheatingResponseDTO);
        // http://localhost:8080/api/floorheating/post/cable-form
    }

}
