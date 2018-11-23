var bookIds = "bookIds";

localStorage.removeItem(bookIds);

function increaseDisplayedNumber() {
    var numberContainer = $('#menuRightCartNumber');
    if (numberContainer.html() == "") {
        numberContainer.html("1");
    } else {
        numberContainer.html( parseInt(numberContainer.html()) + 1 );
    }
}

function getStoredArray() {return localStorage.getItem(bookIds);}
function storedArrayExists() {
    if (getStoredArray() === null) {
        return false;
    } else {
        return true;
    }
}

function addBook(id) {
    var storedIds;
    if (storedArrayExists()) {
        storedIds = JSON.parse(getStoredArray());
        if(id in storedIds) {
            return false;
        }
    } else {
        storedIds = [];
    }
        storedIds.push(id);
        localStorage.setItem(bookIds, JSON.stringify(storedIds));
     increaseDisplayedNumber();
}

function addToCart(id) {
    addBook(id);
}


function showCart() {
    var books = "<h1></h1>";
    ids = JSON.parse(getStoredArray());
    var arrayLength = ids.length;
    for (var i = 0; i < arrayLength; i++) {
            $.ajax({
                type: 'GET',
                url: '/api/books/' + ids[i],
                dataType: "json",
                success: function (data) {
                    books += bookComponent(data);
                    $('#container').html(books);
                }
            });
    }
}
