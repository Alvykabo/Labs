package Continent;

import java.util.Random;

public class Creation {
    public static Planet createPlanet(){
        Random random = new Random();
                return new Planet(
                        NamePlanet.values()[(new Random().nextInt(NamePlanet.values().length))]
                );
    }
    public static Ocean createOcean(){
        Random random = new Random();
        return new Ocean(
                NameOcean.values()[(new Random().nextInt(NameOcean.values().length))]
        );
    }
    public static Island createIsland(){
        Random random = new Random();
        return new Island(
                NameIsland.values()[(new Random().nextInt(NameIsland.values().length))]
        );
    }
    public static Continent createContinent(){
        Random random = new Random();
        return new Continent(
                NameContinent.values()[(new Random().nextInt(NameContinent.values().length))]
        );
    }
}
