<%@ page import="java.util.LinkedList" %>
<%@ page import="entidades.Viaje" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Mis Viajes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid p-0">
        <div class="row align-items-start" style="height: 10vh">
            <div class="col">
                <jsp:include page="header.jsp"></jsp:include>
            </div>
        </div>
	<div class="row m-5 align-items-center" style="height: 80vh">
	
    <h1 class="text-center mb-1">Listado de Viajes</h1>
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
                <th scope="col">ID Viaje</th>
                <th scope="col">Origen</th>
                <th scope="col">Destino</th>
                <th scope="col">Fecha</th>
                <th scope="col">Lugares Disponibles</th>
                <th scope="col">Precio Unitario</th>
                <th scope="col">Lugar de Salida</th>
                <th scope="col">Cancelado</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                LinkedList<Viaje> viajes = (LinkedList<Viaje>) request.getSession().getAttribute("misviajes");
                if (viajes != null && !viajes.isEmpty()) {
                    for (Viaje viaje : viajes) {
            %>
            <tr>
                <td><%= viaje.getIdViaje() %></td>
                <td><%= viaje.getOrigen() %></td>
                <td><%= viaje.getDestino() %></td>
                <td><%= viaje.getFecha() %></td>
                <td><%= viaje.getLugares_disponibles() %></td>
                <td>$<%= viaje.getPrecio_unitario() %></td>
                <td><%= viaje.getLugar_salida() %></td>
                <td><%= viaje.isCancelado() ? "Sí" : "No" %></td>
                <td>                               
                 	<form action="cancelarViaje" method="post">
                    	<input type="hidden" name="viajeId" value="<%= viaje.getIdViaje() %>">		
                    	<button type="submit" class="btn btn-danger" <% if (viaje.isCancelado()) {%> disabled <%} %>>Cancelar</button>
                	</form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8" class="text-center">No existen viajes.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    </div>
    <div class="row align-items-end" style="height: 10vh">
            <div class="col">
                <jsp:include page="footer.jsp"></jsp:include>
            </div>
        </div>
    </div>
    
   

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>