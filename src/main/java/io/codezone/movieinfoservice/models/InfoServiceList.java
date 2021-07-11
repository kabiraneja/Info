package io.codezone.movieinfoservice.models;

import java.util.List;

public class InfoServiceList {
    List<InfoServiceModel> ismlist;

    public List<InfoServiceModel> getList() {
        return ismlist;
    }

    public void setList(List<InfoServiceModel> list) {
        this.ismlist = list;
    }
}
