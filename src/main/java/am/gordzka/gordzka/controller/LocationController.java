package am.gordzka.gordzka.controller;

import am.gordzka.gordzka.model.Location;
import am.gordzka.gordzka.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

}
