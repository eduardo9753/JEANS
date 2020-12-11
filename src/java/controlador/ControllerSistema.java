package controlador;

import Datos.Admin;
import Datos.Categoria;
import Datos.Cliente;
import Datos.Compras;
import Datos.Estado;
import Datos.Factura;
import Datos.Producto;
import Datos.Sector;
import Logica.LogicaCategoria;
import Logica.LogicaEstado;
import Logica.LogicaFactura;
import Logica.LogicaSector;
import Mantenimiento.CRUDAdmin;
import Mantenimiento.CRUDCliente;
import Mantenimiento.CRUDProducto;
import Mantenimiento.CRUDVentas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerSistema extends HttpServlet {

    //VISTAS O INTERFACES
    String clientes = "Sistema/Clientes.jsp";
    String productos = "Sistema/Productos.jsp";
    String ventas = "Sistema/Ventas.jsp";
    String Productos = "Sistema/Productos.jsp";
    String Principal = "Sistema/Principal.jsp";
    String Administradores = "Sistema/Administradores.jsp";
    String login = "Sistema/login.jsp";
    String Index = "index.jsp";
    String Factura = "Sistema/Factura.jsp" ;
    
    
    //CLASE DONDE ESTAN MIS CONSULTAS CON SQL(PAQUETE LOGICA)
    LogicaCategoria logicacategoria = new LogicaCategoria();
    LogicaEstado logicaestado = new LogicaEstado();
    LogicaSector logicasector = new LogicaSector();
    
    //CLASE DONDE ESTAN MIS CONSULTAS CON SQL(PAQUETE SISTEMA)
    CRUDProducto crudProducto = new CRUDProducto();
    CRUDAdmin crudadmin = new CRUDAdmin();

    
    //CLASE PRODUCTO
    Producto producto = new Producto();
    //LISTA DONDE GUARDO TODO MIS PRODUCTOS
    List<Producto> listProducto = new ArrayList<>();
    //LISTA DONDE GUARDO LAS CATEGORIAS
    List<Categoria> listcategorias = new ArrayList<>();
    //LISTA DONDE GUARDO LOS ESTADOS
    List<Estado> listestados = new ArrayList<>();
    int idpro = 0;

    
    
    //CLASE DONDE ESTAN MIS CONSULTAS CON SQL(PAQUETE SISTEMA)
    CRUDCliente crudCliente = new CRUDCliente();
    //CLASE CLIENTE
    Cliente cliente = new Cliente();
    //LISTA DONDE GUARDO TODO MIS PRODUCTOS
    List<Cliente> listCliente = new ArrayList<>();
    int idcliente = 0;

    
    //CLASE CLIENTE PARA ELIMINAR 
    Cliente clienteEstado = new Cliente();
    Admin adminEstado = new Admin();
    Compras compraEstado = new Compras();
    
    //CLASE ADMIN
    Admin admin = new Admin();
    //LISTA DONDE GUARDO MIS ADMINISTRADORES
    List<Admin> listAdmin = new ArrayList<>();
    int idadmin = 0;

    
    //LISTA DONDE GUARDO MIS SECTORES
    List<Sector> listSector = new ArrayList<>();
    
    //LISTA DONDE GUARDO MIS COMPRAS
    List<Compras> listCompras = new ArrayList<>();
    //CLASE DONDE ESTAN MIS CONSULTAS CON SQL(PAQUETE SISTEMA)
    CRUDVentas crudventas = new CRUDVentas();
    int idcompras = 0;
    //CLASE COMPRAS
    Compras compras = new Compras();

    
    //VARIABLES FACTURA
    Factura myfactura = new Factura();
    LogicaFactura logicafactura = new LogicaFactura();
     
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String accesoVista = "";

        if (menu.equalsIgnoreCase("Principal")) {
            accesoVista = Principal;
        }
        /*MANTENIMIENTO PRODUCTO*/
        if (menu.equalsIgnoreCase("Productos")) {

            switch (accion) {
                case "Listar":
                    listcategorias = logicacategoria.listarCategoria();
                    listestados = logicaestado.listarEstado();
                    listProducto = crudProducto.listar();
                    //mandamos las variables para llenar los combos
                    request.setAttribute("categorias", listcategorias);
                    request.setAttribute("estados", listestados);
                    request.setAttribute("productos", listProducto);
                    break;

                case "Registrar":
                    producto.setNombres(request.getParameter("txtnombre"));
                    producto.setImagen(request.getParameter("txtimagen"));
                    producto.setDescripcion(request.getParameter("txtdescripcion"));
                    producto.setPrecio(Integer.parseInt(request.getParameter("txtprecio")));
                    producto.setStock(Integer.parseInt(request.getParameter("txtstock")));
                    producto.setIdcategoria(Integer.parseInt(request.getParameter("cboCategoria")));
                    producto.setIdestado(Integer.parseInt(request.getParameter("cboEstado")));
                    crudProducto.InsertProducto(producto);
                    request.getRequestDispatcher("ControllerSistema?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    idpro = Integer.parseInt(request.getParameter("id"));
                    producto = crudProducto.ProductoPorId(idpro);
                    request.setAttribute("prod", producto);
                    request.getRequestDispatcher("ControllerSistema?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    producto.setNombres(request.getParameter("txtnombre"));
                    producto.setImagen(request.getParameter("txtimagen"));
                    producto.setDescripcion(request.getParameter("txtdescripcion"));
                    producto.setPrecio(Float.parseFloat(request.getParameter("txtprecio")));
                    producto.setStock(Integer.parseInt(request.getParameter("txtstock")));
                    producto.setIdcategoria(Integer.parseInt(request.getParameter("cboCategoria")));
                    producto.setIdestado(Integer.parseInt(request.getParameter("cboEstado")));
                    producto.setIdProducto(Integer.parseInt(request.getParameter("txtidpro")));
                    crudProducto.UpdateProducto(producto);
                    request.getRequestDispatcher("ControllerSistema?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idpro = Integer.parseInt(request.getParameter("id"));
                    crudProducto.DeleteProducto(idpro);
                    request.getRequestDispatcher("ControllerSistema?menu=Productos&accion=Listar").forward(request, response);
                    break;
            }
            accesoVista = Productos;
        }
        /*MANTENIMIENTO CLIENTE*/
        if (menu.equalsIgnoreCase("Clientes")) {
            switch (accion) {
                case "Listar":
                    listCliente = crudCliente.listar();
                    listSector = logicasector.listarSector();
                    //mandamos la variable para llenar los campos
                    request.setAttribute("cliente", listCliente);
                    request.setAttribute("sector", listSector);
                    break;

                case "Registrar":
                    cliente.setDni(request.getParameter("txtdni"));
                    cliente.setNombres(request.getParameter("txtnombre"));
                    cliente.setPrimerApellido(request.getParameter("txtprimerapellido"));
                    cliente.setDireccion(request.getParameter("txtdireccion"));
                    cliente.setEmail(request.getParameter("txtemail"));
                    cliente.setCelular(Integer.parseInt(request.getParameter("txtcelular")));
                    cliente.setIdsector(request.getParameter("cbosector"));
                    cliente.setEstado_cliente(1);
                    crudCliente.InsertCliente(cliente);
                    request.getRequestDispatcher("ControllerSistema?menu=Clientes&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    idcliente = Integer.parseInt(request.getParameter("dni"));
                    cliente = crudCliente.ClientePorId(idcliente);
                    request.setAttribute("cli", cliente);
                    request.getRequestDispatcher("ControllerSistema?menu=Clientes&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    cliente.setNombres(request.getParameter("txtnombre"));
                    cliente.setPrimerApellido(request.getParameter("txtprimerapellido"));
                    cliente.setDireccion(request.getParameter("txtdireccion"));
                    cliente.setEmail(request.getParameter("txtemail"));
                    cliente.setCelular(Integer.parseInt(request.getParameter("txtcelular")));
                    cliente.setIdsector(request.getParameter("cbosector"));
                    cliente.setEstado_cliente(1);
                    cliente.setDni(request.getParameter("txtdni"));
                    crudCliente.Updatecliente(cliente);
                    request.getRequestDispatcher("ControllerSistema?menu=Clientes&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idcliente = Integer.parseInt(request.getParameter("dni"));
                    clienteEstado = crudCliente.ClientePorId(idcliente);
                    cliente.setNombres(clienteEstado.getNombres());
                    cliente.setPrimerApellido(clienteEstado.getPrimerApellido());
                    cliente.setDireccion(clienteEstado.getDireccion());
                    cliente.setEmail(clienteEstado.getEmail());
                    cliente.setCelular(clienteEstado.getCelular());
                    cliente.setIdsector(clienteEstado.getIdsector());
                    cliente.setEstado_cliente(0);
                    cliente.setDni(clienteEstado.getDni());
                    crudCliente.Updatecliente(clienteEstado);
                    request.getRequestDispatcher("ControllerSistema?menu=Clientes&accion=Listar").forward(request, response);
                    break;
            }
            accesoVista = clientes;
        }
        /*MANTENIMIENTO VENTAS*/
        if (menu.equalsIgnoreCase("Ventas")) {
            switch (accion) {
                case "Listar":
                    listCompras = crudventas.listar();
                    //mandamos la variable para llenar los campos
                    request.setAttribute("compras", listCompras);
                    break;
                    
                 case "Eliminar":
                    idcompras = Integer.parseInt(request.getParameter("idcompras"));
                    compraEstado = crudventas.ComprasPorId(idcompras);
                    compras.setDni(compraEstado.getDni());
                    compras.setFechaCompras(compraEstado.getFechaCompras());
                    compras.setMonto(compraEstado.getMonto());
                    compras.setEstado(compraEstado.getEstado());
                    compras.setEstado_compras(0);
                    compras.setIdCompras(compraEstado.getIdCompras());
                    crudventas.UpdateCompra(compras);
                    request.getRequestDispatcher("ControllerSistema?menu=Ventas&accion=Listar").forward(request, response);
                    break;
            }
            accesoVista = ventas;
        }
        /*MANTENIMIENTO ADMIN*/
        if (menu.equalsIgnoreCase("Administrador")) {
            switch (accion) {
                case "Listar":
                    listAdmin = crudadmin.listar();
                    //mandamos la variable para llenar los campos
                    request.setAttribute("admin", listAdmin);
                    break;

                case "Registrar":
                    admin.setNombre(request.getParameter("txtnombreadmin"));
                    admin.setPrimerApellido(request.getParameter("txtapellidoadmin"));
                    admin.setNombreAdmin(request.getParameter("txtnombreusuario"));
                    admin.setCorreo(request.getParameter("txtcorreo"));
                    admin.setIdrol(Integer.parseInt(request.getParameter("cborol")));
                    admin.setEstado_admin(1);
                    crudadmin.InsertAdmin(admin);
                    request.getRequestDispatcher("ControllerSistema?menu=Administrador&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    idadmin = Integer.parseInt(request.getParameter("idadmin"));
                    admin = crudadmin.AdminPorId(idadmin);
                    request.setAttribute("ad", admin);
                    request.getRequestDispatcher("ControllerSistema?menu=Administrador&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    admin.setNombre(request.getParameter("txtnombreadmin"));
                    admin.setPrimerApellido(request.getParameter("txtapellidoadmin"));
                    admin.setNombreAdmin(request.getParameter("txtnombreusuario"));
                    admin.setCorreo(request.getParameter("txtcorreo"));
                    admin.setIdrol(Integer.parseInt(request.getParameter("cborol")));
                    admin.setEstado_admin(1);
                    admin.setIdAmin(Integer.parseInt(request.getParameter("txtidadmin")));
                    crudadmin.UpdateAdmin(admin);
                    request.getRequestDispatcher("ControllerSistema?menu=Administrador&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idadmin = Integer.parseInt(request.getParameter("idadmin"));
                    adminEstado = crudadmin.AdminPorId(idadmin);
                    admin.setNombre(adminEstado.getNombre());
                    admin.setPrimerApellido(adminEstado.getPrimerApellido());
                    admin.setNombreAdmin(adminEstado.getNombreAdmin());
                    admin.setCorreo(adminEstado.getCorreo());
                    admin.setIdrol(adminEstado.getIdrol());
                    admin.setEstado_admin(0);
                    admin.setIdAmin(adminEstado.getIdAmin());
                    crudadmin.UpdateAdmin(admin);
                    request.getRequestDispatcher("ControllerSistema?menu=Administrador&accion=Listar").forward(request, response);
                    break;
            }
            accesoVista = Administradores;
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
