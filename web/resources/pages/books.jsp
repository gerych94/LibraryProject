<%@page import="model.Book" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="emums.SearchType" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%@include file="/WEB-INF/jspf/left_menu.jspf" %>
<%@include file="/WEB-INF/jspf/letters.jspf" %>
<jsp:useBean id="bookList" class="dao.BookDaoJNDI" scope="page"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<div class="book_list">
    <h3>${param.name}</h3>
    <table cellpadding="30" style="font-size: 12px;">
        <%
            List<Book> bookArrayList = null;

            if (request.getParameter("genre_id") != null) {
                bookArrayList = bookList.getBookListByGenreID(Integer.valueOf(request.getParameter("genre_id")));
            } else if (request.getParameter("letter") != null) {
                bookArrayList = bookList.getBookListByFirstLetter(request.getParameter("letter"));
            } else if (request.getParameter("search_String") != null) {
                SearchType searchType = request.getParameter("search_option").equals("Автор") ? SearchType.AUTHOR : SearchType.BOOKNAME;
                bookArrayList = bookList.getListBySearchType(request.getParameter("search_String"), searchType);
            }
            session.setAttribute("currentBookList", bookArrayList);
            session.setAttribute("BookDao",bookList); %>
        <h5 style="text-align: left; margin-top:5px;">Найдено книг: <%=bookArrayList.size() %>
        </h5>
        <%
            for (Book book : bookArrayList) {
        %>
        <div class="book_info">
            <div class="book_title">
                <p><%=book.getBookName()%>
                </p>
            </div>
            <div class="book_image">
                <img src="<%=request.getContextPath()%>/ShowImage?index=<%=bookArrayList.indexOf(book) %>" height="250"
                     width="190" alt="Обложка"/>
            </div>
            <div class="book_details">
                <br><strong>ISBN:</strong> <%=book.getIsbn()%>
                <br><strong>Издательство:</strong> <%=book.getPublisher() %>
                <br><strong>Количество страниц:</strong> <%=book.getPageCount() %>
                <br><strong>Год издания:</strong> <%=book.getPublishYear() %>
                <br><strong>Автор:</strong> <%=book.getAuthor() %>
                <p style="margin:10px;"><a style="margin:5px;" href="<%=request.getContextPath()%>/PdfContentServlet?index=<%=bookArrayList.indexOf(book)%>">Читать</a>
                <img src="../images/download.png"/>
                <a href="<%=request.getContextPath()%>/PdfDownloadServlet?index=<%=bookArrayList.indexOf(book)%>">Скачать</a></p>
            </div>
        </div>
        <%}%>
    </table>
</div>
