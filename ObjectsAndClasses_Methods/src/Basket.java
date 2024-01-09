public class Basket {

    private static int count = 0;
    private String items = "";
    private static int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private int totalCount = 0;
    public static int amount = 0;
    public static int totalItems = 0;

    public Basket() {
        items = "List of goods:";
        this.limit = 1000000;
        totalWeight = 0;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;

    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.totalWeight = totalWeight;
    }

    public static int getCount() {
        return Basket.count;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }



    public static void increaseCount() {
        Basket.count++;
    }

    public static void increaseAmount(int totalPrice){
        Basket.amount = Basket.amount + totalPrice;
    }

    public static void increaseTotalItems(int count) {
        Basket.totalItems = Basket.totalItems + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
        increaseCount();
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " pcs - " + price;
        totalPrice = totalPrice + count * price;
    }

    public void add(String name, int price, int count, double weight) {
        increaseCount();
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " pcs - " + price + " Weight: " + weight;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        increaseAmount(totalPrice);
        increaseTotalItems(count);


    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }


    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Basket is empty");
        } else {
            System.out.println(items);
            System.out.println("Total weight: " + totalWeight);
        }
    }

    public static double averagePrice(int amount, int totalItems) {
        return totalItems == 0 ? -1 : amount / totalItems;
    }

    public static double averagePriceOfBasket(){
        return 0;
    }

}
