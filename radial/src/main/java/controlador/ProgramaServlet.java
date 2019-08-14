package controlador;

import conexion.Conexion;
import dao.GeneroDao;
import dao.ProgramasDAO;
import dao.Tipo_TransmisionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GeneroBean;
import modelo.ProgramasBean;

/**
 *
 * @author mario.rodriguezusam
 */
public class ProgramaServlet extends HttpServlet {

    Conexion conn = new Conexion();
    ProgramasDAO pro = new ProgramasDAO(conn);
    GeneroDao gen = new GeneroDao(conn);
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
        List<ProgramasBean> prom = pro.mostrarProgramas();
        request.setAttribute("prom", prom);
        rd = request.getRequestDispatcher("/mostrarProgramas.jsp");
        rd.forward(request, response);
    }

    protected void showBeforeSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<GeneroBean> generos = gen.findAll();
        request.setAttribute("generos", generos);
        rd = request.getRequestDispatcher("/registroProgramas.jsp");
        rd.forward(request, response);
    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String programa = request.getParameter("programa");
        int genero = Integer.parseInt(request.getParameter("genero"));

        ProgramasBean prob = new ProgramasBean(0);
        prob.setNombre_programa(programa);
        List<GeneroBean> generos = gen.findAll();
        List<ProgramasBean> prom = pro.mostrarProgramas();
        request.setAttribute("generos", generos);
        GeneroBean geb = new GeneroBean(genero);
        prob.setGenero(geb);

        res = pro.guardar(prob);
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
        rd = request.getRequestDispatcher("/registroProgramas.jsp");
        rd.forward(request, response);
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        res = pro.elimiar(id);
        List<ProgramasBean> prom = pro.mostrarProgramas();
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
        request.setAttribute("prom", prom);
        rd = request.getRequestDispatcher("mostrarProgramas.jsp");
        rd.forward(request, response);
    }

    protected void getById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
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
