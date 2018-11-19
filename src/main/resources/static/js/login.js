function validateForm() {
    const usernameF = document.forms["authenticationForm"]["inputUsername"].value;
    const passwordF = document.forms["authenticationForm"]["inputPassword"].value;
    if (usernameF != "" && passwordF != "") {
$.ajax({
    url: '/login',
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify({
        username: usernameF,
        password: passwordF,
    }),
    success: function(result) {
        alert('success');
    },
    error: function(result) {
        alert('failure');
    }
});
    }
    return false;
}