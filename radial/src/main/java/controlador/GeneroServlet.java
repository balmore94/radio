/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.GeneroDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GeneroBean;

/**
 *
 * @author ronald.reyesusam
 */
public class GeneroServlet extends HttpServlet {

    Conexion conn = new Conexion();
    GeneroDao ged = new  GeneroDao(conn);
    RequestDispatcher rd;
    boolean resultado;
    String msg;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch(action){
            case "insertar": insertar(request, response);
                break;
        }
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        
        GeneroBean geb = new GeneroBean(0);
        geb.setNombre_genero(nombre);
        
        resultado = ged.insertar(geb);
        if (resultado) {
            msg ="insertado";
        }else{
            msg = "error";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("registro.jsp");
        rd.forward(request, response);
    }
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        
        GeneroBean geb = new GeneroBean(id);
        geb.setNombre_genero(nombre);
        
        resultado = ged.actualizar(geb);
        List<GeneroBean>generos = ged.findAll();
        if (resultado) {
            msg ="actualizado";
        }else{
            msg = "error";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("generos", generos);
        rd = request.getRequestDispatcher("mostrar.jsp");
        rd.forward(request, response);
    }
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        resultado = ged.eliminar(id);
        List<GeneroBean>generos = ged.findAll();
        if (resultado) {
            msg = "Registro eliminado";
        }else{
            msg = "Error al eliminar";
        }
        request.setAttribute("generos", generos);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("mostrar.jsp");
        rd.forward(request, response);
    }
    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<GeneroBean> generos = ged.findAll();
        request.setAttribute("generos", generos);
        rd = request.getRequestDispatcher("mostrar.jsp");
        rd.forward(request, response);
    }
    protected void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<GeneroBean> genero = ged.findById(id);
        request.setAttribute("genero", genero);
        rd = request.getRequestDispatcher("editarGenero.jsp");
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
