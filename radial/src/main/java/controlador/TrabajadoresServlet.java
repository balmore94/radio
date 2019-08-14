/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.TrabajadoresDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CargosBean;
import modelo.CompaniaBean;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {

            case "insertar":
                insertar(request, response);
                break;
        }
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre_trabajador = request.getParameter("nombre_trabajador");
        String apellido_trabajador = request.getParameter("apellido_trabajador");
        String dui = request.getParameter("dui");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        int programa = Integer.parseInt(request.getParameter("programa_trabajador"));

        TrabajadoresBean tra = new TrabajadoresBean(0);
        tra.setNombre_trabajador(nombre_trabajador);
        tra.setApellido_trabajador(apellido_trabajador);
        tra.setDui(dui);

        CargosBean car = new CargosBean(cargo);
        tra.setCargo(car);
        ProgramasBean pr = new ProgramasBean(programa);
        tra.setPrograma_trabajador(pr);

        try {
            trab.insertar(tra);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/*.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_trabajador = Integer.parseInt(request.getParameter("id_trabajador"));
        String nombre_trabajador = request.getParameter("nombre_trabajador");
        String apellido_trabajador = request.getParameter("apellido_trabajador");
        String dui = request.getParameter("dui");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        int programa = Integer.parseInt(request.getParameter("programa_trabajador"));

        TrabajadoresBean tra = new TrabajadoresBean(id_trabajador);
        tra.setNombre_trabajador(nombre_trabajador);
        tra.setApellido_trabajador(apellido_trabajador);
        tra.setDui(dui);

        CargosBean car = new CargosBean(cargo);
        tra.setCargo(car);
        ProgramasBean pr = new ProgramasBean(programa);
        tra.setPrograma_trabajador(pr);

        try {
            trab.update(tra);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/*.jsp");
        rd.forward(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<TrabajadoresBean> Lista = trab.LlenarTrabajadores();
            request.setAttribute("Lista", Lista);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/*.jsp");
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
        int id_trabajadores = Integer.parseInt(request.getParameter("id_trabajadores"));
        try {
            List<TrabajadoresBean> lista = trab.findbyid(id_trabajadores);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/*.jsp");
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
