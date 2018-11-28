function requestNumberOfBooksInCart() {
    var tokenF = localStorage.getItem('token');
    l('requestNumberOfBooksInCart()');
    $.ajax({
        type: 'GET',
        url: '/api/cart/number-of-items',
        contentType: "application/json",
        beforeSend: function (jqXHR) {
            l('Token: ' + tokenF);
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (data) {
            if(data.message != '0'){
            $('#menuRightCartNumber').html(' [' + data.message + ']');
            }
        },
        error: function () {
            console.log("requestNumberOfBooksInCart() error");
        }
    });
}

function addToCart(bookId) {
    l('Entering: addBook(' + bookId + ')');
    var tokenF = localStorage.getItem('token');
    var urlF = '/api/cart/add/' + bookId;
    $.ajax({
        url: urlF,
        type: 'GET',
        contentType: "application/json",
        beforeSend: function (jqXHR, settings) {
            l('Token: ' + tokenF);
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (data, textStatus, jqXHR) {
            l(data);
            requestNumberOfBooksInCart();
        },
        error: function (data, textStatus, jqXHR) {
            l('ERROR: addBook(bookId)');
            l(data);
            l(textStatus);
            requestNumberOfBooksInCart();
        }
    });
}


function showCart() {
    var tokenF = localStorage.getItem('token');
        $.ajax({
            type: 'GET',
            url: '/api/cart/',
        contentType: "application/json",
        beforeSend: function (jqXHR, settings) {
            l('Token: ' + tokenF);
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
           success: function (data) {
                       drawCart(data);
                   }
        });
}

function drawCart(data) {
    var books = "<h1>Cart</h1>";
        data.forEach(function (book) {
            books += (bookComponent(book));
        });
    $('#container').html(books);
}

