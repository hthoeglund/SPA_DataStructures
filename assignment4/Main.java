public class Main {
    public static void main(String[] args){
        Node node = new Node(5);
        MyLinkedList mll = new MyLinkedList(node);
        System.out.println("INITIAL: " + mll);
        System.out.println("-------------------");

        //add
        System.out.println("ADD:");
        mll.add(4);
        mll.add(3);
        mll.addEnd(7);
        System.out.println(mll);
        System.out.println("-------------------");

        //insert
        System.out.println("INSERT:");
        mll.insert(6, 3);
        mll.insert(10, 1);
        System.out.println(mll);
        System.out.println("-------------------");

        //remove
        System.out.println("REMOVE:");
        mll.remove(1);
        System.out.println(mll);
        System.out.println("-------------------");

        //switch
        System.out.println("SWITCH:");
        mll.Switch(0, 2);
        System.out.println(mll);
        mll.Switch(1, 4);
        System.out.println(mll);
        System.out.println("-------------------");

        //reverse
        System.out.println("REVERSE:");
        mll.reverse();
        System.out.println(mll);
        System.out.println("-------------------");
        
        //merge
        System.out.println("MERGE:");
        Node node1 = new Node(1);
        MyLinkedList mll2 = new MyLinkedList(node1);
        mll2.addEnd(2);
        mll2.addEnd(3);
        System.out.println("Second List: " + mll2);
        System.out.println(merge(mll, mll2));
    }

    public static MyLinkedList merge(MyLinkedList one, MyLinkedList two){
        //merges the lists
        one.lastNode().next = two.headNode;
        //cNode1 and cNode2 are used to cycle through every combination of nodes, a and a2 are their indexes
        Node cNode1 = one.headNode;
        int a = 0;
        Node cNode2 = one.headNode;
        int a2 = 0;
        while(cNode1 != null){
            //sets cNode2 and its index to the node after cNode1
            cNode2 = cNode1.next;
            a2 = a+1;
            while(cNode2 != null){
                if(cNode2.data < cNode1.data){
                    one.Switch(a, a2);
                    //MyLinkedList.Switch only changes the locations of the node, but for comparison purposes I need the names of the node to switch too, which is what these lines do
                    Node tempNode = cNode1;
                    cNode1 = cNode2;
                    cNode2 = tempNode;
                }
                a2++;
                cNode2 = cNode2.next;
            }
            a++;
            cNode1 = cNode1.next;
        }
        return one;
    }
}

