import java.util.ArrayList;
import java.util.Date;

public class LocationTest {
    private Location location;
    public LocationTest() {
        location = new Location(new ArrayList<Film>(), new Client("nom", "prenom"), new Date(), new Date());
    }
}
