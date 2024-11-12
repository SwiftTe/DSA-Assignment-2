import java.util.Scanner;

public class CircularQueue {
    private int front;
    private int rear;
    private int[] queue;
    private int MAX_SIZE;

    // Constructor to initialize the circular queue
    public CircularQueue(int size) {
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
            // If first element is added, set front to 0
            if (front == -1) front = 0;
            // Move rear in a circular way
            rear = (rear + 1) % MAX_SIZE;
            queue[rear] = value;
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
            // If only one element was in the queue, reset front and rear
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                // Move front in a circular way
                front = (front + 1) % MAX_SIZE;
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
        return (rear + 1) % MAX_SIZE == front;
    }

    // Main method for testing the circular queue
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        CircularQueue queue = new CircularQueue(size);

        // Example operations for testing
        queue.enqueue(10);  // Enqueued 10
        queue.enqueue(20);  // Enqueued 20
        queue.enqueue(30);  // Enqueued 30
        System.out.println("Front element: " + queue.peek());  // Peek at front element (10)
        queue.dequeue();  // Dequeued 10
        queue.enqueue(40);  // Enqueued 40
        queue.enqueue(50);  // Enqueued 50 (if queue was of size 5, this will show overflow)
        queue.dequeue();  // Dequeued 20
        queue.enqueue(60);  // Enqueued 60
        queue.dequeue();  // Dequeued 30
        queue.dequeue();  // Dequeued 40

        scanner.close();
    }
}
