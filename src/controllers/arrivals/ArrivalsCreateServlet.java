package controllers.arrivals;

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

import models.Arrival;
import models.Product;
import models.Store;
import models.validators.ArrivalValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ArrivalsCreateServlet
 */
@WebServlet("/arrivals/create")
public class ArrivalsCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArrivalsCreateServlet() {
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

            Arrival a = new Arrival();
            a.setProduct_number(Integer.parseInt(request.getParameter("product_number")));

            Product product = em.createNamedQuery("checkRegisteredProduct_number", Product.class)
                    .setParameter("product_number", a.getProduct_number())
                    .getSingleResult();

            a.setProduct(product);
            a.setStore((Store) request.getSession().getAttribute("login_store"));
            a.setQuantity(Integer.parseInt(request.getParameter("quantity")));

            Date currentDate = Date.valueOf(request.getParameter("arrival_date"));
            a.setArrival_date(currentDate);

            List<String> errors = ArrivalValidator.validate(a);
            if (errors.size() > 0) {

                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("arrival", a);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/arrivals/new.jsp");

                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(a);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/toppage/index");
            }
        }
    }
}
