package hu.elte.familytodo.repository;

import hu.elte.familytodo.model.Task;
import hu.elte.familytodo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    //public Iterable<User> findAllByTitleContains(String title);
}
