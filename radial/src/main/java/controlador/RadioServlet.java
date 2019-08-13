package controlador;

import conexion.Conexion;
import dao.RadioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ProgramasBean;
import modelo.RadioBean;
import modelo.Tipo_transmisionBean;

public class RadioServlet extends HttpServlet {

    Conexion conn = new Conexion();
    RadioDao rad = new RadioDao(conn);
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
        String nombre = request.getParameter("nombre");
        String frecuencia = request.getParameter("frecuencia");
        int tipo_t = Integer.parseInt(request.getParameter("tipo_t"));
        int programa = Integer.parseInt(request.getParameter("programa"));
        
        RadioBean rab = new RadioBean(0);
        rab.setNombre_radio(nombre);
        rab.setFrecuencia(frecuencia);
        
        Tipo_transmisionBean t = new Tipo_transmisionBean(tipo_t);
        
        rab.setTransmision(t);
        ProgramasBean p = new ProgramasBean(programa);
        rab.setPrograma(p);
        
        respuesta = rad.insertar(rab);
        if (respuesta) {
            msg = "Exito";
        }else{
            msg = "error";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("mostrar.jsp");
        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String frecuencia = request.getParameter("frecuencia");
        int tipo_t = Integer.parseInt(request.getParameter("tipo_t"));
        int programa = Integer.parseInt(request.getParameter("programa"));
        
        RadioBean rab = new RadioBean(id);
        rab.setNombre_radio(nombre);
        rab.setFrecuencia(frecuencia);
        
        Tipo_transmisionBean t = new Tipo_transmisionBean(tipo_t);
        
        rab.setTransmision(t);
        ProgramasBean p = new ProgramasBean(programa);
        rab.setPrograma(p);
        
        respuesta = rad.actualizar(rab);
        if (respuesta) {
            msg = "actualizado";
        }else{
            msg = "error";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("mostrar.jsp");
        rd.forward(request, response);
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        respuesta = rad.eliminar(id);
        if (respuesta) {
            msg = "Exito";
        }else{
            msg = "Error";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("mostrar");
        rd.forward(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<RadioBean> radios = rad.findAll();
        request.setAttribute("radios", radios);
        rd = request.getRequestDispatcher("mostrar");
        rd.forward(request, response);
    }

    protected void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
