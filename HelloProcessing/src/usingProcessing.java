import processing.core.PApplet;

public class usingProcessing extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("usingProcessing");
	}

    public void settings(){
    	size(500,500);
    }
    float ballX = random((float) 25.0, (float) 475.0);
    float ballY = (float) -25.0;
    float ballVelocity = random((float) 1.0, (float) 5.0);
    float paddleX = 250;
    float paddleY = 475;
    float paddleVelocity = 3;
    int misses = 0;
    int catches = 0;
    int gameState = 0;
    int highScore;
    public void setup() {
      
    }
    public void draw() {
      println(ballX);
      println(ballY);
      background(255,255,255);
      fill(0,0,0);
      ellipse(ballX, ballY, 50, 50);
      rect(paddleX, paddleY, 30, 20);
      while (misses < 3) {
        textSize (20);
        text(catches, 25, 35);
        text(misses, 25, 50);
        while (ballY < 525){
          ballX += ballVelocity;
          if (((ballX >= paddleX - 25) && (ballX <= paddleX + 25)) && 
          ((ballY <= paddleY + 25) && (ballY >= paddleY - 25))) {
            catches += 1;
            if (catches > highScore) {
              highScore = catches;
            }
          }
          if (ballY > 525) {
            break;
          }
        }
        if (ballY > 525) {
          misses += 1;
          if (misses == 3) {
            while (misses == 3) {
              background(0,0,0);
              textSize(20);
              text("Press 'r' to restart!", 230,250);
            }
          }
          ballY = -25;
          ballX = random(25,475);
        }
      }
    }
    public void keyPressed() {
      if (key == 'r') {
        misses = 0;
      } else if (key == CODED) {
        if (keyCode == LEFT) {
          paddleX -= paddleVelocity;
        } else if (keyCode == RIGHT) {
          paddleY += paddleVelocity;
        }
      }
    }
}
