import java.util.Scanner;

public class Stack {
    private int top;
    private int[] stack;
    private int MAX_SIZE;

    // Constructor to initialize stack
    public Stack(int size) {
        MAX_SIZE = size;
        stack = new int[MAX_SIZE];
        top = -1;  // Initialize top to -1 indicating an empty stack
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow! Cannot push " + value);
        } else {
            stack[++top] = value;
            System.out.println("Pushed " + value + " to stack.");
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! Nothing to pop.");
            return -1;  // Return a value indicating the stack is empty
        } else {
            int poppedValue = stack[top--];
            System.out.println("Popped " + poppedValue + " from stack.");
            return poppedValue;
        }
    }

    // Method to peek at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top element.");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        
        Stack stack = new Stack(size);
        
        // Sample operations for testing
        stack.push(10);  // Pushed 10
        stack.push(20);  // Pushed 20
        stack.pop();     // Popped 20
        stack.push(30);  // Pushed 30
        System.out.println("Top element is: " + stack.peek());  // Peeks 30
        stack.pop();     // Popped 30
        stack.pop();     // Popped 10
        stack.pop();     // Shows underflow message

        scanner.close();
    }
}


