package controller;

import model.Product;
import model.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "Servlet", urlPatterns = "/products")
public class Servlet extends javax.servlet.http.HttpServlet {
    ProductService service = new ProductService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request,response);
                break;
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request, response);
                break;
            case "edit":
                showEditProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("prime");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");
        Product product = new Product(id, name, price, quantity, color, status);
        this.service.edieProduct(product);

        List<Product> productlist = service.getProductList();
        request.setAttribute("productList", productlist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list_product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = service.searchProductByID(id);
        request.setAttribute("editProduct", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/edit_product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteProduct(id);
        List<Product> productList = service.getProductList();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list_product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
//        int id = Integer.parseInt(request.getParameter("id"));
        String price = request.getParameter("prime");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");

        Product product = new Product(id, name, price, quantity, color, status);
        this.service.addNewProduct(product);

//        try {
//            request.getRequestDispatcher("/view/create_product.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        List<Product> productlist = service.getProductList();
        request.setAttribute("productList", productlist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list_product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/create_product.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void listProduct(HttpServletRequest request, HttpServletResponse response ) {

        List<Product> productlist = service.getProductList();
        request.setAttribute("productList", productlist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list_product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        Product product = service.getProductByName(name);
        List<Product> productlist = new ArrayList<>();
        productlist.add(product);
        request.setAttribute("productList", productlist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list_product.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
