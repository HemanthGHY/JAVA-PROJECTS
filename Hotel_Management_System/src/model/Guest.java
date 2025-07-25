package model;

public class Guest {
    private String name;
    private String contact;
    private String id;

    public Guest(String name, String contact, String id) {
        this.name = name;
        this.contact = contact;
        this.id = id;
    }

    public String getName() { return name; }
    public String getContact() { return contact; }
    public String getId() { return id; }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Contact: " + contact + ")";
    }
}