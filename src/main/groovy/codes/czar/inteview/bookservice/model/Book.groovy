package codes.czar.inteview.bookservice.model

import org.hibernate.validator.constraints.NotEmpty

import javax.validation.constraints.AssertTrue

/**
 *
 * @author <a href="https://linkedin.com/in/alexczar">Alexander Czar Sarkisov</a>
 */
class Book {
    @NotEmpty
    String id // ISBN
    @NotEmpty
    String title
    String series
    int seriesId
    List<String> authors

    @AssertTrue
    boolean isHasAtLeastOneAuthor() {
        authors != null && !authors.isEmpty() && !authors[0].isEmpty()
    }
}
