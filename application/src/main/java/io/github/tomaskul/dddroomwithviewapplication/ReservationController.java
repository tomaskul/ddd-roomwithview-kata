package io.github.tomaskul.dddroomwithviewapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
public class ReservationController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public String viewAvailable(Model m){
        // TODO: add filter logic here.
        return "available";
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public String makeReserve(Model m){
        // TODO: wire up services & repos here.
        return "reservationMade";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String cancelReservation(Model m){
        // TODO: wire up services & repos here.
        return "cancellationMade";
    }
}
