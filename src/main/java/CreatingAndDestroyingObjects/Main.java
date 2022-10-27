package CreatingAndDestroyingObjects;

import static CreatingAndDestroyingObjects.Team.createTeamWithSpecificFormation;

public class Main {
    public static void main(String[] args) {

        Team t1 = new Team();

//Static Factory Methods
        Team t2 = createTeamWithSpecificFormation(1, 6, 2, 2);
        t2.writeDataToFile1();

    }
}