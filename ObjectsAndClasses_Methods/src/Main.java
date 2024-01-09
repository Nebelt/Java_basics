public class Main {


    public static void main(String[] args) {


        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Boil", 250, 3, 600);
        basket.print("");
        System.out.println(
                "\n" + "Total items: " + Basket.totalItems +
                "\n" + "Amount: " + Basket.amount +
                "\n" + "Average Price: " + Basket.averagePrice(Basket.amount, Basket.totalItems) +
                "\n" + "Average cost of basket: " + Basket.amount / Basket.getCount()
        );




    }
}
