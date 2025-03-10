package org.example;
import java.io.Serializable;

class Task implements Serializable {
    private String title;
    private String description;
    private User assignee;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignee() {
        return assignee;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void assignUser(User user) {
        this.assignee = user;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task: " + title + " (" + (completed ? "Completed" : "Pending") + ")";
    }
}
