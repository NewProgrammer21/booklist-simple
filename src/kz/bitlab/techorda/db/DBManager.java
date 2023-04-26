package kz.bitlab.techorda.db;

import java.util.ArrayList;

public class DBManager {

    private static final ArrayList<Book> books = new ArrayList<>();
    private static int id=6;
    static {
        books.add(new Book(1,"Harry Potter and PS","Joane Rowling","Fantasy",5000,
                "Harry Potter survives after Voldemort attack!"));
        books.add(new Book(2,"Harry Potter and SR","Joane Rowling","Fantasy",6000,
                "Secret Room"));
        books.add(new Book(3,"Harry Potter and PA","Joane Rowling","Fantasy",5500,
                "Sirius Black"));
        books.add(new Book(4,"Abay Zholy","Mukhtar Auezov","Roman",50000,
                "Biography of Abay Kunanbayev"));
        books.add(new Book(5,"I am Zlatan","Zlatan Ibragimovich","Biography",9000,
                "Biography of Zlatan Ibragimovich"));
    }
    public static ArrayList<Book> getBooks(){
        return books;
    }
    public static void addBook(Book book){
        book.setId(id);
        books.add(book);
        id++;
    }
    public static Book getBook(int id){
        return books.stream().filter(book -> book.getId()==id).findFirst().orElse(null);
    }

    public static void updateBook(Book book){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getId()==book.getId()){
                books.set(i,book);
                break;
            }
        }
    }

    public static void deleteBook(int id){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getId() == id){
                books.remove(i);
                break;
            }
        }
    }
}
