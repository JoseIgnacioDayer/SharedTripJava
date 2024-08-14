<header>
    <div class="header-container">
        <div class="logo">
            <a href="index.jsp">SharedTrip</a>
        </div>
        <nav class="nav-menu">
            <ul>
                <li><a href="#">Viajes</a></li>
                <li><a href="#">Sobre Nosotros</a></li>
                <li><a href="#">Contacto</a></li>
            </ul>
        </nav>
    </div>
</header>
	

<style>

header {
    background-color: #ffffff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 25px 0;
    font-family: Arial, sans-serif;
    height:10vh;
}

.header-container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logo a {
    text-decoration: none;
    font-size: 24px;
    font-weight: bold;
    color: #4CAF50;
}

.nav-menu ul {
    list-style: none;
    margin: 0;
    padding: 0;
    display: flex;
    gap: 20px;
}

.nav-menu ul li {
    display: inline;
}

.nav-menu ul li a {
    text-decoration: none;
    color: #333333;
    font-size: 16px;
    padding: 5px 10px;
    transition: background-color 0.3s ease, color 0.3s ease;
    border-radius: 5px;
}

.nav-menu ul li a:hover {
    background-color: #4CAF50;
    color: #ffffff;
}

</style>