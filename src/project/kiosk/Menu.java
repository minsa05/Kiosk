package project.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<MenuItem> menuItem = new ArrayList<MenuItem>();
    Scanner sc = new Scanner(System.in);


    public Menu() {
        // 리스트 추가
        menuItem.add(new MenuItem("Burger", 0, "버거 모음"));
        menuItem.add(new MenuItem("Drinks", 0, "음료 모음"));
        menuItem.add(new MenuItem("Desserts", 0, "디저트 모음"));

        while (true) { // 반복문 시작

            System.out.println("[ " + "MAIN MENU" + " ]");
            for (int i = 0; i < menuItem.size(); i++) { // 리스트에있는 메뉴 출력
                System.out.println(i + 1 + ". " + menuItem.get(i).getName() + " | W " + menuItem.get(i).getPrice() + " | " + menuItem.get(i).getEx());
            }
            System.out.println("0. 종료    |  종료합니다.");

            System.out.println("메뉴를 선택하세요.");
            int order = sc.nextInt(); // 입력 받기

            switch (order) {
                case 1:
                    new Kiosk().start(); // 1 입력받을시 BURGERS MENU로 이동
                    break;
                case 2:
                    System.out.println("Drinks 메뉴를 선택했습니다.");
                    break;
                case 3:
                    System.out.println("Desserts 메뉴를 선택했습니다.");
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
