package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати проєкт");
            System.out.println("2. Додати завдання");
            System.out.println("3. Призначити користувача на завдання");
            System.out.println("4. Позначити завдання як виконане");
            System.out.println("5. Показати всі проєкти");
            System.out.println("6. Зберегти в файл");
            System.out.println("7. Завантажити з файлу");
            System.out.println("0. Вихід");
            System.out.print("Оберіть опцію: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // зчитуємо зайвий Enter

            switch (option) {
                case 1:
                    System.out.print("Введіть назву проєкту: ");
                    String projectName = scanner.nextLine();
                    manager.addProject(new Project(projectName));
                    break;
                case 2:
                    if (manager.getProjects().isEmpty()) {
                        System.out.println("Спочатку додайте проєкт.");
                        break;
                    }
                    System.out.print("Введіть назву завдання: ");
                    String taskTitle = scanner.nextLine();
                    System.out.print("Введіть опис завдання: ");
                    String taskDescription = scanner.nextLine();
                    System.out.println("Оберіть проєкт для завдання:");
                    for (int i = 0; i < manager.getProjects().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getProjects().get(i).getName());
                    }
                    int projectIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (projectIndex >= 0 && projectIndex < manager.getProjects().size()) {
                        manager.getProjects().get(projectIndex).addTask(new Task(taskTitle, taskDescription));
                    }
                    break;
                case 3:
                    System.out.print("Введіть ім'я користувача: ");
                    String userName = scanner.nextLine();
                    User user = new User(userName);
                    System.out.println("Оберіть проєкт:");
                    for (int i = 0; i < manager.getProjects().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getProjects().get(i).getName());
                    }
                    int projIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (projIndex >= 0 && projIndex < manager.getProjects().size()) {
                        Project proj = manager.getProjects().get(projIndex);
                        System.out.println("Оберіть завдання:");
                        for (int i = 0; i < proj.getTasks().size(); i++) {
                            System.out.println((i + 1) + ". " + proj.getTasks().get(i).getTitle());
                        }
                        int taskIndex = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (taskIndex >= 0 && taskIndex < proj.getTasks().size()) {
                            proj.getTasks().get(taskIndex).assignUser(user);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Оберіть проєкт:");
                    for (int i = 0; i < manager.getProjects().size(); i++) {
                        System.out.println((i + 1) + ". " + manager.getProjects().get(i).getName());
                    }
                    int projIdx = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (projIdx >= 0 && projIdx < manager.getProjects().size()) {
                        Project proj = manager.getProjects().get(projIdx);
                        System.out.println("Оберіть завдання для позначення як виконане:");
                        for (int i = 0; i < proj.getTasks().size(); i++) {
                            System.out.println((i + 1) + ". " + proj.getTasks().get(i).getTitle() +
                                    " (" + (proj.getTasks().get(i).isCompleted() ? "Completed" : "Pending") + ")");
                        }
                        int taskIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (taskIdx >= 0 && taskIdx < proj.getTasks().size()) {
                            proj.getTasks().get(taskIdx).markCompleted();
                        }
                    }
                    break;
                case 5:
                    for (Project proj : manager.getProjects()) {
                        System.out.println(proj);
                        for (Task task : proj.getTasks()) {
                            System.out.println("  - " + task + " (Assigned to: " + (task.getAssignee() != null ? task.getAssignee().getName() : "None") + ")");
                        }
                    }
                    break;
                case 6:
                    manager.saveToFile("tasks.dat");
                    System.out.println("Дані збережено.");
                    break;
                case 7:
                    manager.loadFromFile("tasks.dat");
                    System.out.println("Дані завантажено.");
                    break;
                case 0:
                    System.out.println("Вихід...");
                    return;
                default:
                    System.out.println("Невідома команда.");
            }
        }
    }
}