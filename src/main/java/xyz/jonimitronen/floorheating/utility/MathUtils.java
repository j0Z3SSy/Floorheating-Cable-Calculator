// MathUtils.java
// Tässä luokassa on vain matemaattisia metodeja joita voidaan käyttää halutessaan missä vain.
package xyz.jonimitronen.floorheating.utility;

public class MathUtils {
    // Metodi jossa otetaan arvo ja palautetaan siitä -10% ja +10% versiot taulukon
    // muodossa.
    public static double[] laskePlusMiinusProsenttia(int tehoPerNelio) {
        // - miinus %.
        double miinus = tehoPerNelio - (tehoPerNelio * 0.05);
        // + plus %.
        double plus = tehoPerNelio + (tehoPerNelio * 0.15);
        // Palautetaan taulukko.
        return new double[] { miinus, plus };
    }

    // Metodi jossa otetaan double arvo ja palautetaan siitä pyröistetty double
    // arvo.
    public static double pyöristaDouble(double arvo) {
        // Pyöristetään arvo lähimpään kokonaislukuun
        long pyöristetty = Math.round(arvo);
        // Muutetaan takaisin doubleksi ja palautetaan
        return (double) pyöristetty;
    }

}
