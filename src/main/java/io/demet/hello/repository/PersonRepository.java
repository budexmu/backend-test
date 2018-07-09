package io.demet.hello.repository;

        import io.demet.hello.model.Person;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAllByIdAndUsername(Integer id, String username);

}
