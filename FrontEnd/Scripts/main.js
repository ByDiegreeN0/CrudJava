document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Previene el envío del formulario

    const password1 = document.getElementById('InputPassword1').value;
    const password2 = document.getElementById('InputPassword2').value;
    const errorMessage = document.getElementById('error-message');

    if (password1 !== password2) {
        errorMessage.style.display = 'block';
    } else {
        errorMessage.style.display = 'none';
    }
});
