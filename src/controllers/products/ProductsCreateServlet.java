package controllers.products;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import models.validators.ProductValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ProductsCreateServlet
 */
@WebServlet("/products/create")
public class ProductsCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = (String) request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Product p = new Product();

            p.setBrand_name(request.getParameter("brand_name"));
            p.setProduct(request.getParameter("product"));
            p.setProduct_number(Integer.parseInt(request.getParameter("product_number")));
            p.setSize(request.getParameter("size"));
            p.setColor(request.getParameter("color"));
            p.setPrice(Integer.parseInt(request.getParameter("price")));

            Date currentDate = new Date(System.currentTimeMillis());
            p.setCreated_date(currentDate);

            List<String> errors = ProductValidator.validate(p);
            if (errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("product", p);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/toppage/index");
            }
        }
    }

}