
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static User[] users = new User[5];


    public static void main(String[] args) {

        while (true) {
            menu();
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {

                case 1:
                    showAllUser();
                    break;

                case 2:
                    showUserById();
                    break;

                case 3:
                    createUser();
                    break;

                case 4:
                    updateUserById();
                    break;

                case 5:
                    removeUserById();
                    break;


            }
        }
    }

    public static void menu() {
        System.out.println("1.Bank iscilerini gor");
        System.out.println("2.Bankdaki spesifik iscini gor");
        System.out.println("3.Banka user elave et");
        System.out.println("4.Useri update et");
        System.out.println("5.Useri sil");
        System.out.print("Secim edin: ");

    }


    public static void createUser() {
        System.out.println("User adi daxil edin: ");
        String ad = scanner.nextLine();
        System.out.print("Bir surname daxil edin: ");
        String surname = scanner.nextLine();
        System.out.println("Bir email daxil edin: ");
        String email = scanner.nextLine();
        System.out.println("Bir password daxil edin: ");
        String password = scanner.nextLine();


        int id = showUserById();


        boolean check = true;
        User user = new User(ad, surname, email, password, id);


        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                check = false;
                break;
            }
        }


        if (check) {
            User[] newUsers = new User[users.length * 2];
            for (int i = 0; i < users.length; i++) {
                newUsers[i] = users[i];
            }
            int size = users.length;
            users = newUsers;
            users[size] = user;
        }
    }


    public static void showAllUser() {

        for (var user : users) {
            if (users != null) {
                System.out.println(user);

            }
        }
    }

    public static int showUserById() {
        int id;

        System.out.println("Bir id daxil edin");
        id = scanner.nextInt();

        for (var user : users) {
            if (user != null && user.id == id) {

                System.out.println(user);
                break;
            }

        }
        return id;

    }

    public static void removeUserById() {

        System.out.print("id daxil edin: ");
        int id = scanner.nextInt();

        int indexForRemove = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].id == id) {
                indexForRemove = i;
                break;
            }
        }

        if (indexForRemove != -1) {
            User[] newUser = new User[users.length - 1];
            int j = 0;
            for (int i = 0; i < users.length; i++) {
                if (i != indexForRemove) {
                    newUser[j++] = users[i];
                }
            }
            users = newUser;


        }
    }

    public static void updateUserById() {
        System.out.print("Yeniləmək istədiyiniz işçinin ID-sini daxil edin: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                scanner.nextLine();
                System.out.print("Yeni ad: ");
                String name = scanner.nextLine();
                System.out.print("Yeni soyad: ");
                String surname = scanner.nextLine();
                System.out.print("Yeni email: ");
                String email = scanner.nextLine();
                System.out.print("Yeni şifrə: ");
                String password = scanner.nextLine();

                users[i] = new User(password, name, surname, email, id);
                System.out.println("İşçi yeniləndi.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Belə bir işçi tapılmadı.");
        }
    }

}







