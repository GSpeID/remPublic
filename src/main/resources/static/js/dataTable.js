$(document).ready(function() {
    $('#clients').DataTable( {
        language: {
            url: '../localisation/ru.json'
        }
    } );
    $('#devices').DataTable( {
        language: {
            url: '../localisation/ru.json'
        }
    } );
    $('#clientsTypes').DataTable( {
        language: {
            url: '../localisation/ru.json'
        }
    } );
    $('#repairsTypes').DataTable( {
        language: {
            url: '../localisation/ru.json'
        }
    } );
    $('#statuses').DataTable( {
        language: {
            url: '../localisation/ru.json'
        }
    } );
    $('#r-services').DataTable( {
        language: {
            url: './localisation/ru.json'
        }
    } );
    $('#stats').DataTable( {
        language: {
            url: './localisation/ru.json'
        }
    } );
} );