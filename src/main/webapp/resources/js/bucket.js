
function addBucket(id) {
    $(".add-bucket-btn")
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