$(document).ready(function () {


    //редактирование заказа
    $('table .editRepairBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/api/findRepair/' + id,
            success: function (repair) {
                $('#editRepairModal #repairId').val(repair.repairId);
                $('#editRepairModal #repairAddress').val(repair.repairAddress);
                $('#editRepairModal #repairDescription').val(repair.repairDescription);
                $('#editRepairModal #repairDate').val(repair.repairDate);
                $('#editRepairModal #clientId').val(repair.clientId);
                $('#editRepairModal #deviceId').val(repair.deviceId);
                $('#editRepairModal #repairTypeId').val(repair.repairTypeId);
                $('#editRepairModal #clientTypeId').val(repair.clientTypeId);
                $('#editRepairModal #statusId').val(repair.statusId);
                $('#editRepairModal #fullCost').val(repair.fullCost);
                $('#editRepairModal #paid').val(repair.paid);
                $('#editRepairModal #outlay').val(repair.outlay);
                $('#editRepairModal #arrears').val(repair.arrears);
                $('#editRepairModal #profit').val(repair.profit);
                $('#editRepairModal #clientName').val(repair.clientName);
                $('#editRepairModal #deviceName').val(repair.deviceName);
                $('#editRepairModal #repairTypeName').val(repair.repairTypeName);
                $('#editRepairModal #statusName').val(repair.statusName);
            }
        });

    });

    //полная информация о заказе
    $('table .fullInfoBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/api/findRepair/' + id,
            success: function (repair) {
                $('#fullInfoModal #repairId').val(repair.repairId);
                $('#fullInfoModal #repairAddress').val(repair.repairAddress);
                $('#fullInfoModal #repairDescription').val(repair.repairDescription);
                $('#fullInfoModal #repairDate').val(repair.repairDate);
                $('#fullInfoModal #clientId').val(repair.clientId);
                $('#fullInfoModal #deviceId').val(repair.deviceId);
                $('#fullInfoModal #repairTypeId').val(repair.repairTypeId);
                $('#fullInfoModal #clientTypeId').val(repair.clientTypeId);
                $('#fullInfoModal #statusId').val(repair.statusId);
                $('#fullInfoModal #fullCost').val(repair.fullCost);
                $('#fullInfoModal #paid').val(repair.paid);
                $('#fullInfoModal #outlay').val(repair.outlay);
                $('#fullInfoModal #arrears').val(repair.arrears);
                $('#fullInfoModal #profit').val(repair.profit);
                $('#fullInfoModal #clientName').val(repair.clientName);
                $('#fullInfoModal #deviceName').val(repair.deviceName);
                $('#fullInfoModal #repairTypeName').val(repair.repairTypeName);
                $('#fullInfoModal #statusName').val(repair.statusName);
                console.log(repair)
            }
        });

    });

    //сохраниние в календарь
    $('#saveEventBtn').off("click").on("click", function () {
        const title = $('#title').val();
        const start = $('#start').val();
        const end = $('#end').val();
        const allDay = $('#allDay').val();
        const groupId = $('#groupId').val();
        const backgroundColor = $('#backgroundColor').val();
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/rem/events/api/saveEvent',
            type:'POST',
            data: JSON.stringify({ title, start, end, allDay, groupId, backgroundColor}),
            dataType:'json',
            success:function(data)
            {

                $('#addEvent').modal('hide');
                calendar.refetchEvents();
            },
            error:function (error){
                alert('error:'+eval(error));
            }
        });
    });


    window.update1 = function () {
        const select = document.getElementById('dropClient');
        const option = select.options[select.selectedIndex];
        document.getElementById('clientId').value = option.value;
    }

    window.update2 = function () {
        const select = document.getElementById('dropClientType');
        const option = select.options[select.selectedIndex];
        document.getElementById('clientType').value = option.value;
    }

    window.update3 = function () {
        const select = document.getElementById('dropRepairType');
        const option = select.options[select.selectedIndex];
        document.getElementById('repairTypeId').value = option.value;
    }

    window.update4 = function () {
        const select = document.getElementById('dropDevice');
        const option = select.options[select.selectedIndex];
        document.getElementById('deviceId').value = option.value;
    }
    window.update5 = function () {
        const select = document.getElementById('dropStatus');
        const option = select.options[select.selectedIndex];
        document.getElementById('statusId').value = option.value;
    }

});