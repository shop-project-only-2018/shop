function buttonComponent(className, content, id, f) {
    return "<span class=\"" + className + "\" onclick=\"" + f + "(" + id + ");\">" + content + "</span>";
}

function divClassComponent(className, content) {
    return "<div class=\"" + className + "\">" + content + "</div>";
}

function divClassOnclickComponent(className, content, oncl, arg) {
    return "<div class=\"" + className + "\" onclick=\"" + oncl + "(" + arg + ");\">" + content + "</div>";
}

function divIdComponent(idName) {
    return "<div id=\"" + idName + "\"></div>";
}

function buyButtonsComponent(id) {
    return buttonComponent("buttonBuy bAddToCart", buttonAddToCartText, id, "addToCart")
        + buttonComponent("buttonBuy bBuyNow", buttonBuyNowText, id, "console.log");
}

function removeButtonComponent(id) {
    return buttonComponent("buttonBuy bRemoveFromCart", "i18n Remove", id, "removeFromCart");
}

function imageTdComponent(url) {
    return "<td class=\"book-table-img\" style=\"background-image: url('" + url + "') !important;\">";
}

function bookComponent(book) {

    component = "<div class=\"book\"><table border=\"0\" class=\"book-table\"><tr>"
        + imageTdComponent("/api/images/" + book.coverId) + "</td>"
        + "<td class=\"book-table-main\" valign=\"top\">"
        + divClassOnclickComponent("book-name", book.name, "showBook", book.id)
        + divClassComponent("book-author", book.author);
    if (book.price != undefined) {
        component += divClassComponent("book-price", '$' + book.price);
    }
    if (book.description != undefined) {
        component += divClassComponent("book-description", book.description);
    }
//        + divIdComponent('book-bottom-' + book.id)
    component += buyButtonsComponent(book.id)
        + "</td></tr></table></div>";
    return component;
}

function buttonMakeOrderComponent() {
    //   buttonComponent("buttonBuy", "i18n Make order", id, f);
}

function buttonRemoveAllComponent() {
    return buttonComponent("buttonBuy", "i18n Remove all", "", "removeAllFromCart");
}


function fullBookComponent(book) {

    component = "<div class=\"book\"><table border=\"0\" class=\"book-table\"><tr>"
        + imageTdComponent("/api/images/" + book.coverId) + "</td>"
        + "<td class=\"book-table-main\" valign=\"top\">"
        + divClassOnclickComponent("book-name", book.name, "showBook", book.id)
        + divClassComponent("book-author", book.author);
    component += divClassComponent("book-price", '$' + book.price);
    component += divClassComponent("book-description", book.description);
    component += buyButtonsComponent(book.id)
        + "</td></tr></table></div>";
    return component;
}


function cartBookComponent(book) {

    component = "<div class=\"book\"><table border=\"0\" class=\"book-table\"><tr>"
        + imageTdComponent("/api/images/" + book.coverId) + "</td>"
        + "<td class=\"book-table-main\" valign=\"top\">"
        + divClassOnclickComponent("book-name", book.name, "showBook", book.id)
        + divClassComponent("book-author", book.author);
    if (book.price != undefined) {
        component += divClassComponent("book-price", '$' + book.price);
    }
    if (book.description != undefined) {
        component += divClassComponent("book-description", book.description);
    }
//        + divIdComponent('book-bottom-' + book.id)
    component += buyButtonsComponent(book.id)
        + removeButtonComponent(book.orderItemId)
        + "</td></tr></table></div>";
    return component;
}