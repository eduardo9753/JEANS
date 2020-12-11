package controlador;

import Datos.Admin;
import Mantenimiento.CRUDAdmin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerAdmin extends HttpServlet {

    //Vistas
    String login = "Sistema/login.jsp";
    
    //Clases
    Admin admin = new Admin();

    //logica
    CRUDAdmin crudAdmin = new CRUDAdmin();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        String accesoVista = "";

        if (accion.equalsIgnoreCase("Ingresar")) {
            admin.setNombreAdmin(request.getParameter("txtnomUsuario"));
            admin.setCorreo(request.getParameter("txtcorreo"));
            admin = crudAdmin.BuscarAdmin(admin);
            String Usuario = request.getParameter("txtnomUsuario");
            String Correo = request.getParameter("txtcorreo");

            if (admin.getNombreAdmin().equals(Usuario) && admin.getCorreo().equals(Correo)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("nombre", admin.getNombre());
                session.setAttribute("correo", admin.getCorreo());
                request.getRequestDispatcher("ControllerSistema?menu=Principal").forward(request, response);
            }
            else{
               request.getRequestDispatcher("ControllerAdmin?accion=Login").forward(request, response);
            }
        }

        if (accion.equalsIgnoreCase("Salir")) {
            request.getSession().invalidate();
            accesoVista = login;
        }
        //esta peticion viene directo de la pagina index.jsp
        if (accion.equalsIgnoreCase("Login")) {
            request.getSession().invalidate();
            accesoVista = login;
        }
        RequestDispatcher vista = request.getRequestDispatcher(accesoVista);
        vista.forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
