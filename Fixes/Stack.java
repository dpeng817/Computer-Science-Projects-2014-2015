public class Stack {
      private int top;
      private double[] storage;

      Stack() {
            storage = new double[100];
            top = -1;
      }

      void push(double value) {
            if (top == storage.length)
                  throw new StackException("Stack's underlying storage is overflow");
            top++;
            storage[top] = value;
      }

      double peek() {
            if (top == -1)
                  throw new StackException("Stack is empty");
            return storage[top];
      }

      double pop() {
            if (top == -1)
                  throw new StackException("Stack is empty");
            top--;
			return storage[top+1];
      }

      boolean isEmpty() {
            return (top == -1);
      }

      public class StackException extends RuntimeException {
            public StackException(String message) {
                  super(message);
            }
      }
}