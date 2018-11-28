//function requestBook(id) {
//    $.ajax({
//        type: 'GET',
//        url: '/api/books/' + id,
//        dataType: "json",
//        success: function (data) {
//            l(data);
//            return bookComponent(data);
//        },
//        error: function () {
//            console.log("getBook(id) id = " + id);
//            return "";
//        }
//    });
//}

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

// TODO: REDO
function checkAccess(securedURL, successEvent) {
    var tokenF = localStorage.getItem('token');
    var usernameF = localStorage.getItem('username');
    if ((tokenF === null) || (securedURL === null)) {
        console.log('Error ((token === null) || (securedURL === null))');
        var data = {
            error: true,
            message: ""
        };
        successEvent(data);
    } else {
        securedURL = "/authorization/is-available/" + securedURL;
        $.ajax({
            type: 'POST',
            url: securedURL,
            contentType: 'application/json',
            data: JSON.stringify({
                username: usernameF,
                token: tokenF
            }),
            beforeSend: function (jqXHR, settings) {
                console.log('Setting the Authorization Header:', tokenF);
                jqXHR.setRequestHeader('Authorization', tokenF);
            },
            success: function (data) {
                l('checkAccess');
                l(data);
                successEvent(data)
            }
        });
    }
}


function logout() {
    localStorage.clear();
     window.location = '/';
}
