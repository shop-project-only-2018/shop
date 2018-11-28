function buttonComponent(className, content, id, f) {
    return "<span class=\"" + className + "\" onclick=\"" + f + "(" + id + ");\">" + content + "</span>";
}

function divClassComponent(className, content) {
    return "<div class=\"" + className + "\">" + content + "</div>";
}

function divIdComponent(idName) {
    return "<div id=\"" + idName + "\"></div>";
}

function buyButtonsComponent(id) {
    return buttonComponent("buttonBuy bAddToCart", buttonAddToCartText, id, "addToCart")
        + buttonComponent("buttonBuy bBuyNow", buttonBuyNowText, id, "console.log");
}

function imageTdComponent(url) {
    return "<td class=\"book-table-img\" style=\"background-image: url('" + url + "') !important;\">";
}

function bookComponent(book) {

    component = "<div class=\"book\"><table border=\"0\" class=\"book-table\"><tr>"
        + imageTdComponent("/api/images/" + book.coverId) + "</td>"
        + "<td class=\"book-table-main\" valign=\"top\">"
        + divClassComponent("book-name", book.name)
        + divClassComponent("book-author", book.author);
        if(book.description!=undefined){
        component+= divClassComponent("book-description", book.description);}
//        + divIdComponent('book-bottom-' + book.id)
component+= buyButtonsComponent(book.id)
        + "</td></tr></table></div>";
        return component;
}
