public class Goods {

    final Dimensions size;
    final int weight;
    final String address;
    final boolean isOverturn;
    final String id;
    final boolean isFragile;

    public Goods(Dimensions size, int weight, String address, boolean isOverturn, String id, boolean isFragile) {
        this.size = size;
        this.weight = weight;
        this.address = address;
        this.isOverturn = isOverturn;
        this.id = id;
        this.isFragile = isFragile;
    }


    public Goods setWeight(int weight) {
        return new Goods(size, weight, address, isOverturn, id, isFragile);
    }

    public int getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public Goods setAddress(String address) {
        return new Goods(size, weight, address, isOverturn, id, isFragile);
    }

    public boolean isOverturn() {
        return isOverturn;
    }

    public String getId() {
        return id;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public Dimensions getSize() {
        return size;
    }

    public Goods setSize(int length, int width, int height) {
        return new Goods(new Dimensions(length, width, height), weight, address, isOverturn, id, isFragile);
    }

    public void getInfo() {
        System.out.println("�����" + getSize());
        System.out.println("����� " + getWeight());
        System.out.println("����� " + getAddress());
        System.out.println("����� ��������������? " + (isOverturn() ? "��" : "���"));
        System.out.println("ID " + getId());
        System.out.println("�������? " + (isFragile() ? "��" : "���"));
        System.out.println(" ");
    }

}
