package src;

import java.awt.*;
public class TEllipse extends TCircle {
    public TEllipse(int x, int y, int r1, int r2, Color color) {
        super(x,y);
        this.r1=r1;
        this.r2=r2;
        this.color=color;
    }
    public void Turn() {
        int a = r1;
        r1=r2;
        r2= a;
        this.Show(true);
    }

    public void ChangeRadius(int r) {
        r1 = r;
        this.Show(true);
    }
}