package org.example;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


class Project implements Serializable {
    private String name;
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "Project: " + name + ", Tasks: " + tasks.size();
    }
}
