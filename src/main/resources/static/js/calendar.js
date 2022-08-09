$(document).ready(function () {

    window.update9 = function () {
        const select = document.getElementById('dropGroups');
        const option = select.options[select.selectedIndex];
        document.getElementById('groupId').value = option.value;
    }
    $("#dropGroups").on('change', function () {
        const color = $(this).find('option:selected').attr('id');
        $('#backgroundColor').val(color);
    });
    $('#addEvent').on('hidden.bs.modal', function (e) {
        $(this)
            .find("input,textarea,select")
            .val('')
            .end()
            .find("input[type=checkbox], input[type=radio]")
            .prop("checked", "")
            .end();
    });
});

document.addEventListener('DOMContentLoaded', function () {

    $('#fullInfoModal').modal('hide').on('hidden.bs.modal', function () {
        $(this).find('form').trigger('reset');
    })
    $('#allDay').change(function () {
        $(this).val($(this).prop('checked'));
    })
    const calendarEl = document.getElementById('calendar');
    const calendar = new FullCalendar.Calendar(calendarEl, {
        eventDidMount: function (info) {
            let eventEnd = 'На протяжении всего дня';
            if (!info.event.allDay) {
                eventEnd = moment(info.event.endStr).format('YYYY-MM-DD HH:mm:ss');
            }
            $(info.el).popover({
                title: info.event.title,
                placement: 'top',
                trigger: 'hover',
                content: 'Начало: ' + moment(info.event.startStr).format('YYYY-MM-DD HH:mm') + '\n' +
                    'Окончание: ' + eventEnd,
                container: 'body'
            });
        },
        locale: 'ru',
        initialView: 'dayGridMonth',
        editable: true,
        dayMaxEvents: true,
        nowIndicator: true,
        selectable: true,
        selectHelper: true,
        views: {
            listDay: {buttonText: 'За день'},
            listWeek: {buttonText: 'За неделю'},
            listMonth: {buttonText: 'За месяц'},
            listYear: {buttonText: 'За год'}
        },
        headerToolbar: {
            left: 'dayGridDay,timeGridWeek,dayGridMonth listDay,listWeek,listMonth,listYear',
            center: 'title',
            right: 'today prevYear,prev next,nextYear'
        },
        dateClick: function (start, end) {
            $('#addEvent').modal('toggle');
            $('#saveEventBtn').off("click").on("click", function () {
                const title = $('#title').val();
                const start = $('#start').val();
                const end = $('#end').val();
                const allDay = $('#allDay').val();
                const groupId = $('#groupId').val();
                const backgroundColor = $('#backgroundColor').val();
                const url = $('#url').val();
                const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');
                $.ajax({
                    headers: {
                        'X-CSRF-TOKEN': csrfToken,
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: '/rem/events/api/saveEvent',
                    type: 'POST',
                    data: JSON.stringify({title, start, end, allDay, groupId, backgroundColor, url}),
                    dataType: 'json',
                    success: function (data) {

                        $('#addEvent').modal('hide');
                        calendar.refetchEvents();
                    },
                    error: function (error) {
                        alert('error:' + eval(error));
                    }
                });
            });

        },
        select: function (start, end, allDays) {

        },
        eventDrop: function (info) {
            const msg = confirm("Are you sure about this change?")
            if (msg) {
                const id = info.event.id;
                const title = info.event.title;
                const groupId = info.event.groupId;
                const allDay = info.event.allDay;
                const backgroundColor = info.event.backgroundColor;
                const url = info.event.url;
                const start = moment(info.event.startStr).format('YYYY-MM-DD HH:mm:ss');
                let end = null;
                if (!allDay) {
                    end = moment(info.event.endStr).format('YYYY-MM-DD HH:mm:ss');
                }
                const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');
                $.ajax({
                    headers: {
                        'X-XSRF-TOKEN': csrfToken,
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: 'POST',
                    url: '/rem/events/api/saveEvent',
                    data: JSON.stringify({id, title, start, end, allDay, groupId, backgroundColor, url}),
                    dataType: 'json',
                    traditional: true,
                    success: function (msg) {
                        calendar.refetchEvents();
                    },
                    error: function (msg) {
                        alert('Что-то сломалось, обратитесь куда-нибудь');
                    }
                });
            }
            info.revert();
        },

        eventClick: function (info) {
            const eventId = info.event.id;
            const eventObjUrl = info.event.url;
            console.log(eventId);
            console.log(eventObjUrl);
            if (eventObjUrl) {
                info.jsEvent.preventDefault();
                    $.ajax({
                        type: 'GET',
                        url: info.event.url,
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
                        }
                    });
                $('#fullInfoModal').modal('toggle');
            } else {
                // вызов модального + заполнение полей
                $('#addEvent').modal('toggle');
                $.ajax({
                    type: 'GET',
                    url: '/rem/events/api/findEventById/' + eventId,
                    success: function (editEvent) {
                        $('#addEvent #id').val(editEvent.id)
                        $('#addEvent #dropGroups').val(editEvent.groupId)
                        $('#addEvent #title').val(editEvent.title);
                        $('#addEvent #start').val(editEvent.start);
                        $('#addEvent #end').val(editEvent.end);
                        $('#addEvent #allDay').val(editEvent.allDay);
                        $('#addEvent #groupId').val(editEvent.groupId);
                        $('#addEvent #backgroundColor').val(editEvent.backgroundColor);
                        $('#addEvent #url').val(editEvent.url);
                    },

                });
                //сохранить ивент
                $('#saveEventBtn').off("click").on("click", function () {
                    const id = $('#id').val();
                    const title = $('#title').val();
                    const start = $('#start').val();
                    const end = $('#end').val();
                    const allDay = $('#allDay').val();
                    const groupId = $('#groupId').val();
                    const backgroundColor = $('#backgroundColor').val();
                    const url = $('#url').val();
                    const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');
                    $.ajax({
                        headers: {
                            'X-XSRF-TOKEN': csrfToken,
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        url: '/rem/events/api/saveEvent',
                        type: 'POST',
                        data: JSON.stringify({id, title, start, end, allDay, groupId, backgroundColor, url}),
                        dataType: 'json',
                        success: function (data) {

                            $('#addEvent').modal('hide');
                            calendar.refetchEvents();
                        },
                        error: function (error) {
                            alert('error:' + eval(error));
                        }
                    });
                });
                // удалить ивент
                $('#deleteEventBtn').off("click").on("click", function () {
                    const deleteMsg = confirm("Do you really want to delete?");
                    const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');
                    if (deleteMsg) {
                        $.ajax({
                            headers: {
                                'X-XSRF-TOKEN': csrfToken,
                                'Accept': 'application/json',
                                'Content-Type': 'application/json'
                            },
                            type: "DELETE",
                            url: '/rem/events/api/deleteEvent/' + info.event.id,
                            success: function (response) {
                                $('#addEvent').modal('hide');
                                calendar.refetchEvents();
                            }
                        });
                    }
                });
            }
        },
        events: {
            url: '/rem/events/api/findAllEvents',
            textColor: 'black'
        }


    });
    calendar.render();
});