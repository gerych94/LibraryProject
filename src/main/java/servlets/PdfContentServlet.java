package servlets;

import dao.BookDaoJNDI;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 04.06.2017.
 */
@WebServlet(name = "ContentServlet", urlPatterns = {"/PdfContentServlet"})
public class PdfContentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        OutputStream outputStream=resp.getOutputStream();
        List<Book> bookList= (List<Book>) req.getSession().getAttribute("currentBookList");
        Book book=bookList.get(Integer.parseInt(req.getParameter("index")));
        BookDaoJNDI bookDaoJNDI= (BookDaoJNDI) req.getSession().getAttribute("BookDao");
        book.setContent(bookDaoJNDI.getBookContent(book.getId()));
        resp.setContentLength(book.getContent().length);
        outputStream.write(book.getContent());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
