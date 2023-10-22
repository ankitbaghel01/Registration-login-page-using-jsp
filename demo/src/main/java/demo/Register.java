package demo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out=response.getWriter();
		String myname = request.getParameter("name");
        String myemail = request.getParameter("email");
        String mypassword = request.getParameter("password");
        String mygender = request.getParameter("gender");
        String mycity = request.getParameter("city");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "1234");
            String sql = "INSERT INTO register (name, email, password,gender,city) VALUES (?, ?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, myname);
            statement.setString(2, myemail);
            statement.setString(3, mypassword);
            statement.setString(4, mygender);
            statement.setString(5, mycity);

            int count=statement.executeUpdate();
            if(count>0) {
            	response.setContentType("text/html");
            	out.print("<h3>Success fully register</h3>");
            RequestDispatcher rd=request.getRequestDispatcher("/registration.jsp");
            rd.include(request, response);
            }else {
            	response.setContentType("text/html");
            	out.print("<h3 style='Color:red'> User not register fully register</h3>");
            RequestDispatcher rd=request.getRequestDispatcher("/registration.jsp");
            rd.include(request, response);
            }
        } catch (Exception e) {
     e.printStackTrace();
 	response.setContentType("text/html");
	out.print("<h3 style='color:red'>"+e.getMessage()+"</h3>");
RequestDispatcher rd=request.getRequestDispatcher("/registration.jsp");
rd.include(request, response);
        }
    }
}
