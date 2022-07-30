document.addEventListener('DOMContentLoaded', function() {
    $('#addEvent').modal('hide').on('hidden.bs.modal', function () {
        $(this).find('form').trigger('reset');
    })
    $('#allDay').change(function() {
        $(this).val($(this).prop('checked'));
        console.log('current value of checkbox:', $(this).val())
    })
    const calendarEl = document.getElementById('calendar');
    const calendar = new FullCalendar.Calendar(calendarEl, {
        locale: 'ru',
        initialView: 'dayGridMonth',
        editable: true,
        dayMaxEvents: true,
        nowIndicator: true,
        selectable: true,
        // selectHelper: true,
        weekNumbers: true,
        views: {
            listDay: { buttonText: 'В течении дня' },
            listWeek: { buttonText: 'В течении недели' },
            listMonth: { buttonText: 'В течении месяца' },
            listYear:{buttonText: 'В течении года'}
        },
        headerToolbar: {
            left: 'dayGridDay,timeGridWeek,dayGridMonth listDay,listWeek,listMonth,listYear',
            center: 'title',
            right: 'today prevYear,prev next,nextYear'
        },
        // eventDidMount: function(info) {
        //     const tooltip = new Tooltip(info.el, {
        //         title: info.event.extendedProps.description,
        //         placement: 'top',
        //         trigger: 'hover',
        //         container: 'body'
        //     });
        // },
        dateClick: function(info) {
            $('#addEvent').modal('toggle');

            $('#saveEventBtn').click(function() {
                const title = $('#title').val();
                const start = $('#start').val();
                const end = $('#end').val();
                const allDay = $('#allDay').val();
                const groupId = $('#groupId').val();
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url:'/rem/events/api/saveEvent',
                    type:'POST',
                    data: JSON.stringify({ title, start, end, allDay}),
                    dataType:'json',
                    success:function(data)
                    {
                        $('#addEvent').modal('hide').on('hidden.bs.modal', function () {
                            $(this).find('form').trigger('reset');
                        })
                    },
                    error:function (error){
                     alert('error:'+eval(error));
                    }
                });
            });
        },
        // select: function(start, end, allDays) {
        //     $('#addEvent').modal('toggle');
        // },
        eventDrop: function(info) {
            if (!confirm("Are you sure about this change?")) {
                info.revert();
            }
            const id = info.event.id;
            const title = info.event.title;
            const start = moment(info.event.startStr).format('YYYY-MM-DD HH:mm:ss');
            const end = moment(info.event.endStr).format('YYYY-MM-DD HH:mm:ss');
            const allDay = info.event.allDay;
            const groupId = info.event.groupId;
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type:'POST',
                url:'/rem/events/api/saveEvent',
                data:JSON.stringify({id, title, start, end, allDay, groupId}),
                dataType:'json',
                traditional:true,
                success:function(msg){
                    console.log(msg);
                },
                error:function(msg){
                    console.log(msg);
                    alert('We are unable to process your request');
                }
            });

        },

        events:{
            url: '/rem/events/api/findAllEvents',
        }


    });
    calendar.render();
});