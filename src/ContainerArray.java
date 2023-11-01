package src;
import  javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContainerArray {
    private static ArrayList<TFigure> Figure = new ArrayList<>();
    private int counter;

    void Operation(int operation, JPanel canvas) {

        if (operation == 1) { //создать массив
            counter += 15 + (int) (Math.random()*10);
            for (int i = 0; i < counter; ++i) {
                int number = 1 + (int) (Math.random() * 5);
                this.Create(number, i);
                canvas.add(Figure.get(i), BorderLayout.CENTER);
                canvas.validate();
                canvas.revalidate();
                canvas.repaint();
            }
        }
        else if (operation == 2) { //переместить
            int x = -30 + (int) (Math.random()*100);
            int y = -30 + (int) (Math.random()*100);
            for (int i = 0; i < counter; ++i) {
                Figure.get(i).Move(x,y);
            }
        }
        else if (operation == 3) { //показать или скрыть
            for (int i = 0; i < counter; ++i) {
                Figure.get(i).Show(!Figure.get(i).isVisible());
            }
        }
        else if (operation == 4) { //очистить массив
            for (int i = 0; i < counter; ++i) {
                canvas.remove(Figure.get(i));
            }
            canvas.validate();
            canvas.revalidate();
            canvas.repaint();
            Figure.clear();
            counter = 0;
        }
        else if (operation == 5) { //добавить элемент
            int number = 1 + (int) (Math.random() * 5);
            this.Create(number, counter);
            canvas.add(Figure.get(counter), BorderLayout.CENTER);
            canvas.validate();
            canvas.revalidate();
            canvas.repaint();
            ++counter;
        }
    }
    private void Create(int number, int i) {
        int x = (int) (Math.random() * 500);
        int y = (int) (Math.random() * 500);
        if (number == 1) {
            int r = (int) (Math.random() * 200);
            Figure.add(i, new TCircle(x, y, r, Color.BLACK));
        }
        int w;
        int h;
        if (number == 2) {
            w = (int) (Math.random() * 300);
            h = (int) (Math.random() * 100);
            Figure.add(i, new TEllipse(x, y, w, h, Color.RED));
        }
        if (number == 3) {
            int x2 = (int) (Math.random() * 500);
            int y2 = (int) (Math.random() * 500);
            int x3 = (int) (Math.random() * 500);
            int y3 = (int) (Math.random() * 500);
            int x4 = (int) (Math.random() * 500);
            int y4 = (int) (Math.random() * 500);
            Figure.add(i, new TQuadrangle(x, y, x2, y2, x3, y3, x4, y4, Color.CYAN));
        }
        if (number == 4) {
            w = 100 + (int) (Math.random() * 500);
            h = 100 + (int) (Math.random() * 250);
            Figure.add(i, new TRomb(x, y, w, h, Color.GREEN));
        }
        if (number == 5) {
            w = 100 + (int) (Math.random() * 300);
            h = 100 + (int) (Math.random() * 100);
            int c = 10 + (int) (Math.random() * 50);
            Figure.add(i, new TTrapeze(x, y, w, h, c, Color.MAGENTA));
        }
    }
}
