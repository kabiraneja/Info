package io.codezone.movieinfoservice.models;

import java.util.List;

public class MCM_Wrapper {
    List<MovieCatalogModels>mcmList;

    public MCM_Wrapper() {
    }

    public MCM_Wrapper(List<MovieCatalogModels> mcmList) {
        this.mcmList = mcmList;
    }

    public List<MovieCatalogModels> getMcmList() {
        return mcmList;
    }

    public void setMcmList(List<MovieCatalogModels> mcmList) {
        this.mcmList = mcmList;
    }
}
