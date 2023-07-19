//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Node {
//    public int data;
//    public Node prev;
//    public Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.prev = null;
//        this.next = null;
//    }
//}
//
//class UserSolution {
//
//    private final static int MAX_NODE = 10000;
//
//    private Node[] node = new Node[MAX_NODE];
//    private int nodeCnt = 0;
//    private Node head;
//
//    public Node getNode(int data) {
//        node[nodeCnt] = new Node(data);
//        return node[nodeCnt++];
//    }
//
//    public void init() {
//        nodeCnt = 0;
//        head = null;
//    }
//
//    public void addNode2Head(int data) {
//        Node newNode = getNode(data);
//        if (head == null) {
//            head = newNode;
//        } else {
//            newNode.next = head;
//            head.prev = newNode;
//            head = newNode;
//        }
//    }
//
//    public void addNode2Tail(int data) {
//        Node newNode = getNode(data);
//        if (head == null) {
//            head = newNode;
//        } else {
//            Node curr = head;
//            while (curr.next != null) {
//                curr = curr.next;
//            }
//            curr.next = newNode;
//            newNode.prev = curr;
//        }
//    }
//
//    public void addNode2Num(int data, int num) {
//        if (num <= 1) {
//            addNode2Head(data);
//            return;
//        }
//        int count = 1;
//        Node curr = head;
//        while (curr != null && count < num - 1) {
//            curr = curr.next;
//            count++;
//        }
//        if (curr == null)
//            return;
//        Node newNode = getNode(data);
//        newNode.prev = curr;
//        newNode.next = curr.next;
//        if (curr.next != null) {
//            curr.next.prev = newNode;
//        }
//        curr.next = newNode;
//    }
//
//    public int findNode(int data) {
//        int count = 0;
//        Node curr = head;
//        while (curr != null) {
//            count++;
//            if (curr.data == data) {
//                return count;
//            }
//            curr = curr.next;
//        }
//        return -1;
//    }
//
//    public void removeNode(int data) {
//        if (head == null)
//            return;
//
//        if (head.data == data) {
//            head = head.next;
//            if (head != null) {
//                head.prev = null;
//            }
//            return;
//        }
//
//        Node curr = head;
//        while (curr != null && curr.data != data) {
//            curr = curr.next;
//        }
//        if (curr == null)
//            return;
//        if (curr.prev != null) {
//            curr.prev.next = curr.next;
//        }
//        if (curr.next != null) {
//            curr.next.prev = curr.prev;
//        }
//    }
//
//    public int getList(int[] output) {
//        int count = 0;
//        Node curr = head;
//        while (curr != null) {
//            output[count++] = curr.data;
//            curr = curr.next;
//        }
//        return count;
//    }
//
//    public int getReversedList(int[] output) {
//        int count = 0;
//        Node curr = head;
//        while (curr != null && curr.next != null) {
//            curr = curr.next;
//        }
//        while (curr != null) {
//            output[count++] = curr.data;
//            curr = curr.prev;
//        }
//        return count;
//    }
//}
//
//public class Solution {
//
//    private final static int MAX_NODE = 10000;
//    private final static int ADD_HEAD = 1;
//    private final static int ADD_TAIL = 2;
//    private final static int ADD_NUM = 3;
//    private final static int FIND = 4;
//    private final static int REMOVE = 5;
//    private final static int PRINT = 6;
//    private final static int PRINT_REVERSE = 7;
//    private final static int END = 99;
//
//    private final static UserSolution usersolution = new UserSolution();
//
//    private static BufferedReader br;
//
//    public static void run() throws Exception {
//        int cmd, data, num, ret;
//        int[] output = new int[MAX_NODE];
//        String str;
//        StringTokenizer st;
//
//        while (true) {
//            str = br.readLine();
//            st = new StringTokenizer(str, " ");
//            cmd = Integer.parseInt(st.nextToken());
//
//            switch (cmd) {
//                case ADD_HEAD:
//                    data = Integer.parseInt(st.nextToken());
//                    usersolution.addNode2Head(data);
//                    break;
//
//                case ADD_TAIL:
//                    data = Integer.parseInt(st.nextToken());
//                    usersolution.addNode2Tail(data);
//                    break;
//
//                case ADD_NUM:
//                    data = Integer.parseInt(st.nextToken());
//                    num = Integer.parseInt(st.nextToken());
//                    usersolution.addNode2Num(data, num);
//                    break;
//
//                case FIND:
//                    data = Integer.parseInt(st.nextToken());
//                    num = usersolution.findNode(data);
//                    System.out.println(num);
//                    break;
//
//                case REMOVE:
//                    data = Integer.parseInt(st.nextToken());
//                    usersolution.removeNode(data);
//                    break;
//
//                case PRINT:
//                    ret = usersolution.getList(output);
//                    for (int i = 0; i < ret; i++) {
//                        System.out.print(output[i] + " ");
//                    }
//                    System.out.println();
//                    break;
//
//                case PRINT_REVERSE:
//                    ret = usersolution.getReversedList(output);
//                    for (int i = 0; i < ret; i++) {
//                        System.out.print(output[i] + " ");
//                    }
//                    System.out.println();
//                    break;
//
//                case END:
//                    return;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        int TC;
//        // System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
//
//        br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        TC = Integer.parseInt(str);
//
//        for (int tc = 1; tc <= TC; tc++) {
//            System.out.println("#" + tc);
//            usersolution.init();
//            run();
//            System.out.println();
//        }
//    }
//}
