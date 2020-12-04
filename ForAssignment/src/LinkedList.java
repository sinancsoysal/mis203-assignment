public class LinkedList{
    Node head;
    static int size;

    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, String data){
        Node new_node = new Node(data);
        
        if(list.head == null){ list.head = new_node; }
        else{
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }

            last.next = new_node;
        }

        size ++;
        if(size > 10){ pop(list); }

        return list;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("\nLast " + size + " Result(s): ");

        while (currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void pop(LinkedList list) {
        list.head = list.head.next;
        size--;
    }
}