import processing.core.*;

public class App extends PApplet {
    // arrow keys are not pressed
    boolean moveLeft = false;
    boolean moveRight = false;
    double speed = 30;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    // Flag to track if a collision is detected
    int collisionDetected = 0;

    // the character starts in the middle of the screen
    float characterX = 350;
    // potholes start x, y
    float pothole1X;
    float pothole100X;
    float pothole1Y = -50;
    float pothole2X;
    float pothole200X;
    float pothole2Y = -225;
    float pothole3X;
    float pothole300X;
    float pothole3Y = -400;
    float pothole4X;
    float pothole400X;
    float pothole4Y = -575;
    float pothole5X;
    float pothole500X;
    float pothole5Y = -750;
    float pothole6X;
    float pothole600X;
    float pothole6Y = -975;
    // point counter variable
    double points = 0;

    public void setup() {
        // background is green
        background(26, 189, 8);
        // random x value for potholes, they should not be touching
        pothole1X = random(0, 360);
        pothole2X = random(0, 360);
        pothole3X = random(0, 360);
        pothole4X = random(0, 360);
        pothole100X = random(425, 700);
        pothole200X = random(425, 700);
        pothole300X = random(425, 700);
        pothole400X = random(425, 700);
    }

    public void settings() {
        // screen is 700x800 pixels
        size(700, 800);
    }

    public void draw() {
        if (collisionDetected == 0) {
            startScreen();
        } else if (collisionDetected == 1) {
            // refresh background
            background(26, 189, 8);
            // potholes
            stroke(1);
            fill(1, 66, 14);
            treeMove();
            // make the character
            fill(201, 172, 85);
            strokeWeight(1);
            ellipse(characterX, 500, 50, 50);
            // move the character
            if (moveLeft == true) {
                characterX -= speed / 10 - 0.5;
            }
            if (moveRight == true) {
                characterX += speed / 10 - 0.5;
            }
            checkingCollision();
            fill(255);
            textSize(30);
            text("Score: " + points, 25, 20);
            text("Speed: " + speed / 10, 25, 50);
            changeSpeed();

        } else {
            endScreen();
            playAgain();
        }
    }

    public void playAgain() {
        if (mousePressed && mouseX >= 250 && mouseX <= 450 &&
                mouseY >= 250 && mouseY <= 350) {
            collisionDetected = 1;
            reset();

        }
    }

    public void startScreen() {
        background(5);
        strokeWeight(5);
        stroke(3, 252, 32);
        fill(5);
        rect(250, 250, 200, 100);
        fill(3, 252, 32);
        textSize(30);
        text("Start", 320, 310);
        playAgain();
        text("you are running through the forest", 50, 50);
        text("to your house. Dont run into the trees.", 50, 80);
        text(" Use left and right arrows to move.", 50, 110);
    }

    // Function to detect collision between two circles
    public boolean detectCollision(float x1, float y1, float r1, float x2, float y2, float r2) {
        float distance = dist(x1, y1, x2, y2); // Calculate the distance between the centers
        return distance <= r1 + r2; // Collision if distance is less than or equal to sum of radii
    }

    public void endScreen() {
        background(5);
        winOrLose();
        fill(255);
        textSize(30);
        text("Score: " + points, 25, 20);
        text("Your speed was " + speed / 10, 25, 50);

        strokeWeight(5);
        stroke(3, 252, 32);
        fill(5);
        rect(250, 250, 200, 100);
        fill(3, 252, 32);
        text("Play again", 290, 310);
    }

    public void winOrLose() {
        // if()
        fill(255, 0, 0); // Red
        textSize(50);
        text("You lose!", 260, 200);
    }

    public void checkingCollision() {
        if (detectCollision(pothole1X, pothole1Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole2X, pothole2Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole3X, pothole3Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole4X, pothole4Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole100X, pothole1Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole200X, pothole2Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole300X, pothole3Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole400X, pothole4Y, 25, characterX, 500, 15)) {
            collisionDetected = 2; // Set the flag to true when collision occurs
        }
    }

    public void treeMove() {
        treesMove1(pothole1X, pothole1Y);
        treesMove1(pothole2X, pothole2Y);
        treesMove1(pothole3X, pothole3Y);
        treesMove1(pothole4X, pothole4Y);
        treesMove2(pothole100X, pothole1Y);
        treesMove2(pothole200X, pothole2Y);
        treesMove2(pothole300X, pothole3Y);
        treesMove2(pothole400X, pothole4Y);
    }

    public void treesMove2(float x, float y) {
        ellipse(x, y, 70, 70);
        if (y < 850) {
            y += speed / 10;
            if (y >= 850) {
                y = -50;
                x = random(425, 700);
            }
        }
    }

    public void treesMove1(float x, float y) {
        ellipse(x, y, 70, 70);
        if (y < 850) {
            y += speed / 10;
            if (y >= 850) {
                y = -50;
                x = random(0, 300);
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

    public void reset() {
        // the character starts in the middle of the screen
        characterX = 350;
        // potholes start y
        pothole1Y = -50;
        pothole2Y = -225;
        pothole3Y = -400;
        pothole4Y = -575;
        pothole5Y = -750;
        pothole6Y = -975;
        // point counter variable
        points = 0;
        speed = 30;
    }

    public void changeSpeed() {
        if (frameCount % 300 == 0) {
            speed++;
            points++;
        }
    }
}
