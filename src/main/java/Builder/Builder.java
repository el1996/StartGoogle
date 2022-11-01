package Builder;

import java.time.LocalDate;

public class Builder {
    public static void main(String []args){

        JobPosition jobPosition = new JobPosition.Builder(LocalDate.now().minusDays(12), "Software Engineer", true).location("Jerusalem").build();
        System.out.println(jobPosition.getPublishedDate()+" "+jobPosition.getTitle() +" "+jobPosition.isRemote()+" "+jobPosition.getDescription()+" "+jobPosition.getLocation()+" "+jobPosition.getSalaryCap()+" "+jobPosition.getYearsOfExperienceRequired());
    }
}
