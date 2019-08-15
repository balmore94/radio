package controlador;

import conexion.Conexion;
import dao.TelefonosDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CompaniaBean;
import modelo.TelefonosBean;
/**
 *
 * @author maria.aguillonusam
 */
public class TelefonosServlet extends HttpServlet {

    Conexion conn = new Conexion();
    TelefonosDao td = new TelefonosDao(conn);
    RequestDispatcher rd;
    String msg;
    boolean respuesta;

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
            case "consultarAll":
                consultarAll(request, response);
                break;
            case "consultarById":
                consultarById(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
        }
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String telefono1 = request.getParameter("telefono1");
        int compania = Integer.parseInt(request.getParameter("compania"));

        TelefonosBean tb = new TelefonosBean(0);
        tb.setTelefono1(telefono1);
        CompaniaBean cb = new CompaniaBean(compania);
        tb.setCompania(cb);

        respuesta = td.insertar(tb);
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
        rd = request.getRequestDispatcher("/registroTelefonos.jsp");
        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_telefono = Integer.parseInt(request.getParameter("id_telefono"));
        String telefono1 = request.getParameter("telefono1");
        int compania = Integer.parseInt(request.getParameter("compania"));

        TelefonosBean tb = new TelefonosBean(id_telefono);
        tb.setTelefono1(telefono1);
        CompaniaBean cb = new CompaniaBean(compania);
        tb.setCompania(cb);

        respuesta = td.actualizar(tb);
        List<TelefonosBean> lista = td.consultarAll();
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
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/telefonos.jsp");
        rd.forward(request, response);
    }

    protected void consultarAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TelefonosBean> lista = td.consultarAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/telefonos.jsp");
        rd.forward(request, response);
    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_telefono = Integer.parseInt(request.getParameter("id_telefono"));
        List<TelefonosBean> lista = td.consultarById(id_telefono);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/editarTelefonos.jsp");
        rd.forward(request, response);
   }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_telefono = Integer.parseInt(request.getParameter("id_telefono"));
        respuesta = td.eliminar(id_telefono);
        List<TelefonosBean> lista = td.consultarAll();
        if (respuesta) {
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro eliminado...\n"
                    + "</div>";
        }else{
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo eliminar...\n"
                    + "</div>";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/telefonos.jsp");
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
