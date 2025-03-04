package linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class LinkedListTest {
    public static void main(String[] args) {

        // Get runtime instance
        Runtime runtime = Runtime.getRuntime();

        // Run garbage collector to get a cleaner memory measurement
        runtime.gc();
        // Get memory before function execution
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime(); // Start time

        // list.print();
        checkLoopMain();

        // Get memory after function execution
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long endTime = System.nanoTime(); // End time

        // Print memory usage
        System.out.println("Memory used by function: " + (memoryAfter - memoryBefore) + " bytes");
        System.out.println("Execution time: " + (endTime - startTime) / 1_000_000.0 + " ms");

    }

    static void checkIntersectMain() {
        LinkedList<Integer> listA = new LinkedList<Integer>();
        LinkedList<Integer> listB = new LinkedList<Integer>();

        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(5);
        listA.add(6);
        listA.add(7);
        listB.add(10);
        listB.add(11);
        // listB.add(13);
        listB.last().next = listA.get(3);

        listA.print();
        listB.print();

        Node intersectNode = getIntersectionNode(listA, listB);
        if (intersectNode != null) {
            System.out.println("intersect Node:" + intersectNode.data);
        } else {
            System.out.println("No intersect Node:");
        }

    }

    static void checkLoopMain() {
        LinkedList<Integer> list = new LinkedList<Integer>();

        int size = 6;

        // Random random = new Random();

        // for (int i = 0; i < size; i++) {
        // list.add(random.nextInt(10));
        // }

        list.add(1);

        list.add(2);
        list.add(3);
       
        list.add(4);
        Node loopNode = list.add(55);

        list.add(6);

        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12).next = loopNode;
        // list.print();

        Node foundNodeLoop = checkLoop(list);
        if (foundNodeLoop != null) {
            System.out.println("foundNodeLoop:" + foundNodeLoop.data);

        }

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

    private static <T> Node<T> getKthFormLast(LinkedList<T> list, int k) {
        Node<T> current = list.head;
        Node<T> fastCursor = current;

        int count = 0;
        int countFast = 0;
        boolean foundLast = false;
        while (current.next != null) {

            if (foundLast && count == countFast - k) {
                return current;
            }

            if (fastCursor.next == null) {
                foundLast = true;

                if (k == 0) {
                    return fastCursor;
                }
                if (k == countFast) {
                    return list.head;
                }
                if (k > countFast) {
                    return null;
                }
                if (count > countFast - k) {
                    current = list.head;
                    count = 0;
                }
            } else

            if (fastCursor.next.next == null) {
                countFast++;
                fastCursor = fastCursor.next;
            } else {
                countFast += 2;
                fastCursor = fastCursor.next.next;
            }

            current = current.next;
            count++;
        }

        return null;
    }

    private static <T> Node<T> getKthFromLastFromGPT(LinkedList<T> list, int k) {
        if (list.head == null || k < 0) {
            return null;
        }

        Node<T> fast = list.head;
        Node<T> slow = list.head;

        // Di chuyển con trỏ fast trước k bước
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // k lớn hơn số node trong danh sách
            }
            fast = fast.next;
        }

        // Di chuyển cả hai con trỏ đến khi fast chạm null
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    private static <T> void deleteMiddleNode(LinkedList<T> list) {
        Node<T> fast = list.head;
        Node<T> slow = list.head;
        Node<T> previous = slow;

        if (fast.next == null) {
            return;
        }

        while (slow.next != null) {

            if (fast.next == null || fast.next.next == null) {
                previous.next = slow.next;
                return;
            }

            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    private static <T> boolean checkPalindrome(LinkedList<T> list) {
        Node<T> fast = list.head;
        Node<T> slow = list.head;

        boolean foundLast = false;
        Node<T> reverseCurrent = new Node(slow.data);

        while (slow.next != null) {

            if (foundLast) {
                break;
            }

            if (fast.next == null || fast.next.next == null) {
                foundLast = true;
            }

            if (fast.next != null) {
                Node<T> newNode = new Node<T>(slow.data);
                newNode.next = reverseCurrent;
                reverseCurrent = newNode;
                fast = fast.next;
            }

            slow = slow.next;
            fast = fast.next;
        }

        while (slow.next != null) {

            if (slow.data != reverseCurrent.data) {
                return false;
            }
            slow = slow.next;
            reverseCurrent = reverseCurrent.next;
        }

        return true;

    }

    private static <T> Node checkLoop(LinkedList<T> list) {
        Node<T> fast = list.head;
        Node<T> slow = list.head;
        boolean foundLast = false;
        boolean foundLoop = false;

        int countSlow = 0;
        int fastCount = 0;
        int loopSize = 0;

        Node<T> flag;
        while (slow.next != null) {

            if (foundLast) {
                return null;
            }

            if (fast.next == null || fast.next.next == null) {
                foundLast = true;
            }

            if (fast.next != null) {
                fast = fast.next;
                fastCount++;
            }

            slow = slow.next;
            fast = fast.next;
            countSlow++;
            fastCount++;

            if (slow == fast) {
                System.out.println("FOUND LOOP AT: " + slow.data);
                System.out.println("SLOW COUNT: " + countSlow);
                System.out.println("fast COUNT: " + fastCount);
                System.out.println("LOOP SIZE: " + (fastCount - countSlow));
                loopSize = fastCount - countSlow;
                flag = slow;
                break;
            }
        }

        if (loopSize > countSlow) {
            int diff = loopSize - countSlow;
            while (diff != 0) {
                fast = fast.next;
                diff--;
            }
        } else {
            slow = list.head;
            int diff = countSlow - loopSize;
            while (diff != 0) {
                slow = slow.next;
                diff--;
            }
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    private static <T> Node<T> getIntersectionNode(LinkedList<T> listA, LinkedList<T> listB) {
        int aLength = 0, bLength = 0;
        int minLength = 0, maxLength = 0;
        aLength = getLengthOfLinkedList(listA);
        bLength = getLengthOfLinkedList(listB);
        System.out.println(aLength + "-" + bLength);

        LinkedList<T> minList, maxList;
        if (aLength > bLength) {
            minLength = bLength;
            maxLength = aLength;
            minList = listB;
            maxList = listA;
        } else {
            minLength = aLength;
            maxLength = bLength;
            minList = listA;
            maxList = listB;
        }

        int diff = maxLength - minLength;

        Node minNode = minList.head;
        Node maxNode = maxList.head;
        while (diff != 0) {
            maxNode = maxNode.next;
            diff--;
        }

        do {
            minNode = minNode.next;
            maxNode = maxNode.next;
        } while (minNode != maxNode);

        if (minNode == maxNode) {
            return minNode;
        }

        return null;
    }

    private static int getLengthOfLinkedList(LinkedList list) {
        Node curNode = list.head;
        int count = 1;

        if (curNode == null) {
            return 0;
        }

        if (curNode.next == null) {
            return 1;
        }

        while (curNode.next != null) {
            count++;
            curNode = curNode.next;
        }

        return count;
    }
}
