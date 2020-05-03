import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class universe extends HttpServlet {
Connection con;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
String studentname=request.getParameter("t1");
String fathername=request.getParameter("t2");
String dob=request.getParameter("t3");
String gender=request.getParameter("t4");
String email =request.getParameter("t5");
String Interest =request.getParameter("t6");
String mobileno =request.getParameter("t7");
String location =request.getParameter("t8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insert</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
Class.forName("com.mysql.jdbc.Driver") ;
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","");;
Statement stmt=con.createStatement();  
String query="insert into uni values(' "+studentname+" ',' "+fathername+" ',' "+dob+" ',' "+gender+" ',' "+email+" ',' "+Interest+" ',' "+mobileno+" ',' "+location+" ')";
int iupdate=stmt.executeUpdate(query);
if(iupdate>0)
{
out.println("<font size='14' color='blue'> Admission details registered successfully</font>");
out.println("<br>");
out.println("<a href='index.html'> Click here to regiter data again </a>");
}
else {
out.println("Admission data registered unsuccessfully");

}}
catch(Exception e)
{
e.printStackTrace();
out.println("data inserted unsuccessfully"); }
out.println("</body>");
out.println("</html>");
}
out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
 out.println("</body>");
 out.println("</html>");
   }
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}