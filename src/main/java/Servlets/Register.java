package simpleservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {
    
    //Post request to create a new user and add their information to the database.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isRequestEmpty(request)){
            //Make sure all information required it's entered.
            request.setAttribute("message", "Unable to create account, Please make sure you enter all information required");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            //Add user to the database in case user doesn't exits.
            String userName = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Member member = new Member(userName, email, password);
            RegisterDao registration = new RegisterDao();
            try {
                registration.insert(member);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.setAttribute("message", "Account Created Successfully!! Please log in.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    //Post request in case user exists and wants to change their information.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //Method to checks if all fields are entered.
    protected boolean isRequestEmpty(HttpServletRequest request){
        String user = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String empty = "";
        return user.equals(empty) || email.equals(empty) || pass.equals(empty);
    }
}
