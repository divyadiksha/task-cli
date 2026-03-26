package com.divya.taskcli;

import com.divya.taskcli.service.TaskService;

public class Main {
    public static void main(String[] args) {

        TaskService taskService = new TaskService();
        System.out.println("Task CLI Started");
        System.out.println("Commands: add, update, delete, mark-in-progress, mark-done, list");

        if (args.length == 0) {
            return;
        }

        String command = args[0];

        switch(command) {
            case "add":
                taskService.addTask(args[1]);
                break;
            case "list":
                taskService.listTask();
                break;
            case "update":
                taskService.updateTask(Integer.parseInt(args[1]),args[2]);
                break;
            case "delete":
                taskService.deleteTask(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                taskService.updateTaskStatus(Integer.parseInt(args[1]), "in-progress");
                break;
            case "mark-done":
                taskService.updateTaskStatus(Integer.parseInt(args[1]), "done");
                break;
            default:
                System.out.println("Incorrect input");
        }
    }
}