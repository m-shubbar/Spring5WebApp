package ca.shubbar.spring5app.repositories;

import ca.shubbar.spring5app.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-11
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
