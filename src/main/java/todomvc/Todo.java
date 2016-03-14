package todomvc;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Todo implements Serializable {

    @Id
    private String id;

    private String title;
    private boolean completed;

    public Todo() {}

    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return String.format("Todo[id=%s, content='%s', completed=%s]", id, title, completed);
    }
}
