package bai10_list.thuc_hanh.e2_linkedlist;

public class Main {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.printList();

        System.out.println();
        ll.addFirst(12);
        ll.printList();
        System.out.println();
        ll.addFirst(13);
        ll.printList();
        System.out.println();

        ll.add(4,9);
        ll.printList();
        System.out.println();
        ll.add(4,9);
        ll.printList();
        System.out.println();
    }
}
