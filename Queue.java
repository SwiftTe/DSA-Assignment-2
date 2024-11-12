import java.util.Scanner;

public class Queue {
    private int front;
    private int rear;
    private int[] queue;
    private int MAX_SIZE;

    // Constructor to initialize the queue
    public Queue(int size) {
        MAX_SIZE = size;
        queue = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    // Method to add an element to the queue (enqueue)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue overflow! Cannot add " + value);
        } else {
            if (front == -1) front = 0;  // Initialize front when first element is enqueued
            queue[++rear] = value;
            System.out.println("Enqueued " + value);
        }
    }

    // Method to remove an element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Nothing to dequeue.");
            return -1;
        } else {
            int dequeuedValue = queue[front];
            front++;  // Move front to the next element

            // Reset front and rear if the queue becomes empty after dequeue
            if (front > rear) {
                front = -1;
                rear = -1;
            }
            
            System.out.println("Dequeued " + dequeuedValue);
            return dequeuedValue;
        }
    }

    // Method to get the front element of the queue without removing it (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return queue[front];
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    // Main method for testing the queue implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        Queue queue = new Queue(size);

        // Sample operations for testing
        queue.enqueue(10);  // Enqueued 10
        queue.enqueue(20);  // Enqueued 20
        System.out.println("Front element: " + queue.peek());  // Peek at front element (10)
        queue.dequeue();  // Dequeued 10
        queue.enqueue(30);  // Enqueued 30
        queue.enqueue(40);  // Enqueued 40
        queue.dequeue();  // Dequeued 20
        queue.dequeue();  // Dequeued 30
        queue.dequeue();  // Dequeued 40
        queue.dequeue();  // Shows underflow message

        scanner.close();
    }
}
