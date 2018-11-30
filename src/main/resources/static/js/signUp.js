function validateForm() {
    var u = document.forms["registrationForm"]["inputUsername"].value;
    var p = document.forms["registrationForm"]["inputPassword"].value;
    var f = document.forms["registrationForm"]["inputFirstName"].value;
    var l = document.forms["registrationForm"]["inputLastName"].value;
    if (u != "" && p != "" && l != "" && f != "") {
        $.ajax({
            url: '/sign-up',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: u,
                password: p,
                firstName: f,
                lastName: l,
            }),
            success: function (result) {
                $('#errorMessage').hide();
                window.location = '/';
            },
            error: function (result) {
                $('#errorMessage').show(200);
            }
        });
    }
    return false;
}