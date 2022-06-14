package Servlets;

import Beans.Cancion;
import Daos.BandaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listaCanciones", value = "/listaCanciones")
public class listaCanciones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        BandaDao bandadao = new BandaDao();

        //Creado por niurka

        switch (action){
            case "listar"->{
                ArrayList<Cancion> listaCancionesRecomendadas = bandadao.obtenerCancion();

                request.setAttribute("listaCanciones",listaCancionesRecomendadas);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaRecomendados.jsp");
                requestDispatcher.forward(request,response);

            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
