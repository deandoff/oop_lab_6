package src;

import java.awt.*;
public class TTrapeze extends TQuadrangle {
    public TTrapeze(int x, int y, int w, int h, int c, Color color) {
        super(x,y);
        x2 = x + w; y2 = y;
        x3 = x2 - c; y3 = y - h;
        x4 = x + c; y4 = y3;
        this.color = color;
    }
    public void ChangeSize(int x, int y) {
        super.Set(super.GetX()-x,super.GetY()+y);
        x2 += x;
        y2 += y;
        x3 += x;
        x4 -= x;
        this.Show(true);
    }
}
