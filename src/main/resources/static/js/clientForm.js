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
                console.log(repair)
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

    //редактирование затрат
    $('table .editOutlayBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/statistic/api/findOutlay/' + id,
            success: function (outlay) {
                $('#editOutlayModal #outlayId').val(outlay.outlayId);
                $('#editOutlayModal #itemId').val(outlay.itemId);
                $('#editOutlayModal #itemsItemId').val(outlay.itemsItemId);
                $('#editOutlayModal #itemName').val(outlay.itemName);
                $('#editOutlayModal #subitemsSubitemId').val(outlay.subitemsSubitemId);
                $('#editOutlayModal #subitemName').val(outlay.subitemName);
                $('#editOutlayModal #description').val(outlay.description);
                $('#editOutlayModal #price').val(outlay.price);
                $('#editOutlayModal #date').val(outlay.date);
                console.log(outlay)
            }
        });
    });

    //редактирование статьи затрат
    $('table .llcOutlayModalBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/statistic/api/findItem/' + id,
            success: function (item) {
                $('#llcOutlayModal #itemId').val(item.itemId);
                $('#llcOutlayModal #itemName').val(item.itemName);
                console.log(item)
            }
        });

    });

    //назначение id при выборе из выпадающих списков
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

    window.update6 = function () {
        const select = document.getElementById('dropItems');
        const option = select.options[select.selectedIndex];
        document.getElementById('itemsItemId').value = option.value;
        console.log(option.value)
    }

    window.update7 = function () {
        const select = document.getElementById('dropItemsId');
        const option = select.options[select.selectedIndex];
        document.getElementById('itemsItemId0').value = option.value;
    }

    window.update8 = function () {
        const select = document.getElementById('dropSubItemsId');
        const option = select.options[select.selectedIndex];
        document.getElementById('subitemsSubitemId').value = option.value;
    }

    //зависимый выпадающий список при создании затрат
    getItems();
    function getItems() {
        const urlString0 = "/rem/statistic/api/items";
        $.ajax({
            method: "GET", url: urlString0,
            dataType: 'json',
        })
            .done(function (responseJson) {
                const itemsDD = $("#dropItemsId").change(function (){
                    getSubItems();
                })
                $.each(responseJson, function (index, items) {
                    $("<option>").val(items.itemId).text(items.itemName).appendTo(itemsDD);
                });
            });
    }

    function getSubItems() {
        console.log("<---->");
        const itemId = $("#dropItemsId").val();
        const urlString1 = "/rem/statistic/api/subItemsByItemsId?itemsItemId=" + itemId;
        $.ajax({
            method: "GET",
            url: urlString1,
            dataType: 'json',
        })
            .done(function (responseJson) {
                const subitemsDD = $("#dropSubItemsId");
                subitemsDD.empty();
                $.each(responseJson, function (index, subitems) {
                    $("<option>").val(subitems.subitemId).text(subitems.subitemName).appendTo(subitemsDD);
                });
            });
    }

    //POST сохраниние затрат
        $('#outlaySubmitBtn').on('click', function (event) {
            event.preventDefault();
            let description = $("#descriptionId").val();
            let price = $("#priceId").val();
            let date = $("#dateId").val();
            let itemsItemId = $("#itemsItemId0").val();
            let subitemsSubitemId = $("#subitemsSubitemId").val();
            let data;
            data = {
                description,
                price,
                date,
                subitemsSubitemId,
                itemsItemId
            }
            console.log(data);
            const json = JSON.stringify(data);
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "http://localhost:8191/rem/statistic/api/saveOutlayRest",
                type: 'POST',
                data: json,
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                },
            });
        });

});



