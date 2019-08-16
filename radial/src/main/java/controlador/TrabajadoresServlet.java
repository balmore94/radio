/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CargosDao;
import dao.ProgramasDAO;
import dao.TrabajadoresDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CargosBean;
import modelo.ProgramasBean;
import modelo.TrabajadoresBean;

/**
 *
 * @author rodrigo.martinezusam
 */
public class TrabajadoresServlet extends HttpServlet {

    Conexion conn = new Conexion();
    TrabajadoresDAO trab = new TrabajadoresDAO(conn);
    RequestDispatcher rd;
    boolean respuesta;
    String msg;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String action = request.getParameter("action");

        switch (action) {

            case "insertar":
                insertar(request, response);
                break;
            case "showRegistro":
                showRegistro(request, response);
                break;
            case "findAll":
                findAll(request, response);
                break;
            case "findbyid":
                search(request, response);
                break;
            case "delete":
                eliminar(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
        }
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre_trabajador = request.getParameter("nombre");
        String apellido_trabajador = request.getParameter("apellido");
        String dui = request.getParameter("dui");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        int programa = Integer.parseInt(request.getParameter("programa"));

        TrabajadoresBean tra = new TrabajadoresBean(0);
        tra.setNombre_trabajador(nombre_trabajador);
        tra.setApellido_trabajador(apellido_trabajador);
        tra.setDui(dui);

        CargosBean car = new CargosBean(cargo);
        tra.setCargo(car);
        ProgramasBean pr = new ProgramasBean(programa);
        tra.setPrograma_trabajador(pr);

        respuesta = trab.insertar(tra);
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
        rd = request.getRequestDispatcher("registroTrabajador.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        int id_trabajador = Integer.parseInt(request.getParameter("id"));
        String nombre_trabajador = request.getParameter("nombre");
        String apellido_trabajador = request.getParameter("apellido");
        String dui = request.getParameter("dui");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        int programa = Integer.parseInt(request.getParameter("programa"));

        TrabajadoresBean tra = new TrabajadoresBean(id_trabajador);
        tra.setNombre_trabajador(nombre_trabajador);
        tra.setApellido_trabajador(apellido_trabajador);
        tra.setDui(dui);

        CargosBean car = new CargosBean(cargo);
        tra.setCargo(car);
        ProgramasBean pr = new ProgramasBean(programa);
        tra.setPrograma_trabajador(pr);

        respuesta = trab.update(tra);
        List<TrabajadoresBean> trabajadores = trab.LlenarTrabajadores();
            
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
        request.setAttribute("trabajadores", trabajadores);
        rd = request.getRequestDispatcher("trabajadores.jsp");
        rd.forward(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<TrabajadoresBean> trabajadores = trab.LlenarTrabajadores();
            request.setAttribute("trabajadores", trabajadores);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("trabajadores.jsp");
        rd.forward(request, response);
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_trabajadores = Integer.parseInt(request.getParameter("id_trabajadores"));
        try {
            trab.delete(id_trabajadores);
            List<TrabajadoresBean> lista = trab.LlenarTrabajadores();
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/*.jsp");
        rd.forward(request, response);
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_trabajadores = Integer.parseInt(request.getParameter("id"));
        try {
            CargosDao c = new CargosDao(conn);
            ProgramasDAO p = new ProgramasDAO(conn);
            List<TrabajadoresBean> trabajador = trab.findbyid(id_trabajadores);
            List<CargosBean> cargos = c.consultarAll();
            List<ProgramasBean> lista = p.mostrarProgramas();
            request.setAttribute("cargos", cargos);
            request.setAttribute("lista", lista);
            
            request.setAttribute("trabajador", trabajador);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/editarTrabajador.jsp");
        rd.forward(request, response);
    }

    protected void showRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CargosDao c = new CargosDao(conn);
        ProgramasDAO p = new ProgramasDAO(conn);
        List<CargosBean> cargos = c.consultarAll();
        List<ProgramasBean> lista = p.mostrarProgramas();
        request.setAttribute("cargos", cargos);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/registroTrabajador.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TrabajadoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TrabajadoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
