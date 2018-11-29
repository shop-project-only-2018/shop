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
//            if (data.message != '0') {
            $('#menuRightCartNumber').html(' [' + data.message + ']');
//            }
        },
        error: function () {
            console.log("requestNumberOfBooksInCart() error");
        }
    });
}

function addToCart(bookId) {
    l('Entering: addToCart(' + bookId + ')');
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

function removeFromCart(bookId) {
    l('Entering: removeFromCart(' + bookId + ')');
    var tokenF = localStorage.getItem('token');
    var urlF = '/api/cart/remove/' + bookId;
    $.ajax({
        url: urlF,
        type: 'GET',
        contentType: "application/json",
        beforeSend: function (jqXHR, settings) {
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (data, textStatus, jqXHR) {
            l(data);
            requestNumberOfBooksInCart();
            showCart();
        },
        error: function (data, textStatus, jqXHR) {
            l('ERROR: removeFromCart(bookId)');
            l(data);
            l(textStatus);
            requestNumberOfBooksInCart();
        }
    });
}


function removeAllFromCart() {
    l('Entering: removeAllFromCart()');
    var tokenF = localStorage.getItem('token');
    var urlF = '/api/cart/remove/all';
    $.ajax({
        url: urlF,
        type: 'GET',
        contentType: "application/json",
        beforeSend: function (jqXHR, settings) {
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (data, textStatus, jqXHR) {
            l(data);
            requestNumberOfBooksInCart();
            window.location = '/';
        },
        error: function (data, textStatus, jqXHR) {
            l('ERROR: removeAllFromCart()');
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
    var books = "<h1>i18n Cart</h1>";
    books += cartInfoComponent();
    data.forEach(function (book) {
        books += (cartBookComponent(book));
    });
    $('#container').html(books);
    showTotalPrice();
}

function showBook(bookId) {
    var tokenF = localStorage.getItem('token');
    $.ajax({
        type: 'GET',
        url: '/api/books/' + bookId,
        contentType: "application/json",
        beforeSend: function (jqXHR, settings) {
            l('Token: ' + tokenF);
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (data) {
            drawBook(data);
        }
    });
}

function drawBook(book) {
    $('#container').html(fullBookComponent(book));
}

function increaseNumberOfItems(id) {
    $("#number-of-items-" + id).text(parseInt($("#number-of-items-" + id).text(), 10) + 1);
    showTotalPrice();
}

function decreaseNumberOfItems(id) {
    if ($("#number-of-items-" + id).text() > 1) {
        $("#number-of-items-" + id).text($("#number-of-items-" + id).text() - 1)
    }
    showTotalPrice();
}

function makeOrder() {
    $('.book .buttonBuy').hide();
    $('#cartInfo').empty();
    $('#cartInfo').html(makeOrderComponent());
}

function completeOrder() {
// TODO:!!!
    //postQuantities();
    var addressF = $('#addressInput').value;
    if (addressF != '') {
        var tokenF = localStorage.getItem('token');
        $.ajax({
            type: 'POST',
            url: '/api/cart/make-order',
            data: JSON.stringify({
                address: addressF
            }),
            contentType: "application/json",
            beforeSend: function (jqXHR, settings) {
                l('Token: ' + tokenF);
                jqXHR.setRequestHeader('Authorization', tokenF);
            },
            success: function (data) {
                alert(data.message);
            }
        });
    }
}

function drawTotalPrice(data) {
    totalPrice = 0;
    data.forEach(function (book) {
        totalPrice += parseInt($("#number-of-items-" + book.orderItemId).text(), 10) * book.price;
    });
    $("#cart-statistics").text("i18n Total price: " + totalPrice);
}

function showTotalPrice() {
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
            drawTotalPrice(data);
        }
    });
}

function sendQuantities(data) {
    l(data);
    l($("#number-of-items-" + data[0].id).text());
    ids = [];
    for (i = 0; i < data.length; i++) {
        ids.push(data[i].id);
    }
    var map = ids.map(id = > $("#number-of-items-" + id).text()
)
    ;
    l(map);
    var addressF = $('#addressInput').value;
    if (addressF != '') {
        var tokenF = localStorage.getItem('token');
        $.ajax({
            type: 'POST',
            url: '/api/cart/items/set-quantity',
            data: JSON.stringify(map),
            contentType: "application/json",
            beforeSend: function (jqXHR, settings) {
                l('Token: ' + tokenF);
                jqXHR.setRequestHeader('Authorization', tokenF);
            },
            success: function (data) {
                alert(data.message);
            }
        });
    }
}

function postQuantities() {
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
            sendQuantities(data);
        }
    });
}