# Task Manager

This is a simple console-based task management application implemented in Java. It allows users to manage projects and tasks, assign users to tasks, mark tasks as completed, and save/load data to/from a file.

Features

* Add Projects: Users can add new projects to the system.
* Add Tasks: Tasks can be added to a project with a title and description.
* Assign Users to Tasks: Users can be assigned to specific tasks within a project.
* Mark Tasks as Completed: Tasks can be marked as completed.
* View Projects and Tasks: Users can view all projects and their associated tasks.
* Save and Load Data: Projects and tasks can be saved to a file and loaded from a file.

To run the project, compile and execute the Main class. The program will present a menu where you can interact with the task manager system.

Menu Options
1. Add Project: Add a new project to the system.
2. Add Task: Add a new task to a selected project.
3. Assign User to Task: Assign a user to a selected task.
4. Mark Task as Completed: Mark a task as completed.
5. Show All Projects: View a list of all projects and their tasks.
6. Save to File: Save the current projects and tasks to a file.
7. Load from File: Load projects and tasks from a file.
0. Exit: Exit the program.



## Code Structure

`Main.java`: Contains the main program logic and the menu interface.
`TaskManager.java`: Manages projects and tasks, including adding tasks, assigning users, and saving/loading data.
`Project.java`: Represents a project with a list of tasks.
`Task.java`: Represents a task within a project, including title, description, and completion status.
`User.java`: Represents a user who can be assigned to tasks.