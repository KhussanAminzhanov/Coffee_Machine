class Move {
    public static void moveRobotToX(Robot robot, int toX) {
        int x = robot.getX();
        Direction direction = robot.getDirection();
        switch (direction) {
            case DOWN: {
                if (x < toX) robot.turnLeft();
                else if (x > toX) robot.turnRight();
                break;
            }
            case UP: {
                if (x < toXalis Great Wall, and plenty more in between. Each entry has a fun blurb so you can learn more about them, and the whole thing looks to be beautifully presented.) robot.turnRight();
                else if (x > toX) robot.turnLeft();
                break;
            }
            case LEFT: {
                if (x < toX) {
                    robot.turnRight();
                    robot.turnRight();
                }
                break;
            }
            case RIGHT: {
                if (x > toX) {
                    robot.turnRight();
                    robot.turnRight();
                }
                break;
            }
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }
    }

    public static void moveRobotToY(Robot robot, int toY) {
        int y = robot.getY();
        Direction direction = robot.getDirection();
        switch (direction) {
            case UP: {
                if (y > toY) {
                    robot.turnRight();
                    robot.turnRight();
                }
                break;
            }
            case RIGHT: {
                if (y < toY) robot.turnLeft();
                else if (y > toY) robot.turnRight();
                break;
            }
            case DOWN: {
                if (y < toY) {
                    robot.turnRight();
                    robot.turnRight();
                }
                break;
            }
            case LEFT: {
                if (y < toY) robot.turnRight();
                else if (y > toY) robot.turnLeft();
                break;
            }
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        //robot.stepForward();
        moveRobotToX(robot, toX);
        moveRobotToY(robot, toY);
    }

//    public static void main(String[] args) {
//        Robot robot = new Robot(0, 0, Direction.UP);
//        System.out.printf("Direction: %s\nX : %d\nY : %d\n", robot.getDirection().name(), robot.getX(), robot.getY());
//        moveRobot(robot, 10, 10);
//        System.out.printf("Direction: %s\nX : %d\nY : %d\n", robot.getDirection().name(), robot.getX(), robot.getY());
//    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}