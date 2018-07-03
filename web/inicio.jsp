<%-- 
    Document   : inicio
    Created on : 02/07/2018, 22:49:42
    Author     : jhona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" href="css/estilos.css">

        <title>JSP Page</title>
    </head>

<body>
    <div class="contenedor-form">
        <div class="toggle">
            <span> Crear Cuenta</span>
        </div>
        
        <div class="formulario">
            <h2>Iniciar Sesión</h2>
            <form action="xx">
                <input type="textusuario" placeholder="Usuario" required>
                <input type="password" placeholder="Contraseña" required>
                <input type="submit" value="Iniciar Sesión">
            </form>
        </div>
        
        <div class="formulario">
            <h2>Crea tu Cuenta</h2>
            <form action="NuevoUsuario">
                  <input type="textcodigo" placeholder="Codigo" required>
                
                <input type="textusuario" placeholder="Usuario" required>
                
                <input type="password" placeholder="Contraseña" required>
                
                <input type="textcargo" placeholder="Tipo de Cargo" required>
                
               
                
                <input type="submit" value="Registrarse">
            </form>
        </div>
        <div class="reset-password">
            <a href="#">Olvide mi Contraseña?</a>
        </div>
    </div>
  
    <script src="js/jquery-3.1.1.min.js"></script>    
    <script src="js/main.js"></script>
</body>
</html>
