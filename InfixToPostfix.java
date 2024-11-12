import java.util.Scanner;

public class InfixToPostfix {
    private char[] stack;
    private int top;
    private int MAX_SIZE;

    // Constructor to initialize stack
    public InfixToPostfix(int size) {
        MAX_SIZE = size;
        stack = new char[MAX_SIZE];
        top = -1;
    }

    // Push operation for the stack
    public void push(char c) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack overflow");
        } else {
            stack[++top] = c;
        }
    }

    // Pop operation for the stack
    public char pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return '\0'; // Return null character for empty stack
        } else {
            return stack[top--];
        }
    }

    // Peek operation for the stack (get the top element)
    public char peek() {
        return top == -1 ? '\0' : stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to determine precedence of operators
    public int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    // Method to convert infix to postfix expression
    public String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // If the character is an operand, add it to postfix
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If the character is '(', push it to stack
            else if (c == '(') {
                push(c);
            }
            // If the character is ')', pop and append until '(' is encountered
            else if (c == ')') {
                while (!isEmpty() && peek() != '(') {
                    postfix.append(pop());
                }
                pop(); // Remove '(' from stack
            }
            // If the character is an operator
            else {
                while (!isEmpty() && precedence(peek()) >= precedence(c)) {
                    postfix.append(pop());
                }
                push(c);
            }
        }

        // Pop all remaining operators in the stack
        while (!isEmpty()) {
            postfix.append(pop());
        }
        return postfix.toString();
    }

    // Main method to test the conversion
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = scanner.nextLine();

        InfixToPostfix converter = new InfixToPostfix(infix.length());
        String postfix = converter.convertToPostfix(infix);

        System.out.println("Postfix expression: " + postfix);
        scanner.close();
    }
}
