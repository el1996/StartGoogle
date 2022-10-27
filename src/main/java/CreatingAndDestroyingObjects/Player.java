package CreatingAndDestroyingObjects;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String position;
    private int jersey;
    private int grade;

    public Player() {}
    public Player(String name, String position, int jersey, int grade) {
        this.name = name;
        this.position = position;
        this.jersey = jersey;
        this.grade = grade;
    }

    public  Player newPlayer(String name, String position, int jersey, int grade){
        return new Player(name, position, jersey, grade);
    }
    public  Player createNewPlayerWithNoGrade(String name, String position, int age, int jersey){
        return new Player(name, position, jersey, 0);
    }

    public static Player newGoalKeeperPlayer(String name, int jersey, int grade) {
        return new Player(name, "Goal Keeper", jersey, grade);
    }

    public static Player newDefenderPlayer(String name, int jersey, int grade) {
        return new Player(name, "Defender", jersey, grade);
    }

    public static Player newMidfielderPlayer(String name, int jersey, int grade) {
        return new Player(name, "Midfielder", jersey, grade);
    }

    public static Player newAttackerPlayer(String name, int jersey, int grade) {
        return new Player(name, "Attacker", jersey, grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
        this.jersey = jersey;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String print() {

        return "Name: " + name + ", " +
                " Position: " + position + ", " +
                " Jersey: " + jersey+ ", " +
                " Grade: " + grade + "\n";
    }
}
