function log(message) {
    console.log(message);
}

function l(message) {
    console.log(message);
}

function renderNewBooks(data, elementId) {
    bookslist = "";
    var newBooksDiv = $(elementId).empty();
    data.forEach(function (book) {
        newBooksDiv.append(bookComponent(book));
    });
}

function renderPage() {
    loadBooks('api/books/new', '#newBooks');
    loadBooks('api/books/bestsellers', "#bestsellers");


    //TODO:REDO
    checkAccess('cart', function (a) {
        if (a.error) {
            $('#menuRightCart').hide();
            $('#menuRightLogout').hide();
            $('.bAddToCart').hide();
//        $('#menuRightSignIn').show(200);
//        $('#menuRightSignUp').show(200);
        } else {
            $('#menuRightSignIn').hide();
            $('#menuRightSignUp').hide();
            $('.bAddToCart').show();
            $('#menuRightCart').html($('#menuRightCart').html() + "<span id=\"menuRightCartNumber\"></span>");
//        $('#menuRightCart').show(200);
//        $('#menuRightLogout').show(200);
        }
    });
    //
}