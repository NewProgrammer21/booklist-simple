package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Book;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/save-book")
public class SaveBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("book_id"));
        String name = req.getParameter("book_name");
        String author = req.getParameter("book_author");
        String genre = req.getParameter("book_genre");
        double price = Double.parseDouble(req.getParameter("book_price"));
        String description=req.getParameter("book-description");

        Book book= DBConnection.getBook(id);
        if(book!=null){
            book.setName(name);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setPrice(price);
            book.setDescription(description);
            DBConnection.updateBook(book);
            resp.sendRedirect("/details?book_id="+id);
        }else{
            resp.sendRedirect("/");
        }
    }
}
