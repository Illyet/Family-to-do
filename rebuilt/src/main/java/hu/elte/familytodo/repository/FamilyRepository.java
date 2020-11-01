package hu.elte.familytodo.repository;

import hu.elte.familytodo.model.Family;
import hu.elte.familytodo.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Integer> {
    //public Iterable<Family> findAllByTitleContains(String title);

}
