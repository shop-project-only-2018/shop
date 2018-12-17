function loadBooks(u, elementId) {
    $.ajax({
        type: 'GET',
        url: u,
        dataType: "json",
        success: function (data) {
            renderNewBooks(data, elementId);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('Error! Data:', jqXHR.responseJSON);
        }
    });
}

function searchBooks(str) {
    l('api/books/search/' + str);
    $.ajax({
        type: 'GET',
        url: 'api/books/search/' + str,
        dataType: "json",
        success: function (data) {
            renderNewBooks(data, "#content");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('Error! Data:', jqXHR.responseJSON);
        }
    });
}

function checkToken(securedURL, successEvent, errorHandler) {
    var token = localStorage.getItem('token');
    if ((token === null) || (securedURL === null)) {
        l(token);
        l(securedURL);
        console.log('Error ((token === null) || (securedURL === null))');
    } else {
        $.ajax({
            type: 'GET',
            url: securedURL,
            dataType: 'json',
            beforeSend: function (jqXHR, settings) {
                console.log('Setting the Authorization Header:', token);
                jqXHR.setRequestHeader('Authorization', token);
            },
            success: function (data, textStatus, jqXHR) {
                console.log('Accepted Data:', data);
                successEvent(data)
            },
            error: function (jqXHR, textStatus, errorThrown) {
                l('error');
                if (errorHandler != undefined) {
                    errorHandler(jqXHR.responseJSON);
                }
            }
        })
    }
}

function getRole() {
    var tokenF = localStorage.getItem('token');
    var securedURL = '/api/get-menu';
    $.ajax({
        type: 'GET',
        url: securedURL,
        contentType: 'application/json',
        beforeSend: function (jqXHR, settings) {
            console.log('Setting the Authorization Header:', tokenF);
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (data) {
            l(data);
            renderMenu(data);
        }
    });
}


function logout() {
    localStorage.clear();
    window.location = '/';
}
