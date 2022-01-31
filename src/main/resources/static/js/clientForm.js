$(document).ready(function (){

    $('table .editRepairBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/api/findRepair/' + id,
            success: function (repair) {
                $('#editRepairModal #repair_id').val(repair.repair_id);
                $('#editRepairModal #repair_address').val(repair.repair_address);
                $('#editRepairModal #repair_description').val(repair.repair_description);
                $('#editRepairModal #repair_date').val(repair.repair_date);
                $('#editRepairModal #client_id').val(repair.client_id);
                $('#editRepairModal #device_id').val(repair.device_id);
                $('#editRepairModal #repair_type_id').val(repair.repair_type_id);
                $('#editRepairModal #client_type_id').val(repair.client_type_id);
                $('#editRepairModal #status_id').val(repair.status_id);
                $('#editRepairModal #full_cost').val(repair.full_cost);
                $('#editRepairModal #paid').val(repair.paid);
                $('#editRepairModal #outlay').val(repair.outlay);
                $('#editRepairModal #arrears').val(repair.arrears);
                $('#editRepairModal #profit').val(repair.profit);
                $('#editRepairModal #client_name').val(repair.client_name);
                $('#editRepairModal #device_name').val(repair.device_name);
                $('#editRepairModal #repair_type_name').val(repair.repair_type_name);
                $('#editRepairModal #status_name').val(repair.status_name);
            }
        });

    });

    $('table .fullInfoBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/api/findRepair/' + id,
            success: function (repair) {
                $('#fullInfoModal #repair_id').val(repair.repair_id);
                $('#fullInfoModal #repair_address').val(repair.repair_address);
                $('#fullInfoModal #repair_description').val(repair.repair_description);
                $('#fullInfoModal #repair_date').val(repair.repair_date);
                $('#fullInfoModal #client_id').val(repair.client_id);
                $('#fullInfoModal #device_id').val(repair.device_id);
                $('#fullInfoModal #repair_type_id').val(repair.repair_type_id);
                $('#fullInfoModal #client_type_id').val(repair.client_type_id);
                $('#fullInfoModal #status_id').val(repair.status_id);
                $('#fullInfoModal #full_cost').val(repair.full_cost);
                $('#fullInfoModal #paid').val(repair.paid);
                $('#fullInfoModal #outlay').val(repair.outlay);
                $('#fullInfoModal #arrears').val(repair.arrears);
                $('#fullInfoModal #profit').val(repair.profit);
                $('#fullInfoModal #client_name').val(repair.client_name);
                $('#fullInfoModal #device_name').val(repair.device_name);
                $('#fullInfoModal #repair_type_name').val(repair.repair_type_name);
                $('#fullInfoModal #status_name').val(repair.status_name);
            }
        });

    });

    $('table .editClientBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/management/api/findClient/' + id,
            success: function (client) {
                $('#editClientModal #client_id').val(client.client_id);
                $('#editClientModal #client_name').val(client.client_name);
                $('#editClientModal #client_type_id').val(client.client_type_id);
            }
        });

    });

    $('table .editDeviceBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
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
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/management/api/findRepairType/' + id,
            success: function (repair_type) {
                $('#editRepairTypeModal #repair_type_id').val(repair_type.repair_type_id);
                $('#editRepairTypeModal #repair_type_name').val(repair_type.repair_type_name);
            }
        });
    });

    $('table .editStatusBtn') .on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type:'GET',
            url:'/rem/repair-service/management/api/findStatus/' + id,
            success: function (status) {
                $('#editStatusModal #status_id').val(status.status_id);
                $('#editStatusModal #status_name').val(status.status_name);
            }
        });
    });

    window.update1 = function() {
        const select = document.getElementById('dropClient');
        const option = select.options[select.selectedIndex];
        document.getElementById('client').value = option.value;
    }

    window.update2 = function() {
        const select = document.getElementById('dropClientType');
        const option = select.options[select.selectedIndex];
        document.getElementById('clientType').value = option.value;
    }

    window.update3 = function() {
        const select = document.getElementById('dropRepairType');
        const option = select.options[select.selectedIndex];
        document.getElementById('repairType').value = option.value;
    }

    window.update4 = function() {
        const select = document.getElementById('dropDevice');
        const option = select.options[select.selectedIndex];
        document.getElementById('device').value = option.value;
    }
    window.update5 = function() {
        const select = document.getElementById('dropStatus');
        const option = select.options[select.selectedIndex];
        document.getElementById('status').value = option.value;
    }

});



