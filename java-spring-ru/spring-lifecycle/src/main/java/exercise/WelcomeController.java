package exercise;

import exercise.daytimes.Daytime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

// BEGIN
@RestController
public class WelcomeController {
    @Autowired
    Daytime daytime;

    @Autowired
    Meal meal;

    @GetMapping(path = "/daytime")
    public String getMeal() {
        return "It is " + daytime.getName() + " now. Enjoy your ."
                + meal.getMealForDaytime(daytime.getName());
    }
}
// END
