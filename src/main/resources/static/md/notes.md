# **_notes.md📊_**

## **1. Kylmä-Pinta-Ala ❄️**

- Seinään jätetään aina 10 cm rako.
- Lattiakaivoon jätetään aina 10 cm rako.
- Vessanpöntön putken kohdalle jätetään aina 45 cm rako.
- Kaikki muut mahdolliset kylmät alueet, joissa ei ole fyysisesti mahdollista kävellä (esim. seinät ja kaapit).

## **2. Teho per Neliömetri 💡**

- Valitaan tuote, jonka nimellisteho W on lähempänä mutta suurempi kuin laskettu teho.
- **Pistesarjat:**
  - Teho per neliömetri = kaapelin kokonaisteho / lämmitettävä pinta-ala.
- **Devi:**
  - PCalc [W] = PInst [W/m²] · AInst [m²].

## **3. Asennusväli 📏**

- Asennusväli = lämmin kokonaispinta-ala / lämpökaapelin pituus.
- Lämpökaapelin pituus = lämmin kokonaispinta-ala / asennusväli.
- **Pistesarjat:**
  - 7 cm - 25 cm.
- **Devi:**
  - 5-10 cm.

## **4. Valukorkeus 📐**

- **Pistesarjat:**
  - PST 10: 5 mm klinkkeristä sekä 10 mm muovimatosta ja puulattiasta.
  - PST-C10: 5 mm klinkkeristä sekä 10 mm muovimatosta ja puulattiasta.
  - PST 18: Betonirakenteen korkeuden oltava yli 30 mm. Teho 20 W per metri.
- **Devi:**
  - 3-5 mm lattiasta, lämmitysmatot.
  - Yli 3 cm niin kaapeli voi olla.

## **5. Tehoalueet 🌡️**

- **Koodissa:**
  1. Matalaenergiatalot: n. 40-80 W/m²
  2. Mukavuuslämmitys: n. 70-120 W/m²
  3. Kostea tila: n. 80-130 W/m²
  4. Osittain varaava: n. 100-160 W/m²
- **Pistesarjat:**
  1. Matalaenergiatalot: n. 40-60 W/m²
  2. Mukavuuslämmitys: n. 70-90 W/m²
  3. Kostea tila: 100 W/m²
  4. Osittain varaava: 120 W/m²
  - PST 10 ja PST-C max 100 W/m² tasoitteisiin.
  - PST 18 max 120 W/m² betonivaluihin.
- **Devi:**
  1. Puulattiat: enintään 100 W/m².
  2. Kuivat tilat, eristetyt lattiat: vähintään 100 W/m².
  3. Lattiat ilman eristystä: 130–160 W/m².
  4. Kosteat tilat: 150–180 W/m².
  5. Parvekkeet, heikko eristys: 160–200 W/m².
  6. Maksimiteho lattiarakenteissa: enintään 200 W/m².

## **6. Lämpötila Tavoitteet 🎯**

- Huoneen lämpötila: 20 astetta.
- Lattian tavoitelämpötila: 29 astetta.
- Muista 30% turvallisuusmarginaali.

## **7. Asennustapa 🏗️**

- Tasoitteseen: PST 10 ja PST-C.
- Betonivaluun: PST 18.

## **8. Termostaatti 🌡️**

- **Pistesarjat:**
  - (Lisää tarvittavat tiedot myöhemmin).
- **Devi:**
  - (Lisää tarvittavat tiedot myöhemmin).

## **9. Muut Asennusvaatimukset 🔧**

- **Pistesarjat:**
  - (Lisää tarvittavat tiedot myöhemmin).
- **Devi:**
  - (Lisää tarvittavat tiedot myöhemmin).

---

# **To-Do Lista 📋**

1. kommentoi ja dokumentoi kaikki kuntoon ja ymmärrä koko koodi. front-end yhteensovita.
2. tee omat kansiot html ja css tiedostoille. Jaa jotenkin järkevästi.
3. Listaa kaikki tiedot, mitä on annettu.
4. Tee unit testing kaikille luokille JUnit:llä, tee database testing ja Restful testing Robot Frameworkilla.
5. Käytä 2m ja 1,7m malli pituus ja leveytenä.

---

# **Jossain Myöhemmin ⏳**

1. Tee joku `run.bat` -tiedosto, jotta saat helposti ja nopeasti ajettua ohjelmaa komentoriviltä.
2. Tee luokka termostaateille (Pistesarjat ja Devi).
3. Tee taulu termostaateille (Pistesarjat ja Devi) ja määrittele niiden suositukset.
4. Lisää Devin kaapelit, koska hintoja ei näy Pistesarjoilla.
   - Vertaa ohjeita, miten määritetään oikea kaapeli; voi olla, että aika paljon joutuu uusimaan.
   - Lisää hinta- ja valmistajakolumnit.
5. Näytä hinta, paljonko kaapeli maksaa ja paljonko sen kanssa sopiva termostaatti maksaisi.

---
