// CableEntity.java
// Tämä luokka toimii tietokannan taulun rakenteen kuvastajana. 
// Se määrittelee, millaisia attribuutteja koiralla on, ja sen avulla tiedot tallennetaan ja haetaan tietokannasta.
package xyz.jonimitronen.floorheating.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cables")
public class CableEntity {

    // Primary key: id (auto-incremented)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    // tyyppi
    @Column(name = "tyyppi", length = 20, nullable = false)
    private String tyyppi;

    // sahkonumero
    @Column(name = "sahkonumero", nullable = true)
    private int sahkonumero;

    // pituus
    @Column(name = "pituus", nullable = false)
    private double pituus;

    // teho
    @Column(name = "teho", nullable = false)
    private double teho;

    // vastus_per_metri
    @Column(name = "vastus_per_metri", nullable = false)
    private double vastusPerMetri;

    // vastus_toleranssi
    @Column(name = "vastus_toleranssi", nullable = false)
    private int vastusToleranssi;

    // halkaisija
    @Column(name = "halkaisija", nullable = false)
    private int halkaisija;

    // Konstructorit.
    public CableEntity() {
    }

    public CableEntity(String tyyppi, Integer sahkonumero, double pituus, double teho, double vastusPerMetri,
            int vastusToleranssi, int halkaisija) {
        this.tyyppi = tyyppi;
        this.sahkonumero = sahkonumero;
        this.pituus = pituus;
        this.teho = teho;
        this.vastusPerMetri = vastusPerMetri;
        this.vastusToleranssi = vastusToleranssi;
        this.halkaisija = halkaisija;
    }

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

    public Integer getSahkonumero() {
        return sahkonumero;
    }

    public void setSahkonumero(Integer sahkonumero) {
        this.sahkonumero = sahkonumero;
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

    public double getVastusPerMetri() {
        return vastusPerMetri;
    }

    public void setVastusPerMetri(double vastusPerMetri) {
        this.vastusPerMetri = vastusPerMetri;
    }

    public int getVastusToleranssi() {
        return vastusToleranssi;
    }

    public void setVastusToleranssi(int vastusToleranssi) {
        this.vastusToleranssi = vastusToleranssi;
    }

    public int getHalkaisija() {
        return halkaisija;
    }

    public void setHalkaisija(int halkaisija) {
        this.halkaisija = halkaisija;
    }

}
