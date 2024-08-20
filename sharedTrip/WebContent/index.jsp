<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SharedTrip</title>
    <link rel="stylesheet" href="styles/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	
</head>
<body>
<div class="container-fluid p-0">
	<div class="row align-items-start"  style="height: 10vh">
		<div class="col">
			<jsp:include page="WEB-INF/header.jsp"></jsp:include>
		</div>
	</div>
	<div class="row" style="height: 80vh">
		<div class="col d-flex align-items-center justify-content-center">
			<jsp:include page="WEB-INF/login.jsp"></jsp:include>
		</div>
	</div>
	<div class="row align-items-end" style="height: 10vh">
		<div class="col">
			<jsp:include page="WEB-INF/footer.jsp"></jsp:include>
		</div>
	</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>