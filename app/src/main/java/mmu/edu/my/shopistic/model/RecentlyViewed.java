package mmu.edu.my.shopistic.model;

public class RecentlyViewed {
    String name;
    String description;
    String price;
    String size;
    String colour;
    int imageUrl;
    int bigimageurl;

    public RecentlyViewed(String name, String description, String price, String size, String colour, int
            imageUrl, int bigimageurl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.colour = colour;
        this.imageUrl = imageUrl;
        this.bigimageurl = bigimageurl;

    }

    public int getBigimageurl() {
        return bigimageurl;
    }

    public void setBigimageurl(int bigimageurl) {
        this.bigimageurl = bigimageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}