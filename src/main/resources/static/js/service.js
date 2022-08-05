$(document).ready(function () {

    $('#cash').change(function () {
        $(this).val($(this).prop('checked'));
    })

    $("#dropClient").on('change', function () {
        const clientId = $(this).find('option:selected').attr('value');
        $('#clientId').val(clientId);
    });

    $("#dropRepairType").on('change', function () {
        const repairTypeId = $(this).find('option:selected').attr('value');
        $('#repairTypeId').val(repairTypeId);
    });

    $("#dropDevice").on('change', function () {
        const deviceId = $(this).find('option:selected').attr('value');
        $('#deviceId').val(deviceId);
    });
    $("#dropStatus").on('change', function () {
        const statusId = $(this).find('option:selected').attr('value');
        $('#statusId').val(statusId);
    });


    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    const table = $('#r-services').DataTable({
        footerCallback: function (row, data, start, end, display) {
            const api = this.api();

            // Remove the formatting to get integer data for summation
            const intVal = function (i) {
                return typeof i === 'string' ? i.replace(/,/g, '') * 1 : typeof i === 'number' ? i : 0;
            };

            // Total over all pages
            let total = api
                .column(5)
                .data()
                    .reduce(function (a, b) {
                        return intVal(a) + intVal(b);
                    }, 0);

                // Total over this page
                let pageTotal = api
                    .column(5, {page: 'current'})
                    .data()
                    .reduce(function (a, b) {
                        return intVal(a) + intVal(b);
                    }, 0);

                // Update footer
                $(api.column(5).footer()).html('$' + pageTotal + ' ( $' + total + ' total)');
            },
            columnDefs: [
                {"visible": false, "targets": 7}
            ],

            language: {
                url: './localisation/ru.json'
            },
        }
    );

    //редактирование заказа
    $('table .editRepairBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/api/findRepairById/' + id,
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
                if (repair.cash) {
                    $('#fullInfoModal').find(':checkbox[name=cash]').prop('checked', true);
                } else {
                    $('#fullInfoModal').find(':checkbox[name=cash]').prop('checked', false);
                }
            }
        });

    });

    //полная информация о заказе
    $('table .fullInfoBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/repair-service/api/findRepairById/' + id,
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
                if (repair.cash) {
                    $('#fullInfoModal').find(':checkbox[name=cash]').prop('checked', true);
                } else {
                    $('#fullInfoModal').find(':checkbox[name=cash]').prop('checked', false);
                }

                console.log(repair)
            }
        });

    });



    // сохраниние в календарь
    $('table .saveRepairEventBtn').off("click").on("click", function () {
        $('#r-services tbody').off("click").on('click', 'tr', function (event) {
        const repairId = table.row($(this).closest('tr')).data()[7];
        const title = table.row($(this).closest('tr')).data()[0];
        const start = table.row($(this).closest('tr')).data()[6];
        const end = start;
        const allDay = true;
        const groupId = '1';
            const backgroundColor = '#4da843';
            const url = '/rem/repair-service/api/findRepairById/' + repairId;
        console.log(repairId);
        console.log(url);
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: '/rem/events/api/saveEvent',
                type: 'POST',
                data: JSON.stringify({title, start, end, allDay, groupId, backgroundColor, url}),
                dataType: 'json',
                success: function (data) {
                    $('#addEvent').modal('hide');
                },
                error: function (error) {
                    alert('error:' + eval(error));
                }
            });
        });
    });
});