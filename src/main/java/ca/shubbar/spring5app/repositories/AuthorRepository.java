package ca.shubbar.spring5app.repositories;

import ca.shubbar.spring5app.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-11
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
