import processing.core.*;

public class App extends PApplet {
    // arrow keys are not pressed
    boolean moveLeft = false;
    boolean moveRight = false;
    int speed = 3;
    public static void main(String[] args) {
        PApplet.main("App");
    }

    // Flag to track if a collision is detected
    boolean collisionDetected = false;

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
    int points = 0;

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
        if (!collisionDetected) {
            // refresh background
            background(26, 189, 8);
            // potholes
            stroke(1);
            fill(50);
            // pothole 1
            ellipse(pothole1X, pothole1Y, 70, 70);
            potHoleMove();
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
            checkingCollision();

        } else {
            endScreen();
            playAgain();
        }
    }

    public void playAgain() {
        if (mousePressed) {
            if (mouseX >= 250 && mouseX <= 450 &&
                    mouseY >= 250 && mouseY <= 350) {
                collisionDetected = false;
                reset();
            }
        }
    }

    // Function to detect collision between two circles
    public boolean detectCollision(float x1, float y1, float r1, float x2, float y2, float r2) {
        float distance = dist(x1, y1, x2, y2); // Calculate the distance between the centers
        return distance <= r1 + r2; // Collision if distance is less than or equal to sum of radii
    }

    public void endScreen() {
        background(5);
        fill(255, 0, 0); // Red
        textSize(50);
        textAlign(CENTER, CENTER);
        text("You lose!", width / 2, height / 5);
        fill(255);
        textSize(30);
        text("Score: " + points, width / 7, height / 10);
        text("Your speed was " + speed, width / 5, height / 7);
        
        strokeWeight(5);
        stroke(3, 252, 32);
        fill(5);
        rect(250, 250, 200, 100);
        fill(3, 252, 32);
        text("Play again", 350, 290);
    }

    public void checkingCollision() {
        if (detectCollision(pothole1X, pothole1Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole2X, pothole2Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole3X, pothole3Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole4X, pothole4Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole100X, pothole1Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole200X, pothole2Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole300X, pothole3Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
        if (detectCollision(pothole400X, pothole4Y, 25, characterX, 500, 15)) {
            collisionDetected = true; // Set the flag to true when collision occurs
        }
    }

    public void potHoleMove() {
        if (pothole1Y < 850) {
            pothole1Y += speed;
            if (pothole1Y >= 850) {
                pothole1Y = -50;
                pothole1X = random(0, 360);
                points++;
                speed += 0.5;
            }
        }
        // pothole 2
        ellipse(pothole2X, pothole2Y, 70, 70);
        if (pothole2Y < 850) {
            pothole2Y += speed;
            if (pothole2Y >= 850) {
                pothole2Y = -50;
                pothole2X = random(0, 360);
                points++;
                speed += 0.5;
            }
        }
        // pothole 3
        ellipse(pothole3X, pothole3Y, 70, 70);
        if (pothole3Y < 850) {
            pothole3Y += speed;
            if (pothole3Y >= 850) {
                pothole3Y = -50;
                pothole3X = random(0, 360);
                points++;
                speed += 0.5;
            }
        }
        // pothole 4
        ellipse(pothole4X, pothole4Y, 70, 70);
        if (pothole4Y < 850) {
            pothole4Y += speed;
            if (pothole4Y >= 850) {
                pothole4Y = -50;
                pothole4X = random(0, 360);
                points++;
                speed += 0.5;
            }
        }
        // pothole 1.2
        ellipse(pothole100X, pothole1Y, 70, 70);
        if (pothole1Y < 850) {
            pothole1Y += speed;
            if (pothole1Y >= 850) {
                pothole1Y = -50;
                pothole100X = random(425, 700);
                points++;
                speed += 0.5;
            }
        }

        // pothole 2.2
        ellipse(pothole200X, pothole2Y, 70, 70);
        if (pothole2Y < 850) {
            pothole2Y += speed;
            if (pothole2Y >= 850) {
                pothole2Y = -50;
                pothole200X = random(425, 700);
                points++;
                speed += 0.5;
            }
        }
        // pothole 3.2
        ellipse(pothole300X, pothole3Y, 70, 70);
        if (pothole3Y < 850) {
            pothole3Y += speed;
            if (pothole3Y >= 850) {
                pothole3Y = -50;
                pothole300X = random(425, 700);
                points++;
                speed += 0.5;
            }
        }

        // pothole 4.2
        ellipse(pothole400X, pothole4Y, 70, 70);
        if (pothole4Y < 850) {
            pothole4Y += speed;
            if (pothole4Y >= 850) {
                pothole4Y = -50;
                pothole400X = random(425, 700);
                points++;
                speed += 0.5;
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
     speed = 3;
    }
}
