class Node<T>{
    T data;
    Node next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    void appendToTail(T data){
        Node<T> end = new Node<T>(data);
        Node<T> n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}

public class LinkedList<T> {
    Node<T> head;

    public LinkedList(){
        this.head = null;
    }

    public void add(T data){
        Node<T> newNode = new Node<T>(data);
        if(head == null){
            head = newNode;
        } else {
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void print(){
        Node<T> current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node deleteNode(T data){
        Node n = head;
        if(n.data == data){
            return head.next;
        }
        while(n.next != null){
            if(n.next.data == data){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
