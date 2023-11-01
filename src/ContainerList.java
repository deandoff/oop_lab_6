package src;
import javax.swing.*;
import java.awt.*;
class Node
{
    private final Node Next;
    private final TFigure Fig;

    public Node (Node Next, TFigure Fig) { this.Next = Next; this.Fig = Fig; }
    public Node GetNext ()  { return Next; }
    public TFigure GetFig () { return Fig ; }
}
class ContainerList {
    private Node First;
    private int x;
    private int y;
    private int counter;

    public ContainerList() {
        First = null;
    }

    public void Operation(int operation, JPanel canvas) {
        if (operation == 1) {
            counter += 15 + (int) (Math.random() * 10);
            for (int i = 0; i < counter; ++i) {
                int number = 1 + (int) (Math.random() * 5);
                this.Create(number, counter - i - 1);
            }
            Node Current = First;
            while (Current != null) {
                canvas.add(Current.GetFig(), BorderLayout.CENTER);
                canvas.validate();
                canvas.revalidate();
                canvas.repaint();
                Current = Current.GetNext();
            }
        } else if (operation == 2) {
            x = -30 + (int) (Math.random() * 100);
            y = -30 + (int) (Math.random() * 100);
            Node Current = First;
            while (Current != null) {
                Current.GetFig().Move(x, y);
                Current = Current.GetNext();
            }
        } else if (operation == 3) {
            Node Current = First;
            while (Current != null) {
                Current.GetFig().Show(!Current.GetFig().isVisible());
                Current = Current.GetNext();
            }
        } else if (operation == 4) {
            while (First != null) {
                Node removedNode = First;
                First = First.GetNext();
                canvas.remove(removedNode.GetFig());
                canvas.validate();
                canvas.revalidate();
                canvas.repaint();
            }
        } else if (operation == 5) {
            int number = 1 + (int) (Math.random() * 5);
            this.Create(number, counter);
            Node Current = First;
            while (Current != null) {
                canvas.add(Current.GetFig(), BorderLayout.CENTER);
                canvas.validate();
                canvas.revalidate();
                canvas.repaint();
                Current = Current.GetNext();
            }
            ++counter;
        }
    }

    public void Add(TFigure aFig) {
        First = new Node(First, aFig);
    }

    private void Create(int number, int j) {
        x = (int) (Math.random() * 500);
        y = (int) (Math.random() * 500);
        if (number == 1) {
            int r = (int) (Math.random() * 200);
            Add(new TCircle(x, y, r, Color.BLACK));
        }
        int w;
        int h;
        if (number == 2) {
            w = (int) (Math.random() * 200);
            h = (int) (Math.random() * 100);
            Add(new TEllipse(x, y, w, h, Color.RED));
        }
        if (number == 3) {
            int x2 = (int) (Math.random() * 500);
            int y2 = (int) (Math.random() * 500);
            int x3 = (int) (Math.random() * 500);
            int y3 = (int) (Math.random() * 500);
            int x4 = (int) (Math.random() * 500);
            int y4 = (int) (Math.random() * 500);
            Add(new TQuadrangle(x, y, x2, y2, x3, y3, x4, y4, Color.CYAN));
        }
        if (number == 4) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            Add(new TRomb(x, y, w, h, Color.GREEN));
        }
        if (number == 5) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            int c = 10 + (int) (Math.random() * 50);
            Add(new TTrapeze(x, y, w, h, c, Color.MAGENTA));
        }
    }
}