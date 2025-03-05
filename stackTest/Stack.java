package stackTest;

public class Stack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null)
            return null;
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {

        if (top == null)
            return null;
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void print() {
        StackNode<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // Xuống dòng sau khi in xong
    }

    public int size() {
        int stackLength = 0;
        StackNode<T> current = top;
        while (current != null) {
            stackLength++;
            current = current.next;
        }
        return stackLength;
    }

}
