package GameContainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObjectLoader {
    private final int BLOCK_SIZE = 50;
    private final int ENEMY_COLOR;
    private final int OBSTACLE_COLOR;
    private final int CANVAS_HEIGHT;
    private final int CANVAS_WIDTH;

    private GameObject[] classA;
    private GameObject[] classB;
    private int Acount = 0;
    private int Bcount = 0;
    private String filepath;
    //private GameObject[] tmpClassA;
    //private GameObject[] tmpClassB;
    
    public ObjectLoader (GameContainer gc, int enemyColor, int obstacleColor, int canvasHeight, int canvasWidth) throws FileNotFoundException {
        ENEMY_COLOR = enemyColor;
        OBSTACLE_COLOR = obstacleColor;
        CANVAS_HEIGHT = canvasHeight;
        CANVAS_WIDTH = canvasWidth;
        
        filepath = System.getProperty("user.dir") + "\\Map\\" + "Map.txt";
        classA = new GameObject[100];
        classB = new GameObject[100];
        File file = new File(filepath);
        Scanner sc = new Scanner(file);
        int idx = 0;
        int idy = 0;
        int classAcount = 0;
        int classBcount = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') continue;
                if (line.charAt(i) == 'X') {
                    //EMPTY FIELD
                }
                if (line.charAt(i) == 'A') {
                    System.out.println(i);
                    classA[i] = new GameObject("Obstacle.png", idx, idy, classAcount, gc, ENEMY_COLOR, OBSTACLE_COLOR, CANVAS_HEIGHT, CANVAS_WIDTH, BLOCK_SIZE);
                    classA[i].draw("Obstacle.png");
                    classAcount += 1;
                }
                if (line.charAt(i) == 'B') {
                    classB[i] = new GameObject("jednorozec.png", idx, idy, classBcount, gc, ENEMY_COLOR, OBSTACLE_COLOR, CANVAS_HEIGHT, CANVAS_WIDTH, BLOCK_SIZE);
                    classB[i].draw("jednorozec.png");
                    classBcount += 1;
                }
                idx += BLOCK_SIZE;
            }
            idx = 0;
            idy += BLOCK_SIZE;
        }
    }
    
    /*public boolean removeObject(int idx, char type) {
        if (type == 'A' || type == 'a') {
            classA[idx] = null;
            for (int i = idx + 1; i < classA.length - 2; i++) {
                classA[i] = classA[i + 1];
            }
            classA[classA.length - 1] = null;
            return true;
        }
        else if (type == 'B' || type == 'b') {
            classB[idx] = null;
            for (int i = idx + 1; i < classB.length - 2; i++) {
                classB[i] = classB[i + 1];
            }
            classB[classB.length - 1] = null;
            return true;
        }
        else {
            return false;
        }
    }*/

    public int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }

    public int getAcount() {
        return Acount;
    }

    public int getBcount() {
        return Bcount;
    }

    public GameObject[] getClassA() {
        return classA;
    }

    public GameObject[] getClassB() {
        return classB;
    }
    
    public void addObject(GameObject go, char type) {
        
        // TODO: adding objects to list and to canvas 
        /*if (type == 'A' || type == 'a') {
            classA[Acount] = go;
            go.draw("Obstacle.png");
            return Acount++;
        }
        else if (type == 'B' || type == 'b') {
            classB[Bcount] = go;
            go.draw("Enemy.png");
            return Bcount++;
        }
        else {
            return 0;
        }*/
    }
}
