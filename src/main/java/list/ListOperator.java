package list;

public class ListOperator {

    public Node initListHead(int n){
        Node head = new Node();
        head.data = 0;
        head.next = null;

        for(int i = 1; i < n; i++){
            Node node = new Node();

            node.data = i;
            node.next = head.next;
            head.next = node;
        }

        return head;
    }

    public Node initListTail(int n){
        Node head = new Node();
        head.data = 0;
        head.next = null;
        Node tail = head;


        for(int i = 1; i < n; i++){
            Node node = new Node();

            node.data = i;
            node.next = null;

            tail.next = node;
            tail = node;
        }
        return head;
    }

    public boolean insert(Node head,int index,Node node){
        if(index == 1){
            node.next = head;
            return true;
        }

        Node pre = head;
        int i = 1;
        while(i < index - 1){
            pre = pre.next;
            if(pre == null && i < index){
                System.out.println("list index out of range "+i);
                return false;
            }

            i++;
        }

        Node next = pre.next;
        pre.next = node;
        node.next = next;

        return true;
    }

    public boolean remove(Node head,int index){
        Node pre = head;
        int i = 1;
        while(i < index - 1){
            pre = pre.next;
            if(pre.next == null){
                System.out.println("list index out of range "+i);
                return false;
            }

            i++;
        }


        Node next = pre.next;
        if(next != null){
            pre.next = next.next;
        }

        return true;
    }

    public void clearList(Node head){
        if(head.next == null){
            head.data = -2;
            head = null;
        }else{
            Node next = head.next;
            head.next = next.next;
            next = null;
            clearList(head);
        }
    }

    public void listLIst(Node head){
        System.out.println(head.data);
        if(null != head.next) {
            listLIst(head.next);
        }
    }


    public static void main(String[] args) {
        ListOperator listOperator = new ListOperator();

        Node head = listOperator.initListTail(3);
        listOperator.listLIst(head);

        System.out.println("-----------------------");

        Node node = new Node();
        node.data = 111;
        listOperator.insert(head,1,node);
        listOperator.listLIst(head);
//
//        listOperator.remove(head,2);
//        listOperator.listLIst(head);

//        System.out.println("=================================");
//        listOperator.clearList(head);
//        listOperator.listLIst(head);

    }
}
