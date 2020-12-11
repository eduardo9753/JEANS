package controlador;

import Conexion.Fechas;
import Datos.CarritoProducto;
import Datos.Cliente;
import Datos.Compras;
import Datos.Producto;
import Datos.Sector;
import Logica.LogicaCompras;
import Logica.LogicaProducto;
import Logica.LogicaSector;
import Mantenimiento.CRUDCliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController extends HttpServlet {

    //VISTAS O INTERFACES
    String productos = "Vistas/Productos.jsp";
    String Miproducto = "Vistas/MiProducto.jsp";
    String CarritoCompras = "Vistas/CarritoCompras.jsp";
    String DetalleCompras = "Vistas/DetalleCompras.jsp";
    String Exito = "Vistas/Exito.jsp";
    String Index = "index.jsp";

    //OBEJTO LOGICA PRODUCTO (pequete Logica)
    LogicaProducto logicaproducto = new LogicaProducto();

    //PRODUCTO PRODUCTO (pequete Datos)
    Producto producto = new Producto();

    //OBJETO CLIENTE
    Cliente cliente = new Cliente();

    //OBJETO COMPRAS
    Compras compra = new Compras();

    //LISTA DONDE GUARDO TODO MIS PRODUCTOS
    List<Producto> listPro = new ArrayList<>();

    //VARIABLE QUE ME GUARDA LA CANTIDAD DE PRODUCTOS
    int cantiproducto = 0;

    //LISTA DONDE GUARDO MIS PRODUCTOS
    List<CarritoProducto> micarrito = new ArrayList<>();
    double TotalPago = 0;
    int idproducto = 0;

    //CLASE DONDE ESTAN MIS CONSULTAS CON SQL(PAQUETE LOGICA)
    LogicaSector logicasector = new LogicaSector();

    //LISTA DONDE GUARDO MIS SECTORES
    List<Sector> listSector = new ArrayList<>();

    //CLASE MANTENIMIENTO CLIENTE
    CRUDCliente crudcliente = new CRUDCliente();

    //CLASE DONDE ESTA MI CONSULTA PARA GENERAR LA COMPRA
    LogicaCompras logicacompras = new LogicaCompras();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accesoVista = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("index")) {
            accesoVista = Index;
        }

        //PARA VER TODOS  MIS PRODUCTOS
        if (action.equalsIgnoreCase("VerProductos")) {
            listPro = logicaproducto.listar();
            request.setAttribute("producto", listPro);
            //contabiliza cuantos productos hay en el carrito
            request.setAttribute("contador", micarrito.size());
            accesoVista = productos;
        }

        //PARA VER UN PRODUCTO POR IDPRODUCTO
        if (action.equalsIgnoreCase("MiProducto")) {
            idproducto = Integer.parseInt(request.getParameter("idpro"));
            producto = logicaproducto.VerProductoPorId(idproducto);
            request.setAttribute("producto", producto);
            //contabiliza cuantos productos hay en el carrito
            request.setAttribute("contador", micarrito.size());
            accesoVista = Miproducto;
        }

        //PARA AGREGAR UN PRODUCTO A MI CARRITO
        if (action.equalsIgnoreCase("Agregar")) {
            int posicionProducto = 0;
            idproducto = Integer.parseInt(request.getParameter("txtidpro"));
            int cantidad = Integer.parseInt(request.getParameter("txtcantidad"));
            producto = logicaproducto.VerProductoPorId(idproducto);

            if (micarrito.size() >= 1) {
                for (int indice = 0; indice < micarrito.size(); indice++) {
                    if (idproducto == micarrito.get(indice).getIdProducto()) {
                        posicionProducto = indice;
                    }
                }
                if (idproducto == micarrito.get(posicionProducto).getIdProducto()) {
                    cantidad = cantidad + micarrito.get(posicionProducto).getCantidad();
                    TotalPago = TotalPago + micarrito.get(posicionProducto).Costo();
                    micarrito.get(posicionProducto).setCantidad(cantidad);
                } else {
                    //OBJETO CARRITO
                    CarritoProducto cp = new CarritoProducto();
                    cantiproducto = cantiproducto + 1;
                    cp.setCatidadProducto(cantiproducto);
                    cp.setIdProducto(producto.getIdProducto());
                    cp.setNombre(producto.getNombres());
                    cp.setImagen(producto.getImagen());
                    cp.setDescripcion(producto.getDescripcion());
                    cp.setPrecio(producto.getPrecio());
                    cp.setCantidad(cantidad);
                    cp.setCategoria(producto.getIdcategoria());
                    cp.setEstado(producto.getIdestado());
                    cp.Costo();
                    micarrito.add(cp);
                }
            } else {
                //OBJETO CARRITO
                CarritoProducto cp = new CarritoProducto();
                cantiproducto = cantiproducto + 1;
                cp.setCatidadProducto(cantiproducto);
                cp.setIdProducto(producto.getIdProducto());
                cp.setNombre(producto.getNombres());
                cp.setImagen(producto.getImagen());
                cp.setDescripcion(producto.getDescripcion());
                cp.setPrecio(producto.getPrecio());
                cp.setCantidad(cantidad);
                cp.setCategoria(producto.getIdcategoria());
                cp.setEstado(producto.getIdestado());
                cp.Costo();
                micarrito.add(cp);
            }

            //contabiliza cuantos productos hay en el carrito
            request.setAttribute("contador", micarrito.size());
            request.getRequestDispatcher("ServletController?accion=VerProductos").forward(request, response);
        }

        //RUTA O VISTA DONDE ME DIRECCION A CARRITOCOMPRAS
        if (action.equalsIgnoreCase("Comprar")) {
            int posicionProducto = 0;
            int cantidad = 1;
            idproducto = Integer.parseInt(request.getParameter("idpro"));
            producto = logicaproducto.VerProductoPorId(idproducto);

            if (micarrito.size() >= 1) {
                for (int indice = 0; indice < micarrito.size(); indice++) {
                    if (idproducto == micarrito.get(indice).getIdProducto()) {
                        posicionProducto = indice;
                    }
                }
                if (idproducto == micarrito.get(posicionProducto).getIdProducto()) {
                    cantidad = cantidad + micarrito.get(posicionProducto).getCantidad();
                    TotalPago = TotalPago + micarrito.get(posicionProducto).Costo();
                    micarrito.get(posicionProducto).setCantidad(cantidad);
                } else {
                    //OBJETO CARRITO
                    CarritoProducto cp = new CarritoProducto();
                    cantiproducto = cantiproducto + 1;
                    cp.setCatidadProducto(cantiproducto);
                    cp.setIdProducto(producto.getIdProducto());
                    cp.setNombre(producto.getNombres());
                    cp.setImagen(producto.getImagen());
                    cp.setDescripcion(producto.getDescripcion());
                    cp.setPrecio(producto.getPrecio());
                    cp.setCantidad(cantidad);
                    cp.setCategoria(producto.getIdcategoria());
                    cp.setEstado(producto.getIdestado());
                    cp.Costo();
                    micarrito.add(cp);
                }
            } else {
                //OBJETO CARRITO
                CarritoProducto cp = new CarritoProducto();
                cantiproducto = cantiproducto + 1;
                cp.setCatidadProducto(cantiproducto);
                cp.setIdProducto(producto.getIdProducto());
                cp.setNombre(producto.getNombres());
                cp.setImagen(producto.getImagen());
                cp.setDescripcion(producto.getDescripcion());
                cp.setPrecio(producto.getPrecio());
                cp.setCantidad(cantidad);
                cp.setCategoria(producto.getIdcategoria());
                cp.setEstado(producto.getIdestado());
                cp.Costo();
                micarrito.add(cp);
            }

            TotalPago = 0;
            for (int indice = 0; indice < micarrito.size(); indice++) {
                TotalPago = TotalPago + micarrito.get(indice).Costo();
            }

            request.setAttribute("TotalPago", TotalPago);
            request.setAttribute("carrito", micarrito);
            accesoVista = CarritoCompras;
        }

        //RUTA O VISTA DONDE ME DIRECCIONA A CARRITO COMPRAS
        if (action.equalsIgnoreCase("CarritoCompras")) {
            TotalPago = 0;
            for (int indice = 0; indice < micarrito.size(); indice++) {
                TotalPago = TotalPago + micarrito.get(indice).Costo();
            }
            request.setAttribute("TotalPago", TotalPago);
            request.setAttribute("carrito", micarrito);
            accesoVista = CarritoCompras;
        }

        //ELIMINAR UN CARRITO DE LA LISTA
        if (action.equalsIgnoreCase("Delete")) {
            idproducto = Integer.parseInt(request.getParameter("idp"));
            for (int indice = 0; indice < micarrito.size(); indice++) {
                if (micarrito.get(indice).getIdProducto() == idproducto) {
                    micarrito.remove(indice);
                }
            }
            request.getRequestDispatcher("ServletController?accion=CarritoCompras").forward(request, response);
        }

        //DETALLES DE LA COMPRAS
        if (action.equalsIgnoreCase("Adquirir")) {
            listSector = logicasector.listarSector();
            //mandamos la variable para llenar los campos   
            request.setAttribute("sector", listSector);
            request.setAttribute("TotalPago", TotalPago);
            request.setAttribute("carrito", micarrito);
            accesoVista = DetalleCompras;
        }

        //REGISTRAR LA COMPRA
        if (action.equalsIgnoreCase("Facturar")) {

            if (TotalPago > 0) {
                //datos del cliente
                cliente.setDni(request.getParameter("txtdni"));
                cliente.setNombres(request.getParameter("txtnombre"));
                cliente.setPrimerApellido(request.getParameter("txtprimerapellido"));
                cliente.setDireccion(request.getParameter("txtdireccion"));
                cliente.setEmail(request.getParameter("txtemail"));
                cliente.setCelular(Integer.parseInt(request.getParameter("txtcelular")));
                cliente.setIdsector(request.getParameter("cbosector"));
                cliente.setEstado_cliente(1);
                boolean insertado = crudcliente.InsertCliente(cliente);

                if (insertado) {
                    //datos de la compra
                    compra.setDni(cliente.getDni());
                    compra.setFechaCompras(Fechas.Fecha());//funcion estatica
                    compra.setMonto(TotalPago);
                    compra.setEstado("COMPRADO");
                    compra.setEstado_compras(1);
                    compra.setDetalleCompras(micarrito);
                    boolean success = logicacompras.GenerarCompra(compra, cliente);

                    if (success && TotalPago > 0) {
                        for (int indice = 0; indice < micarrito.size(); indice++) {
                            micarrito.remove(indice);
                        }
                        accesoVista = Exito;
                    }
                }
            } else if (micarrito.isEmpty() && TotalPago <= 0) {
                request.getRequestDispatcher("Vistas/Error.jsp").forward(request, response);
            }
        }/*cierre*/

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
