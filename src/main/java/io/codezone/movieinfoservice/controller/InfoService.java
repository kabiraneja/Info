package io.codezone.movieinfoservice.controller;

import io.codezone.movieinfoservice.models.InfoServiceList;
import io.codezone.movieinfoservice.models.InfoServiceModel;
import io.codezone.movieinfoservice.models.MCM_Wrapper;
import io.codezone.movieinfoservice.models.MovieCatalogModels;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoService {

    @GetMapping("/moviesList")
    public InfoServiceList getMoviesList() {
        List<InfoServiceModel> infoList = new ArrayList<>();
        InfoServiceList isl = new InfoServiceList();

        infoList.add(createMovie(1, "Transformers"));
        infoList.add(createMovie(2, "Intersteller"));
        infoList.add(createMovie(3, "Dark knight"));
//We wrap infoList into class InfoServiceList
        isl.setList(infoList);
        return isl;
    }
    public InfoServiceModel createMovie(int movieId,String name) {
        InfoServiceModel ism = new InfoServiceModel();
        ism.setMovieId(movieId);
        ism.setName(name);
        return ism;
    }
    @GetMapping("/{movieId}")
    public String getSingleMovieId(@PathVariable("movieId") int movieId) {
        InfoServiceModel ism1 = new InfoServiceModel(1, "Transformers");
        InfoServiceModel ism2 = new InfoServiceModel(2, "Intersteller");
        InfoServiceModel ism3 = new InfoServiceModel(3, "Dark knight");
        if(movieId==ism1.getMovieId())
            return ism1.getName();
        if(movieId==ism2.getMovieId())
            return ism2.getName();
        if(movieId==ism3.getMovieId())
            return ism3.getName();
        return null;
    }
    @GetMapping ("/singleObject/{movieId}")
    public InfoServiceModel getObject(@PathVariable("movieId") int movieId) {
        InfoServiceModel ism1 = new InfoServiceModel(1, "Transformers");
        InfoServiceModel ism2 = new InfoServiceModel(2, "Intersteller");
        InfoServiceModel ism3 = new InfoServiceModel(3, "Dark knight");
        if(movieId==ism1.getMovieId())
            return ism1;
        if(movieId==ism2.getMovieId())
            return ism2;
        if(movieId==ism3.getMovieId())
            return ism3;
        return null;
    }
    @GetMapping("/getsingleObject/{mName}")
    public MovieCatalogModels getObjectFromMCM_Wrapper(@PathVariable("mName") String mName) {
        RestTemplate r = new RestTemplate();

        MCM_Wrapper obj = r.getForObject("http://movie-catalog-service/catalog/moviecatalog",MCM_Wrapper.class);

        for(int i=0;obj!=null&&i<obj.getMcmList().size();i++)
            if(obj.getMcmList().get(i).getName().equals(mName))
                return obj.getMcmList().get(i);
        return null;
    }
    @GetMapping("getRatings")
    public int getratings() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://movie-rating-service/rate/singleRating/Transformers",int.class);
    }
}
