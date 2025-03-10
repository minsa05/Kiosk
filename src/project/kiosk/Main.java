package project.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 스캐너
        List<MenuItem> menuList = new ArrayList<>(); //

        // 리스트 추가
        menuList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (true) { // 반복문 시작

            System.out.println("[ " + "SHAKESHACK" + " ]");
            for (int i = 0; i < menuList.size(); i++) { // 리스트에있는 메뉴 출력
                System.out.println(i + 1 + ". " + menuList.get(i).getname() + " | W "  + menuList.get(i).getprice() + " | "+menuList.get(i).getex());
            }
            System.out.println("0." + " 종료   " + " | " + " 종료 ");

            System.out.println("메뉴를 선택하세요."); // 입력 받기
            int order = sc.nextInt();

            if (order >= 1 && order <= menuList.size()) { // 고른 메뉴 출력
                System.out.println("메뉴 : " + menuList.get(order - 1).getname());
                System.out.println("가격 : W " + menuList.get(order - 1).getprice());
                System.out.println("설명 : " + menuList.get(order - 1).getex());
                break;
            } else if (order == 0) {
                System.out.println("선택을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
