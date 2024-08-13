<%@ page import="java.util.LinkedList" %>
<%@ page import="entidades.Viaje" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SharedTrip</title>
</head>
<body>
		<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Origen</th>
                <th>Destino</th>
                <th>Fecha</th>
                <th>Lugares Disponibles</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Obtener la lista de viajes de la solicitud
                LinkedList<Viaje> viajes = (LinkedList<Viaje>) request.getAttribute("viajes");

                if (viajes != null && !viajes.isEmpty()) {
                    for (Viaje viaje : viajes) {
            %>
            <tr>
                <td><%= viaje.getIdViaje() %></td>
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
                <td colspan="5">No hay viajes disponibles.</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</body>
</html>