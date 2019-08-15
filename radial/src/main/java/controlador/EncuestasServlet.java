package controlador;

import conexion.Conexion;
import dao.EncuestasDAO;
import dao.ProgramasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EncuestasBean;
import modelo.ProgramasBean;

/**
 *
 * @author mario.rodriguezusam
 */
public class EncuestasServlet extends HttpServlet {

    Conexion conn = new Conexion();
    EncuestasDAO enDAO = new EncuestasDAO(conn);
    ProgramasDAO proDAO = new ProgramasDAO(conn);
    RequestDispatcher rd;
    boolean res;
    String msj;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "mostrar":
                mostrar(request, response);
                break;
            case "show":
                showBeforeSave(request, response);
                break;
            case "guardar":
                guardar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "getById":
                getById(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
        }
    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EncuestasBean> encuestab = enDAO.mostrarEncuestas();
        request.setAttribute("encuestab", encuestab);
        rd = request.getRequestDispatcher("/mostrarEncuestas.jsp");
        rd.forward(request, response);

    }

    protected void showBeforeSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProgramasBean> programa = proDAO.mostrarProgramas();
        request.setAttribute("programa", programa);
        rd = request.getRequestDispatcher("/registroEncuestas.jsp");
        rd.forward(request, response);

    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int total = Integer.parseInt(request.getParameter("total"));
        int aprobaciones = Integer.parseInt(request.getParameter("aprobaciones"));
        int rechazos = Integer.parseInt(request.getParameter("rechazos"));
        int indiferentes = Integer.parseInt(request.getParameter("indiferentes"));

        EncuestasBean encu = new EncuestasBean(0);
        encu.setTotal_encuestados(total);
        encu.setAprobaciones(aprobaciones);
        encu.setRechazos(rechazos);
        encu.setIndiferencias(indiferentes);
        List<ProgramasBean> programa = proDAO.mostrarProgramas();
        request.setAttribute("programa", programa);

        int progra = Integer.parseInt(request.getParameter("programa"));
        ProgramasBean pro = new ProgramasBean(progra);
        encu.setPrograma(pro);

        res = enDAO.guardar(encu);
        List<EncuestasBean> encuestab = enDAO.mostrarEncuestas();
        if (res) {
            msj = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro guardado...\n"
                    + "</div>";
        } else {
            msj = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo guardar...\n"
                    + "</div>";
        }
        request.setAttribute("msj", msj);
        request.setAttribute("encuestab", encuestab);
        rd = request.getRequestDispatcher("/mostrarEncuestas.jsp");
        rd.forward(request, response);
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        res = enDAO.eliminar(id);
        List<EncuestasBean> encuestab = enDAO.mostrarEncuestas();
        if (res) {
            msj = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro eliminado...\n"
                    + "</div>";
        } else {
            msj = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo eliminar...\n"
                    + "</div>";
        }
        request.setAttribute("msj", msj);
        request.setAttribute("encuestab", encuestab);
        rd = request.getRequestDispatcher("/mostrarEncuestas.jsp");
        rd.forward(request, response);
    }

    protected void getById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        List<EncuestasBean> enb = enDAO.GetEncuById(id);
        List<ProgramasBean> pro = proDAO.mostrarProgramas();
        request.setAttribute("enb", enb);
        request.setAttribute("pro", pro);

        rd = request.getRequestDispatcher("/editarEncuestas.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int total = Integer.parseInt(request.getParameter("total"));
        int aprobaciones = Integer.parseInt(request.getParameter("aprobaciones"));
        int rechazos = Integer.parseInt(request.getParameter("rechazos"));
        int indiferentes = Integer.parseInt(request.getParameter("indiferentes"));

        EncuestasBean encu = new EncuestasBean(id);
        encu.setTotal_encuestados(total);
        encu.setAprobaciones(aprobaciones);
        encu.setRechazos(rechazos);
        encu.setIndiferencias(indiferentes);
        List<ProgramasBean> programa = proDAO.mostrarProgramas();
        request.setAttribute("programa", programa);

        int progra = Integer.parseInt(request.getParameter("programa"));
        ProgramasBean pro = new ProgramasBean(progra);
        encu.setPrograma(pro);

        res = enDAO.actualizar(encu);
        List<EncuestasBean> encuestab = enDAO.mostrarEncuestas();
        if (res) {
            msj = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro actualizado...\n"
                    + "</div>";
        } else {
            msj = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo actualizar...\n"
                    + "</div>";
        }
        request.setAttribute("msj", msj);
        request.setAttribute("encuestab", encuestab);
        rd = request.getRequestDispatcher("/mostrarEncuestas.jsp");
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
