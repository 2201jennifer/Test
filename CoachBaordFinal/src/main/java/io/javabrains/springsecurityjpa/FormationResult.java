
package io.javabrains.springsecurityjpa;

public class FormationResult {

    private String formation;
    private String goalkeeper;
    private String defenders;
    private String midfielders;
    private String forwards;

    // Constructors, getters, and setters

    public FormationResult() {
        // Default constructor
    }

    public FormationResult(String formation, String goalkeeper, String defenders, String midfielders, String forwards) {
        this.formation = formation;
        this.goalkeeper = goalkeeper;
        this.defenders = defenders;
        this.midfielders = midfielders;
        this.forwards = forwards;
    }
    // Getters and setters

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getGoalkeeper() {
        return goalkeeper;
    }

    public void setGoalkeeper(String goalkeeper) {
        this.goalkeeper = goalkeeper;
    }

    public String getDefenders() {
        return defenders;
    }

    public void setDefenders(String defenders) {
        this.defenders = defenders;
    }

    public String getMidfielders() {
        return midfielders;
    }

    public void setMidfielders(String midfielders) {
        this.midfielders = midfielders;
    }

    public String getForwards() {
        return forwards;
    }

    public void setForwards(String forwards) {
        this.forwards = forwards;
    }
}

