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
            $subcat.find("option").attr("style", "");
            $subcat.val("");
            if (!_rel) return $subcat.prop("disabled", true);
            $subcat.find("[rel~='" + _rel + "']").show();
            $subcat.prop("disabled", false);
            console.log($cat)
            console.log($subcat)
        });
    });


    //редактирование статьи затрат
    $('table .editItemBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/statistic/api/findItem/' + id,
            success: function (item) {
                $('#itemEdit #itemId').val(item.itemId);
                $('#itemEdit #itemName').val(item.itemName);
                console.log(item)
            }
        });

    });

    //редактирование подстатьи затрат
    $('table .editSubItemBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/statistic/api/findSubItem/' + id,
            success: function (item) {
                $('#subItemEdit #subitemId').val(item.subitemId);
                $('#subItemEdit #subitemName').val(item.subitemName);
                $('#subItemEdit #itemsItemId').val(item.itemsItemId);
                $('#subItemEdit #dropItems').val(item.itemsItemId);
                console.log(item)
            }
        });

    });

    //редактирование затрат
    $('table .editOutlayBtn').on('click', function (event) {
        event.preventDefault();
        const id = (this.href.substring(this.href.lastIndexOf('?') + 1));
        $.ajax({
            type: 'GET',
            url: '/rem/statistic/api/findOutlayById/' + id,
            success: function (outlay) {
                $('#outlayEdit #outlayId').val(outlay.outlayId);
                $('#outlayEdit #itemId').val(outlay.itemId);
                $('#outlayEdit #itemsItemId').val(outlay.itemsItemId);
                $('#outlayEdit #itemName').val(outlay.itemName);
                $('#outlayEdit #subitemsSubitemId').val(outlay.subitemsSubitemId);
                $('#outlayEdit #subitemName').val(outlay.subitemName);
                $('#outlayEdit #description').val(outlay.description);
                $('#outlayEdit #price').val(outlay.price);
                $('#outlayEdit #date').val(outlay.date);
                $('#outlayEdit #dropItemsId').val(outlay.date);
                $('#outlayEdit #dropSubItemsId').val(outlay.date);
                console.log(outlay)
            }
        });
    });

    $('#dropItemsEdit').on('change', function () {
        const dropId = $(this).find('option:selected').attr('value');
        console.log(dropId);
        $('#itemsItemIdEditSub').val(dropId);
    });

    $('#dropItemsForSub').on('change', function () {
        const dropId = $(this).find('option:selected').attr('value');
        console.log(dropId);
        $('#itemsItemIdForSub').val(dropId);
    });

    $('#dropItemsId').on('change', function () {
        const dropId = $(this).find('option:selected').attr('value');
        console.log(dropId);
        $('#itemsItemId0').val(dropId);
        $.ajax({
            type: 'GET',
            url: '/rem/statistic/api/findOutlayById/' + id,
            success: function (subItems) {
                $('#dropSubItemsId #outlayId').val(subItems.subitemName);

                console.log(subItems)
            }
        });
    });

    $('#dropSubItemsId').on('change', function () {
        const dropId = $(this).find('option:selected').attr('value');
        console.log(dropId);
        $('#subitemsSubitemId').val(dropId);
    });


});

