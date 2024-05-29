package services;

import models.BookRequest;
import models.Person;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface LibraryService {
    String addLibraryUsersToQueue(Person user);
    Optional<BookRequest> reduceBookCount(String nameOfBook, List<BookRequest>books);
    String givingBooksByHighPriority(String nameOfBook, List<BookRequest> books);
    String givingBookByFirstCome(String nameOfBook,List<BookRequest>books);
    String returnBook(String nameOfBook, List<BookRequest>books, Person user);
}
