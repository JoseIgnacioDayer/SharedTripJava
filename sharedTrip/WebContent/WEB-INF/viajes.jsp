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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
	<%
	LinkedList<Viaje> viajes = (LinkedList<Viaje>)request.getAttribute("viajes");
	%>
<body>


	<h2>Lista de Viajes</h2>
	<table border="1" cellpadding="10">
		<thead>
			<tr>
				<th>Origen</th>
				<th>Destino</th>
				<th>Fecha</th>
				<th>Lugares Disponibles</th>
			</tr>
		</thead>
		<tbody>
			<%
            if (viajes != null && !viajes.isEmpty()) {
                for (Viaje viaje : viajes) {
        %>
			<tr>
				<td><%= viaje.getOrigen() %></td>
				<td><%= viaje.getDestino() %></td>
				<td><%= viaje.getFecha() %></td>
				<td><%= viaje.getLugares_disponibles() %></td>
			</tr>
			<%
                }
            } else {
        %>
			<tr>
				<td colspan="4">No hay viajes disponibles.</td>
			</tr>
			<%
            }
        %>
		</tbody>
	</table>


</body>
</html>