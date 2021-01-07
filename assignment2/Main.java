public class Main {
    public static void main(String[] args){
        int[] myArray = {1, 2, 3, 4};
        MyList list = new MyList(myArray);

        System.out.print("LIST:");
        list.printList();
        System.out.print("append 0: ");
        list.append(0);
        list.printList();
        System.out.print("pop: ");
        list.pop();
        list.printList();
        System.out.print("insert 0 at index 0: ");
        list.insert(0, 0);
        list.printList();
        System.out.print("remove index 2: ");
        list.remove(2);
        list.printList();
        System.out.println("-------------------");

        MyStack s = new MyStack(myArray);
        System.out.print("STACK:");
        s.printList();
        System.out.print("push 1: ");
        s.push(1);
        s.printList();
        System.out.print("pop twice: ");
        s.pop();
        s.pop();
        s.printList();
        System.out.println("-------------------");

        MyQueue q = new MyQueue(myArray);
        System.out.print("QUEUE:");
        q.printList();
        System.out.print("queue 5: ");
        q.queue(5);
        q.printList();
        System.out.print("dequeue: ");
        q.dequeue();
        q.printList();
        System.out.println("-------------------");

        DumbQueue d = new DumbQueue(s);
        System.out.print("DUMB QUEUE:");
        d.printList();
        System.out.print("queue 4: ");
        d.queue(4);
        d.printList();
        System.out.print("dequeue: ");
        d.dequeue();
        d.printList();
        System.out.println("-------------------");
    }
}
