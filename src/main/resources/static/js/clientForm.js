$(document).ready(function (){

    $('table .editRepairBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        console.log(id);
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/api/findRepair/' + id,
            success: function (repair) {
                $('#editRepairModal #repair_id').val(repair.repair_id);
                $('#editRepairModal #repair_name').val(repair.repair_name);
                $('#editRepairModal #repair_description').val(repair.repair_description);
                $('#editRepairModal #repair_cost').val(repair.repair_cost);
                $('#editRepairModal #repair_date').val(repair.repair_date);
                $('#editRepairModal #client_id').val(repair.client_id);
                $('#editRepairModal #client_type_id').val(repair.client_type_id);
                $('#editRepairModal #device_id').val(repair.device_id);
                $('#editRepairModal #repair_type_id').val(repair.repair_type_id);
                $('#editRepairModal #client_name').val(repair.client_name);
                $('#editRepairModal #device_name').val(repair.device_name);
                $('#editRepairModal #client_type_name').val(repair.client_type_name);
                $('#editRepairModal #repair_type_name').val(repair.repair_type_name);
            }
        });

    });

    $('table .editClientBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        console.log(id);
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/management/api/findClient/' + id,
            success: function (client) {
                $('#editClientModal #client_id').val(client.client_id);
                $('#editClientModal #client_name').val(client.client_name);
            }
        });

    });

    $('table .editDeviceBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        console.log(id);
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/management/api/findDevice/' + id,
            success: function (device) {
                $('#editDeviceModal #device_id').val(device.device_id);
                $('#editDeviceModal #device_name').val(device.device_name);
            }
        });

    });

    $('table .editClientTypeBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        console.log(id);
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/management/api/findClientType/' + id,
            success: function (client_type) {
                $('#editClientTypeModal #client_type_id').val(client_type.client_type_id);
                $('#editClientTypeModal #client_type_name').val(client_type.client_type_name);
            }
        });

    });

    $('table .editRepairTypeBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        console.log(id);
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/management/api/findRepairType/' + id,
            success: function (repair_type) {
                $('#editRepairTypeModal #repair_type_id').val(repair_type.repair_type_id);
                $('#editRepairTypeModal #repair_type_name').val(repair_type.repair_type_name);
            }
        });

    });

});


