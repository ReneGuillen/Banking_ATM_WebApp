package simpleservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet", urlPatterns = {"/Home"})
public class Servlet extends HttpServlet {
    protected RegisterDao registerDao = new RegisterDao();
    protected Transactions transactions = new Transactions();

    //Post Method to make transaction and update user's information in the database.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        if(request.getParameter("option") != null) {
            try {
                makeTransaction(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            request.setAttribute("userName", username);
            request.setAttribute("balance", registerDao.showBalance(username));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(request, response);

    }

    //Get Method to get user's information from database.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //Method to get all information from imput to send it to the database and make the correspondant transaction.
    protected void makeTransaction(HttpServletRequest request) throws ServletException, IOException, SQLException {
        String option = request.getParameter("option");
        String username = request.getParameter("userName");
        transactions.setBalance(Double.parseDouble(registerDao.showBalance(username)));
        if(option.equals("Deposit") && !notEmpty(request)) {
            Double i = getAmount(request);
            transactions.deposit(i);
            registerDao.updateBalance(username, transactions.getBalance());
            request.setAttribute("alert", " You deposit $" + i + " in your account");
        }
        else if(option.equals("Withdraw") && !notEmpty(request)){
            Double i = getAmount(request);
            if(transactions.noBalance(i)) {
                request.setAttribute("alert", " You do not have enough balance in your account!");
            }else {
                transactions.withdraw(i);
                registerDao.updateBalance(username, transactions.getBalance());
                request.setAttribute("alert", " You withdraw $" + i + " from your account");
            }
        }
        else if(option.equals("Apply Now!") && isLoanEmpty(request)){
            double credit = Double.parseDouble(request.getParameter("Credit Score"));
            Double i = getAmount(request);
            if (credit >= 700){
                transactions.applyLoan(i,credit);
                registerDao.updateBalance(username, transactions.getBalance());
                request.setAttribute("alert", "Your loan has been approved and added to your account!");
            }
            else{
                request.setAttribute("alert", "Your credit score is too low!");
            }
        }
        else if(option.equals("Transfer Now!") && isTransferEmpty(request)){
            Double i = getAmount(request);
            if(transactions.noBalance(i)) {
                request.setAttribute("alert", " You do not have enough balance in your account!");
            }
            else {
                transactions.withdraw(i);
                registerDao.updateBalance(username, transactions.getBalance());
                String user = request.getParameter("username");
                double balance = Double.parseDouble(registerDao.showBalance(user));
                registerDao.updateBalance(user, Double.toString(i + balance));
                request.setAttribute("alert", " You have transfer $" + i + " to " + user);
            }
        }
        else{

            request.setAttribute("alert", "Unsuccessful Operation, Please try again and enter all required information");
        }

    }

    //Method to convert amount to double digits.
    protected Double getAmount(HttpServletRequest request){
        return Double.parseDouble(request.getParameter("Amount"));
    }

   //Method to make sure amount is not empty. 
    protected boolean notEmpty(HttpServletRequest request){
        return request.getParameter("Amount") == null || request.getParameter("Amount").equals("");
    }

    //method to make sure all the information required for a transaction is entered.
    protected boolean isTransferEmpty(HttpServletRequest request){
        String user = request.getParameter("username");
        String amount = request.getParameter("Amount");
        String email = request.getParameter("Email");
        String empty = "";
        return !user.equals(empty) || !amount.equals(empty) || !email.equals(empty);
    }
    
    //Method to make sure all the information required for a loan is entered.
    protected boolean isLoanEmpty(HttpServletRequest request){
        String user = request.getParameter("userName");
        String amount = request.getParameter("Amount");
        String pass = request.getParameter("Credit Score");
        String empty = "";
        return !user.equals(empty) || !amount.equals(empty) || !pass.equals(empty);
    }
}
