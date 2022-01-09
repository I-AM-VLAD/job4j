package ru.job4j.chapter_003.search;

import java.util.LinkedList;


public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var index = 0;
        for (var element : tasks) {
            if(tasks == null) {
                break;
            }
            if(task.getPriority()   <=   element.getPriority())
            {
                break;
            }
            if(element == tasks.getLast()) {
                ++index;
                break;
            }
            if(    task.getPriority()  <=  tasks.get(++index).getPriority()     &&    task.getPriority()   >=   element.getPriority()     ) {
                break;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}

