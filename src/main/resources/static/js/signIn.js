function validateForm() {
    const usernameF = document.forms["authenticationForm"]["inputUsername"].value;
    const passwordF = document.forms["authenticationForm"]["inputPassword"].value;
    if (usernameF != "" && passwordF != "") {
        $.ajax({
            url: '/sign-in',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: usernameF,
                password: passwordF,
            }),
            success: function (result) {
                        const token = result.tokenType + ' ' + result.accessToken;
                        const userURI = result.user.userURI;
                        const userID = result.user.username;

                        localStorage.setItem('token', token);
                        localStorage.setItem('userURI', userURI);
                        localStorage.setItem('username', userID);

//                        l(localStorage.getItem('token', token));
//                        l(localStorage.getItem('userURI', userURI));
//                        l(localStorage.getItem('userID', userID));
                     //   window.location = '/';
            },
            error: function (result) {
                if(result.message != undefined) {
                    $('#errorMessage').text(result.message);
                }
                $('#errorMessage').show(200);
            }
        });
    }
    return false;
}