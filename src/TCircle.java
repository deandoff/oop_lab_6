package src;

import java.awt.*;
public class TCircle extends TFigure {
    protected int r1, r2;
    protected Color color;
    public TCircle(int x, int y, int r, Color color) {
        super(x,y);
        r1 = r2 = r;
        this.color = color;
    }
    public TCircle(int x, int y) { super(x,y); }
    public void ChangeRadius(int r) {
        r1 = r2 = r;
        this.Show(true);
    }
    @Override
    public void paintComponent(Graphics component){
        super.paintComponent(component);
        component.setColor(color);
        component.drawOval(super.GetX(),super.GetY(),r1*2,r2*2);
    }
}
