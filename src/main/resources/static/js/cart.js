function increaseDisplayedNumber() {
    var numberContainer = $('#menuRightCartNumber');
    if (numberContainer.html() == "") {
        numberContainer.html("1");
    } else {
        numberContainer.html(parseInt(numberContainer.html()) + 1);
    }
}

function addBook(bookId) {
    var tokenF = localStorage.getItem('token');
    var usernameF = localStorage.getItem('username');
    var urlF = '/api/cart/add/' + bookId;
    $.ajax({
        url: urlF,
        type: 'POST',
        dataType: "xml/html/script/json",
        contentType: "application/json",
        data: JSON.stringify({
            username: usernameF,
            token: tokenF
        }),
        beforeSend: function (jqXHR, settings) {
            console.log('Setting the Authorization Header:', tokenF);
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (data) {
            l(data);
        },
        error: function () {
            l('error');
        }
    })
    increaseDisplayedNumber();
}

function addToCart(id) {
    addBook(id);
}


function showCart() {
    var books = "<h1>Cart</h1>";
    ids = JSON.parse(getStoredArray());
    var arrayLength = ids.length;
    for (var i = 0; i < arrayLength; i++) {
        $.ajax({
            type: 'GET',
            url: '/api/books/' + ids[i],
            dataType: "json",
            success: function (data) {
                books += bookComponent(data);
                $('#container').html(books);
            }
        });
    }
}
