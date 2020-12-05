public class LinkedList{
    Node head;
    static int size;

    // sub-class that defines the contents of a Node
    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            next = null;
        }
    }

    /**
     * This function inserts given data to end of the given list.
     * 
     * @param list Linked list which is the operation will be held on
     * @param data Data to be inserted
     * @return Final list after insertion operation
     */
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

        stackLimiter(list);

        return list;
    }

    /**
     * The stack allowed to store maximum of 10 elements at a time.
     * If the stacks size is bigger then 10, it will pop the first element from the stack
     * @param list
     */
    private static void stackLimiter(LinkedList list){
        size ++;
        if(size > 10){ pop(list); }
    }

    /**
     * Prints elements of the given list and display the ratio of results.
     * @param list
     */
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        int headC = 0;
        System.out.print("\n\tLast " + size + " Result(s): ");

        while (currNode != null){
            System.out.print(currNode.data + " ");
            if(currNode.data.equals("HEADS")){ headC++; }
            currNode = currNode.next;
        }
        printRatio(headC);
    }

    private static void printRatio(int headCount){
        double headR = Math.round(((double)headCount / (double)size) * 100);
        System.out.print("\n\tHeads ratio: " + headR + "%");
        System.out.print("\n\tTails ratio: " + (100 - headR) + "%");
    }

    private static void pop(LinkedList list) {
        list.head = list.head.next;
        size--;
    }
}