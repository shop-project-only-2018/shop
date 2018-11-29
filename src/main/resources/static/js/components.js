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

function spanIdComponent(idName, contents) {
    return "<span id=\"" + idName + "\">" + contents + "</span>";
}

function spanClassIdComponent(className, idName, contents) {
    return "<span class=\"" + className + "\" id=\"" + idName + "\">" + contents + "</span>";
}

function bBuyNow(id) {
    return buttonComponent("buttonBuy bBuyNow", buttonBuyNowText, id, "console.log");
}

function buyButtonsComponent(id) {
    return buttonComponent("buttonBuy bAddToCart", buttonAddToCartText, id, "$(this).text('i18n Added');addToCart");
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
    return buttonComponent("buttonBuy", "i18n Make order", "", "makeOrder");
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


function numberEditComponent(id) {
    return divClassComponent("number-of-items-block",

        buttonComponent("buttonBuy", "-", id, "decreaseNumberOfItems") +
        spanClassIdComponent("number-of-items", "number-of-items-" + id, 1) +
        buttonComponent("buttonBuy", "+", id, "increaseNumberOfItems")
    );
}

function cartInfoComponent() {
    return "<div id=\"cartInfo\">" +
        divIdComponent("cart-statistics") +
        buttonRemoveAllComponent() +
        buttonMakeOrderComponent() + "</div>";
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
    component += numberEditComponent(book.orderItemId);
    component += removeButtonComponent(book.orderItemId)
        + "</td></tr></table></div>";
    return component;
}

function textComponent(id) {
    return "<input type=\"text\" id=\"" + id + "\" />";
}

function makeOrderComponent() {
    return textComponent("addressInput") +
        buttonComponent("buttonBuy", "i18n Make order", '', "completeOrder");
}