package com.complex;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CreateAll createAll = new CreateAll();
        List<Planet> planets = createAll.createPlanet(1);
        List<Ocean> oceans = createAll.createOcean(6);
        List<Island> islands = createAll.createIsland(6);
       // List<Continent> continents = createAll.createContinent((int) (Math.random()*10+1));
        List<Continent> continents = createAll.createContinent(3);

        for(Planet planet:planets){
            for (Continent continent: continents){
                planet.addContinent(continent);
            }
            System.out.println("Planet name: "+planet.getName());
            System.out.println("Continent name: "+getFirstContinentName(planet.getContinentList()));
            System.out.println("Count continents:" + planet.getContinentList().size());
        }
    }

    public static NameContinent getFirstContinentName(List<Continent> continentList) {
        NameContinent result = null;
        for (Continent continent: continentList) {
            result = continent.getName();
        }

        return result;
    }
}
