
<div class="login-container">
	<h2>Iniciar Sesión</h2>
	<form action="signin" method="POST">
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