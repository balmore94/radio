package controlador;

import conexion.Conexion;
import dao.RadioDao;
import dao.Tipo_TransmisionDAO;
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
        //int programa = 1; 
        //Integer.parseInt(request.getParameter("programa"));

        RadioBean rab = new RadioBean(0);
        rab.setNombre_radio(nombre);
        rab.setFrecuencia(frecuencia);

        Tipo_transmisionBean t = new Tipo_transmisionBean(tipo_t);

        rab.setTransmision(t);
        //ProgramasBean p = new ProgramasBean(programa);
        //rab.setPrograma(p);

        respuesta = rad.insertar(rab);
        if (respuesta) {
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro guardado...\n"
                    + "</div>";
        } else {
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo guardar...\n"
                    + "</div>";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("registroRadio.jsp");
        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String frecuencia = request.getParameter("frecuencia");
        int tipo_t = Integer.parseInt(request.getParameter("tipo_t"));
        

        RadioBean rab = new RadioBean(id);
        rab.setNombre_radio(nombre);
        rab.setFrecuencia(frecuencia);

        Tipo_transmisionBean t = new Tipo_transmisionBean(tipo_t);
        rab.setTransmision(t);


        respuesta = rad.actualizar(rab);
        List<RadioBean> radios = rad.findAll();
        if (respuesta) {
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro actualizado...\n"
                    + "</div>";
        } else {
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo actualizar...\n"
                    + "</div>";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("radios", radios);
        rd = request.getRequestDispatcher("radios.jsp");
        rd.forward(request, response);
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        respuesta = rad.eliminar(id);
        List<RadioBean> radios = rad.findAll();
        if (respuesta) {
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro eliminado...\n"
                    + "</div>";
        } else {
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo eliminar...\n"
                    + "</div>";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("radios", radios);
        rd = request.getRequestDispatcher("radios.jsp");
        rd.forward(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<RadioBean> radios = rad.findAll();
        request.setAttribute("radios", radios);
        rd = request.getRequestDispatcher("radios.jsp");
        rd.forward(request, response);
    }

    protected void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<RadioBean> radio = rad.findById(id);
        Tipo_TransmisionDAO t = new Tipo_TransmisionDAO(conn);
        List<Tipo_transmisionBean> tipot = t.MostrarTipoTransmision();
        request.setAttribute("radio", radio);
        request.setAttribute("tipot", tipot);
        rd = request.getRequestDispatcher("editarRadio.jsp");
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
