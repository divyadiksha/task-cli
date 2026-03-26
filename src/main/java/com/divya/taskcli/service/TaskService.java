package com.divya.taskcli.service;

import com.divya.taskcli.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskService {

    //private List<Task> taskList = new ArrayList<>();
    //private int nextId = 1;
    private static final String FILE_NAME = "tasks.json";
    private ObjectMapper objectMapper;

    public TaskService() {
        objectMapper = new ObjectMapper();
        //very important to register java 8 LocalDateTime, add time dependency then register.
        objectMapper.registerModule(new JavaTimeModule()); // 🔥 CRITICAL
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public void addTask(String description) {

        List<Task> tasks = readTasks();
        int taskId = tasks.size() + 1;
        Task task = new Task(taskId, description);
        tasks.add(task);
        writeTasks(tasks);
        System.out.println("Task added id:" + task.getId());
    }

    public void listTask() {
        List<Task> tasks = readTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void updateTask(int id, String description) {

        List<Task> tasks = readTasks();

        if (tasks.isEmpty()) {
            System.out.println("Nothing to update. To-do list is empty!!!");
            return;
        }
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                task.setUpdatedAt();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("task with id:" + id + " not found");
            return;
        }
        writeTasks(tasks);
    }

    public void deleteTask(int id) {
        List<Task> tasks = readTasks();

        if (tasks.isEmpty()) {
            System.out.println("Nothing to delete. To-do list is empty!!!");
            return;
        }

        boolean found = tasks.removeIf(task -> task.getId() == id);

        if (!found) {
            System.out.println("Task not found with ID: " + id);
            return;
        }
        writeTasks(tasks);
        System.out.println("deleted task with ID:"+id);
    }

    public void updateTaskStatus(int id, String status){
        List<Task> tasks = readTasks();

        if (tasks.isEmpty()) {
            System.out.println("Nothing to update. To-do list is empty!!!");
            return;
        }

        boolean found = false;
        for(Task task : tasks) {
            if(task.getId() == id) {
                task.setStatus(status);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Task not found with ID: " + id);
            return;
        }
        writeTasks(tasks);
    }

    //read file
    private List<Task> readTasks() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return new ArrayList<>(Arrays.asList(objectMapper.readValue(file, Task[].class)));
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    //write file
    // ---------- Write tasks to file ----------
    private void writeTasks(List<Task> tasks) {
        try {
            objectMapper.writeValue(new File(FILE_NAME), tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
