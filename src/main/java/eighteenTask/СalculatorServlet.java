package eighteenTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Vitaliy on 08.03.2017.
 */
public class СalculatorServlet extends HttpServlet {

    private ArrayList<HttpSession> httpSessionArrayList;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.httpSessionArrayList=new ArrayList();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String operationName=request.getParameter("operation");
         double result=0;
         String resultString=request.getSession().getAttribute("result")==null?"":request.getSession().getAttribute("result").toString();
        switch (operationName){
            case "add":
                  result=Double.parseDouble(request.getParameter("oneNumber"))+Double.parseDouble(request.getParameter("twoNumber"));
                  resultString+=request.getParameter("oneNumber")+"+"+request.getParameter("twoNumber")+"="+result;
                  break;
            case "subtract":
                result=Double.parseDouble(request.getParameter("oneNumber"))-Double.parseDouble(request.getParameter("twoNumber"));
                resultString+=request.getParameter("oneNumber")+"-"+request.getParameter("twoNumber")+"="+result;
                break;
            case "multiply":
                result=Double.parseDouble(request.getParameter("oneNumber"))*Double.parseDouble(request.getParameter("twoNumber"));
                resultString+=request.getParameter("oneNumber")+"*"+request.getParameter("twoNumber")+"="+result;
                break;
            case "divide":
                result=Double.parseDouble(request.getParameter("oneNumber"))/Double.parseDouble(request.getParameter("twoNumber"));
                resultString+=request.getParameter("oneNumber")+"/"+request.getParameter("twoNumber")+"="+result;
                break;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Калькулятор</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<table width=\"100%\" cellspacing=\"50\" cellpadding=\"5\">");
        printWriter.println("<tr> ");
        printWriter.println("<td width=\"200\" valign=\"top\">Левая колонка</td><td valign=\"top\">Правая колонка</td>");
        printWriter.println("</tr>");
        printWriter.println("</table>");
        printWriter.println(" </body>");
        printWriter.println("</html>");



        request.getSession().setAttribute("result",resultString+System.lineSeparator());
        printWriter.println(resultString);
    }
}
