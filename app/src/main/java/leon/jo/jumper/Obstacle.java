package leon.jo.jumper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Leon on 08.01.2018.
 */

public class Obstacle implements GameObject {

    private Rect rectangle;
    private int color;

    public Rect getRectangle() {
        return rectangle;
    }

    public void decrementX(float x)
    {
        rectangle.left -= x;
        rectangle.right -= x;
    }

    public Obstacle(int startX, int startTop, int length, int height, int color){
        this.color = color;
        rectangle = new Rect(startX ,startTop, startX + length, startTop + height);
    }

    public boolean playerCollide(Player player){
        if(rectangle.contains(player.getRectangle().left, player.getRectangle().top)
                || rectangle.contains(player.getRectangle().right, player.getRectangle().top )
                || rectangle.contains(player.getRectangle().right, player.getRectangle().bottom)
                || rectangle.contains(player.getRectangle().left, player.getRectangle().bottom))
            return true;
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }
}
