package src;

import javax.swing.*;

abstract class TFigure extends JPanel {
    protected int x1,y1,x2,y2,x3,y3,x4,y4;
    private final Point TPoint = new Point();
    public TFigure(int x, int y) {
        setLayout(null);
        setOpaque(false);
        TPoint.Set(x, y);
    }
    protected void Move(int x, int y) {
        this.Show(false);
        x1 = TPoint.GetX() + x;
        y1 = TPoint.GetY() + y;
        TPoint.Set(x1, y1);
        x2 += x;
        x3 += x;
        x4 += x;
        y2 += y;
        y3 += y;
        y4 += y;
        this.Show(true);
    }
    public void Show(boolean vision) {
        setVisible(vision);
        this.repaint();
    }
    public void Set(int x, int y) {
        TPoint.Set(x,y);
    }
    public int GetX() {return TPoint.GetX();}
    public int GetY() {return TPoint.GetY();}
}
