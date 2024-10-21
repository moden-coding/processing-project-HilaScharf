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
    //coordinates for each tree
    PVector tree1 = new PVector(random(0, 360), -50);
    PVector tree100 = new PVector(random(425, 700), -50);
    PVector tree2 = new PVector(random(0, 360), -225);
    PVector tree200 = new PVector(random(425, 700), -225);
    PVector tree3 = new PVector(random(0, 360), -400);
    PVector tree300 = new PVector(random(425, 700), -400);
    PVector tree4 = new PVector(random(0, 360), -575);
    PVector tree400 = new PVector(random(425, 700), -575);
    PVector tree5 = new PVector(random(0, 360), -750);
    PVector tree500 = new PVector(random(425, 700), -750);
    PVector tree6 = new PVector(random(0, 360), -975);
    PVector tree600 = new PVector(random(425, 700), -975);

    float pothole6X;
    float pothole600X;
    float pothole6Y = -975;
    // point counter variable
    double points = 0;

    public void setup() {
        // background is green
        background(26, 189, 8);
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
            checkingCollision(tree1);
            checkingCollision(tree100);
            checkingCollision(tree2);
            checkingCollision(tree200);
            checkingCollision(tree3);
            checkingCollision(tree300);
            checkingCollision(tree4);
            checkingCollision(tree400);
            checkingCollision(tree5);
            checkingCollision(tree500);
            checkingCollision(tree6);
            checkingCollision(tree600);
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
        float distance = dist(x1, y1, x2, y2); 
        return distance <= r1 + r2;
    }
        //display after you lose
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
    //text that says you lose
    public void winOrLose() {
        // if()
        fill(255, 0, 0); // Red
        textSize(50);
        text("You lose!", 260, 200);
    }

    public void checkingCollision(PVector treeNumber) {
        if (detectCollision(treeNumber.x, treeNumber.y, 25, characterX, 500, 15)) {
            collisionDetected = 2; 
        }
    }

    public void treeMove() {
        treesMove1(tree1);
        treesMove1(tree2);
        treesMove1(tree3);
        treesMove1(tree4);
        treesMove2(tree100);
        treesMove2(tree200);
        treesMove2(tree300);
        treesMove2(tree400);
    }

    public void treesMove2(PVector treeX00) {
        ellipse(treeX00.x, treeX00.y, 70, 70);
        if (treeX00.y < 850) {
            treeX00.y += speed / 10;
            if (treeX00.y >= 850) {
                treeX00.y = -50;
                treeX00.x = random(425, 700);
            }
        }
    }

    public void treesMove1(PVector tree) {
        ellipse(tree.x, tree.y, 70, 70);
        if (tree.y < 850) {
            tree.y += speed / 10;
            if (tree.y >= 850) {
                tree.y = -50;
                tree.x = random(0, 300);
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
        tree1.y = -50;
        tree2.y = -225;
        tree3.y = -400;
        tree4.y = -575;
        tree5.y = -750;
        tree6.y = -975;
        tree100.y = -50;
        tree200.y = -225;
        tree300.y = -400;
        tree400.y = -575;
        tree500.y = -750;
        tree600.y = -975;
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
