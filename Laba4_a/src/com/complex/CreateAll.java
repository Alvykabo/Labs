package com.complex;

import java.util.ArrayList;
import java.util.List;

public class CreateAll {
    public List<Planet> createPlanet(int numbers){
        List<Planet> planets = new ArrayList<Planet>();
        for (int i = 0; i<numbers; i++){
            planets.add(Creation.createPlanet());
        }
        return planets;
    }
    public List<Ocean> createOcean(int numbers){
        List<Ocean> oceans = new ArrayList<Ocean>();
        for (int i = 0; i<numbers; i++){
            oceans.add(Creation.createOcean());
        }
        return oceans;
    }
    public List<Continent> createContinent(int numbers){
        List<Continent> continents = new ArrayList<Continent>();
        for (int i = 0; i<numbers; i++){
            continents.add(Creation.createContinent());
        }
        return continents;
    }
    public List<Island> createIsland(int numbers){
        List<Island> islands = new ArrayList<Island>();
        for (int i = 0; i<numbers; i++){
            islands.add(Creation.createIsland());
        }
        return islands;
    }

}
