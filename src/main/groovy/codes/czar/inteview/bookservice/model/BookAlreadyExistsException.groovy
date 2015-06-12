package codes.czar.inteview.bookservice.model

/**
 *
 * @author <a href="https://linkedin.com/in/alexczar">Alexander Czar Sarkisov</a>
 */
class BookAlreadyExistsException extends RuntimeException {
    BookAlreadyExistsException() {
        super('This book already exists.')
    }

    BookAlreadyExistsException(String message) {
        super(message)
    }
}
