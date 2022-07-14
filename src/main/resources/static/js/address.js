$(document).ready(function() {

    function initialize() {
        const input = document.getElementById('repair_address');
        new google.maps.places.Autocomplete(input);
    }

    google.maps.event.addDomListener(window, 'load', initialize);

} );