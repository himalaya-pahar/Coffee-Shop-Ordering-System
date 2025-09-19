import java.util.HashMap;
import java.util.Scanner;

class Coffee {
    private String name;
    private double price;

    public Coffee(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class ViewOrder{
    public double bill;
    public HashMap<String,Integer> coffeeCount;
    public HashMap<String,Double> coffeePrice;

    public ViewOrder(){
        bill=0;
        coffeeCount=new HashMap<String,Integer>();
        coffeePrice=new HashMap<String,Double>();
    }

    public void add(Coffee coffee){
        coffeeCount.put(coffee.getName(),coffeeCount.getOrDefault(coffee.getName(),0)+1);
        coffeePrice.put(coffee.getName(), coffee.getPrice());
        bill+=coffee.getPrice();
    }

//    public void remove(Coffee coffee){
//        bill-=coffee.getPrice();
//        coffeeCount.put(coffee.getName(),coffeeCount.getOrDefault(coffee.getName(),0)-1);
//    }

    public void getMenu(){
        int idx=1;
        for(String name: coffeeCount.keySet()){
            int qnt=coffeeCount.get(name);
            double price=coffeePrice.get(name);
            double total=qnt*price;
            System.out.println(idx+". "+name+" x "+ qnt+  " - $"+String.format("%.2f",total));
            idx++;
        }
    }

    public double getBill(){
        return bill;
    }
}


public class Main{
    public static void main(String[] args){
        ViewOrder menu=new ViewOrder();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("--- Coffee Menu ---");
            System.out.println("1. Espresso - $2.5");
            System.out.println("2. Latte - $3.5");
            System.out.println("3. Cappuccino - $3.0");
            System.out.println("4. Americano - $2.0");
            System.out.println("5. View Order");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int n= sc.nextInt();
            if(n==1){
                System.out.println("Espresso added to the cart successfully");
                Coffee c1=new Coffee("Espresso",2.5);
                menu.add(c1);
            }
            else if(n==2){
                System.out.println("Latte added to the cart successfully");
                Coffee c2=new Coffee("Latte",3.5);
                menu.add(c2);
            }
            else if(n==3){
                System.out.println("Cappuccino added to the cart successfully");
                Coffee c3=new Coffee("Cappuccino",3);
                menu.add(c3);
            }
            else if(n==4){
                System.out.println("Americano added to the cart successfully");
                Coffee c4=new Coffee("Americano",2);
                menu.add(c4);
            }
            else if(n==5 || n==6){
                if(menu.getBill()==0){
                    System.out.println("Your cart is empty. Please order some coffee.");
                    continue;
                }
                menu.getMenu();
                if(n==5)
                    continue;
                else{
                    System.out.println("--------------------");
                    System.out.println("Total = "+menu.getBill());
                    System.out.println("Thanks for ordering.");
                    break;
                }
            }
            else{
                System.out.println("Thanks for visiting our coffee shop.");
                break;
            }
        }
    }
}