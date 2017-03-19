package app.attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alec on 2017-03-18.
 */
public class AttractionService {

    private List<Attraction> attractions;
    private volatile int nextId;

    public AttractionService() {
        attractions = new ArrayList<>();
        nextId = 0;

        //dummy values
        createAttraction("Romp in the woods", 5.5f, 1.43f);
        createAttraction("Lit party", 65.444f, -32.223f, Attraction.Type.SOCIAL);
        createAttraction("420", 5.5f, 24.33f, Attraction.Type.HEALTH, "Good shit");
    }

    public Iterable<Attraction> getAttractions() { return attractions; }

    public Attraction getAttraction(long id) {
        for (Attraction a : attractions) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Attraction createAttraction(String name, float latitude, float longitude) {
        Attraction a = new Attraction();
        a.setId(nextId++);
        a.setLongitude(longitude);
        a.setLatitude(latitude);
        a.setName(name);
        a.setType(Attraction.Type.OTHER);
        a.setDescription("");

        attractions.add(a);
        return a;
    }

    public Attraction createAttraction(String name, float latitude, float longitude, Attraction.Type type) {
        Attraction a = new Attraction();
        a.setId(nextId++);
        a.setLongitude(longitude);
        a.setLatitude(latitude);
        a.setName(name);
        a.setType(type);
        a.setDescription("");
        attractions.add(a);
        return a;
    }

    public Attraction createAttraction(String name, float latitutde, float longitude, Attraction.Type type, String description) {
        Attraction a = new Attraction();
        a.setId(nextId++);
        a.setLatitude(latitutde);
        a.setLongitude(longitude);
        a.setName(name);
        a.setType(type);
        a.setDescription(description);

        attractions.add(a);
        return a;
    }

}
