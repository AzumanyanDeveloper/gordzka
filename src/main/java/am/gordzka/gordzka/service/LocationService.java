package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.Location;
import am.gordzka.gordzka.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;


    public List<Location> allLocations () {
        return locationRepository.findAll();
    }
}
