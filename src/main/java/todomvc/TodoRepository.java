package todomvc;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {

    public List<Todo> findByCompleted(boolean completed);

}
