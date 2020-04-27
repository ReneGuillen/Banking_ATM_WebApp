package simpleservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isRequestEmpty(request)){
            request.setAttribute("message", "Unsuccessful Login, Please make sure you enter all information required");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            Member member = new Member(username, password);
            RegisterDao login = new RegisterDao();
            try {
                if (login.retrieve(member)) {
                    request.setAttribute("userName", username);
                    request.setAttribute("balance", login.showBalance(username));
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    request.setAttribute("message", "Invalid Login, Please try again!");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected boolean isRequestEmpty(HttpServletRequest request){
        String user = request.getParameter("userName");
        String pass = request.getParameter("password");
        String empty = "";
        return user.equals(empty) || pass.equals(empty);
    }
}
