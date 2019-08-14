/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CompaniaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;
import modelo.CompaniaBean;

/**
 *
 * @author rodrigo.martinezusam
 */
public class CompaniServelet extends HttpServlet {

    Conexion conn = new Conexion();
    CompaniaDAO comp = new CompaniaDAO(conn);
    RequestDispatcher rd;
    String msg;

    boolean aa;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "Insertar":
                Insertar(request, response);
                break;

            case "update":
                update(request, response);
                break;

            case "Eliminar":
                Eliminar(request, response);
                break;

            case "findAll":
                findAll(request, response);
                break;

            case "search":
                search(request, response);
                break;
        }

    }

    protected void Insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String registrofc = request.getParameter("registrofc");
        String nombre_compania = request.getParameter("nombre_compania");

        CompaniaBean co = new CompaniaBean(0);
        co.setRegistrofc(registrofc);
        co.setNombre_compania(nombre_compania);
        System.out.println("Intentando");
        try {
            comp.insertar(co);
            System.out.println("Insertado");
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro guardado...\n"
                    + "</div>";
            request.setAttribute("msg", msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo guardar...\n"
                    + "</div>";
            request.setAttribute("msg", msg);
        }
        rd = request.getRequestDispatcher("registroCompania.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String registrofc = request.getParameter("registrofc");
        String nombre_compania = request.getParameter("nombre_compania");

        CompaniaBean com = new CompaniaBean(id);
        com.setRegistrofc(registrofc);
        com.setNombre_compania(nombre_compania);

        try {
            comp.actualizar(com);
            List<CompaniaBean> compania = comp.findAll();
            request.setAttribute("compania", compania);
            System.out.println("update.. en curso");
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro actualizado...\n"
                    + "</div>";
            request.setAttribute("msg", msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo actualizar...\n"
                    + "</div>";
            request.setAttribute("msg", msg);
        }

        rd = request.getRequestDispatcher("compania.jsp");
        rd.forward(request, response);
    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            comp.delete(id);
            List<CompaniaBean> compania = comp.findAll();
            request.setAttribute("compania", compania);
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro Eliminado...\n"
                    + "</div>";
            request.setAttribute("msg", msg);
        } catch (Exception e) {
            e.printStackTrace();            
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo Eliminar...\n"
                    + "</div>";
            request.setAttribute("msg", msg);
        }
        rd = request.getRequestDispatcher("compania.jsp");
        rd.forward(request, response);

    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<CompaniaBean> compania = comp.findAll();
            request.setAttribute("compania", compania);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("compania.jsp");
        rd.forward(request, response);
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            List<CompaniaBean> compania = comp.findbyid(id);
            request.setAttribute("compania", compania);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("editarCompania.jsp");
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
