<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles/style.css">
    <title>Dashboard Medicos</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Dashboard Medicos</a>
        <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="main.html">Citas</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="consultorios.html">Consultorios</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="medicos.html">Médicos</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="tratamientos.html">Tratamientos</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="row card-container">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Sistema de Agendamiento de Citas</h5>
                    <p class="card-text">Con esta herramienta, puedo visualizar fácilmente el calendario completo de citas, verificar disponibilidades y programar nuevas consultas con solo unos clics. Esto no solo reduce la posibilidad de errores en la programación, sino que también optimiza mis horarios, permitiéndome dedicar más tiempo a la atención directa de los pacientes.</p>
                    <a href="#" class="btn btn-primary">Ver Manual</a>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="InputEmail1">Ingresa tu email</label>
                            <input type="email" required class="form-control" id="InputEmail1" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="InputPassword1">Ingresa tu contraseña</label>
                            <input type="password" required class="form-control" id="InputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="InputPassword2">Confirma tu contraseña</label>
                            <input type="password" required class="form-control" id="InputPassword2" placeholder="Confirm Password">
                        </div>
                        <div id="error-message" style="color: red; display: none;">Las contraseñas no coinciden</div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <h2 style="padding: .5rem;">Lista de Pacientes</h2>

    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
        </tbody>
    </table>

    <script src="Scripts/main.js"></script>
</body>
</html>
