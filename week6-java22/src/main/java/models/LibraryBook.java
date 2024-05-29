package models;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LibraryBook {
    public static List<BookRequest> bookshelf = new ArrayList<>();
    public static List<Person> UsersOnQueue= new LinkedList<>();


    public static List<BookRequest> getBookShelf() {
            bookshelf.add(new BookRequest("When you were mine", "Jacky",1995,4));
            bookshelf.add(new BookRequest( "The Gods Are Mad", "Felix Achebe", 1996, 3));
            bookshelf.add(new BookRequest("Beautiful Ones Are Not Yet Born", "Caro White", 2020, 4));
            bookshelf.add(new BookRequest("The Eternals", "Charles Wright", 2012, 7));
            bookshelf.add(new BookRequest( "Living Dangerously", "Darry Light", 2023, 12));

        return bookshelf;
    }
}
