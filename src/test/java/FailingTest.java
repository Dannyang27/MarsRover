import org.junit.Test;
import static org.junit.Assert.*;

public class FailingTest {
   @Test
   public void checkXPosition() {
       Rover rover = new Rover(1,1, 'N', "LML");
       assertEquals(rover.getX(), 1);
   }
}
