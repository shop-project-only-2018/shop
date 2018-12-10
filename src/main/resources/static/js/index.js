function log(message) {
    console.log(message);
}

function l(message) {
    console.log(message);
}

function renderNewBooks(data, elementId) {
    bookslist = "";
    var newBooksDiv = $(elementId).empty();
    data.items.forEach(function (book) {
        newBooksDiv.append(bookComponent(book));
    });
    newBooksDiv.append(paginationComponent(data.pageNumber, data.numberOfPages));
}

function renderPage(pageNumber) {
    loadBooks('api/books/' + pageNumber, "#bestsellers");
}


function renderIndexPage() {
    renderPage(1);
    requestNumberOfBooksInCart();

    //TODO:REDO
    checkAccess('cart', function (a) {
        if (a.error) {
            $('#menuRightCart').hide();
            $('#menuRightLogout').hide();
            $('.bAddToCart').hide();
        } else {
            $('#menuRightSignIn').hide();
            $('#menuRightSignUp').hide();
            $('.bAddToCart').show();
            $('#menuRightCart').html($('#menuRightCart').html() + "<span id=\"menuRightCartNumber\"></span>");
        }
    });
    //
}