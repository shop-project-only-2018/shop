function requestBook(id) {
        $.ajax({
            type: 'GET',
            url: '/api/books/' + id,
            dataType: "json",
            success: function (data) {
                l(data);
                return bookComponent(data);
            },
            error: function () {
                return "";
                console.log("getBook(id) id = " + id);
            }
        });
}

function loadBooks(u, elementId) {
    $.ajax({
        type: 'GET',
        url: u,
        dataType: "json",
        success: function (data) {
            renderNewBooks(data, elementId);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('Error! Data:', jqXHR.responseJSON);
        }
    });
}