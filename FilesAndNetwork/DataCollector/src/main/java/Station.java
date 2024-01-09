public class Station {

    String number;
    String name;
    String date;
    double depth;
    boolean hasConnection;

    public Station(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Station(String name, double depth) {
        this.name = name;
        this.depth = depth;
    }

    public Station(String number, String name, String date, double depth, boolean hasConnection) {
        this.number = number;
        this.name = name;
        this.date = date;
        this.depth = depth;
        this.hasConnection = hasConnection;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    @Override
    public String toString() {
        return "Station{" + "number='" + number + '\'' + ", name='" + name + '\'' + ", depth=" + depth + ", date='" + date + '\'' + ", hasConnection=" + hasConnection + '}';
    }
}
