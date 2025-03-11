package project.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    List<MenuItem> menuList = new ArrayList<>();


    public void start() {
        System.out.println("[ " + "BURGERS MENU" + " ]");

        // 리스트 추가
        menuList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (true) { // 반복문 시작

            for (int i = 0; i < menuList.size(); i++) { // 리스트에있는 메뉴 출력
                System.out.println(i + 1 + ". " + menuList.get(i).getName() + " | W "  + menuList.get(i).getPrice() + " | "+menuList.get(i).getEx());
            }
            System.out.println("0." + " 뒤로가기   ");

            System.out.println("메뉴를 선택하세요.");
            int order = sc.nextInt(); // 입력 받기

            if (order >= 1 && order <= menuList.size()) { // 고른 메뉴 출력
                System.out.print("선택한 메뉴: ");
                System.out.print( menuList.get(order - 1).getName());
                System.out.print(" | W " + menuList.get(order - 1).getPrice() + " | ");
                System.out.print( menuList.get(order - 1).getEx());
                break;
            } else if (order == 0) { // 뒤로가기 옵션
                new Menu();
                return;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요."); // 잘못된 입력일경우
            }
        }

    }
}
