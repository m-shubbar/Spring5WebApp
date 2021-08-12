package ca.shubbar.spring5app.repositories;

import ca.shubbar.spring5app.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-12
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
