/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.ProgramaradioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
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
        rd = request.getRequestDispatcher("/programasRadio.jsp");
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int programa = Integer.parseInt(request.getParameter("programa"));
        int radio = Integer.parseInt(request.getParameter("radio"));
        /*DUDAS... -->*/
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        Time hora_inicio = Time.valueOf(request.getParameter("hora_inicio"));

        int duracion = Integer.parseInt(request.getParameter("duracion"));
        boolean repeticion = Boolean.getBoolean(request.getParameter("repeticion"));
        /*<-- ....*/
        int emision = Integer.parseInt(request.getParameter("emision"));

        ProgramaradioBean pr = new ProgramaradioBean(0);
        ProgramasBean p = new ProgramasBean(programa);
        pr.setPrograma(p);
        RadioBean r = new RadioBean(radio);
        pr.setRadio(r);
        pr.setFecha(fecha);
        pr.setHora_inicio(hora_inicio);
        pr.setDuracion(duracion);
        pr.setRepeticion(repeticion);
        EmisionesBean em = new EmisionesBean(emision);
        pr.setEmisiones(em);

        try {
            prad.insertar(pr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        rd = request.getRequestDispatcher("/registroProgramaradio.jsp");
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
        pr.setFecha(fecha);
        pr.setHora_inicio(hora_inicio);
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
