import processing.core.*;

public class App extends PApplet {
    // arrow keys are not pressed
    boolean moveLeft = false;
    boolean moveRight = false;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    // the character starts in the middle of the screen
    float characterX = 350;
    //potholes start x, y
    float pothole1X;
    float pothole100X;
    float pothole1Y = -50;
    float pothole2X;
    float pothole200X;
    float pothole2Y = -200;
    float pothole3X;
    float pothole300X;
    float pothole3Y = -350;
    float pothole4X;
    float pothole400X;
    float pothole4Y = -500;

    public void setup() {
        // background is green
        background(26, 189, 8);
        // random x value for potholes
        pothole1X = random(0, 350);
        pothole2X = random(0, 350);
        pothole3X = random(0, 350);
        pothole4X = random(0, 350);
        pothole100X = random(350, 700);
        pothole200X = random(350, 700);
        pothole300X = random(350, 700);
        pothole400X = random(350, 700);
    }

    public void settings() {
        // screen is 700x800 pixels
        size(700, 800);
    }

    public void draw() {
        // refresh background
        background(26, 189, 8);
        // make the character
        fill(201, 172, 85);
        strokeWeight(1);
        ellipse(characterX, 500, 50, 50);
        // move the character
        if (moveLeft == true) {
            characterX -= 3;
        }
        if (moveRight == true) {
            characterX += 3;
        }
        // potholes
        fill(50);
        //pothole 1
        ellipse(pothole1X, pothole1Y, 70, 70);
        if (pothole1Y < 850) {
            pothole1Y += 4;
        if (pothole1Y >= 850) {
           pothole1Y = -50;
           pothole1X= random(0, 700);
            }
        }
        //pothole 2
        ellipse(pothole2X, pothole2Y, 70, 70);
        if (pothole2Y < 850) {
            pothole2Y += 4;
        if (pothole2Y >= 850) {
           pothole2Y = -50;
           pothole2X= random(0, 700);
            }
        }
        //pothole 3
        ellipse(pothole3X, pothole3Y, 70, 70);
        if (pothole3Y < 850) {
            pothole3Y += 4;
        if (pothole3Y >= 850) {
           pothole3Y = -50;
           pothole3X= random(0, 700);
            }
        }
        //pothole 4
        ellipse(pothole4X, pothole4Y, 70, 70);
        if (pothole4Y < 850) {
            pothole4Y += 4;
        if (pothole4Y >= 850) {
           pothole4Y = -50;
           pothole4X= random(0, 700);
            }
        }
        //pothole 1.2
        ellipse(pothole100X, pothole1Y, 70, 70);
        if (pothole1Y < 850) {
            pothole1Y += 4;
        if (pothole1Y >= 850) {
           pothole1Y = -50;
           pothole100X= random(0, 700);
            }
        }
        //pothole 2
        ellipse(pothole200X, pothole2Y, 70, 70);
        if (pothole2Y < 850) {
            pothole2Y += 4;
        if (pothole2Y >= 850) {
           pothole2Y = -50;
           pothole200X= random(0, 700);
            }
        }
        //pothole 3
        ellipse(pothole300X, pothole3Y, 70, 70);
        if (pothole3Y < 850) {
            pothole3Y += 4;
        if (pothole3Y >= 850) {
           pothole3Y = -50;
           pothole300X= random(0, 700);
            }
        }
        //pothole 4
        ellipse(pothole400X, pothole4Y, 70, 70);
        if (pothole4Y < 850) {
            pothole4Y += 4;
        if (pothole4Y >= 850) {
           pothole4Y = -50;
           pothole400X= random(0, 700);
            }
        }

    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            moveLeft = true;
        }
        if (keyCode == RIGHT) {
            moveRight = true;
        }

    }

    public void keyReleased() {
        moveLeft = false;
        moveRight = false;
    }
}
