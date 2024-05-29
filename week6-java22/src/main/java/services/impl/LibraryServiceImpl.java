package services.impl;

import models.BookRequest;
import models.Person;
import services.LibraryService;

import java.util.*;

import static models.LibraryBook.UsersOnQueue;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public String addLibraryUsersToQueue(Person user) {
        UsersOnQueue.add(user);
        return user.getName();
    }

    @Override
    public Optional<BookRequest> reduceBookCount(String nameOfBook, List<BookRequest> books) {
        Optional<BookRequest> optionalBookRequest = books.stream()
                .filter(b-> nameOfBook.equals(b.getTitle())&& b.getNumberOfCopies()> 0)
                .findFirst();
        optionalBookRequest.ifPresent(book -> book.setNumberOfCopies(book.getNumberOfCopies() -1));

        return optionalBookRequest;
    }

    @Override
    public String givingBooksByHighPriority(String book, List<BookRequest> books) {
        UsersOnQueue.sort(Comparator.comparing(Person::getRole));
        UsersOnQueue.forEach(
                p ->{
                    if(reduceBookCount(book, books).isPresent()){
                        System.out.println(p.getName()+ " has borrowed " + book);
                    }else{
                        System.out.println(p.getName()+ " cannot borrow "+ book+ " because it is not available");
                    }
                }
        );
        return "Book has Successfully been given";

    }

    @Override
    public String givingBookByFirstCome(String book, List<BookRequest> books) {
        List<Person> usersWithRequest = UsersOnQueue.stream()
                .filter(person -> books.stream().anyMatch(b -> b.getTitle().equals(book) && b.getNumberOfCopies() > 0))
                .toList();
        for (Person user : usersWithRequest) {
            Optional<BookRequest> bookRequestOptional = reduceBookCount(book, books);
            if (bookRequestOptional.isPresent()) {
                System.out.println(user.getName() + " has borrowed " + book);
            } else {
                System.out.println(user.getName() + " cannot borrow " + book + " because it is not available");
            }
        }

        return "Book has Successfully been given";


    }

    @Override
    public String returnBook(String nameOfBook, List<BookRequest> books, Person user) {
        Optional<BookRequest> bookOptional = books.stream()
                .filter(b -> nameOfBook.equals(b.getTitle()))
                .findFirst();

        bookOptional.ifPresentOrElse(
                book -> {
                    book.setNumberOfCopies(book.getNumberOfCopies() + 1);
                    System.out.println(user.getName() + " has returned " + book.getTitle() + " to the Library");
                },
                () -> System.out.println(nameOfBook + " does not belong to this library")
        );
        return bookOptional.map(BookRequest::getTitle).orElse(nameOfBook + " does not belong to this library");
    }
}
