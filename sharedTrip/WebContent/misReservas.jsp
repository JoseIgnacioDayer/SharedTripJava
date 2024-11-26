<%@ page import="entidades.Reserva"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="entidades.Viaje" %>
<%@ page import="entidades.Usuario" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mis Reservas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
<div class="container-fluid p-0">
	<div class="row align-items-start" style="height: 10vh">
         <div class="col">
             <jsp:include page="header.jsp"></jsp:include>
         </div>
    </div>
        <h2 class="my-4">Mis Reservas</h2>
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
        <div class="row">
            <%
                LinkedList<Reserva> reservas = (LinkedList<Reserva>) request.getSession().getAttribute("misreservas");
                if (reservas != null && !reservas.isEmpty()) {
                    for (Reserva reserva : reservas) {
            %>
            <div class="col-md-3 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Destino: <%= reserva.getViaje().getDestino() %></h5>
                        <p class="card-text">Fecha de Reserva: <%= reserva.getFecha_reserva() %></p>
                        <p class="card-text">Fecha de Viaje: <%= reserva.getViaje().getFecha() %></p>
                        <p class="card-text">Total: $<%= reserva.getViaje().getPrecio_unitario() %></p>
                        <form action="cancelarReserva" method="post">
                            <input type="hidden" name="viajeId" value="<%= reserva.getViaje().getIdViaje() %>">
                            <input type="hidden" name="reservaId" value="<%= reserva.getIdReserva() %>">
                            <button type="submit" class="btn btn-danger">Cancelar Reserva</button>
                        </form>
                    </div>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <div class="col-12">
                <p>No tienes reservas registradas.</p>
            </div>
            <%
                }
            %>
        </div>
    </div>

	<div class="row align-items-end" style="height: 10vh">
         <div class="col">
             <jsp:include page="footer.jsp"></jsp:include>
         </div>
    </div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>