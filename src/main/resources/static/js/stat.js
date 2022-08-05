$(document).ready(function () {

    $('#stats').DataTable({
        language: {
            url: './localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });
    $('#itms').DataTable({
        language: {
            url: './localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });
    const groupColumn = 2;
    const table = $('#subitms').DataTable({
        columnDefs: [{visible: false, targets: groupColumn}],
        order: [[groupColumn, 'asc']],
        displayLength: 25,
        drawCallback: function (settings) {
            const api = this.api();
            const rows = api.rows({page: 'current'}).nodes();
            let last = null;

            api
                .column(groupColumn, {page: 'current'})
                .data()
                .each(function (group, i) {
                    if (last !== group) {
                        $(rows)
                            .eq(i)
                            .before('<tr class="group"><td colspan="5">' + group + '</td></tr>');

                        last = group;
                    }
                });
        },
        language: {
            url: './localisation/ru.json'
        },
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    });
    // Order by the grouping
    $('#subitms tbody').on('click', 'tr.group', function () {
        const currentOrder = table.order()[0];
        if (currentOrder[0] === groupColumn && currentOrder[1] === 'asc') {
            table.order([groupColumn, 'desc']).draw();
        } else {
            table.order([groupColumn, 'asc']).draw();
        }
    });

    // для выбора добавления статьи\подстатьи
    $('input[type="radio"]').click(function () {
        let inputValue = $(this).attr("value");
        const targetBox = $("." + inputValue);
        $(".box").not(targetBox).hide();
        $(targetBox).show();
        window.onload;
    });

    //зависимое выпадающее меню для добавления новых затрат
    $(function(){
        const $cat = $("#dropItemsItemId"),
              $subcat = $("#dropSubItems");
        $cat.on("change",function(){
            const _rel = $(this).val();
            $subcat.find("option").attr("style","");
            $subcat.val("");
            if(!_rel) return $subcat.prop("disabled",true);
            $subcat.find("[rel~='"+_rel+"']").show();
            $subcat.prop("disabled",false);
            console.log($cat)
            console.log($subcat)
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

    window.update6 = function () {
        const select = document.getElementById('dropItems');
        const option = select.options[select.selectedIndex];
        document.getElementById('itemsItemId').value = option.value;
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
                const itemsDD = $("#dropItemsId");
                $.each(responseJson, function (index, items) {
                    $("<option>").val(items.itemId).text(items.itemName).appendTo(itemsDD);
                });
            });
    }


    $('#dropItemsId').on('change', function (){

        let idd = $(this).val();
        console.log(idd);
        const urlString1 = "/rem/statistic/api/subItemsByItemsId?itemsItemId=" + idd;
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
    })

});

