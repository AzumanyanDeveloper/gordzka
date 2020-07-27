package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.Location;
import am.gordzka.gordzka.repozitory.LocationRepozitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepozitory locationRepozitory;


    public List<Location> allLocations () {
        return locationRepozitory.findAll();
    }
}
