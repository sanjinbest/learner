package list;

/**
 * 静态链表实现
 */
public class StaticList {

    private Node[] elements;
    private Node data;
    private Node head;

    private final int DEFAULT_ARRAY_SIZE = 100;
    private int max = 0;

    /**
     * 初始化数组
     * data 存储在数组0下标位置，标记下一个可用存储的下标，起始从下标1开始
     * head 存储在数组最后位置，标记静态链表的head下标，起始从下标1开始
     * @param size
     */
    public void init(int size){
        max = size ;

        size += 2;
        elements = new Node[size];
        data = new Node(null,1);
        head = new Node(null,1);

        elements[0] = data;
        elements[size - 1] = head;
    }

    public StaticList() {
        init(DEFAULT_ARRAY_SIZE);
    }

    public StaticList(int size){
        init(size);
    }

    /**
     * 向链表追加一个元素
     * 默认放到data.next下标处
     * @param node
     * @return
     */
    public Node add(Node node){
        checkLength();
        Node tail = tail();
        tail.next = data.next++;
        elements[tail.next] = node;

        return elements[tail.next];
    }

    /**
     * 遍历查找当前链表尾节点
     * @return
     */
    private Node tail() {
        if(head.next.equals(data.next)){
            return head;
        }
        int index = head.next;
        while(null != elements[index]
                && null != elements[index].next
                && elements[index].next > 0){
            index = elements[index].next;
        }

        return elements[index];
    }

    /**
     * 插入元素到链表index处
     * 直接追加到数组data.next位置，并将链表对应节点指向data.next位置
     * @param node
     * @param index
     * @return
     */
    public boolean insert(Node node,int index){
        checkLength();

        if(index > data.next){
            index = data.next;
        }

        elements[data.next] = node;

        if(1 == index){
            node.next = head.next;
            head.next = data.next;
        }else{
            Node preNode = get(index - 1);
            node.next = preNode.next;
            preNode.next = data.next;
        }

        data.next++;
        return true;
    }

    /**
     * 删除链表index位置的元素
     * 删除链表index位置的元素，并将数组最后一个链表元素放到原链表index位置元素在数组的位置
     * @param index
     * @return
     */
    public boolean remove(int index){
        //非头节点
        if(!head.next.equals(index)){
            Node preNode = get(index - 1);
            if(null == preNode){
                return false;
            }
            Node curNode = elements[preNode.next];
            elements[preNode.next] = null;
            preNode.next = curNode.next;
        }else{
            int tmpIndex = elements[head.next].next;
            elements[head.next] = null;
            head.next = tmpIndex;
        }
        compact();

        return true;
    }

    public boolean remove(Node node){
        int index = 0;
        for(int i = 1; i < elements.length - 1; i++){
            if(null != elements[i] && elements[i].data.equals(node.data) && elements[i].next.equals(node.next)){
                index = i;
            }
        }

        if(index > 0){
            return remove(index);
        }
        return false;
    }

    public Node get(int index){
        if(index > (data.next - 1)){
            return null;
        }

        int currentIndex = head.next;
        for(int i = 1; i < index; i++){
            currentIndex = elements[currentIndex].next;
        }

        return elements[currentIndex];
    }

    /**
     * 整理数组
     * @return
     */
    private void compact(){
        for(int i = 1; i < data.next; i++){
            transfer(i);
        }
    }

    /**
     * 将最后一个元素移动到index处
     * @param index
     * @return
     */
    private boolean transfer(int index){
        if(null != elements[index]){
            return false;
        }

        int preIndex = data.next - 1;

        Node preNode = getPrevious(preIndex);
        if(null == preNode){
            return false;
        }

        elements[index] = elements[preIndex];
        elements[preIndex] = null;
        preNode.next = index;
        data.next--;

        return true;
    }

    public Node getPrevious(int index){
        if(index > data.next){
            throw new ArrayIndexOutOfBoundsException("list capacity is "+max);
        }
        if(null == elements[index]){
            return null;
        }
        if(head.next.equals(index)){
            return head;
        }
        Node curNode = elements[head.next];
        while(!curNode.next.equals(index)){
            curNode = elements[curNode.next];
        }

        return curNode;
    }

    public void output(){
        Node node = elements[head.next];
        while(true){
            System.out.print(node.data+",");
            if(node.next != null){
                node = elements[node.next];
            }else{
                break;
            }
        }
        System.out.println();
    }

    public void printElements(){
        for(Node node : elements){
            if(node != null){
                System.out.print("["+node.data+","+node.next+"]  ");
            }else{
                System.out.print("[  ]  ");
            }
        }
        System.out.println();
    }

    private void checkLength(){
        if(data.next > max){
            data.next = max;
            throw new ArrayIndexOutOfBoundsException("list capacity is "+max);
        }
    }

    class Node{
        protected Integer data;
        protected Integer next;

        public Node(Integer data) {
            this.data = data;
        }

        public Node(Integer data, Integer next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        int size = 10;
        StaticList list = new StaticList(size);
        for(int i = 1;i <= size - 5; i++){
            list.add(list.new Node(i));
        }

        System.out.println("add");
        list.printElements();
        list.output();

        list.insert(list.new Node(7),1);
        System.out.println("insert");
        list.printElements();
        list.output();

        list.remove(2);
        list.remove(1);
        System.out.println("remove");
        list.printElements();
        list.output();
    }
}
