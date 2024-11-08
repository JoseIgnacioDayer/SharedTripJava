<%@ page import="java.util.LinkedList"%>
<%@ page import="entidades.Vehiculo" %>
<%@ page import="entidades.Usuario" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mis Vehiculos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid p-0">
	<div class="row align-items-start" style="height: 10vh">
         <div class="col">
             <jsp:include page="header.jsp"></jsp:include>
         </div>
    </div>
</div>

<h2 class="my-4">Mis Vehículos</h2>
            <% 
       
	        	String mensaje = (String) session.getAttribute("mensaje");
	        	if (mensaje != null) {
    		%>
	        	<div class="alert alert-info">
	            	<%= mensaje %>
	        	</div>
    		<%
	            session.removeAttribute("mensaje");
	        	}
   			 %>
        <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th scope="col">ID Vehiculo</th>
                <th scope="col">Patente</th>
                <th scope="col">Modelo</th>
                <th scope="col">Anio</th>
                <th scope="col">Id usuario dueño</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                LinkedList<Vehiculo> vehiculos= (LinkedList<Vehiculo>) request.getSession().getAttribute("misvehiculos");
                if (vehiculos != null && !vehiculos.isEmpty()) {
                    for (Vehiculo vehiculo : vehiculos) {
            %>
            <tr>
                <td><%= vehiculo.getId_vehiculo() %></td>
                <td><%= vehiculo.getPatente() %></td>
                <td><%= vehiculo.getModelo() %></td>
                <td><%= vehiculo.getAnio() %></td>
                <td><%= vehiculo.getUsuario_duenio_id() %></td>
                <td> <form 
                			action="bajaVehiculo" method="post">
                			<input type="hidden" name="id_vehiculo" value="<%= vehiculo.getId_vehiculo() %>">
               			    <button type="submit" class="btn btn-danger">Eliminar Vehiculo</button>
                     </form> 
                </td> 
                
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8" class="text-center">El usuario no posee vehiculos registrados.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    
    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#nuevoVehiculo">
  	Nuevo Vehiculo
	</button>
	
	
    
    
    	
    <!--  Modal  ---------------------------------------------------------------------------------------------------->


<!-- #nuevoVehiculo -->
<div class="modal fade" id="nuevoVehiculo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="nuevoVehiculo">Nuevo Vehiculo</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method = "post" action="altaVehiculo" id="altaVehiculo">
        	<label for="patente">
        		Patente
        	</label> <br>
        	<input type= "text" name="patente" placeholder = "Ingrese su patente" id="patente"> <br>
        	
        	<label for="modelo">
        		Modelo
        	</label> <br>
        	<input type= "text" name="modelo" placeholder = "Ingrese el modelo" id="modelo"> <br>
        	
        	<label for="anio">
        		Año
        	</label> <br>
        	<input type= "number" min="1960" max="2024" name="anio" placeholder = "Ingrese el año" id="anio"> <br>
        	
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button type="submit" class="btn btn-primary" onclick = "envioFormulario()">Guardar</button>
      </div>
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script type="text/javascript">
function envioFormulario() {
    // Obtener el formulario por su ID
    var form = document.getElementById("altaVehiculo");

    // Enviar el formulario
    form.submit();
    
    var modal = bootstrap.Modal.getInstance(document.getElementById("nuevoVehiculo"));
    modal.hide();
}
</script>
</body>
<div class="row align-items-end" style="height: 10vh">
    <div class="col">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</div>
</html>