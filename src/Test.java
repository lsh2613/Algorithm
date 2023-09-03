class Test{
    public static void main(String[] args) {
        int cnt = 10;
        for (int i = 0; i < cnt; i++) {
            System.out.println("i = " + i);
            cnt--;
        }
        String str = "abcde";
        System.out.println(str.substring(0, 3));
    }
}