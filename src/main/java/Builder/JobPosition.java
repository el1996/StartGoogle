package Builder;

import java.time.LocalDate;

public class JobPosition {
    private LocalDate publishedDate;
    private String title;
    private boolean isRemote;
    private String description;
    private String location;
    private double salaryCap;
    private int yearsOfExperienceRequired;

    public static class Builder {
        //Required Parameters
        private LocalDate publishedDate;
        private String title;
        private boolean isRemote;

        //Optional Parameters

        private String description = "Strong knowledge of Python / C++ / Java";
        private String location = "Tel Aviv";
        private double salaryCap = 30000;
        private int yearsOfExperienceRequired = 1;

        public Builder(LocalDate publishedDate, String title, boolean isRemote) {
            this.publishedDate = publishedDate;
            this.title = title;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder salaryCap(double salaryCap) {
            this.salaryCap = salaryCap;
            return this;
        }

        public LocalDate getPublishedDate() {
            return publishedDate;
        }

        public String getTitle() {
            return title;
        }

        public boolean isRemote() {
            return isRemote;
        }

        public String getDescription() {
            return description;
        }

        public String getLocation() {
            return location;
        }

        public double getSalaryCap() {
            return salaryCap;
        }

        public int getYearsOfExperienceRequired() {
            return yearsOfExperienceRequired;
        }

        public Builder yearsOfExperienceRequired(int yearsOfExperienceRequired) {
            this.yearsOfExperienceRequired = yearsOfExperienceRequired;
            return this;
        }

        public JobPosition build() {
            return new JobPosition( this);
        }
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getSalaryCap() {
        return salaryCap;
    }

    public int getYearsOfExperienceRequired() {
        return yearsOfExperienceRequired;
    }

    private JobPosition(Builder builder) {
        this.publishedDate = builder.publishedDate;
        this.title = builder.title;
        this.isRemote = builder.isRemote;
        this.description = builder.description;
        this.location = builder.location;
        this.salaryCap = builder.salaryCap;
        this.yearsOfExperienceRequired = builder.yearsOfExperienceRequired;
    }
}