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

    boolean aa;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        switch(action){
            case "insertar":Insertar(request, response);
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

        try {
            comp.insertar(co);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        rd = request.getRequestDispatcher("Regcompania.jsp");
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

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
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
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
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
        rd = request.getRequestDispatcher("editcompania.jsp");
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
