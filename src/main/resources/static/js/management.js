$(document).ready(function () {

    $('#message').off('change').on('change', function (e) {
        const msg = $('#message').val();
        console.log(msg)
        // if(msg!=null){
        //     e.preventDefault();
        // }else {
        //     return false;
        // }
    });

    // if ('message') {
    //     swal("Are you sure you want to do this?", {
    //         buttons: ["OK", true],
    //     });
    // }

    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    const table = $('#clients').DataTable({
        language: {
            url: '../localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });

    $('#devices').DataTable({
        language: {
            url: '../localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });
    $('#clientsTypes').DataTable({
        language: {
            url: '../localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });
    $('#repairsTypes').DataTable({
        language: {
            url: '../localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });
    $('#statuses').DataTable({
        language: {
            url: '../localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });

    $('#clientFilesTable').DataTable({
        language: {
            url: '../localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });

    //полная информация о клиенте
    $('table .fullInfoClientBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/management/api/findClient/' + id,
            success: function (client) {
                $('#clientCardModal #clientName').val(client.clientName);
                $('#clientCardModal #clientContact').val(client.clientContact);
                $('#clientCardModal #clientPhone').val(client.clientPhone);
                $('#clientCardModal #clientMail').val(client.clientMail);
            }
        });
    });

    //загрузка файлов
    $('table .clientFilesBtn').off("click").on("click", function () {
        $('#clients tbody').off("click").on('click', 'tr', function (event) {
            const clientDir = table.row($(this).closest('tr')).data()[1];
            $('#clientDir').val(clientDir)
            console.log(clientDir);
            // $.ajax({
            //     headers: {
            //         'Accept': 'application/json',
            //         'Content-Type': 'application/json'
            //     },
            //     url: '/rem/events/api/saveEvent',
            //     type: 'POST',
            //     data: JSON.stringify({}),
            //     dataType: 'json',
            //     success: function (data) {
            //         $('#addEvent').modal('hide');
            //     },
            //     error: function (error) {
            //         alert('error:' + eval(error));
            //     }
            // });
        });
    });

    //редактирование клиента
    $('table .editClientBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/management/api/findClient/' + id,
            success: function (client) {
                $('#editClientModal #clientId').val(client.clientId);
                $('#editClientModal #clientName').val(client.clientName);
                $('#editClientModal #clientTypeId').val(client.clientTypeId);
            }
        });

    });

    //редактирование техники
    $('table .editDeviceBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/management/api/findDevice/' + id,
            success: function (device) {
                $('#editDeviceModal #deviceId').val(device.deviceId);
                $('#editDeviceModal #deviceName').val(device.deviceName);
            }
        });

    });

    //редактирование тип клиента
    $('table .editClientTypeBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/management/api/findClientType/' + id,
            success: function (clientType) {
                $('#editClientTypeModal #clientTypeId').val(clientType.clientTypeId);
                $('#editClientTypeModal #clientTypeName').val(clientType.clientTypeName);
            }
        });

    });

    //редактирование типа ремонта
    $('table .editRepairTypeBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/management/api/findRepairType/' + id,
            success: function (repairType) {
                $('#editRepairTypeModal #repairTypeId').val(repairType.repairTypeId);
                $('#editRepairTypeModal #repairTypeName').val(repairType.repairTypeName);
            }
        });
    });

    //редактирование статуса
    $('table .editStatusBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/management/api/findStatus/' + id,
            success: function (status) {
                $('#editStatusModal #statusId').val(status.statusId);
                $('#editStatusModal #statusName').val(status.statusName);
            }
        });
    });

    $("#dropClientType").on('change', function () {
        const clientTypeId = $(this).find('option:selected').attr('value');
        $('#clientType').val(clientTypeId);
        console.log(clientTypeId)
    });

});