import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; */
public class LoginServlet extends HttpServlet{
public void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String username = req.getParameter("pname");
String password = req.getParameter("pvalue");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc: mysql://localhost: 3306/LOGIN?useSSL=false", "admin", "Manasa@2004");
Statement stm = con.createStatement ();
ResultSet rs= stm.executeQuery("select * from USERLOGIN where pname='"+username+" ' and pvalue='"+password+"'");
if(rs.next()){
out.println("success");
}else{
out.println("wrong username and password");
}
con.close();
}catch(Exception e) { System.out.println(e.getMessage());}
}
}