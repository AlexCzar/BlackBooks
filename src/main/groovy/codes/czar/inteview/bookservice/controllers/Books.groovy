package codes.czar.inteview.bookservice.controllers

import codes.czar.inteview.bookservice.model.Book
import codes.czar.inteview.bookservice.model.BookAlreadyExistsException
import codes.czar.inteview.bookservice.model.BookNotFoundException
import codes.czar.inteview.bookservice.services.BookStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

import static org.springframework.http.HttpStatus.*
import static org.springframework.web.bind.annotation.RequestMethod.*

/**
 *
 * @author <a href="https://linkedin.com/in/alexczar">Alexander Czar Sarkisov</a>
 */
@RestController
@RequestMapping('books')
class Books {
    @Autowired
    BookStore store

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    void addBook(@RequestBody @Valid Book book) {
        store.addBook(book)
    }

    @RequestMapping(method = DELETE, value = '{id}')
    void removeBook(@PathVariable('id') String id) {
        store.removeBook(id)
    }

    @RequestMapping(method = PUT)
    void updateBook(@RequestBody @Valid Book book) { store.updateBook(book) }

    @RequestMapping(method = GET, value = '{id}')
    Book findBook(@PathVariable('id') String id) { store.findBook(id) }

    @RequestMapping(method = GET)
    Collection<Map<String, Object>> findBooks() {
        store.books.values().collect { [id: it.id, title: it.title] }
    }

    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    Map<String, String> handle(BookNotFoundException ex) {
        [error: ex.message]
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    Map<String, String> handle(BookAlreadyExistsException ex) {
        [error: ex.message]
    }
}
