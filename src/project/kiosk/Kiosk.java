package project.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    List<MenuItem> menuList = new ArrayList<>();
    List<MenuItem> cartList = new ArrayList<>();

    public Kiosk() {
        menuList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start() {
        int order;
        while (true) {
            // 메뉴판 출력
            System.out.println("[ BURGERS MENU ]");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i + 1) + ". " + menuList.get(i).getName() + " | W " + menuList.get(i).getPrice() + " | " + menuList.get(i).getEx());
            }
            System.out.println("0. 뒤로가기");
            System.out.print("메뉴를 선택하세요: ");

            order = sc.nextInt();
            if (order >= 1 && order <= menuList.size()) {
                // 선택한 메뉴 출력
                System.out.println("선택한 메뉴: " + menuList.get(order - 1).getName() + " | W " + menuList.get(order - 1).getPrice() + " | " + menuList.get(order - 1).getEx());
                System.out.println(menuList.get(order - 1).getName() + " | W " + menuList.get(order - 1).getPrice() + " | " + menuList.get(order - 1).getEx());
            } else if (order == 0) { // 뒤로가기 처리
                new Menu();
                return;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            // 장바구니 추가 여부 확인
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인  2. 취소");
            int cart = sc.nextInt();
            if (cart != 1 && cart != 2){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                start();
                return;
            }

            if (cart == 1) {
                System.out.println(menuList.get(order - 1).getName() + " 이 장바구니에 추가되었습니다.");
                cartList.add(new MenuItem(menuList.get(order - 1).getName(), menuList.get(order - 1).getPrice(), menuList.get(order - 1).getEx()));

                System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                if (cartList.size() >= 1) {
                    int cartmenu;
                    while (true) { // ORDER MENU에서 올바른 입력(4 or 5) 받기
                        System.out.println("[ ORDER MENU ]");
                        System.out.println("4. Orders    | 장바구니를 확인 후 주문합니다.");
                        System.out.println("5. Cancel    | 진행중인 주문을 취소합니다.");

                        cartmenu = sc.nextInt();
                        if (cartmenu == 4 || cartmenu == 5) {
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                            continue;
                        }
                    }

                    double total = 0;
                    if (cartmenu == 4) {
                        System.out.println("[ Orders ]");
                        System.out.println(cartList.get(cart - 1).getName() + " | W " + cartList.get(cart - 1).getPrice() + " | " + cartList.get(cart - 1).getEx());
                        for (int i = 0; i < cartList.size(); i++) {
                            total += cartList.get(i).getPrice();
                        }
                        System.out.println("[ Total ]");
                        System.out.println("W " + total);
                    } else if (cartmenu == 5) {
                        System.out.println("주문이 취소되었습니다.");
                        new Menu();
                    }


                    System.out.println("1.주문    2.메뉴판");
                    int lastorder = sc.nextInt();
                    if (lastorder == 1) {
                        System.out.println("주문이 완료되었습니다. 금액은 " + total + " 입니다.");
                        cartList.clear();
                        break;
                    } else if (lastorder == 2) {
                        new Menu();
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    }
                }
            } else if (cart == 2) {
                System.out.println("취소되었습니다. 주문 화면으로 돌아갑니다.");
                new Menu();
                return;
            } else if (cart <= 0 || cart > 2) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
