package project.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    List<MenuItem> burgersList = new ArrayList<>();
    List<MenuItem> drinkList = new ArrayList<>();
    List<MenuItem> dessertsList = new ArrayList<>();
    List<MenuItem> cartList = new ArrayList<>();

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
        System.out.println("[ BURGERS MENU ]");
        for (int i = 0; i < burgersList.size(); i++) {
            System.out.println((i + 1) + ". " + burgersList.get(i).getName() + " | W " + burgersList.get(i).getPrice() + " | " + burgersList.get(i).getEx());
        }

        System.out.println("0. 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
        int order = sc.nextInt();

        if (order >= 1 && order <= burgersList.size()) {
            System.out.println("선택한 메뉴: " + burgersList.get(order - 1).getName() + " | W " + burgersList.get(order - 1).getPrice() + " | " + burgersList.get(order - 1).getEx());
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? (1. 확인  2. 취소)");
            int cart = sc.nextInt();

            if (cart == 1) {
                cartList.add(new MenuItem(burgersList.get(order - 1).getName(), burgersList.get(order - 1).getPrice(), burgersList.get(order - 1).getEx()));
                System.out.println(burgersList.get(order - 1).getName() + " 이 장바구니에 추가되었습니다.");
                orderProcess();
            } else if (cart == 2) {
                System.out.println("취소되었습니다. 메인 메뉴로 돌아갑니다.");
                new Menu();
            } else {
                System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
                new Menu();
            }
        } else if (order == 0) {
            new Menu();
        } else {
            System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
            new Menu();
        }
    }

    // Drinks 메뉴 출력
    public void startDrinks() {
        System.out.println("[ Drinks MENU ]");
        for (int i = 0; i < drinkList.size(); i++) {
            System.out.println((i + 1) + ". " + drinkList.get(i).getName() + " | W " + drinkList.get(i).getPrice() + " | " + drinkList.get(i).getEx());
        }
        System.out.println("0. 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
        int order = sc.nextInt();

        if (order >= 1 && order <= drinkList.size()) {
            System.out.println("선택한 메뉴: " + drinkList.get(order- 1).getName() + " | W " + drinkList.get(order- 1).getPrice() + " | " + drinkList.get(order- 1).getEx());
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? (1. 확인  2. 취소)");
            int cart = sc.nextInt();

            if (cart == 1) {
                cartList.add(new MenuItem(drinkList.get(order- 1).getName(), drinkList.get(order- 1).getPrice(), drinkList.get(order- 1).getEx()));
                System.out.println(drinkList.get(order- 1).getName() + " 이(가) 장바구니에 추가되었습니다.");
                orderProcess();
            } else if (cart == 2) {
                System.out.println("취소되었습니다. 메인 메뉴로 돌아갑니다.");
                new Menu();
            } else {
                System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
                new Menu();
            }
        } else if (order == 0) {
            new Menu();
        } else {
            System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
            new Menu();
        }
    }

    // Desserts 메뉴 출력
    public void startDesserts() {
        System.out.println("[ Desserts MENU ]");
        for (int i = 0; i < dessertsList.size(); i++) {
            System.out.println((i + 1) + ". " + dessertsList.get(i).getName() + " | W " + dessertsList.get(i).getPrice() + " | " + dessertsList.get(i).getEx());
        }
        System.out.println("0. 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
        int order = sc.nextInt();

        if (order >= 1 && order <= dessertsList.size()) {
            System.out.println("선택한 메뉴: " + dessertsList.get(order - 1).getName() + " | W " + dessertsList.get(order - 1).getPrice() + " | " + dessertsList.get(order - 1).getEx());
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? (1. 확인  2. 취소)");
            int cart = sc.nextInt();

            if (cart == 1) {
                cartList.add(new MenuItem(dessertsList.get(order - 1).getName(), dessertsList.get(order - 1).getPrice(), dessertsList.get(order - 1).getEx()));
                System.out.println(dessertsList.get(order - 1).getName() + " 이(가) 장바구니에 추가되었습니다.");
                orderProcess();
            } else if (cart == 2) {
                System.out.println("취소되었습니다. 메인 메뉴로 돌아갑니다.");
                new Menu();
            } else {
                System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
                new Menu();
            }
        } else if (order == 0) {
            new Menu();
        } else {
            System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
            new Menu();
        }
    }

    // 장바구니
    private void orderProcess() {
        System.out.println("[ ORDER MENU ]");
        System.out.println("1. Orders    | 장바구니를 확인 후 주문합니다.");
        System.out.println("2. Cancel    | 진행중인 주문을 취소합니다.");
        int orderMenu = sc.nextInt();

        if (orderMenu == 1) {
            double total = 0;
            System.out.println("[ Orders ]");
            for (MenuItem item : cartList) {
                System.out.println(item.getName() + " | W " + item.getPrice() + " | " + item.getEx());
                total += item.getPrice();
            }
            System.out.println("[ Total ]");
            System.out.println("W " + total);
            System.out.println("1. 주문    2. 메뉴판");
            int lastorder = sc.nextInt();
            if (lastorder == 1) {
                System.out.println("주문이 완료되었습니다. 금액은 W " + total + " 입니다.");
                cartList.clear();
            } else if (lastorder == 2) {
                new Menu();
            } else {
                System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
                new Menu();
            }
        } else if (orderMenu == 2) {
            System.out.println("주문이 취소되었습니다.");
            cartList.clear();
            new Menu();
        } else {
            System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
            new Menu();
        }
    }
}
