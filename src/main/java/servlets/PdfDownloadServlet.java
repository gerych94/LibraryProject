package servlets;

import dao.BookDaoJNDI;
import model.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspApplicationContext;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Vitaliy on 27.06.2017.
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/PdfDownloadServlet"})
public class PdfDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("application/pdf");
        OutputStream outputStream=resp.getOutputStream();
        List<Book> bookList= (List<Book>) req.getSession().getAttribute("currentBookList");
        Book book=bookList.get(Integer.parseInt(req.getParameter("index")));
        BookDaoJNDI bookDaoJNDI= (BookDaoJNDI) req.getSession().getAttribute("BookDao");
        book.setContent(bookDaoJNDI.getBookContent(book.getId()));
        resp.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(book.getBookName(),"UTF-8")+".pdf");
        outputStream.write(book.getContent());
    }
}
