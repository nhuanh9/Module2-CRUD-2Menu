public class Test {
    public static void main(String[] args) {
        int a = 10;
        Post post = new Post();
        String x = "100"; //literal => lưu ở String pool
        String y = new String("1000"); // instance => luu ở Heap
        String y2 = new String("1000"); // instance => luu ở Heap
        String z = "1000"; // Tạo them 1 string moi
        String t = "100";
        // String là bất biến
        System.out.println(y.equals(y2));
        System.out.println(y == y2);
        System.out.println(x.equals(t));
        System.out.println(x == t);

        Post p1 = new Post(1, "A", "A", "A", "A");
        Post p2 = new Post(1, "B", "B", "A", "A");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
    }
}
