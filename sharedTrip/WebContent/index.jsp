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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
body {
	background-color: #f8f9fa;
}

.card {
	transition: transform 0.2s ease-in-out;
}

.card:hover {
	transform: scale(1.03);
}

.section-header {
	margin-top: 2rem;
	margin-bottom: 2rem;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container-fluid p-0">

		<div class="row">
			<div class="col-12">
				<jsp:include page="header.jsp"></jsp:include>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-12">
				<jsp:include page="buscadorViajes.jsp"></jsp:include>
			</div>
		</div>


		<div class="row px-3 mt-4">

			<div class="col-12">
				<%
				String reservado = request.getParameter("reservado");
				if ("true".equals(reservado)) {
				%>
				<div class="alert alert-success" role="alert">¡Reserva
					realizada con éxito!</div>
				<%
				}
				%>
				<%
				String mensaje = (String) session.getAttribute("mensaje");
				if (mensaje != null) {
				%>
				<div class="alert alert-info">
					<%=mensaje%>
				</div>
				<%
				session.removeAttribute("mensaje");
				}
				%>
			</div>

			<div class="col-12">
				<h2 class="section-header">Listado de Viajes</h2>
			</div>

			<div class="col-12">
				<div class="row row-cols-1 row-cols-md-3 g-4 mb-5">
					<%
					LinkedList<Viaje> viajes = (LinkedList<Viaje>) request.getAttribute("viajes");
					if (viajes != null && !viajes.isEmpty()) {
						for (Viaje viaje : viajes) {
					%>
					<div class="col">
						<div class="card h-100 shadow-sm">
							<div class="card-body d-flex flex-column">
								<h5 class="card-title text-primary"><%=viaje.getDestino()%></h5>
								<p class="card-text mb-1">
									<strong>Origen:</strong>
									<%=viaje.getOrigen()%></p>
								<p class="card-text mb-1">
									<strong>Fecha:</strong>
									<%=viaje.getFecha()%></p>
								<p class="card-text mb-3">
									<strong>Lugares Disponibles:</strong>
									<%=viaje.getLugares_disponibles()%></p>
								<div class="mt-auto">
									<%
									if (viaje.getLugares_disponibles() > 0) {
									%>
									<form action="reservar" method="post"
										class="d-flex align-items-center">
										<input type="hidden" name="viajeId"
											value="<%=viaje.getIdViaje()%>"> <input
											type="number" name="cantPasajeros" min="1"
											max="<%=viaje.getLugares_disponibles()%>" value="1"
											required class="form-control me-2" style="width: 80px;">
										<button type="submit" class="btn btn-success">Reservar</button>
									</form>
									<%
									} else {
									%>
									<p class="text-danger fw-bold">No hay lugares disponibles</p>
									<%
									}
									%>
								</div>
							</div>
						</div>
					</div>
					<%
					}
					} else {
					%>
					<div class="col-12">
						<div class="alert alert-warning" role="alert">No hay viajes
							disponibles.</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
		
		<div class="row mt-5">
			<div class="col-12">
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
