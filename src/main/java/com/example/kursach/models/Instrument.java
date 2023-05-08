package com.example.kursach.models;

public class Instrument {
    private Integer ID;
    private String name;
    private double price;
    private int category;
    private String description;

    public Instrument(Integer ID, String name, double price, int category, String description) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description; //maybe redo
    }

    public Integer getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Instrument)) return false;
        final Instrument other = (Instrument) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$ID = this.getID();
        final Object other$ID = other.getID();
        if (this$ID == null ? other$ID != null : !this$ID.equals(other$ID)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (Double.compare(this.getPrice(), other.getPrice()) != 0) return false;
        if (this.getCategory() != other.getCategory()) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Instrument;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $ID = this.getID();
        result = result * PRIME + ($ID == null ? 43 : $ID.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final long $price = Double.doubleToLongBits(this.getPrice());
        result = result * PRIME + (int) ($price >>> 32 ^ $price);
        result = result * PRIME + this.getCategory();
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "Instrument(ID=" + this.getID() + ", name=" + this.getName() + ", price=" + this.getPrice() + ", category=" + this.getCategory() + ", description=" + this.getDescription() + ")";
    }
}
