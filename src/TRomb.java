package src;

import java.awt.*;

public class TRomb extends TQuadrangle {
    public TRomb (int x, int y, int w, int h, Color color) {
        super(x,y);
        x2 = x4 = x + w/2;
        y2 = y - h/2;
        x3 = x + w;
        y3 = y;
        y4 = y + h/2;
        this.color=color;
    }
    public void ChangeSize(int x, int y) {
        super.Set(super.GetX()+x,super.GetY());
        x3 -= x;
        y2 += y;
        y4 -= y;
        this.Show(true);
    }
}
