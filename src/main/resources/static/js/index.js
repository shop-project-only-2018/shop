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
    localStorage.clear();
    loadBooks('api/books/new', '#newBooks');
    loadBooks('api/books/bestsellers', "#bestsellers");
    $('#menuRightCart').html($('#menuRightCart').html() + "<span id=\"menuRightCartNumber\"></span>");
}