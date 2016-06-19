package mypackage;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class HelloServlet extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
	PrintWriter writer = response.getWriter();

        try{
           String userId = request.getParameter("userId").toString();
	   String reply = "alert(\"some text" + userId + "\");";
           writer.write(reply);
           writer.close();
           }
       catch(Exception ex) {
              ex.getStackTrace();
       } finally {
         writer.close();  // Always close the output writer
       }
   }
}
