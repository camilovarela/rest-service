package todomvc;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
public class TodoController {

    private static final Logger LOG = Logger.getLogger(TodoController.class);

    @Autowired
    private TodoRepository repository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping("/greeting")
    public Todo greeting(@RequestParam(value="name", defaultValue="World") String name) {
        LOG.info("Checking health status...");
        return new Todo("nueva tarea", false);
    }

    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/todos", method=RequestMethod.GET)
    public List<Todo> listAllTodos() {
        LOG.info("Finding all To-do's...");
        return repository.findAll();
    }

    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/todos", method=RequestMethod.POST)
    public void saveTodo(@RequestBody Todo todo) {
        LOG.info("Saving a new To-do...");
        todo.setCompleted(false);
        repository.save(todo);
    }

    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/todos/{id}", method=RequestMethod.PUT)
    public void updateTodo(@RequestBody Todo todo) {
        LOG.info("Updating a To-do...");
        repository.save(todo);
    }

    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/todos", method=RequestMethod.DELETE)
    public void deleteAllTodos() {
        LOG.info("Deleting all To-do's...");
        repository.deleteAll();
    }

    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/todos/{id}", method=RequestMethod.DELETE)
    public void deleteTodo() {
        LOG.info("Deleting a To-do...");
    }
}
