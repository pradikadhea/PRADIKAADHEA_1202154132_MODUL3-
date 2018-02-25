package com.example.user.pradika_1202154132_modul3;

/**
 * Created by User- on 2/25/2018.
 */

public class Air {
    String title, description, detail;
    int image;

    //method untuk memanggil
    public Air (String title, String description, String detail, int image){
        this.title= title;
        this.description=description;
        this.detail= detail;
        this.image= image;
    }

    public String getTitle() {
        return title;
    }
    public String getDescpription() {
        return description;
    }
    public String getDetail() {
        return detail;
    }
    public int getImage() {
        return image;
    }
}
