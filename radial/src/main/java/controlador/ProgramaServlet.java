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
            case "guardar":
                guardar(request, response);
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

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String programa = request.getParameter("programa");
        int genero = Integer.parseInt(request.getParameter("genero"));
        
        
        ProgramasBean prob = new ProgramasBean(0);
        prob.setNombre_programa(programa);
        GeneroBean geb = new GeneroBean(genero);
        prob.setGenero(geb);
        List<GeneroBean> lista = gen.findAll();
        res = pro.guardar(prob);
        if(res){
            msj = "Exito";
        } else {
            msj = "Error";
        }
        request.setAttribute("lista", lista);
        request.setAttribute("msj", msj);
        rd = request.getRequestDispatcher("/registroProgramas.jsp");
        rd.forward(request, response);
        } 

    
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void getbyid(HttpServletRequest request, HttpServletResponse response)
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
