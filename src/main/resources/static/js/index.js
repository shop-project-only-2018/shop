function divClassComponent(className, content) {
    return "<div class=\""+ className + "\">" + content + "</div>" ;
}

function buyButtonsComponent() {
    return divClassComponent("buttonBuy", buttonAddToCartText) + divClassComponent("buttonBuy", buttonBuyNowText);
}

function imageTdComponent(url) {
    return "<td class=\"book-table-img\" style=\"background-image: url('" + url + "') !important;\">";
}

function bookComponent(book) {
console.log(book.name);
    return "<div class=\"book\"><table border=\"0\" class=\"book-table\"><tr>"
    + imageTdComponent("/api/images/" + book.coverId) + "</td>"
    + "<td class=\"book-table-main\" valign=\"top\">"
    + divClassComponent("book-name", book.name)
    + divClassComponent("book-author", book.author)
    + divClassComponent("book-description", book.description)
    + buyButtonsComponent()
    + "</td></tr></table></div>";
}

function loadBooks(u, elementId) {
    $.ajax({
        type: 'GET',
        url: u,
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            renderNewBooks(data, elementId);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('Error! Data:', jqXHR.responseJSON);
        }
    });
}
function renderNewBooks(data, elementId) {
    bookslist = "";
    const newBooksDiv = $(elementId).empty();
    data.forEach(function (book, i, arr) {
            newBooksDiv.append(bookComponent(book));
    });
}
function renderPage() {
    loadBooks('api/books/new', '#newBooks');
    loadBooks('api/books/bestsellers', "#bestsellers");
}