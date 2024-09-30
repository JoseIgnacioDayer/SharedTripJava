<%@ page import="entidades.Viaje"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SharedTrip</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	
</head>

    <div class="container-fluid p-0">
        <div class="row align-items-start" style="height: 10vh">
            <div class="col">
                <jsp:include page="header.jsp"></jsp:include>
            </div>
        </div>
        <div class="row align-items-center" style="height: 80vh">
            <div class="container">
            
            <% 
			    String reservado = request.getParameter("reservado");
			    if ("true".equals(reservado)) { 
			%>
			    <div class="alert alert-success" role="alert">
			        ¡Reserva realizada con éxito!
			    </div>
			<% 
			    } 
			%>
                <h2 class="my-4">Lista de Viajes</h2>
                <div class="row">
                    <%
                        LinkedList<Viaje> viajes = (LinkedList<Viaje>) request.getAttribute("viajes");
                        if (viajes != null && !viajes.isEmpty()) {
                            for (Viaje viaje : viajes) {
                    %>
                    <div class="col-md-3 mb-4">
                        <div class="card">
             
                            <div class="card-body">
                                <h5 class="card-title"><%= viaje.getDestino() %></h5>
                                <p class="card-text">Origen: <%= viaje.getOrigen() %></p>
                                <p class="card-text">Fecha: <%= viaje.getFecha() %></p>
                                <p class="card-text">Lugares Disponibles: <%= viaje.getLugares_disponibles() %></p>
                                <form action="reservar" method="post">
                    				<input type="hidden" name="viajeId" value="<%= viaje.getIdViaje() %>">
                    				<input type="number" name="cantPasajeros" min="1" max="<%= viaje.getLugares_disponibles()%>" value="1" required>
                    				<button type="submit" class="btn btn-success">Reservar</button>
                			</form>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        } else {
                    %>
                    <div class="col-12">
                        <p>No hay viajes disponibles.</p>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        <div class="row align-items-end" style="height: 10vh">
            <div class="col">
                <jsp:include page="footer.jsp"></jsp:include>
            </div>
        </div>
    </div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>