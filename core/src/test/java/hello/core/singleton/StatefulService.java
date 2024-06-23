package hello.core.singleton;

public class StatefulService {


    private int price; // 가격 상태 유지

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
    return price;
    }

    public int getPrice(){
        return price;
    }


}
