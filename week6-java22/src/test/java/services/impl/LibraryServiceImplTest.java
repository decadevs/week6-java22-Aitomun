package services.impl;

import enums.Role;
import models.BookRequest;
import models.Person;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static models.LibraryBook.UsersOnQueue;
import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    private LibraryServiceImpl libraryService;
    private List<BookRequest> books;
    @BeforeEach
    void setUp() {
        libraryService = new LibraryServiceImpl();
        books = new ArrayList<>();
        books.add(new BookRequest("When you were mine", "Jacky", 1995, 4));
        books.add(new BookRequest("The Gods Are Mad", "Felix Achebe", 1996, 3));
        books.add(new BookRequest("Beautiful Ones Are Not Yet Born", "Caro White", 2020, 4));
        books.add(new BookRequest("The Eternals", "Charles Wright", 2012, 7));
        books.add(new BookRequest("Living Dangerously", "Darry Light", 2023, 12));
    }


    @org.junit.jupiter.api.Test
    void addLibraryUsersToQueue() {
        Person teacher = new Person("Mr. Daro", Role.TEACHER, 1);
        String result = libraryService.addLibraryUsersToQueue(teacher);
        assertEquals("Mr. Daro", result);
        assertTrue(UsersOnQueue.contains(teacher));

    }

    @org.junit.jupiter.api.Test
    void reduceBookCount() {
        Optional<BookRequest> book = libraryService.reduceBookCount("The Gods Are Mad", books);
        assertTrue(book.isPresent());
        assertEquals(2,book.get().getNumberOfCopies());
    }

    @org.junit.jupiter.api.Test
    void givingBooksByHighPriority() {
        Person Teacher = new Person("Daro",Role.TEACHER,4);
        Person Senior = new Person("Royal",Role.SENIOR_STUDENT, 3);
        Person Junior = new Person("Sampson", Role.JUNIOR_STUDENT, 2);

        libraryService.addLibraryUsersToQueue(Teacher);
        libraryService.addLibraryUsersToQueue(Junior);
        libraryService.addLibraryUsersToQueue(Senior);


        String result = libraryService.givingBooksByHighPriority("When you are mine" , books);
        assertEquals("Book has Successfully been given", result);
    }

    @org.junit.jupiter.api.Test
    void givingBookByFirstCome() {
        Person Teacher = new Person("Daro",Role.TEACHER,4);
        Person Senior = new Person("Royal",Role.SENIOR_STUDENT, 3);
        Person Junior = new Person("Sampson", Role.JUNIOR_STUDENT, 2);

        libraryService.addLibraryUsersToQueue(Teacher);
        libraryService.addLibraryUsersToQueue(Junior);
        libraryService.addLibraryUsersToQueue(Senior);


        String result = libraryService.givingBookByFirstCome("The God are mad", books);
        assertEquals("Book has Successfully been given", result);

    }

    @org.junit.jupiter.api.Test
    void returnBook() {

    }
}