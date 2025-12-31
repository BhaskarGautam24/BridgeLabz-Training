class TaskNode {

    int taskId;
    String taskName;
    int priority;
    String dueDate;

    TaskNode next;
    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
// Circular Linked List class
class TaskScheduler {
    TaskNode head = null;
    TaskNode current = null;
    // Add task at end
    void addTask(int id, String name, int priority, String date) {

        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }
    // Remove task by ID
    void removeTask(int id) {

        if (head == null) {
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;
        do {
            if (temp.taskId == id) {

                if (temp == head) {
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    temp.next = head.next;
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;

        } while (temp != head);
    }
    
    // View current task and move next
    void viewNextTask() {

        if (current == null) {
            return;
        }

        System.out.println(
            current.taskId + " " +
            current.taskName + " Priority: " +
            current.priority
        );

        current = current.next;
    }
    // Display all tasks
    void displayTasks() {

        if (head == null) {
            return;
        }

        TaskNode temp = head;

        do {
            System.out.println(
                temp.taskId + " " +
                temp.taskName + " Priority: " +
                temp.priority
            );
            temp = temp.next;
        } while (temp != head);
    }
    // Search by priority
    void searchByPriority(int priority) {

        if (head == null) {
            return;
        }

        TaskNode temp = head;

        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskName);
            }
            temp = temp.next;
        } while (temp != head);
    }
}
public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Coding", 1, "10-01-2025");
        scheduler.addTask(2, "Testing", 2, "11-01-2025");
        scheduler.addTask(3, "Review", 1, "12-01-2025");
        scheduler.displayTasks();
        System.out.println("Current Task:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        System.out.println("Priority 1 Tasks:");
        scheduler.searchByPriority(1);
    }
}
