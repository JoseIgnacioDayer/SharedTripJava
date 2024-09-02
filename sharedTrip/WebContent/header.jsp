<div class="container-fluid p-0">
    <nav class="navbar navbar-expand-lg navbar-light bg-secondary sticky-top">
        <a class="navbar-brand" href="<%= request.getContextPath() %>/ViajesListado">SharedTrip</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Registrarse</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Iniciar Sesión</a>
                </li>
            </ul>
        </div>
    </nav>
</div>


<style>
.navbar-brand{
	text-decoration: none;
    font-size: 24px;
    font-weight: bold;
    color: #4CAF50;
    margin: 0 0 0 35px;
}
nav{
	margin: auto;
}

a{
	font-color: #4CAF50;
}
a:hover{
	background-color : white;
}

</style>