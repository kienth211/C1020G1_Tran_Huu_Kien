package bai10_list.bai_tap.p1_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addLast(6);
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);
        myLinkedList.addLast(7);
//
        myLinkedList.printList();
        System.out.println("\n" + myLinkedList.size());

        System.out.println("\n" + myLinkedList.remove(8));
        System.out.println(myLinkedList.get(5));

        myLinkedList.printList();
        System.out.println("\n" + myLinkedList.size());

//        myLinkedList.addLast(6);

//        myLinkedList.printList();
    }
}
