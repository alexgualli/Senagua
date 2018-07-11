<%-- 
    Document   : FormularioClientes
    Created on : 08/07/2018, 10:19:07
    Author     : jhona
--%>

<%@page import="ec.gob.senagua.entidades.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>CLIENTES</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/sweetalert2.css">
        <link rel="stylesheet" href="css/material.min.css">
        <link rel="stylesheet" href="css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.11.2.min.js"><\/script>')</script>
        <script src="jsprincipal/material.min.js" type="text/javascript"></script>
        <script src="jsprincipal/sweetalert2.min.js" type="text/javascript"></script>
        <script src="jsprincipal/jquery.mCustomScrollbar.concat.min.js" type="text/javascript"></script>
        <script src="jsprincipal/main.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            String user = (String) request.getSession().getAttribute("user");


        %>
        <!-- Notifications area -->
        <section class="full-width container-notifications">
            <div class="full-width container-notifications-bg btn-Notification"></div>
            <section class="NotificationArea">
                <div class="full-width text-center NotificationArea-title tittles">Notifications <i class="zmdi zmdi-close btn-Notification"></i></div>
                <a href="#" class="Notification" id="notifation-unread-1">
                    <div class="Notification-icon"><i class="zmdi zmdi-accounts-alt bg-info"></i></div>
                    <div class="Notification-text">
                        <p>
                            <i class="zmdi zmdi-circle"></i>
                            <strong>New User Registration</strong> 
                            <br>
                            <small>Just Now</small>
                        </p>
                    </div>
                    <div class="mdl-tooltip mdl-tooltip--left" for="notifation-unread-1">Notification as UnRead</div> 
                </a>
                <a href="#" class="Notification" id="notifation-read-1">
                    <div class="Notification-icon"><i class="zmdi zmdi-cloud-download bg-primary"></i></div>
                    <div class="Notification-text">
                        <p>
                            <i class="zmdi zmdi-circle-o"></i>
                            <strong>New Updates</strong> 
                            <br>
                            <small>30 Mins Ago</small>
                        </p>
                    </div>
                    <div class="mdl-tooltip mdl-tooltip--left" for="notifation-read-1">Notification as Read</div>
                </a>
                <a href="#" class="Notification" id="notifation-unread-2">
                    <div class="Notification-icon"><i class="zmdi zmdi-upload bg-success"></i></div>
                    <div class="Notification-text">
                        <p>
                            <i class="zmdi zmdi-circle"></i>
                            <strong>Archive uploaded</strong> 
                            <br>
                            <small>31 Mins Ago</small>
                        </p>
                    </div>
                    <div class="mdl-tooltip mdl-tooltip--left" for="notifation-unread-2">Notification as UnRead</div>
                </a> 
                <a href="#" class="Notification" id="notifation-read-2">
                    <div class="Notification-icon"><i class="zmdi zmdi-mail-send bg-danger"></i></div>
                    <div class="Notification-text">
                        <p>
                            <i class="zmdi zmdi-circle-o"></i>
                            <strong>New Mail</strong> 
                            <br>
                            <small>37 Mins Ago</small>
                        </p>
                    </div>
                    <div class="mdl-tooltip mdl-tooltip--left" for="notifation-read-2">Notification as Read</div>
                </a>
                <a href="#" class="Notification" id="notifation-read-3">
                    <div class="Notification-icon"><i class="zmdi zmdi-folder bg-primary"></i></div>
                    <div class="Notification-text">
                        <p>
                            <i class="zmdi zmdi-circle-o"></i>
                            <strong>Folder delete</strong> 
                            <br>
                            <small>1 hours Ago</small>
                        </p>
                    </div>
                    <div class="mdl-tooltip mdl-tooltip--left" for="notifation-read-3">Notification as Read</div>
                </a>  
            </section>
        </section>
        <!-- navBar -->
        <div class="full-width navBar">
            <div class="full-width navBar-options">
                <i class="zmdi zmdi-more-vert btn-menu" id="btn-menu"></i>	
                <div class="mdl-tooltip" for="btn-menu">Menu</div>
                <nav class="navBar-options-list">
                    <ul class="list-unstyle">
                        <li class="btn-Notification" id="notifications">
                            <i class="zmdi zmdi-notifications"></i>
                            <!-- <i class="zmdi zmdi-notifications-active btn-Notification" id="notifications"></i> -->
                            <div class="mdl-tooltip" for="notifications">Notifications</div>
                        </li>
                        <li class="btn-exit" id="btn-exit">
                            <i class="zmdi zmdi-power"></i>
                            <div class="mdl-tooltip" for="btn-exit">Cerrar Sesion</div>
                        </li>
                        <li class="text-condensedLight noLink" ><small>Bienvenido <%=user%></small></li>
                        <li class="noLink">
                            <figure>
                                <img src="assets/img/avatar-male.png" alt="Avatar" class="img-responsive">
                            </figure>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- navLateral -->
        <section class="full-width navLateral">
            <div class="full-width navLateral-bg btn-menu"></div>
            <div class="full-width navLateral-body">
                <div class="full-width navLateral-body-logo text-center tittles">
                    <i class="zmdi zmdi-close btn-menu"></i> Facturacion Bayushig
                </div>
                <figure class="full-width" style="height: 77px;">
                    <div class="navLateral-body-cl">
                        <img src="assets/img/avatar-male.png" alt="Avatar" class="img-responsive">
                    </div>
                    <figcaption class="navLateral-body-cr hide-on-tablet">
                        <span>
                            <%=user%><br>
                            <small>Admin</small>
                        </span>
                    </figcaption>
                </figure>
                <div class="full-width tittles navLateral-body-tittle-menu">
                    <i class="zmdi zmdi-desktop-mac"></i><span class="hide-on-tablet">&nbsp; MENU DE OPCIONES</span>
                </div>
                <nav class="full-width">
                    <ul class="full-width list-unstyle menu-principal">
                        <li class="full-width">
                            <a href="FormularioPrincipal.jsp" class="full-width">
                                <div class="navLateral-body-cl">
                                    <i class="zmdi zmdi-view-dashboard"></i>
                                </div>
                                <div class="navLateral-body-cr hide-on-tablet">
                                    INICIO
                                </div>
                            </a>
                        </li>
                        <li class="full-width divider-menu-h"></li>
                        <li class="full-width">
                            <a href="#!" class="full-width btn-subMenu">
                                <div class="navLateral-body-cl">
                                    <i class="zmdi zmdi-case"></i>
                                </div>
                                <div class="navLateral-body-cr hide-on-tablet">
                                    ADMINISTRACION
                                </div>
                                <span class="zmdi zmdi-chevron-left"></span>
                            </a>
                            <ul class="full-width menu-principal sub-menu-options">
                                <li class="full-width">
                                    <a href="FormularioConsumo.jsp" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-balance"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            CONSUMO
                                        </div>
                                    </a>
                                </li>
                                <li class="full-width">
                                    <a href="providers.html" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-truck"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            PROVIDERS
                                        </div>
                                    </a>
                                </li>
                                <li class="full-width">
                                    <a href="payments.html" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-card"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            PAYMENTS
                                        </div>
                                    </a>
                                </li>
                                <li class="full-width">
                                    <a href="categories.html" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-label"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            CATEGORIES
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="full-width divider-menu-h"></li>
                        <li class="full-width">
                            <a href="#!" class="full-width btn-subMenu">
                                <div class="navLateral-body-cl">
                                    <i class="zmdi zmdi-face"></i>
                                </div>
                                <div class="navLateral-body-cr hide-on-tablet">
                                    USUARIOS
                                </div>
                                <span class="zmdi zmdi-chevron-left"></span>
                            </a>
                            <ul class="full-width menu-principal sub-menu-options">
                                <li class="full-width">
                                    <a href="FormularioUsuario.jsp" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-account"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            ADMINISTRADORES
                                        </div>
                                    </a>
                                </li>
                                <li class="full-width">
                                    <a href="MostrarCliente" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-accounts"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            CLIENTES
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="full-width divider-menu-h"></li>
                        <li class="full-width">
                            <a href="products.html" class="full-width">
                                <div class="navLateral-body-cl">
                                    <i class="zmdi zmdi-washing-machine"></i>
                                </div>
                                <div class="navLateral-body-cr hide-on-tablet">
                                    PRODUCTS
                                </div>
                            </a>
                        </li>
                        <li class="full-width divider-menu-h"></li>
                        <li class="full-width">
                            <a href="sales.html" class="full-width">
                                <div class="navLateral-body-cl">
                                    <i class="zmdi zmdi-shopping-cart"></i>
                                </div>
                                <div class="navLateral-body-cr hide-on-tablet">
                                    SALES
                                </div>
                            </a>
                        </li>
                        <li class="full-width divider-menu-h"></li>
                        <li class="full-width">
                            <a href="inventory.html" class="full-width">
                                <div class="navLateral-body-cl">
                                    <i class="zmdi zmdi-store"></i>
                                </div>
                                <div class="navLateral-body-cr hide-on-tablet">
                                    INVENTORY
                                </div>
                            </a>
                        </li>
                        <li class="full-width divider-menu-h"></li>
                        <li class="full-width">
                            <a href="#!" class="full-width btn-subMenu">
                                <div class="navLateral-body-cl">
                                    <i class="zmdi zmdi-wrench"></i>
                                </div>
                                <div class="navLateral-body-cr hide-on-tablet">
                                    SETTINGS
                                </div>
                                <span class="zmdi zmdi-chevron-left"></span>
                            </a>
                            <ul class="full-width menu-principal sub-menu-options">
                                <li class="full-width">
                                    <a href="#!" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-widgets"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            OPTION
                                        </div>
                                    </a>
                                </li>
                                <li class="full-width">
                                    <a href="#!" class="full-width">
                                        <div class="navLateral-body-cl">
                                            <i class="zmdi zmdi-widgets"></i>
                                        </div>
                                        <div class="navLateral-body-cr hide-on-tablet">
                                            OPTION
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </section>
        <!-- pageContent -->
        <section class="full-width pageContent">
            <section class="full-width header-well">
                <div class="full-width header-well-icon">
                    <i class="zmdi zmdi-accounts"></i>
                </div>
                <div class="full-width header-well-text">
                    <p class="text-condensedLight">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde aut nulla accusantium minus corporis accusamus fuga harum natus molestias necessitatibus.
                    </p>
                </div>
            </section>
            <div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
                <div class="mdl-tabs__tab-bar">
                    <a href="#tabNewClient" class="mdl-tabs__tab is-active">NUEVO</a>
                    <a href="#tabListClient" class="mdl-tabs__tab"><input class="mdl-tabs__tab"  type="submit" value="LISTA" name="listaCliente" /></a>

                </div>
                <div class="mdl-tabs__panel is-active" id="tabNewClient">
                    <div class="mdl-grid">
                        <div class="mdl-cell mdl-cell--4-col-phone mdl-cell--8-col-tablet mdl-cell--8-col-desktop mdl-cell--2-offset-desktop">
                            <div class="full-width panel mdl-shadow--2dp">
                                <div class="full-width panel-tittle bg-primary text-center tittles">
                                    Nuevo Cliente
                                </div>
                                <div class="full-width panel-content">
                                    <form action="IngresoCliente" method="POST">
                                        <h5 class="text-condensedLight">Datos de Cliente</h5>
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtcodigo" type="number" pattern="-?[0-9]*(\.[0-9]+)?" id="DNIClient">
                                            <label class="mdl-textfield__label" for="DNIClient">Codigo</label>
                                            <span class="mdl-textfield__error">Invalid number</span>
                                        </div>
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtnombre"type="text" pattern="-?[A-Za-záéíóúÁÉÍÓÚ ]*(\.[0-9]+)?" id="NameClient">
                                            <label class="mdl-textfield__label" for="NameClient">Nombre</label>
                                            <span class="mdl-textfield__error">Nombre Invalido</span>
                                        </div>
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtapellido"type="text" pattern="-?[A-Za-záéíóúÁÉÍÓÚ ]*(\.[0-9]+)?" id="LastNameClient">
                                            <label class="mdl-textfield__label" for="LastNameClient">Apellido</label>
                                            <span class="mdl-textfield__error">Apellido Invalido</span>
                                        </div>
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtdireccion" type="text" id="addressClient1">
                                            <label class="mdl-textfield__label" for="addressClient1">Direccion</label>
                                            <span class="mdl-textfield__error">Direccion Invalida</span>
                                        </div>
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtcedula" type="tel" pattern="-?[0-9+()- ]*(\.[0-9]+)?" id="phoneClient">
                                            <label class="mdl-textfield__label" for="phoneClient">Cedula</label>
                                            <span class="mdl-textfield__error">Numero de Cedula Invalido</span>
                                        </div>

                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtemail"type="email" id="emailClient">
                                            <label class="mdl-textfield__label" for="emailClient">E-mail</label>
                                            <span class="mdl-textfield__error">Invalid E-mail</span>
                                        </div>
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtfecha"type="tel" pattern="-?[0-9+()- ]*(\.[0-9]+)?" id="phoneClient">
                                            <label class="mdl-textfield__label" for="phoneClient">Fecha de Nacimineto</label>
                                            <span class="mdl-textfield__error">Utilize el Formato de Fecha</span>
                                        </div>
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                            <input class="mdl-textfield__input" name="txtcodigodis"type="tel" pattern="-?[0-9+()- ]*(\.[0-9]+)?" id="phoneClient">
                                            <label class="mdl-textfield__label" for="phoneClient">Codigo de Discapacidad (opcional si posee)</label>
                                            <span class="mdl-textfield__error">Codigo de Discapacidad Invalido</span>
                                        </div>
                                        <p class="text-center">
                                            <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored bg-primary" id="btn-addClient">
                                                <i class="zmdi zmdi-plus"></i>
                                            </button>
                                        <div class="mdl-tooltip" for="btn-addClient">Añadir Cliente</div>
                                       
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mdl-tabs__panel" id="tabListClient">
                    <div class="mdl-grid">
                        <div class="mdl-cell mdl-cell--4-col-phone mdl-cell--8-col-tablet mdl-cell--8-col-desktop mdl-cell--2-offset-desktop">
                            <div class="full-width panel mdl-shadow--2dp">
                                <div class="full-width panel-tittle bg-success text-center tittles">
                                    Lista de Clientes
                                </div>
                                <div class="full-width panel-content">
                                    <form action="#">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                                            <label class="mdl-button mdl-js-button mdl-button--icon" for="searchClient">
                                                <i class="zmdi zmdi-search"></i>
                                            </label>
                                            <div class="mdl-textfield__expandable-holder">
                                                <input class="mdl-textfield__input" type="text" id="searchClient">
                                                <label class="mdl-textfield__label"></label>
                                            </div>
                                        </div>
                                    </form>

                                    <div class="mdl-list">

                                        <table border="1">
                                            <thead>
                                            <th>Codigo</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>DIreccion</th>
                                            <th>Cedula</th>
                                            <th>correo</th>
                                            <th>fecha nacimiento</th>
                                            <th>COdigodis</th>    
                                            </thead>
                                            <tbody>

                                            </tbody>   

                                        </table>



                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>