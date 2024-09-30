<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid ">
<div class="row">
<div class="col-md-3">&nbsp;</div>
<div class="col-12 col-md-6 mx-3 my-5 border border-secondary rounded">
	<h2 class="align-items-center">Iniciar Sesión</h2>
	<form action="signin" class="align-items-center"  method="POST">
		<div class="form-group">
			<label for="user">Usuario</label> 
			<input type="text" id="user" name="usuario" required>
		</div>
		<div class="form-group">
			<label for="password">Contraseña</label> 
			<input type="password" id="password" name="password" required>
		</div>
		<button type="submit" class="login-btn">Ingresar</button>
		<a href="#" class="forgot-password">¿Olvidaste tu contraseña?</a>
		<a href="register.jsp" class="forgot-password">Registrarse Aquí</a>
	</form>
</div>
<div class="col-md-3">&nbsp;</div>
</div>
</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>

<style>

.login-container {
    background-color: #ffffff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.3);
    width: 350px;
    text-align: center;
    font-family: Arial, sans-serif;
}

h2 {
    margin-bottom: 20px;
    color: #333333;
}

.form-group {
    margin-bottom: 15px;
    text-align: left;
}

label {
    display: block;
    margin-bottom: 5px;
    color: #666666;
}

input {
    width: 100%;
    padding: 10px;
    border: 1px solid #cccccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px;
}

input:focus{
    outline: none;
    border-color: #66afe9;
    box-shadow: 0 0 8px rgba(102, 175, 233, 0.6);
}

.login-btn {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    border: none;
    border-radius: 5px;
    color: white;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.login-btn:hover {
    background-color: #45a049;
}

.forgot-password {
    display: block;
    margin-top: 15px;
    font-size: 14px;
    color: #007bff;
    text-decoration: none;
}

.forgot-password:hover {
    text-decoration: underline;
}

</style>