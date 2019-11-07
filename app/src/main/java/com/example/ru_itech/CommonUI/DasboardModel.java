package com.example.ru_itech.CommonUI;

public class DasboardModel {

    private String School;

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public DasboardModel() {
    }

    public String getLogo() {
        return logo;
    }

    public DasboardModel(String school, String logo) {
        School = school;
        this.logo = logo;
    }

    private String logo;

}
