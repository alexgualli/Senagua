<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>LogIn Form</title>
        <link href="css/family Pacifico.css" rel="stylesheet" type="text/css"/>
        <link href="css/family Arimio.css" rel="stylesheet" type="text/css"/>
        <link href="css/family Hind.css" rel="stylesheet" type="text/css"/>
            <link href="css/family Sand Serif.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style.css">


    </head>

    <body>

        <div id="login-button">
            <img src="https://dqcgrsy5v35b9.cloudfront.net/cruiseplanner/assets/img/icons/login-w-icon.png">
            </img>
        </div>
        <div id="container">
            <h1>BAYUSHIG</h1>
            <span class="close-btn">
                <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
            </span>

            <form action="Login" method="GET">
                <input type="text" name="txtnombre" placeholder="Nombre de Usuario" required="required">
                <input type="password" name="txtclave" placeholder="Password" required="required">
                <input type="submit" value="Iniciar sesion" name="btniniciar" />
                <div id="remember-container">
                    <input type="checkbox" id="checkbox-2-1" class="checkbox" checked="checked"/>
                    <span id="remember">Remember me</span>
                    <span id="forgotten">Olvide mi Contraseña   </span>
                </div>
            </form>
        </div>

        <!-- Forgotten Password Container -->
        <div id="forgotten-container">
            <h1>Forgotten</h1>
            <span class="close-btn">
                <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
            </span>

            <form>
                <input type="email" name="txtusuario" placeholder="Nombre de Usuario">
                <a href="#" class="orange-btn">Get new password</a>
            </form>         
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/gsap/1.16.1/TweenMax.min.js'></script>
        <script src="jsprincipal/jquery-1.11.2.min.js" type="text/javascript"></script>

        <script src="jsprincipal/index.js" type="text/javascript"></script>





    </body> 
        
</html>
