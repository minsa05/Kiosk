package project.kiosk;

public class MenuItem { // 속성
    private String name;
    private double price;
    private String ex;

    public MenuItem(String name, double price, String ex) { // 생성자
        this.name = name;
        this.price = price;
        this.ex = ex;
    }

    public String getName() { // name 게터
        return name;
    }

    public double getPrice() { // price(가격) 게터
        return price;
    }

    public String getEx() { // ex(설명) 게터
        return ex;
    }

    public void setName(String name) { // name 세터
        this.name = name;
    }
    public void setPrice(double price) { // price(가격) 세터
        if (price < 0) {
            System.out.println("가격은 음수가 될 수 없습니다."); // 가격이 0보다 아래일경우
        }
        this.price = price;
    }
    public void setEx(String ex) { // ex(설명) 세터
        this.ex = ex;
    }

}