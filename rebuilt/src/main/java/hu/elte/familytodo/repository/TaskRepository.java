package hu.elte.familytodo.repository;

import hu.elte.familytodo.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
    public Iterable<Task> findAllByTitleContains(String title);
}
