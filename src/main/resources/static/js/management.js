$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    $('#clients').DataTable({
        language: {
            url: '../localisation/ru.json'
        }
    });

    //полная информация о клиенте
    $('table .fullInfoClientBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/management/api/findClient/' + id,
            success: function (client) {
                $('#clientCardModal #clientName').val(client.clientName);
                $('#clientCardModal #clientContact').val(client.clientContact);
                $('#clientCardModal #clientPhone').val(client.clientPhone);
                $('#clientCardModal #clientMail').val(client.clientMail);
            }
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
    });

});