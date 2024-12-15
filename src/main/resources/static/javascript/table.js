// table.js
// Tämä funktio haetaan kaapelit tietokannasta
console.log("table.js loaded."); // This confirms loading

// This function fetches cables from the database
window.fetchCables = function () {
  // Assign to window to make it global
  console.log("Fetching cables..."); // Log message to see if this function is called
  fetch("/api/read-all-cables")
    .then((response) => {
      if (!response.ok) {
        throw new Error("Verkkovirhe: " + response.status);
      }
      return response.json();
    })
    .then((cables) => {
      const cableTableBody = document.getElementById("kaapeliTauluBody");
      cableTableBody.innerHTML = ""; // Clear existing content

      cables.forEach((cable) => {
        const row = document.createElement("tr");
        row.innerHTML = `
                    <td>${cable.id}</td>
                    <td>${cable.tyyppi}</td>
                    <td>${cable.sähkönumero}</td>
                    <td>${cable.pituus}</td>
                    <td>${cable.teho}</td>
                    <td>${cable.vastus_per_metri}</td>
                    <td>${cable.vastus_toleranssi}</td>
                    <td>${cable.halkaisija}</td>
                `;
        cableTableBody.appendChild(row); // Append row to table
      });
    })
    .catch((error) => {
      console.error("Virhe kaapelien hakemisessa:", error);
      alert("Kaapeleiden hakemisessa tapahtui virhe. Tarkista konsoli.");
    });
};
