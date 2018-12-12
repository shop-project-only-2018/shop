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
                coverId: c
            }),
            beforeSend: function (jqXHR, settings) {
                l('Token: ' + tokenF);
                jqXHR.setRequestHeader('Authorization', tokenF);
            },
            success: function (result) {
                l(result);
                l(result.message);
                $('#errorMessage').hide();
                drawBook(result);
            },
            error: function (result) {
                l(result);
            }
        });
    }
    return false;
}

function uploadImage() {
    var dataF = new FormData();
    var d = $('#image')[0].files[0];
    dataF.append("image", d, d.name);
    for (var pair of dataF.entries()) {
        console.log(pair[0] + ', ' + pair[1]);
    }
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
            l(result);
            if (!result.error) {
                $('#inputCoverId').val(result);
                $('#coverLoaded').html(imageImgComponent(result));
            }
        },
        error: function (result) {
            l(result);
        }
    });
}