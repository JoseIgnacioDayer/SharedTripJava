<%@ page import="java.util.LinkedList"%>
<%@ page import="entidades.Usuario" %>
<%@ page import="entidades.Rol" %>
<%@ page import="logic.RolController" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
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

<h2 class="my-4">Listado de Usuarios</h2>
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
                <th scope="col">Usuario</th>
                <th scope="col">Nombre</th>
                <th scope="col">Correo</th>
                <th scope="col">Teléfono</th>
                <th scope="col">Rol</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                LinkedList<Usuario> usuarios= (LinkedList<Usuario>) request.getSession().getAttribute("usuarios");
                if (usuarios != null && !usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
            %>
            <tr>
                <td><%= usuario.getUsuario() %></td>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getCorreo() %></td>
                <td><%= usuario.getTelefono() %></td>
                <%
                {
                	RolController rolCtrl = new RolController();
                	Rol rol = rolCtrl.getOne(usuario.getRol());
                	%>
                	<td><%= rol.getNombre() %></td>
                <% 
                }
                %>
                <td>
                <form 
            			action="BajaUsuarioAdmin" method="post">
            			<input type="hidden" name="id_usuario" value="<%= usuario.getIdUsuario() %>">
           			    <button type="submit" class="btn btn-danger">Eliminar Usuario</button>
                 </form> 
                </td> 
                
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8" class="text-center">No existen usuarios registrados</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    
    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#nuevoUsuario">
  	Nuevo Usuario
	</button>
	
	
    
    <div class="row align-items-end" style="height: 10vh">
            <div class="col">
                <jsp:include page="footer.jsp"></jsp:include>
            </div>
        </div>
        
        
  <!--  MODALES  -------------------------------------------------------->
  
 <div class="modal fade" id="nuevoUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="nuevoUsuario">Nuevo Usuario</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="RegistrarUsuarioAdmin" id="registrarUsuarioAdmin">
				
			      <label for="nombre">Nombre</label>
			      <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
			    
			   
			      <label for="apellido">Apellido</label>
			      <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido" required>
			    
			    
			      <label for="correo">Correo Electrónico</label>
			      <input type="email" class="form-control" id="correo" name="correo" placeholder="Correo Electrónico" required>
			    
			      <label for="usuario">Usuario</label>
			      <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario" required>
			  
			    
			      <label for="clave">Clave</label>
			      <input type="password" class="form-control" id="clave" name="clave" placeholder="Clave" required>
			  
			    
			      <label for="telefono">Teléfono</label>
			      <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Teléfono" required>
			   
			   	  <label for="rol">Rol</label>
			   	    <select id="rol" name="rol" class="form-control" required>
				        <% 
				            LinkedList<Rol> roles = (LinkedList<Rol>)request.getSession().getAttribute("roles");  
				           for (Rol rol : roles) {
				        %>
				            <option value="<%= rol.getIdRol() %>"><%= rol.getNombre() %></option>
				        <% 
				        		}
				         %>
				    </select>
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
    
    var form = document.getElementById("registrarUsuarioAdmin");

    form.submit();
    
    var modal = bootstrap.Modal.getInstance(document.getElementById("nuevoUsuario"));
    modal.hide();
}
</script>
 
  
</body>
</html>