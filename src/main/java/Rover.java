public class Rover {
    int x;
    int y;
    char direction;
    String movement;
    boolean [][] plateau;

    public Rover(int x, int y, char direction, String movement){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.movement = movement;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public void initRover(boolean [][] plateau){
        this.plateau = plateau;
        for(char command: this.movement.toCharArray()){
            switch (command){
                case 'L': {
                    rotateLeft();
                    break;
                }
                case 'R': {
                    rotateRight();
                    break;
                }
                case 'M': {
                    moveForward();
                    break;
                }

                default: break;
            }
        }

        System.out.println(String.format("%d %d %s", this.x, this.y, this.direction));
    }


    public void rotateLeft(){
        switch (this.direction){
            case 'N': {
                this.direction = 'W';
                break;
            }

            case 'W': {
                this.direction = 'S';
                break;
            }

            case 'S': {
                this.direction = 'E';
                break;
            }

            case 'E': {
                this.direction = 'N';
                break;
            }

            default: break;
        }
    }

    public void rotateRight(){
        switch (this.direction){
            case 'N': {
                this.direction = 'E';
                break;
            }

            case 'E': {
                this.direction = 'S';
                break;
            }

            case 'S': {
                this.direction = 'W';
                break;
            }

            case 'W': {
                this.direction = 'N';
                break;
            }

            default: break;
        }
    }

    public void moveForward(){
        switch (this.direction){
            case 'N': {
                if(isInsideLimit(this.x, this.y + 1)){
                    this.y++;
                }else{
                    System.out.println("Cannot go, not moving");
                }

                break;
            }

            case 'E': {
                if(isInsideLimit(this.x + 1, this.y)){
                    this.x++;
                }else{
                    System.out.println("Cannot go, not moving");
                }

                break;
            }

            case 'S': {
                if(isInsideLimit(this.x, this.y - 1)){
                    this.y--;
                }else{
                    System.out.println("Cannot go, not moving");
                }

                break;
            }

            case 'W': {
                if(isInsideLimit(this.x - 1, this.y)){
                    this.x--;
                }else{
                    System.out.println("Cannot go, not moving");
                }
                break;
            }
            default: break;

        }
    }

    public boolean isInsideLimit(int x, int y){
        return (0 <= x && x < plateau.length) && (0 <= y && y < plateau[0].length);
    }
}
