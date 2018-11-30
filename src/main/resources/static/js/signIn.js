function validateForm() {
    var usernameF = document.forms["authenticationForm"]["inputUsername"].value;
    var passwordF = document.forms["authenticationForm"]["inputPassword"].value;
    if (usernameF != "" && passwordF != "") {
        $.ajax({
            url: '/sign-in',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: usernameF,
                password: passwordF
            }),
            success: function (result) {
                var token = result.tokenType + ' ' + result.accessToken;
                var userURI = result.user.userURI;
                var userID = result.user.username;

                localStorage.setItem('token', token);
                localStorage.setItem('userURI', userURI);
                localStorage.setItem('username', userID);
                window.location = '/';
            },
            error: function (result) {
                if (result.message != undefined) {
                    $('#errorMessage').text(result.message);
                }
                $('#errorMessage').show(200);
            }
        });
    }
    return false;
}