package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book firstBook = new Book("TestName", "123");
        eric.getBooks().add(firstBook);
        firstBook.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book springBook = new Book("Spring", "12345");
        rod.getBooks().add(springBook);
        springBook.getAuthors().add(rod);

        Publisher publisher = new Publisher();
        publisher.setName("RandomName");
        publisher.setCity("Warsaw");
        publisher.setState("State");

        publisherRepository.save(publisher);
        authorRepository.save(eric);
        bookRepository.save(firstBook);
        authorRepository.save(rod);
        bookRepository.save(springBook);

        System.out.println("Num of publishers: " + publisherRepository.count());
        System.out.println("Num of books: " + bookRepository.count());
    }
}
