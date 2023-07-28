package swEA;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//
//class UserSolution {
//
//    private final static int NAME_MAXLEN	= 6;
//    private final static int PATH_MAXLEN	= 1999;
//    static HashMap<String, ArrayList<String>> dir;
////	int mstrcmp(char[] a, char[] b) {
////		int i;
////		for (i = 0; a[i] != '\0'; i++) {
////			if (a[i] != b[i])
////				return a[i] - b[i];
////		}
////		return a[i] - b[i];
////	}
////
////	int mstrncmp(char[] a, char[] b, int len) {
////		for (int i = 0; i < len; i++) {
////			if (a[i] != b[i])
////				return a[i] - b[i];
////		}
////		return 0;
////	}
////
////	int mstrlen(char[] a) {
////		int len = 0;
////
////		while (a[len] != '\0')
////			len++;
////
////		return len;
////	}
////
////	void mstrcpy(char[] dest, char[] src) {
////		int i = 0;
////		while (src[i] != '\0') {
////			dest[i] = src[i];
////			i++;
////		}
////		dest[i] = src[i];
////	}
////
////	void mstrncpy(char[] dest, char[] src, int len) {
////		for (int i = 0; i < len; i++) {
////			dest[i] = src[i];
////		}
////		dest[len] = '\0';
////	}
//
//    //    static int findPath(char[] path) {
////        for (int i = 0; i < path.length; i++) {
////            if (path[i]=='/') continue;
////
////        }
////    }
//    private String getSubDir(char[] path) {
//        String[] srcs = new String(path).split("/");
//        String finalPath = srcs.length == 0 ? "/" : srcs[srcs.length - 1];
//        return finalPath;
//    }
//
//
//    void init(int n) {
//        dir = new HashMap<>();
//        dir.put("/", new ArrayList<>());
//    }
//
//    void cmd_mkdir(char[] path, char[] name) {
//
//        String[] dests = new String(name).split("/");
//        // name의 경로를 path에 넣어주기 전에 name의 계층관계를 먼저 추가
//        injectHierarchical(dests);
//
//        // path 마지막 경로에 name의 시작 경로를 추가
//        String subDir = getSubDir(path);
//        ArrayList<String> subChild = dir.get(subDir);
//        subChild.add(dests[0]);
//        dir.put(subDir, subChild);
//    }
//
//    private void injectHierarchical(String[] dests) {
//        for (int i = 0; i < dests.length-1; i++) {
//            if (dir.containsKey(dests[i])) {
//                ArrayList<String> destChild = dir.get(dests[i]);
//                destChild.add(dests[i + 1]);
//                dir.put(dests[i], destChild);
//            }
//            else
//                dir.put(dests[i], new ArrayList<>(Arrays.asList(dests[i + 1])));
//        }
//    }
//
//    void cmd_rm(char[] path) {
//        String subDir = getSubDir(path);
//        ArrayList<String> targetChild = dir.get(subDir);
//        targetChild.clear();
//        dir.put(subDir, targetChild);
//        dir.
//    }
//
//    void cmd_cp(char[] srcPath, char[] dstPath) {
//        //dst 마지막 경로에 src 첫경로를 추가
//        String[] srcs = new String(srcPath).split("/");
//        injectHierarchical(srcs);
//
//        String subDir = getSubDir(dstPath);
//        ArrayList<String> finalPathChild = dir.get(subDir);
//        finalPathChild.add(srcs[0]);
//        dir.put(srcs[0], finalPathChild);
//    }
//
//    void cmd_mv(char[] srcPath, char[] dstPath) {
//
//    }
//
//    int cmd_find(char[] path) {
//
//        return 0;
//    }
//}
//
//class Solution {
//
//    private static UserSolution usersolution = new UserSolution();
//
//    private final static int CMD_MKDIR		= 1;
//    private final static int CMD_RM			= 2;
//    private final static int CMD_CP			= 3;
//    private final static int CMD_MV			= 4;
//    private final static int CMD_FIND		= 5;
//
//    private final static int NAME_MAXLEN	= 6;
//    private final static int PATH_MAXLEN	= 1999;
//
//
//    private static boolean run(Scanner sc, int m) throws Exception {
//
//        boolean isAccepted = true;
//        int cmd;
//        char[] name;
//        char[] path1;
//        char[] path2;
//        String inputStr = "";
//
//        while (m-- > 0) {
//
//            cmd = sc.nextInt();
//
//            if (cmd == CMD_MKDIR) {
//                inputStr = sc.next() + " ";
//                path1 = inputStr.toCharArray();
//                path1[inputStr.length() - 1] = '\0';
//                inputStr = sc.next() + " ";
//                name = inputStr.toCharArray();
//                name[inputStr.length() - 1] = '\0';
//
//                usersolution.cmd_mkdir(path1, name);
//            }
//            else if (cmd == CMD_RM) {
//                inputStr = sc.next() + " ";
//                path1 = inputStr.toCharArray();
//                path1[inputStr.length() - 1] = '\0';
//
//                usersolution.cmd_rm(path1);
//            }
//            else if (cmd == CMD_CP) {
//                inputStr = sc.next() + " ";
//                path1 = inputStr.toCharArray();
//                path1[inputStr.length() - 1] = '\0';
//                inputStr = sc.next() + " ";
//                path2 = inputStr.toCharArray();
//                path2[inputStr.length() - 1] = '\0';
//
//                usersolution.cmd_cp(path1, path2);
//            }
//            else if (cmd == CMD_MV) {
//                inputStr = sc.next() + " ";
//                path1 = inputStr.toCharArray();
//                path1[inputStr.length() - 1] = '\0';
//                inputStr = sc.next() + " ";
//                path2 = inputStr.toCharArray();
//                path2[inputStr.length() - 1] = '\0';
//
//                usersolution.cmd_mv(path1, path2);
//            }
//            else {
//                int ret;
//                int answer;
//
//                inputStr = sc.next() + " ";
//                path1 = inputStr.toCharArray();
//                path1[inputStr.length() - 1] = '\0';
//
//                ret = usersolution.cmd_find(path1);
//
//                answer = sc.nextInt();
//
//                isAccepted &= (ret == answer);
//            }
//        }
//
//        return isAccepted;
//    }
//
//    public static void main(String[] args) throws Exception {
//        int test, T;
//        int n, m;
//
//        System.setIn(new java.io.FileInputStream("sample_input.txt"));
//
//        Scanner sc = new Scanner(System.in);
//
//        T = sc.nextInt();
//
//        for (test = 1; test <= T; ++test) {
//
//            n = sc.nextInt();
//            m = sc.nextInt();
//
//            usersolution.init(n);
//
//            if (run(sc, m)) {
//                System.out.println("#" + test + " 100");
//            }
//            else {
//                System.out.println("#" + test + " 0");
//            }
//        }
//
//        sc.close();
//    }
//}