import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Post> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new Post(1, "A", "B", "123", null));
        list.add(new Post(2, "B", "B", "123", null));
        list.add(new Post(3, "C", "B", "123", null));
        list.add(new Post(4, "D", "B", "123", null));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Login Time");
            System.out.println("Username: ");
            String usn = scanner.nextLine();
            System.out.println("Password: ");
            String pass = scanner.nextLine();
            if (usn.equals("admin") && pass.equals("admin")) {
                showMenuAdmin();
            }
            if (usn.equals("user") && pass.equals("user")) {
                showMenuUser();
            }
        }
    }

    static void showMenuAdmin() {
        System.out.println("Menu Admin");
        int choice = -1;
        Scanner inNumber = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        while (true) {
            System.out.println("" + "1. Thêm: Nhập vào id, title, content. createAt lấy thời gian hiện tại, updateAt để null\n" + "2. Cập nhập. Nhập và id muốn sửa, nhập vào title, content mới, updateAt lấy thời gian hiện tại\n" + "3. Xóa\n" + "4. Hiện danh sách\n" + "5. Đăng xuất\n");
            choice = inNumber.nextInt();
            if (choice == 1) {
                System.out.println("Nhap vao id: ");
                int id = inNumber.nextInt();
                System.out.println("Nhap vao title: ");
                String title = inStr.nextLine();
                System.out.println("Nhap vao content: ");
                String content = inStr.nextLine();
                String createAt = String.valueOf(LocalDateTime.now());
                list.add(new Post(id, title, content, createAt, null));
            }
            if (choice == 2) {
                System.out.println("Nhap vao id can sua: ");
                int id = inNumber.nextInt();
                System.out.println("Nhap vao title: ");
                String title = inStr.nextLine();
                System.out.println("Nhap vao content: ");
                String content = inStr.nextLine();
                String updateAt = String.valueOf(LocalDateTime.now());
                for (int i = 0; i < list.size(); i++) {
                    if (id == list.get(i).getId()) {
                        list.get(i).setTitle(title);
                        list.get(i).setContent(content);
                        list.get(i).setUpdateAt(updateAt);
                    }
                }
            }
            if (choice == 5) {
                break;
            }
        }
    }

    static void showMenuUser() {
        System.out.println("Menu User");
        int choice = -1;
        Scanner inNumber = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        while (true) {
            System.out.println("" +
                    "1. Hiện danh sách\n" +
                    "2. Xem chi tiet 1 bai viet\n" +
                    "5. Đăng xuất\n");
            choice = inNumber.nextInt();
            if (choice == 1) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).getTitle() + "," +list.get(i).getCreateAt());
                }
            }
            if (choice == 2) {
                System.out.println("Nhap vao id can tim: ");
                int id = inNumber.nextInt();
                for (int i = 0; i < list.size(); i++) {
                    if (id == list.get(i).getId()) {
                        System.out.println(list.get(i));
                    }
                }
            }
            if (choice == 5) {
                break;
            }
        }
    }

}