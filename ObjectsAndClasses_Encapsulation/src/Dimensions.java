public class Dimensions {

    private final int width;
    private final int height;
    private final int length;

    public Dimensions(int length, int width, int height) {
        this.width = width;
        this.height = height;
        this.length = length;
    }
    public static int calculateSize(int length, int width, int height) {
        return length * width * height;
    }

    @Override
    public String toString() {
        return " " + calculateSize(length, width, height);
    }
}
