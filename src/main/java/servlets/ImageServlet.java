package servlets;

import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Vitaliy on 30.05.2017.
 */
@WebServlet(name = "ImageServlet", urlPatterns = {"/ShowImage"})
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        OutputStream out = resp.getOutputStream();
        ArrayList<Book> bookArrayList = (ArrayList<Book>) req.getSession().getAttribute("currentBookList");
        Book book = bookArrayList.get(Integer.valueOf(req.getParameter("index")));
        resp.setContentLength(book.getImage().length);
        out.write(book.getImage());
        out.close();
    }
}
