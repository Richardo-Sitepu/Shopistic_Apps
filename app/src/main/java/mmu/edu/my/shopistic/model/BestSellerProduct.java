package mmu.edu.my.shopistic.model;

public class BestSellerProduct {
    Integer id;
    Integer imageurl;

    public BestSellerProduct(Integer id, Integer imageurl) {
        this.id = id;
        this.imageurl = imageurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }
}
