public class Item {

    public enum Type {
        ELECTRONIC,
        FASHION,
        GROCERY,
        TOOLS,
        OTHER
    }

    private String name;
    private String desc = "";
    private Type type;
    private float price;
    private int quantity;

    Item(String name, int quantity, Type type, float price) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setDesc(String desc) {
        this.desc = desc;
    }

    String getDesc() {
        return this.desc;
    }

    void setType(Type type) {
        this.type = type;
    }

    Type getType() {
        return this.type;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int getQuantity() {
        return this.quantity;
    }

    void setPrice(float price) {
        this.price = price;
    }

    float getPrice() {
        return this.price;
    }

    float getTotal() {
        return this.quantity * this.price;
    }
}
