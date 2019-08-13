package controlador;

import conexion.Conexion;
import dao.Tipo_TransmisionDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Tipo_transmisionBean;


public class TipoTransmiServlet extends HttpServlet {

    Conexion conn = new Conexion();
    Tipo_TransmisionDAO tipotDAO = new Tipo_TransmisionDAO(conn);
    RequestDispatcher rd;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case "mostrar":mostrar(request, response);
        }
    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tipo_transmisionBean> tipo = tipotDAO.MostrarTipoTransmision();
        request.setAttribute("tipo", tipo);
        rd = request.getRequestDispatcher("/tipotransmision.jsp");
        rd.forward(request, response);
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
