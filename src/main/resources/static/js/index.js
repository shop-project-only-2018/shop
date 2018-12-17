function log(message) {
    console.log(message);
}

function l(message) {
    console.log(message);
}

function renderNewBooks(data, elementId) {
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

    getRole();
    
    var topSearchInput = document.getElementById("topSearchInput");
    topSearchInput.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            searchBooks(document.getElementById("topSearchInput").value);
        }
    });
}


function renderMenu(role) {
    var menuContent = "<a href=\"/\" class=\"topmenu\">Books</a>";
    if (role === "NONE") {
        menuContent += "<a id=\"menuRightSignUp\" href=\"/sign-up\" class=\"menuright topmenu\">Sign up</a>";
        menuContent += "<a id=\"menuRightSignIn\" href=\"/sign-in\" class=\"menuright topmenu\">Sign in</a>";
    } else if (role === "USER") {
        menuContent += "<span id=\"menuRightLogout\" onclick=\"logout();\" class=\"menuright topmenu\">Log out</span>";
        menuContent += "<span id=\"menuRightCart\" onclick=\"showCart(); return false;\" class=\"menuright topmenu\">Cart" +
            "<span id=\"menuRightCartNumber\"></span></span>";
    } else if (role === "ADMIN") {
        menuContent += "<span id=\"menuRightLogout\" onclick=\"logout();\" class=\"menuright topmenu\">Log out</span>";
        menuContent += "<a id=\"menuRightAddBook\" href=\"/books/add\" class=\"menuright topmenu\">Add book</a>";
    }
    $('#innermenubar').html(menuContent);
}