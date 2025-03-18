package project.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private List<MenuItem> burgersList = new ArrayList<>();
    private List<MenuItem> drinkList = new ArrayList<>();
    private List<MenuItem> dessertsList = new ArrayList<>();
    private List<MenuItem> cartList = new ArrayList<>();

    public Kiosk() {
        // Burger 메뉴 항목 (menuList)
        burgersList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgersList.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgersList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Drinks 메뉴 항목 (drinkList)
        drinkList.add(new MenuItem("Coke", 2.5, "코카콜라"));
        drinkList.add(new MenuItem("Soda", 2.5, "칠성사이다"));
        drinkList.add(new MenuItem("Milkshake", 3.9, "아이스크림을 갈아서 만든 음료"));

        // Desserts 메뉴 항목 (dessertsList)
        dessertsList.add(new MenuItem("Hot dog", 4.5, "기다란 모양의 소시지, 또는 핫도그 번에 끼운 음식"));
        dessertsList.add(new MenuItem("Chicken nugget", 4.5, "닭의 순살과 껍질을 갈아 튀긴 음식"));
        dessertsList.add(new MenuItem("Cheese stick", 4.5, "치즈에 튀김옷을 입혀 튀겨낸 음식"));
    }

    // Burger 메뉴 출력
    public void startBurger() {
        while (true) {
            System.out.println("\n[ BURGERS MENU ]");
            for (int i = 0; i < burgersList.size(); i++) {
                MenuItem item = burgersList.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getEx());
            }
            System.out.println("0. 뒤로가기");
            System.out.print("메뉴를 선택하세요: ");
            int order = sc.nextInt();

            if (order == 0) {
                return;  // 메인 메뉴로 돌아감
            } else if (order >= 1 && order <= burgersList.size()) {
                System.out.println("선택한 메뉴: " + burgersList.get(order - 1).getName() + " | W " + burgersList.get(order - 1).getPrice() + " | " + burgersList.get(order - 1).getEx());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? (1. 확인  2. 취소)");
                int cart = sc.nextInt();
                if (cart == 1) {
                    cartList.add(burgersList.get(order - 1));
                    System.out.println(burgersList.get(order - 1).getName() + " 이(가) 장바구니에 추가되었습니다.");
                    orderProcess();
                } else {
                    System.out.println("취소되었습니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // Drinks 메뉴
    public void startDrinks() {
        while (true) {
            System.out.println("\n[ DRINKS MENU ]");
            for (int i = 0; i < drinkList.size(); i++) {
                MenuItem item = drinkList.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getEx());
            }
            System.out.println("0. 뒤로가기");
            System.out.print("메뉴를 선택하세요: ");
            int order = sc.nextInt();

            if (order == 0) {
                return;
            } else if (order >= 1 && order <= drinkList.size()) {
                System.out.println("선택한 메뉴: " + drinkList.get(order - 1).getName() + " | W " + drinkList.get(order - 1).getPrice() + " | " + drinkList.get(order - 1).getEx());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? (1. 확인  2. 취소)");
                int cart = sc.nextInt();
                if (cart == 1) {
                    cartList.add(drinkList.get(order - 1));
                    System.out.println(drinkList.get(order - 1).getName() + " 이(가) 장바구니에 추가되었습니다.");
                    orderProcess();
                } else {
                    System.out.println("취소되었습니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // Desserts 메뉴
    public void startDesserts() {
        while (true) {
            System.out.println("[ DESSERTS MENU ]");
            for (int i = 0; i < dessertsList.size(); i++) {
                MenuItem item = dessertsList.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getEx());
            }
            System.out.println("0. 뒤로가기");
            System.out.print("메뉴를 선택하세요: ");
            int order = sc.nextInt();

            if (order == 0) {
                return;
            } else if (order >= 1 && order <= dessertsList.size()) {
                System.out.println("선택한 메뉴: " + dessertsList.get(order - 1).getName() + " | W " + dessertsList.get(order - 1).getPrice() + " | " + dessertsList.get(order - 1).getEx());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? (1. 확인  2. 취소)");
                int cart = sc.nextInt();
                if (cart == 1) {
                    cartList.add(dessertsList.get(order - 1));
                    System.out.println(dessertsList.get(order - 1).getName() + " 이(가) 장바구니에 추가되었습니다.");
                    orderProcess();
                } else {
                    System.out.println("취소되었습니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 최종 주문 확인 및 결제 처리: 메인 메뉴에서 4번 옵션으로 호출
    private void orderProcess() {
        if (cartList.isEmpty()) {
            System.out.println("장바구니가 비어있습니다!");
            return;
        }
        double total = 0;
        System.out.println("[ ORDER MENU ]");
        for (MenuItem item : cartList) {
            System.out.println(item.getName() + " | W " + item.getPrice() + " | " + item.getEx());
            total += item.getPrice();
        }
        System.out.println("[ Total ]");
        System.out.println("W " + total);

        System.out.println("1. 주문 확정    2. 계속 쇼핑");
        int lastOrder = sc.nextInt();
        if (lastOrder == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + total + " 입니다.");
            System.exit(0);
        } else {
            System.out.println("계속 쇼핑합니다.");
        }
    }

}