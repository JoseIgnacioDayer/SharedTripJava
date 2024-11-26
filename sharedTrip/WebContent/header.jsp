<div class="container-fluid p-0">
    <nav class="navbar navbar-expand-lg navbar-light bg-secondary sticky-top">
        <a class="navbar-brand" href="<%= request.getContextPath() %>/">SharedTrip</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">

            <ul class="navbar-nav">
                <% if(request.getSession().getAttribute("usuario") != null) { %>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="<%= request.getContextPath() %>/misViajes">Mis Viajes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="<%= request.getContextPath() %>/misReservas">Mis Reservas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="<%= request.getContextPath() %>/misVehiculos">Mis Vehículos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="<%= request.getContextPath() %>/usuarios">Usuarios</a>
                    </li>
                <% } %>
            </ul>

            <ul class="navbar-nav ms-auto">
                <% if(request.getSession().getAttribute("usuario") == null) { %>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="register.jsp">Registrarse</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="login.jsp">Iniciar Sesión</a>
                    </li>
                <% } else { %>
                    <li class="nav-item">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <%= request.getSession().getAttribute("nombre") + " " + request.getSession().getAttribute("apellido") %>
                            </button>
                            <div class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/CerrarSesion">Cerrar Sesión</a>
                            </div>
                        </div>
                    </li>
                <% } %>
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