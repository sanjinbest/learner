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

        return false;
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

        System.out.println("=================================");
        listOperator.clearList(head);
        listOperator.listLIst(head);

    }
}
