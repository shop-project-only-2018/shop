function validateForm() {
    var t = document.forms["addBookForm"]["inputBookTitle"].value;
    var fn = document.forms["addBookForm"]["inputAuthorFN"].value;
    var ln = document.forms["addBookForm"]["inputAuthorLN"].value;
    var p = document.forms["addBookForm"]["inputPrice"].value;
    var q = document.forms["addBookForm"]["inputQuantity"].value;
    var d = document.forms["addBookForm"]["inputDescription"].value;
    var c = document.forms["addBookForm"]["inputCoverId"].value;
    if (t != "" && fn != "" && ln != "" && p != "" && q != "" && d != "") {
        var tokenF = localStorage.getItem('token');
        l(JSON.stringify({
            title: t,
            description: d,
            authorFN: fn,
            authorLN: ln,
            price: p,
            quantity: q,
            coverId: c
        }));
        $.ajax({
            url: '/admin/books/add',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                title: t,
                description: d,
                authorFN: fn,
                authorLN: ln,
                price: p,
                quantity: q,
            }),
            beforeSend: function (jqXHR, settings) {
                l('Token: ' + tokenF);
                jqXHR.setRequestHeader('Authorization', tokenF);
            },
            success: function (result) {
            l(result);
                l(result.message);
                $('#errorMessage').hide();
//                window.location = '/';
            },
            error: function (result) {
            }
        });
    }
    return false;
}

function uploadImage() {
    var dataF = new FormData($('#addCoverForm'));
    l(dataF);
    var tokenF = localStorage.getItem('token');
    $.ajax({
        url: '/api/images',
        type: 'POST',
        processData: false,
        contentType: false,
        cache: false,
        data: dataF,
        beforeSend: function (jqXHR, settings) {
            l('Token: ' + tokenF);
            jqXHR.setRequestHeader('Authorization', tokenF);
        },
        success: function (result) {
        if(!result.error){
            document.forms["addBookForm"]["inputCoverId"].value = result.message;
        }},
        error: function (result) {
        }
    });
}