
function addBucket(id) {
    $.ajax({
        url: "/bucket/addProduct",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            alert('Товар успешно добавлен в корзину');
            return true;
        }
    })
}

function changeNumberProduct(id) {
    var numberProduct = $('#numberProduct'+id).val();
    $.ajax({
        url: "/bucket/changeNumberProduct",
        type: "POST",
        data: {
            id: id,
            number: numberProduct
        },
        success: function () {
            alert('Изменено');
            return true;
        }
    })
}