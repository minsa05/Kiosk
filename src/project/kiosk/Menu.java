package project.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<MenuItem> menuItem = new ArrayList<MenuItem>();
    Scanner sc = new Scanner(System.in);

    public Menu() {
        // 메인 메뉴 항목 추가
        menuItem.add(new MenuItem("Burger", 0, "버거 모음"));
        menuItem.add(new MenuItem("Drinks", 0, "음료 모음"));
        menuItem.add(new MenuItem("Desserts", 0, "디저트 모음"));

        while (true) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuItem.size(); i++) {
                System.out.println((i + 1) + ". " + menuItem.get(i).getName() + " | W " + menuItem.get(i).getPrice() + " | " + menuItem.get(i).getEx());
            }

            System.out.println("0. 종료    | 종료합니다.");
            System.out.print("메뉴를 선택하세요: ");
            int order = sc.nextInt();

            switch (order) {
                case 1:
                    new Kiosk().startBurger();
                    break;
                case 2:
                    new Kiosk().startDrinks();
                    break;
                case 3:
                    new Kiosk().startDesserts();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
