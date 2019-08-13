package controlador;

import conexion.Conexion;
import dao.EmisionesDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EmisionesBean;

public class EmisionesServlet extends HttpServlet {
    Conexion conn = new Conexion();
    EmisionesDao ed = new EmisionesDao(conn);
    RequestDispatcher rd;
    String msg;
    boolean respuesta;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "insertar": insertar(request, response);
            break;
            case "actualizar": actualizar(request, response);
            break;
            case "consultarAll": consultarAll(request, response);
            break;
            case "consultarById": consultarById(request, response);
            break;
            case "eliminar": eliminar(request, response);
        }
    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emision = request.getParameter("emision");
        
        EmisionesBean eb = new EmisionesBean(0);
        eb.setEmision(emision);
        
        respuesta = ed.insertar(eb);
        if(respuesta){
            msg = "Guardado";
        }else{
            msg = "No guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registroEmisiones.jsp");
        rd.forward(request, response);
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_emisiones = Integer.parseInt(request.getParameter("id_emisiones"));
        String emision = request.getParameter("emision");
        
        EmisionesBean eb = new EmisionesBean(id_emisiones);
        eb.setEmision(emision);
        
        respuesta = ed.actualizar(eb);
        List<EmisionesBean> lista = ed.consultarAll();
        if (respuesta) {
            msg = "Actualizado";
        }else{
            msg = "No actualizado";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/emisiones.jsp");
        rd.forward(request, response);
    }
    protected void consultarAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EmisionesBean> lista = ed.consultarAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/emisiones.jsp");
        rd.forward(request, response);
    }
    
    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_emision = Integer.parseInt(request.getParameter("id_emision"));
        List<EmisionesBean> lista = ed.consultarById(id_emision);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/editarEmisiones.jsp");
        rd.forward(request, response);
    }
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_emision = Integer.parseInt(request.getParameter("id_emision"));
        respuesta = ed.eliminar(id_emision);
        List<EmisionesBean> lista = ed.consultarAll();
        if (respuesta) {
            msg = "Eliminado";
        }else{
            msg = "No eliminado";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/emisiones.jsp");
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
