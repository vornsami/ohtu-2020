
package ohtu;

public class Player {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    private int penalties;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setGoals(int goals){
        this.goals = goals;
    }
    public void setAssists(int assists){
        this.assists = assists;
    }
    public void setPenalties(int penalties){
        this.penalties = penalties;
    }
    public String getName() {
        return name;
    }
    public String getTeam() {
        return team;
    }
    public String getNationality() {
        return nationality;
    }
    public int getGoals() {
        return goals;
    }
    public int getAssists() {
        return assists;
    }
    public int getPenalties() {
        return penalties;
    }
    public int getSum() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return name + "\t" + ((name.length() < 16)? "\t" : "") + nationality + "\t" + team + "\t" + goals + "\t" + assists + "\t" + (goals + assists) + "\t" + penalties;
    }
      
}
