/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CargosDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CargosBean;

/**
 *
 * @author maria.aguillonusam
 */
public class CargosServlet extends HttpServlet {
    Conexion conn = new Conexion();
    CargosDao cd = new CargosDao(conn);
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
            case "consultarAll":
                consultarAll(request, response);
        }
    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cargo = request.getParameter("cargo");
        
        CargosBean cb = new CargosBean(0);
        cb.setCargo(cargo);
        
        respuesta = cd.insertar(cb);
        if (respuesta) {
            msg = "Guardado";
        }else{
            msg = "No guardado";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registroCargos.jsp");
        rd.forward(request, response);
    }
    
    protected void consultarAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CargosBean> lista = cd.consultarAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/cargos.jsp");
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
