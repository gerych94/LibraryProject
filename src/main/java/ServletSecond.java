import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Vitaliy on 05.03.2017.
 */
public class ServletSecond extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Мои рисунки</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>First Image</h2>");
        printWriter.println("<p><img src=\"resources/joinus-java.png\" width=\"200\" height=\"250\"></p>");
        printWriter.println("<h1>Second Image</h2>");
        printWriter.println("<p><img src=\"resources/computers_geek_programming_desktop_1920x1200_hd-wallpaper-509289.png\" width=\"250\" height=\"250\"></p>");
        printWriter.println("<h1>Third Image</h2>");
        printWriter.println("<p><img src=\"resources/46af0923113ef63ffbb15bb78345e203.jpg\" width=\"250\" height=\"250\"></p>");
        printWriter.println(" </body>");
        printWriter.println("</html>");
    }
}
