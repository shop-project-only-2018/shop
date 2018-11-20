function validateForm() {
    const u = document.forms["registrationForm"]["inputUsername"].value;
    const p = document.forms["registrationForm"]["inputPassword"].value;
    const f = document.forms["registrationForm"]["inputFirstName"].value;
    const l = document.forms["registrationForm"]["inputLastName"].value;
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