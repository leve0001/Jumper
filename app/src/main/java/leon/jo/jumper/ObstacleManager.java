package leon.jo.jumper;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Leon on 08.01.2018.
 */

public class ObstacleManager {
    private ArrayList<Obstacle> obstacles;
    private int obstacleGap;
    private int obstacleHeight;
    private int color;

    private long startTime;

    public ObstacleManager(int obstacleGap, int obstacleHeight, int color) {
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.color = color;

        startTime = System.currentTimeMillis();

        obstacles = new ArrayList<>();

        populateObstacles();
    }

    private void populateObstacles() {
        int currX = -5*Constants.SCREEN_WIDTH/4;
        while(currX < 0){
            int startTop = (int) (Math.random()*Constants.SCREEN_HEIGHT);
            //obstacles.add(new Obstacle(obstacleHeight, color, xStart, currY, playerGap));
            obstacles.add(new Obstacle(Constants.SCREEN_WIDTH + 1, startTop, Constants.SCREEN_HEIGHT - obstacleHeight - 100 , 75, color));
            currX = 1;
        }
    }

    public void update(){
        int elapsedTime =(int) (System.currentTimeMillis()-startTime);
        startTime=System.currentTimeMillis();
        //geschwindigkeit
        float speed = Constants.SCREEN_WIDTH/10000.f;
        for(Obstacle ob :obstacles)
        {
            ob.decrementX(speed*elapsedTime);
        }
        if (obstacles.get(obstacles.size()-1).getRectangle().top >= Constants.SCREEN_HEIGHT)
        {
            int xStart = (int) (Math.random()*Constants.SCREEN_WIDTH);

           // obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, obstacles.get(0).getRectangle().top - obstacleHeight));
            obstacles.remove(obstacles.size()-1);
        }
    }

    public void draw(Canvas canvas){
        for(Obstacle ob : obstacles){
            ob.draw(canvas);
        }
    }
}
