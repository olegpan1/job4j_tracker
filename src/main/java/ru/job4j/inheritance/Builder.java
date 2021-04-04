package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String typeOfBuild;

    public boolean buildingBuild(Project project) {
        return false;
    }
}
