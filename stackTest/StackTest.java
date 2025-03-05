package stackTest;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(22);
        stack.push(122);
        stack.push(1);
        stack.print();
        sortStack(stack);
        stack.print();
    }

    private static Stack sortStack(Stack<Integer> stack) {
        try {

            Stack<Integer> tmpStack = new Stack<>();
            int stackLength = stack.size();
            int sortRemain = stackLength;
            System.out.println("STACK LENGTH:" + stackLength);

            while (sortRemain != 0) {
                moveNodesExceptMax(stack, tmpStack, sortRemain);
                // stack.print();
                sortRemain--;
            }

           

            return null;
        } catch (Exception e) {
            System.out.println("STACK LENGTH:" + e);
            e.printStackTrace();
            return null;
        }
    }

    private static void moveNodesExceptMax(Stack<Integer> stack1, Stack<Integer> stack2, int amount) {
        int count = 1;
        int max = stack1.pop();
        while (count < amount) {
            Integer current = stack1.pop();
            count++;
            // System.out.println(current + ">" + count + ">" + amount);

            if (max < current) {
                stack2.push(max);
                max = current;
            } else {
                stack2.push(current);
            }
        }
        stack1.push(max);

        while (!stack2.isEmpty()) {
            Integer current = stack2.pop();
            stack1.push(current);
        }
    }
}
