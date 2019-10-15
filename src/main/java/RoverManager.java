import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RoverManager {
    boolean [] [] plateau;
    List<Rover> rovers = new ArrayList();
    int NUM_ROVERS = 2;

    public void init(){
        String PATH = "src/main/files/rover.txt";
        BufferedReader bReader = null;

        try{
            bReader = new BufferedReader(new FileReader(PATH));
            String strCurrentLine;

            String [] coordinate = bReader.readLine().split(" ");
            int x = Integer.parseInt(coordinate[0]) + 1;
            int y = Integer.parseInt(coordinate[1]) + 1;

            plateau = new boolean[x][y];

            for(int i=0; i < NUM_ROVERS; i++){
                String [] roverCoord = bReader.readLine().split(" ");
                String roverMovement = bReader.readLine();

                int roverX = Integer.parseInt(roverCoord[0]);
                int roverY = Integer.parseInt(roverCoord[1]);
                char direction = roverCoord[2].charAt(0);

                Rover rover = new Rover(roverX, roverY, direction, roverMovement);
                rovers.add(rover);
            }

            initExploration();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initExploration(){
        for(int i=0 ; i < rovers.size(); i++){
            rovers.get(i).initRover(plateau);
        }
    }
}
