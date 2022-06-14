<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>

<html>
    <!--Colocar como value: nombre de la presente página  (DOCUMENTO DE NIURKA)-->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones Recomendadas"/>
    </jsp:include>
    <jsp:useBean id="listaCancionesRecomendados" scope="request" type="java.util.ArrayList<Beans.Cancion>"/>

    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="listaBandas"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones Recomendados: </h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CANCIÓN</th>
                            <th>BANDA</th>
                            <th>VER</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <%for (Cancion cancion :listaCancionesRecomendadas ) {%>
                            <td><%=cancion.getIdCancion()%></td>
                            <td><%=cancion.getNombre_cancion()%></td>
                            <td><%=cancion.getBanda()%></td>
                            <td><a class="btn btn-warning" href="… ">Mostrar todas las canciones</a></td>
                        </tr>
                        <%}%>


                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
