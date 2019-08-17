/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.EmisionesDao;
import dao.ProgramaradioDAO;
import dao.ProgramasDAO;
import dao.RadioDao;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EmisionesBean;
import modelo.ProgramaradioBean;
import modelo.ProgramasBean;
import modelo.RadioBean;

/**
 *
 * @author rodrigo.martinezusam
 */
public class ProgramaRadioServlet extends HttpServlet {

    Conexion conn = new Conexion();
    ProgramaradioDAO prad = new ProgramaradioDAO(conn);
    RequestDispatcher rd;
    boolean respuesta;
    String msg;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {

            case "insertar":
                insertar(request, response);
                break;
            case "findAll":
                findAll(request, response);
                break;
            case "update": 
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "getbyID":
                getbyID(request, response);
                break;
            case "showRegistro":
                showRegistro(request, response);
                break;

        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<ProgramaradioBean> list = prad.findAll();
            request.setAttribute("lista", list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/programaRadio.jsp");
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        System.out.println(request.getParameter("hora"));
        int programa = Integer.parseInt(request.getParameter("programa"));
        int radio = Integer.parseInt(request.getParameter("radio"));
        /*DUDAS... -->*/boolean isWhatever = Boolean.parseBoolean( request.getParameter("whatever") );
        String fecha = request.getParameter("fecha");
        String hora_inicio = request.getParameter("hora");

        int duracion = Integer.parseInt(request.getParameter("duracion"));
        boolean repeticion = Boolean.getBoolean(request.getParameter("repe"));
        String [] s = request.getParameterValues("repe");
        
        System.out.println(isWhatever);
        int emision = Integer.parseInt(request.getParameter("emision"));

        ProgramaradioBean pr = new ProgramaradioBean(0);
        ProgramasBean p = new ProgramasBean(programa);
        pr.setPrograma(p);
        RadioBean r = new RadioBean(radio);
        pr.setRadio(r);
        pr.setFecha(fecha);
        pr.setHora_inicio(hora_inicio);
        pr.setDuracion(duracion);
        pr.setRepeticion(isWhatever);
        EmisionesBean em = new EmisionesBean(emision);
        pr.setEmisiones(em);

        respuesta = prad.insertar(pr);
        if (respuesta) {
            msg = "<div id=\"moo\" class=\"alert alert-success alert-dismissible\" role=\"alert\" auto-close=\"3000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Éxito! Registro guardado...\n"
                    + "</div>";
        }else{
            msg = "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\" auto-close=\"5000\">\n"
                    + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>\n"
                    + "  </button>\n"
                    + "  Error! El registro no se pudo guardar...\n"
                    + "</div>";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registroPrograRadio.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_programaradio = Integer.parseInt(request.getParameter("id_programaradio"));
        int programa = Integer.parseInt(request.getParameter("programa"));
        int radio = Integer.parseInt(request.getParameter("radio"));
        /*DUDAS... -->*/
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        Time hora_inicio = Time.valueOf(request.getParameter("hora_inicio"));

        int duracion = Integer.parseInt(request.getParameter("duracion"));
        boolean repeticion = Boolean.getBoolean(request.getParameter("repeticion"));
        /*<-- ....*/
        int emision = Integer.parseInt(request.getParameter("emision"));

        ProgramaradioBean pr = new ProgramaradioBean(id_programaradio);
        ProgramasBean p = new ProgramasBean(programa);
        pr.setPrograma(p);
        RadioBean r = new RadioBean(radio);
        pr.setRadio(r);
        //pr.setFecha(fecha);
        //pr.setHora_inicio(hora_inicio);
        pr.setDuracion(duracion);
        pr.setRepeticion(repeticion);
        EmisionesBean em = new EmisionesBean(emision);
        pr.setEmisiones(em);

        try {
            prad.update(pr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/programasRadio.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_programaradio = Integer.parseInt(request.getParameter("id_programaradio"));
        try {
            prad.delete(id_programaradio);
            List<ProgramaradioBean> list = prad.findAll();
            request.setAttribute("lista", list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/programasRadio.jsp");
        rd.forward(request, response);
    }

    protected void getbyID(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_programaradio = Integer.parseInt(request.getParameter("id_programaradio"));
        try {
            List<ProgramaradioBean> lista = prad.finbyID(id_programaradio);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/programasRadio.jsp");
        rd.forward(request, response);

    }
    protected void showRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProgramasDAO p = new ProgramasDAO(conn);
        RadioDao r = new RadioDao(conn);
        EmisionesDao e = new EmisionesDao(conn);
        
        List<ProgramasBean> programas = p.mostrarProgramas();
        List<RadioBean> radios = r.findAll();
        List<EmisionesBean> emisiones = e.consultarAll();
        
        request.setAttribute("programas", programas);
        request.setAttribute("radios", radios);
        request.setAttribute("emisiones", emisiones);
        rd = request.getRequestDispatcher("registroPrograRadio.jsp");
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
