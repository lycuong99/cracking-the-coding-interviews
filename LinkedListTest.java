import java.util.HashMap;
import java.util.HashSet;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(5);
        list.add(10);

        removeDuplicateWithSpace(list);

        removeDuplicateWithOutSpace(list);
        list.print();

    }

    private static void removeDuplicateWithSpace(LinkedList list) {
        // solution 1 space O(n) - time O(n)
        HashSet<Integer> set = new HashSet<>();

        Node<Integer> current = list.head;
        while (current.next != null) {

            if (set.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                set.add(current.data);
                current = current.next;
            }
        }

    }

    private static void removeDuplicateWithOutSpace(LinkedList list) {
        // solution 1 space O(n) - time O(n)
        HashSet<Integer> set = new HashSet<>();

        Node<Integer> current = list.head;
        while (current != null) {

            current = current.next;
            Node<Integer> currentCheck = current;
            if (currentCheck.next == null)
                break;
            while (currentCheck.next != null) {
                if (current.data == currentCheck.next.data) {
                    currentCheck.next = currentCheck.next.next;
                } else {
                    currentCheck = currentCheck.next;
                }
            }
        }

    }
}
