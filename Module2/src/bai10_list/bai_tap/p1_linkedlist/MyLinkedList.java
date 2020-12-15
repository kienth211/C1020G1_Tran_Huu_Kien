package bai10_list.bai_tap.p1_linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private  int numNodes;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

        public MyLinkedList() {
        }

        public MyLinkedList(E data) {
            head = new Node(data);
        }

    public void add(int index, E data) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E data){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }

    public int size(){
        return numNodes;
    }

    public Object get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public Object remove(int index){
        Node temp = head;
        Node holder;
        for(int i=0; i < index-2 && temp.next.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = temp.next.next;
        numNodes--;
        return holder.data;
    }

    public boolean remove(E data){
        if(head.data.equals(data)){
            remove(0);
        }
        else {
            Node temp = head;
            while (temp.next != null){
                if (temp.next.data.equals(data)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return  true;
                }
            }
        }
        return false;
    }

    public MyLinkedList<E> clone(){
        if(numNodes== 0){
            throw new NullPointerException("Linked này Null");
        }
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        Node temp = head;
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null){
            returnLinkedList.addFirst((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean contain(E element){
        Node temp = head;
        while (temp.next != null){
            if(temp.data.equals(element)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            if (temp.getData().equals(element)){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }
}
