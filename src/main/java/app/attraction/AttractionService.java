package app.attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alec on 2017-03-18.
 */
public class AttractionService {

    private List<Attraction> attractions;

    public AttractionService() {
        attractions = new ArrayList<>();

        //dummy values
        Attraction a1 = new Attraction();
        a1.setId(0);
        a1.setLongitude(5.5f);
        a1.setLatitude(1.43f);
        a1.setName("Romp in the woods");
        a1.setType(Attraction.Type.OTHER);

        Attraction a2 = new Attraction();
        a2.setId(1);
        a2.setLongitude(65.444f);
        a2.setLatitude(-32.223f);
        a2.setName("Lit party");
        a2.setType(Attraction.Type.PARTY);

        attractions.add(a1);
        attractions.add(a2);
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
}
