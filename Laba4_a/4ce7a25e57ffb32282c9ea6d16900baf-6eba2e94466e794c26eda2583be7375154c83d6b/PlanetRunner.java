public class PlanetRunner {
    public static void main(String[] args) {
        Island island = new Island("Barbados");

        Planet planet = new Planet("Earth");

        planet.addContinent(new Continent("Eurasia"));
        planet.addContinent(new Continent("Africa"));

        planet.addOcean(new Ocean("Atlantic"));
        planet.addOcean(new Ocean("Pacific"));

        planet.addIsland(new Island("Barbados"));

        System.out.println("Planet name: "+planet.getName());
        System.out.println("Continent name: "+getFirstContinentName(planet.getContinentList()));
        System.out.println("Count continents:" + planet.getContinentList().size());
    }

    public static String getFirstContinentName(List<Continent> continentList) {
        String result = null;
        for (Continent continent: continentList) {
            result = continent.getName();
        }

        return result;
    }
}