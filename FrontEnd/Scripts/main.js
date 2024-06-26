document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var password1 = document.getElementById('InputPassword1').value;
    var password2 = document.getElementById('InputPassword2').value;

    if (password1 !== password2) {
        document.getElementById('error-message').style.display = 'block';
        return;
    }

    document.getElementById('error-message').style.display = 'none';

    var formData = new FormData(this);

    fetch('RegistroServlet', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        console.log('Registro exitoso:', data);
        // Aquí podrías redirigir o mostrar un mensaje de éxito
    })
    .catch(error => {
        console.error('Error en el registro:', error);
        // Manejar errores aquí, como mostrar un mensaje de error al usuario
    });
});
