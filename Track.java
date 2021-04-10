package Level2_L1;

public class Track implements Obstacles {

    int trackLength;

    public Track(int trackLength) {
        this.trackLength = trackLength;
    }

    public boolean isObstacleGotOver(String name, int maxLengthRun) {

        if (maxLengthRun >= trackLength) {
            System.out.println(name + " пробежал по беговой дорожке");
            return true;
        } else if (maxLengthRun <= 0) {
            System.out.println(name + " не умеет бегать");
            return false;
        } else {
            System.out.println(name + " не может пробежать больше, чем " + maxLengthRun + " м.");
            return false;
        }

    }
}
