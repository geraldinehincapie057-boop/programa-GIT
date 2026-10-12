// =====================================
// FORMULARIO DE AGENDAMIENTO
// =====================================

const formulario = document.getElementById("formCita");

if (formulario) {

    formulario.addEventListener("submit", function(event) {

        event.preventDefault();

        const nombre = document.getElementById("nombre").value;
        const servicio = document.getElementById("servicio").value;
        const fecha = document.getElementById("fecha").value;
        const hora = document.getElementById("hora").value;

        if (nombre === "" || servicio === "" || fecha === "" || hora === "") {

            alert("Por favor complete los campos obligatorios.");

            return;
        }

        alert(
            "¡Solicitud enviada correctamente!\n\n" +
            "Cliente: " + nombre + "\n" +
            "Servicio: " + servicio + "\n" +
            "Fecha: " + fecha + "\n" +
            "Hora: " + hora
        );

        formulario.reset();

    });

}


// =====================================
// BOTONES Y NAVEGACIÓN
// =====================================

const enlaces = document.querySelectorAll(".nav a");

enlaces.forEach(function(enlace) {

    enlace.addEventListener("click", function() {

        console.log(
            "Navegando a: " + enlace.textContent
        );

    });

});