package ru.job4j.chapter_003.search;

import java.util.LinkedList;


public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var index = 0;
        /*
        Task task1 = new Task("low", 5);
        Task task2 = new Task("urgent", 2);
        this.tasks.add(0, task1);
        this.tasks.add(0, task2);
        */
        for (var element : tasks) {
            //вставка в пустую очередь
            if(tasks == null) {
                break;
            }

            //вставка в начало
            if(task.getPriority()   <=   element.getPriority())
            {
                break;
            }

            //вставка в конец
            if(element == tasks.getLast()) {
                ++index;
                break;
            }

            //вставка в середину
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

