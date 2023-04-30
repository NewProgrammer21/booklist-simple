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

@WebServlet(value = "/add-book")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("book_name");
        String author = req.getParameter("book_author");
        String genre = req.getParameter("book_genre");
        String price = req.getParameter("book_price");
        String description=req.getParameter("book-description");

        double bookPrice = Double.parseDouble(price);

        Book book =new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setPrice(bookPrice);
        book.setDescription(description);

        DBConnection.addBook(book);

        resp.sendRedirect("/");
    }
}
