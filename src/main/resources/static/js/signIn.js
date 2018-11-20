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
    success: function(result) {
        $('#errorMessage').hide();
        window.location = '/';
    },
    error: function(result) {
        $('#errorMessage').show(200);
    }
});
    }
    return false;
}