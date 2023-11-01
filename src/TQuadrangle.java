package src;

import java.awt.*;
public class TQuadrangle extends TFigure {
    protected Color color;
    public TQuadrangle(int x1, int y1, int x2, int y2, int x3, int y3,int x4,int y4, Color color){
        super(x1,y1);
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
        this.x4=x4;
        this.y4=y4;
        this.color=color;
    }
    public TQuadrangle(int x1, int y1){
        super(x1,y1);
    }
    public void ChangeSize(int x, int y) {
        x2 += x;
        x3 = x2;
        y3 += y;
        y4 = y3;
        this.Show(true);
    }
    @Override
    public void paintComponent(Graphics component) {
        super.paintComponent(component);
        int x1 = super.GetX();
        int y1 = super.GetY();
        component.setColor(color);
        component.drawLine(x1, y1, x2, y2);
        component.drawLine(x2, y2, x3, y3);
        component.drawLine(x3, y3, x4, y4);
        component.drawLine(x4, y4, x1, y1);
    }
}
