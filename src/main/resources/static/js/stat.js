$(document).ready(function () {
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


});

