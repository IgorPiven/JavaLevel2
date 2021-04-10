package Level2_L1;

public class Wall implements Obstacles {

    int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public boolean isObstacleGotOver(String name, int maxHeightJump) {
        if (maxHeightJump >= wallHeight) {
            System.out.println(name + " перепрыгнул через стену");
            return true;
        } else if (maxHeightJump == 0) {
            System.out.println(name + " не умеет прыгать");
            return false;
        } else {
            System.out.println(name + " не может прыгнуть выше, чем " + maxHeightJump + " м.");
            return false;
        }

    }
}
