//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Node {
//    public int data;
//    public Node next;
//
//    public Node(int data) {
//        this.data = data;
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
//    // 초기화
//    public void init() {
//        nodeCnt = 0;
//        head = null;
//    }
//
//    // 맨 앞에 노드 추가
//    public void addNode2Head(int data) {
//        Node newNode = getNode(data);
//        newNode.next = head;
//        head = newNode;
//    }
//
//    // 맨 뒤에 노드 추가
//    public void addNode2Tail(int data) {
//        Node newNode = getNode(data);
//        if (head == null) {
//            head = newNode;
//            return;
//        }
//        Node curr = head;
//        while (curr.next != null) {
//            curr = curr.next;
//        }
//        curr.next = newNode;
//    }
//
//    // 지정된 순서에 노드 추가
//    public void addNode2Num(int data, int num) {
//        if (num <= 1) {
//            addNode2Head(data);
//            return;
//        }
//        int count = 1;
//        Node curr = head;
//        while (curr != null && count < num-1) {
//            curr = curr.next;
//            count++;
//        }
//        if (curr == null)
//            return;
//        Node newNode = getNode(data);
//        newNode.next = curr.next;
//        curr.next = newNode;
//    }
//
//    // 주어진 데이터 값을 가진 노드 삭제
//    public void removeNode(int data) {
//        if (head == null)
//            return;
//
//        if (head.data == data) {
//            head = head.next;
//            return;
//        }
//
//        Node curr = head;
//        while (curr.next != null) {
//            if (curr.next.data == data) {
//                curr.next = curr.next.next;
//                return;
//            }
//            curr = curr.next;
//        }
//    }
//
//    // output[] 배열에 리스트 노드의 data를 차례대로 넣고, 총 노드 갯수를 리턴
//    public int getList(int[] output) {
//        int count = 0;
//        Node curr = head;
//        while (curr != null) {
//            output[count++] = curr.data;
//            curr = curr.next;
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
//    private final static int REMOVE = 4;
//    private final static int PRINT = 5;
//    private final static int END = 99;
//
//    private final static UserSolution usersolution = new UserSolution();
//
//    private static BufferedReader br;
//
//    private static void run() throws Exception {
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
