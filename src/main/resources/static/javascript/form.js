// form.js
console.log("form.js ladattu");
$(document).on("submit", "#KaapeliForm", function (event) {
  console.log("submittia on painettu");
  event.preventDefault();

  const formData = $(this).serialize();

  $.ajax({
    url: "/api/floorheating/post/cable-form",
    type: "POST",
    data: formData,
    success: function (response) {
      // Pinta-ala.
      $("#pinta_ala").html("<p>Pinta-ala: " + response.roomDTO.pinta_ala + " m²</p>");

      // Kylmät pinta-ala.
      $("#kylmä_pinta_ala").html("<p>Kylmä pinta-ala: " + response.roomDTO.kylmä_pinta_ala + " m²</p>");

      // Lämmitetty pinta-ala.
      $("#lämmitetty_pinta_ala").html("<p>Lämmin pinta-ala: " + response.roomDTO.lämmin_pinta_ala + " m²</p>");

      // Asennusväli.
      $("#asennusväli").html("<p>Asennusväli: " + response.asennusväli_toteuma + " cm</p>");

      // Teho per neliö.
      $("#teho_per_neliö").html("<p>Teho per neliö: " + response.teho_per_neliö + " W/m²</p>");

      // Kaapeli.
      $("#kaapeli_tiedot").html(
        "<ul>" +
          "<li>ID: " +
          response.cableDTO.id +
          "</li>" +
          "<li>Tyyppi: " +
          response.cableDTO.tyyppi +
          "</li>" +
          "<li>Sähkönumero: " +
          response.cableDTO.sähkönumero +
          "</li>" +
          "<li>Pituus: " +
          response.cableDTO.pituus +
          " m</li>" +
          "<li>Teho: " +
          response.cableDTO.teho +
          " W</li>" +
          "<li>Vastus per metri: " +
          response.cableDTO.vastus_per_metri +
          " Ω/m</li>" +
          "<li>Vastus toleranssi: " +
          response.cableDTO.vastus_toleranssi +
          " Ω</li>" +
          "<li>Halkaisija: " +
          response.cableDTO.halkaisija +
          " mm</li>" +
          "</ul>"
      );
    },
    error: function (xhr, status, error) {
      $("#virhe").html("<p>Virhe: " + error + "</p>");
    },
  });
});
