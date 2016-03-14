package todomvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    @Autowired
    private TodoRepository repository;

    public static void main(String[] args) {
        String mongoIp = System.getenv("MONGO_IP");
        LOG.info("Mongo IP: " + mongoIp);
        System.setProperty("spring.data.mongodb.host", mongoIp);
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (Todo todo : repository.findAll()) {
            LOG.info(todo);
        }
    }
}
