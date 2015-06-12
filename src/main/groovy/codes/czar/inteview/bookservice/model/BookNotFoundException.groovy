package codes.czar.inteview.bookservice.model

/**
 *
 * @author <a href="https://linkedin.com/in/alexczar">Alexander Czar Sarkisov</a>
 */
class BookNotFoundException extends RuntimeException {
    BookNotFoundException() {
        super('We do not have this book')
    }

    BookNotFoundException(String message) {
        super(message)
    }
}
