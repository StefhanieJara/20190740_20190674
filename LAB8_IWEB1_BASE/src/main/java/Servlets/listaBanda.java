package Servlets;

import Beans.Cancion;
import Daos.BandaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listaBanda", value = "/listaBanda")
public class listaBanda extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        BandaDao bandadao = new BandaDao();

        switch (action){
            case "listar"->{
                ArrayList<Cancion> listaRecomendados = bandadao.obtenerCancion();

                request.setAttribute("listaRecomendados",listaRecomendados);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaRecomendados.jsp");
                requestDispatcher.forward(request,response);

            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
