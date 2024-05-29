
import enums.Role;
import models.BookRequest;
import models.LibraryBook;
import models.Person;
import services.impl.LibraryServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryServiceImpl libraryService = new LibraryServiceImpl();


        // Create some users
        Person teacher = new Person("Mr. Daro", Role.TEACHER, 1);
        Person seniorStudent = new Person("Royal", Role.SENIOR_STUDENT, 2);
        Person juniorStudent = new Person("Samson", Role.JUNIOR_STUDENT, 3);

        System.out.println("Users have been created.");

        libraryService.addLibraryUsersToQueue(juniorStudent);
        libraryService.addLibraryUsersToQueue(seniorStudent);
        libraryService.addLibraryUsersToQueue(teacher);

        System.out.println("#####################################################");
        System.out.println("GIVING BOOK BY PRIORITY");
//        libraryService.givingBooksByHighPriority("When you were mine", LibraryBook.getBookShelf());


        System.out.println("##############################");
        System.out.println("Giving book by first come first serve");
        libraryService.givingBookByFirstCome("The Gods Are Mad",LibraryBook.getBookShelf());



    }
}
