package exercise.controller;
import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}")
    public Map<String,String> getWeatherCity(@PathVariable long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found"));
        return weatherService.getWeather(city);
    }

    @GetMapping(path = "/search")
    public List<Map<String, String>> getWeatherCities(@RequestParam(required = false, defaultValue = "") String name) {
        List<City> cities = cityRepository.findByNameStartsWithIgnoreCase(name);
        return cities.stream()
                .map (x -> {
                        Map <String,String> fullWeather = weatherService.getWeather(x);
                        Map <String,String> weatherCity = new HashMap<>();
                        weatherCity.put("temperature",fullWeather.get("temperature"));
                        weatherCity.put("name",fullWeather.get("name"));
                        return weatherCity;
                })
                .sorted(Comparator.comparing(x -> x.get("name")))
                .toList();
    }
    // END
}

