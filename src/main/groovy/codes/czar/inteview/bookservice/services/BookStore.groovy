package codes.czar.inteview.bookservice.services

import codes.czar.inteview.bookservice.model.Book
import codes.czar.inteview.bookservice.model.BookAlreadyExistsException
import codes.czar.inteview.bookservice.model.BookNotFoundException
import org.springframework.stereotype.Service


/**
 *
 * @author <a href="https://linkedin.com/in/alexczar">Alexander Czar Sarkisov</a>
 */
@Service
class BookStore {
    Map<String, Book> books = [:]

    void addBook(Book book) {
        if (books.containsKey(book.id)) throw new BookAlreadyExistsException()
        books.put(book.id, book)
    }

    void removeBook(String id) {
        books.remove(id)
    }

    Book findBook(String id) {
        Book book = books[id]
        if (!book) throw new BookNotFoundException()
        else return book
    }

    void updateBook(Book book) {
        if (books.containsKey(book.id)) books[book.id] = book
        else throw new BookNotFoundException()
    }
}
