<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row align-items-center d-flex justify-content-center" >
		<div class="col-md-3 d-none d-md-block"></div>
		<div class="col-12 col-md-6">
		
            <form action="Register" method="POST">
                <h1 class="text-secondary border-bottom border-success border-5">Registrarse</h1>
			     <div class="form-group col-12">
			    <div class="form-group col-12">
			      <label for="nombre">Nombre</label>
			      <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
			    </div>
			    <div class="form-group col-12">
			      <label for="apellido">Apellido</label>
			      <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido" required>
			    </div>
			    <div class="form-group col-12">
			      <label for="correo">Correo Electrónico</label>
			      <input type="email" class="form-control" id="correo" name="correo" placeholder="Correo Electrónico" required>
			    </div>
			      <label for="usuario">Usuario</label>
			      <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario" required>
			    </div>
			    <div class="form-group col-12">
			      <label for="clave">Clave</label>
			      <input type="password" class="form-control" id="clave" name="clave" placeholder="Clave" required>
			    </div>
			    <div class="form-group col-12">
			      <label for="telefono">Teléfono</label>
			      <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Teléfono" required>
			    </div>
                <div class="d-grid gap-2 col-6 mx-auto">
                    <button class="btn btn-success mb-4 mt-2" type="submit">Registrarse</button>
                </div>
            </form>
        </div>
		<div class="col-md-3 d-none d-md-block"></div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>