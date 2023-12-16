
package io.javabrains.springsecurityjpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormationsController {

    //  handles the initial GET request to the URL ("/formations")
    @GetMapping("/formations")
    public String showForm() {
        // We can perform any additional logic here if needed
        return "formations"; // This should match the name of the HTML template
    }

    //  handles the form submission POST request to "/arrange-players"
    @PostMapping("/arrange-players")
    public String arrangePlayers(Model model,
                                 String goalkeeper,
                                 String defenders,
                                 String midfielders,
                                 String forwards,
                                 String formation) {

        // Validate and process the input

        // check if the selected formation is valid
        if (Arrays.asList(FormationConstants.FORMATION_4_3_3, FormationConstants.FORMATION_4_2_3_1, FormationConstants.FORMATION_4_4_2).contains(formation)) {

            // Validate the number of defenders, midfielders, and forwards based on the selected formation
            if (!isValidFormation(formation, defenders, midfielders, forwards)) {
                model.addAttribute("error", "Invalid number of players for the selected formation");
                return "formations";
            }

            // Process the input and arrange players
            Map<String, Object> result = new HashMap<>();
            result.put("formation", formation);
            result.put("goalkeeper", goalkeeper);
            result.put("defenders", Arrays.asList(defenders.split(",")));
            result.put("midfielders", Arrays.asList(midfielders.split(",")));
            result.put("forwards", Arrays.asList(forwards.split(",")));

            model.addAttribute("result", result);

           // return "redirect:/arrange-players";
        } else {
            // Handle invalid formation
            model.addAttribute("error", "Invalid formation selected");
        }

        return "formations";
    }

    private boolean isValidFormation(String formation, String defenders, String midfielders, String forwards) {
        int numDefenders = defenders.split(",").length;
        int numMidfielders = midfielders.split(",").length;
        int numForwards = forwards.split(",").length;

        switch (formation) {
            case FormationConstants.FORMATION_4_3_3:
                return numDefenders == 4 && numMidfielders == 5 && numForwards == 1;

            case FormationConstants.FORMATION_4_2_3_1:
                return numDefenders == 4 && numMidfielders == 5 && numForwards == 1;

            case FormationConstants.FORMATION_4_4_2:
                return numDefenders == 4 && numMidfielders == 4 && numForwards == 2;

            default:
                return false;
        }
    }
}