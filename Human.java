package Level2_L1;

public class Human implements Participants {


    String name;
    int maxActionValue;
    int maxHeightJump;
    int maxLengthRun;
    private boolean attempt;

    public Human() {

    }

    public Human(String name, int maxHeightJump, int maxLengthRun) {
        this.name = name;
        this.maxHeightJump = maxHeightJump;
        this.maxLengthRun = maxLengthRun;
    }

    public void jump() {
        System.out.println("Человек прыгает");
    }

    public void run() {
        System.out.println("Человек бежит");
    }

    public void getOver(Obstacles o) {

        if (o instanceof Wall) {
            maxActionValue = maxHeightJump;
        } else {
            maxActionValue = maxLengthRun;
        }
        attempt = o.isObstacleGotOver(name, maxActionValue);
    }

    public boolean getAttempt() {
        return attempt;
    }
}
