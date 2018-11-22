function buyButtonsComponent() {
    return "<div class=\"buttonBuy\">\n" + buttonAddToCartText +
        "</div><div class=\"buttonBuy\">\n" + buttonBuyNowText + "</div>"
}


function bookComponent(book) {
    return "<div class=\"book\">\n" +
        "<div class=\"bookname\">\n" + book.name +
        "</div>" + buyButtonsComponent() + "</div>"
}

function loadBooks(u, elementId) {
    $.ajax({
        type: 'GET',
        url: u,
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            console.log('Accepted Data:', data);
            renderNewBooks(data, elementId);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('Accepted Error Data:', jqXHR.responseJSON);
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