package CreatingAndDestroyingObjects;

import CreatingAndDestroyingObjects.Team;
import CreatingAndDestroyingObjects.Utilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test1 {


//    @Test
//    void testRandom(){
//        Team team = new Team();
//        System.out.println(team.generateGrade());
//    }

    private Team team;
    @BeforeEach
    void beforeEach(){
        team = new Team();
    }

    @Test
    void test_size_of_team(){
        int size = team.getPlayers().size();
        assertEquals(11,size);
    }

    @Test
    void test_generateNameFromNamesList(){
        Utilities utility = new Utilities();
        String s = team.generateNameFromNamesList(utility.getNames1());
        assertTrue(utility.getNames2().contains(s));
    }
    @Test
    void test_generateGrade(){
        assertTrue(team.generateGrade() < 100);
    }

    @Test
    void test_generateJersey(){
        assertTrue(team.generateGrade() < 60);
    }

    @Test
    void test_generatePosition(){
        //String s = team.getPlayers().get().getPosition();
       List<Player> players = team.getPlayers().stream().filter(i -> i.getPosition().equalsIgnoreCase("Goal Keeper"))
                .collect(Collectors.toList());
       assertEquals(1,players.size());

    }
}
