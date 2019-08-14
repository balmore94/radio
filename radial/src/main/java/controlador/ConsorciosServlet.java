package controlador;

import conexion.Conexion;
import dao.ConsorciosDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CompaniaBean;
import modelo.ConsorciosBean;
import modelo.ProgramasBean;
import modelo.RadioBean;

public class ConsorciosServlet extends HttpServlet {

    Conexion conn = new Conexion();
    ConsorciosDao csd = new ConsorciosDao(conn);
    RequestDispatcher rd;
    boolean respuesta;
    String msg;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insertar":
                insertar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "findAll":
                findAll(request, response);
                break;
            case "findById":
                findById(request, response);
                break;
        }
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int radio = Integer.parseInt(request.getParameter("radio"));
        int programa  = Integer.parseInt(request.getParameter("programa"));
        int compania = Integer.parseInt(request.getParameter("compania"));
        
        ConsorciosBean csb = new ConsorciosBean(0);
        RadioBean r = new RadioBean(radio);
        csb.setRadio_consorcio(r);
        ProgramasBean p = new  ProgramasBean(programa);
        csb.setPrograma_consorcio(p);
        CompaniaBean c = new CompaniaBean(compania);
        csb.setCompania_consorcio(c);
        
        respuesta = csd.insertar(csb);
        if (respuesta) {
            msg = "Exito";
        }else{
            msg = "Error";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("registro");
        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int radio = Integer.parseInt(request.getParameter("radio"));
        int programa  = Integer.parseInt(request.getParameter("programa"));
        int compania = Integer.parseInt(request.getParameter("compania"));
        
        ConsorciosBean csb = new ConsorciosBean(id);
        RadioBean r = new RadioBean(radio);
        csb.setRadio_consorcio(r);
        ProgramasBean p = new  ProgramasBean(programa);
        csb.setPrograma_consorcio(p);
        CompaniaBean c = new CompaniaBean(compania);
        csb.setCompania_consorcio(c);
        
        respuesta = csd.actualizar(csb);
        if (respuesta) {
            msg = "Exito";
        }else{
            msg = "Error";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("mostrar");
        rd.forward(request, response);
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        respuesta = csd.eliminar(id);
        List<ConsorciosBean> consorcios = csd.findAll();
        if (respuesta) {
            msg = "Eliminado";
        }else{
            msg = "Error";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("consorcios", consorcios);
        rd = request.getRequestDispatcher("mostrar");
        rd.forward(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ConsorciosBean> consorcios = csd.findAll();
        request.setAttribute("consorcios", consorcios);
        rd = request.getRequestDispatcher("mostrar");
        rd.forward(request, response);
    }

    protected void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<ConsorciosBean> consorcios = csd.findById(id);
        request.setAttribute("consorcios", consorcios);
        rd = request.getRequestDispatcher("mostrar");
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
