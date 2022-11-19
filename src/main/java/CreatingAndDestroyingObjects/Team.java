package CreatingAndDestroyingObjects;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import CreatingAndDestroyingObjects.NameGenerator;
import autovalue.shaded.com.google.common.annotations.VisibleForTesting;

public class Team {

    private String name;

    public  ArrayList<Player> getPlayers() {
        return players;
    }

    private static ArrayList<CreatingAndDestroyingObjects.Player> players;

    private final int DEFAULT_SIZE = 11;
    private  ArrayList<Integer> jerseys  = new ArrayList<>();

    private static Random random = new Random();

    private Utilities utility = new Utilities();

    static HashMap<String, Integer> positionsMap = new HashMap<>();

    public  String generateNameFromNamesList( ArrayList<String> names){

        NameGenerator nameGenerator = new NameGenerator(names);

        return nameGenerator.generateName();
    }

    public  int generateGrade(){
        return generateRandomNumber(101);
    }

    public  int generateJersey(){
        boolean flag = false;
        int num = generateRandomNumber(60);
        do{
            if(!jerseys.contains(num)) {
                jerseys.add(num);
                flag = true;

            }else {
                num = generateRandomNumber(60);
            }
        }while (flag == false);
        return num;
    }

    public String generatePosition(){

        List<String> positionList = new ArrayList<>(positionsMap.keySet());
        String selectedPosition = null;
        String randomPosition;
        int index;

        while (selectedPosition == null) {

            index = generateRandomNumber(4);
            randomPosition = positionList.get(index);
            int positionValue = positionsMap.get(randomPosition);

            if (randomPosition.equalsIgnoreCase("Goal Keeper") && positionValue == 1) {

                positionsMap.replace(randomPosition, 0);
                selectedPosition = randomPosition;
            }

            if (randomPosition.equalsIgnoreCase("Defender") && positionValue > 0 && positionValue <= 2) {

                positionsMap.replace(randomPosition, positionValue -1);
                selectedPosition = randomPosition;
            }

            if (randomPosition.equalsIgnoreCase("Midfielder") && positionValue > 0 && positionValue <= 2) {

                positionsMap.replace(randomPosition, positionValue -1);
                selectedPosition = randomPosition;
            }

            if (randomPosition.equalsIgnoreCase("Attacker") && positionValue > 0 && positionValue <= 2) {

                positionsMap.replace(randomPosition, positionValue -1);
                selectedPosition = randomPosition;
            }

            if (positionsMap.values().stream().allMatch(v -> v == 0) && !randomPosition.equalsIgnoreCase("Goal Keeper")) {

                selectedPosition = randomPosition;
            }
        }

        return selectedPosition;
    }

    public  String generatePositionWithFormation() {

        List<String> positionList = new ArrayList<>(positionsMap.keySet());
        String selectedPosition = null;
        String randomPosition;
        int index;

        while (selectedPosition == null) {

            index = generateRandomNumber(4);
            randomPosition = positionList.get(index);
            int positionValue = positionsMap.get(randomPosition);

            if (positionValue > 0) {

                positionsMap.replace(randomPosition, positionValue -1);
                selectedPosition = randomPosition;
            }
        }

        return selectedPosition;
    }

    private  void initPositionsMap(int gkNumber, int dNumber, int mNumber, int aNumber) {

        positionsMap.put("Goal Keeper", gkNumber);
        positionsMap.put("Defender", dNumber);
        positionsMap.put("Midfielder", mNumber);
        positionsMap.put("Attacker", aNumber);
    }

    public Team() {

        initPositionsMap(1, 2, 2, 2);
        players = new ArrayList<>();

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            // use names 1
            players.add(new CreatingAndDestroyingObjects.Player(generateNameFromNamesList(utility.getNames1()), generatePosition(), generateJersey(), generateGrade()));
        }
        for (CreatingAndDestroyingObjects.Player p : players) {

            System.out.print(p.getName() + "  ");
            System.out.print(p.getPosition() + "  ");
            System.out.print(p.getJersey() + "  ");
            System.out.print(p.getGrade() + "  ");
            System.out.println();
        }
        System.out.println();
    }

    public Team(int gkNumber, int dNumber, int mNumber, int aNumber) {

        initPositionsMap(gkNumber, dNumber, mNumber, aNumber);
        players = new ArrayList<>();

        for (int i = 0; i < DEFAULT_SIZE; i++) {

            String p = generatePositionWithFormation();
            switch (p) {
                case "Goal Keeper":                                                     // use names 2
                    players.add(CreatingAndDestroyingObjects.Player.newGoalKeeperPlayer(generateNameFromNamesList(utility.getNames2()), generateJersey(), generateGrade())); break;
                case "Defender":
                    players.add(CreatingAndDestroyingObjects.Player.newDefenderPlayer(generateNameFromNamesList(utility.getNames2()), generateJersey(), generateGrade())); break;
                case "Midfielder":
                    players.add(CreatingAndDestroyingObjects.Player.newMidfielderPlayer(generateNameFromNamesList(utility.getNames2()), generateJersey(), generateGrade())); break;
                case "Attacker":
                    players.add(CreatingAndDestroyingObjects.Player.newAttackerPlayer(generateNameFromNamesList(utility.getNames2()), generateJersey(), generateGrade())); break;
            }
        }
        for (CreatingAndDestroyingObjects.Player p : players) {

            System.out.print(p.getName() + "  ");
            System.out.print(p.getPosition() + "  ");
            System.out.print(p.getJersey() + "  ");
            System.out.print(p.getGrade() + "  ");
            System.out.println();
        }
    }

    public static Team createTeamWithSpecificFormation(int gkNumber, int dNumber, int mNumber, int aNumber) {

        return new Team(gkNumber, dNumber, mNumber, aNumber);
    }

    public static int generateRandomNumber(int num) {

        return random.nextInt(num);
    }

//    public void writeDataToFile()
//    {
//        try (FileOutputStream fos = new FileOutputStream("src/main/java/CreatingAndDestroyingObjects/teamData.txt");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//
//            for (CreatingAndDestroyingObjects.Player p: players) {
//                oos.writeObject(p);
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.print("File not found");
//
//        } catch (IOException ex) {
//            System.out.print(ex.getMessage());
//        }
//    }
    public void writeDataToFile1()
    {
        try {
            ArrayList<String> ss = new ArrayList<>();

            for (CreatingAndDestroyingObjects.Player p: players) {
                ss.add(p.print());
            }
            Path output = Paths.get("src/main/java/CreatingAndDestroyingObjects/teamData.txt");
            Files.write(output, ss);

        } catch (FileNotFoundException ex) {
            System.out.print("File not found");

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

}
