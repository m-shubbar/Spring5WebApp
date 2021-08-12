package ca.shubbar.spring5app.bootstrap;

import ca.shubbar.spring5app.domain.Author;
import ca.shubbar.spring5app.domain.Book;
import ca.shubbar.spring5app.domain.Publisher;
import ca.shubbar.spring5app.repositories.AuthorRepository;
import ca.shubbar.spring5app.repositories.BookRepository;
import ca.shubbar.spring5app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-11
 */

@Component // Means go ahead and detect this as a  spring manage component
public class BootStrapData implements CommandLineRunner {

    // Dependency injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // Once Spring implements this component, it will do dependency injection into the constructor for an instance
    // of AuthorRepository, BookRepository and PublisherRepository


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("The Great Canada Publishing");
        publisher.setCity("Toronto");
        publisher.setProvince("Ontario");

        System.out.println("Started in Bootstrap");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author mustafa = new Author("Mustafa", "Shubbar");
        Book weBelieveInJava = new Book("weBelieveInJava", "12345");
        mustafa.getBooks().add(weBelieveInJava);
        weBelieveInJava.getAuthors().add(mustafa);
        weBelieveInJava.setPublisher(publisher);
        publisher.getBooks().add(weBelieveInJava);

        authorRepository.save(mustafa);
        bookRepository.save(weBelieveInJava);
        publisherRepository.save(publisher);



        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "837465384765");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
