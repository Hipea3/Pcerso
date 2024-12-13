package controller;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import util.DBConnection;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    ProductoDAO productoDao = new ProductoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null || accion.isEmpty()) {
            //ir a la lista
            listarProductos(request, response);
        } else {
            switch (accion) {
                case "nuevo":
                    nuevoProducto(request, response);
                    break;
                case "edit":
                    editProducto(request, response);
                    break;
                case "delete":
                    deleteProducto(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Productos producto = null;
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        String cantidad = request.getParameter("cantidad");
        if (id == null || id.isEmpty()) {
            producto = new Productos(nombre, categoria, Integer.parseInt(cantidad));
            productoDao.save(producto);
            listarProductos(request, response);
        } else {
            producto = new Productos(Integer.parseInt(id), nombre, categoria, Integer.parseInt(cantidad));
            productoDao.update(producto);
            listarProductos(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Productos> list = new ArrayList<>();
        list = productoDao.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void nuevoProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect("form-producto.jsp");

    }

    private void editProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Productos producto;
        int id = Integer.parseInt(request.getParameter("id"));

        producto = productoDao.getById(id);
        request.setAttribute("producto", producto);
        request.getRequestDispatcher("actualizar-producto.jsp").forward(request, response);

    }

    private void deleteProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        productoDao.delete(id);
        listarProductos(request, response);

    }

}
