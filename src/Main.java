package src;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    private final JFrame frame = new JFrame("Lab_5");
    private final JButton back_btn = new JButton("Назад");
    private final JButton circles_btn = new JButton("Окружности");
    private final JButton circle_btn = new JButton("Окружность");
    private final JButton ellipse_btn = new JButton("Эллипс");
    private final JButton quads_btn = new JButton("Четырехугольники");
    private final JButton quad_btn = new JButton("Четырехугольник");
    private final JButton romb_btn = new JButton("Ромб");
    private final JButton trap_btn = new JButton("Трапеция");
    private final JButton create_btn = new JButton("Создать");
    private final JButton move_btn = new JButton("Передвинуть");
    private final JButton remove_btn = new JButton("Удалить объект");
    private final JButton csize_btn = new JButton("Изменить размер");
    private final JButton rotate_btn = new JButton("Повернуть");
    private final JButton array_btn = new JButton("Массив");
    private final JButton poly_btn = new JButton("Полиморфизм");
    private final JButton circles_show_hide_btn = new JButton("Показать/скрыть окружности");
    private final JButton quads_show_hide_btn = new JButton("Показать/скрыть четырёхугольники");
    private final JButton circles_move_btn = new JButton("Переместить окружности");
    private final JButton quads_move_btn = new JButton("Переместить четырехугольники");
    private final JButton circles_csize_btn = new JButton("Изменить окружности");
    private final JButton quads_csize_btn = new JButton("Изменить четырехугольники");
    private final JButton containers_btn = new JButton("Контейнер");
    private final JButton container_array_btn = new JButton("Массив");
    private final JButton container_list_btn = new JButton("Список");
    private final JButton show_hide_btn = new JButton("Скрыть/Показать");
    private final JButton add_btn = new JButton("Добавить");


    private final JPanel Canvas = canvas();
    private JPanel circle = null;
    private TCircle[] circles = null;
    private JPanel ellipse = null;
    private TEllipse[] ellipses = null;
    private JPanel quadrangle = null;
    private TQuadrangle[] quadrangles = null;
    private JPanel romb = null;
    private TRomb[] rombs = null;
    private JPanel trapeze = null;
    private TTrapeze[] trapezes = null;
    private JPanel[] array = null;
    private ContainerArray Array = null;
    private ContainerList List = null;
    private int btn_num;
    private Main() {
        frame.setLayout(new BorderLayout());
        frame.setSize(1920,1080);
        frame.add(Canvas, BorderLayout.CENTER);
        JPanel NPanel = navigation_panel();
        frame.add(NPanel, BorderLayout.WEST);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    MoveArray(0, -10);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    MoveArray(0, 10);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    MoveArray(-10, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    MoveArray(10, 0);
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private JPanel canvas() {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvas.setBackground(Color.WHITE);
        return canvas;
    }
    private JPanel createButton(JButton button) {
        JPanel panel = new JPanel();
        Dimension buttonSize = new Dimension(200, 50);
        button.setPreferredSize(buttonSize);
        Font font = new Font("Open Sans", Font.PLAIN, 20);
        button.setFont(font);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(button);
        return panel;
    }
    private void SetDefaultMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(circles_btn));
        panel.add(createButton(quads_btn));
        panel.add(createButton(poly_btn));
        panel.add(createButton(containers_btn));
    }
    private void SetCirclesMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(circle_btn));
        panel.add(createButton(ellipse_btn));
        panel.revalidate();
        panel.repaint();
    }
    private void SetQuadsMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(quad_btn));
        panel.add(createButton(romb_btn));
        panel.add(createButton(trap_btn));
        panel.revalidate();
        panel.repaint();
    }
    private void SetQuadAndCircleMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(create_btn));
        panel.add(createButton(remove_btn));
        panel.add(createButton(move_btn));
        panel.add(createButton(csize_btn));
        panel.add(createButton(array_btn));
        panel.revalidate();
        panel.repaint();
    }
    private void SetEllipseMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(create_btn));
        panel.add(createButton(remove_btn));
        panel.add(createButton(move_btn));
        panel.add(createButton(rotate_btn));
        panel.add(createButton(array_btn));
        panel.revalidate();
        panel.repaint();
    }
    private void SetPolymorphismMenu(JPanel panel){
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(create_btn));
        panel.add(createButton(circles_show_hide_btn));
        panel.add(createButton(quads_show_hide_btn));
        panel.add(createButton(circles_move_btn));
        panel.add(createButton(quads_move_btn));
        panel.add(createButton(circles_csize_btn));
        panel.add(createButton(quads_csize_btn));
        panel.add(createButton(remove_btn));
        panel.revalidate();
        panel.repaint();
    }
    private void SetContainersMenu(JPanel panel) {
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(container_array_btn));
        panel.add(createButton(container_list_btn));
        panel.revalidate();
        panel.repaint();
    }
    private void SetContainerMenu(JPanel panel) {
        panel.removeAll();
        panel.add(createButton(back_btn));
        panel.add(createButton(create_btn));
        panel.add(createButton(add_btn));
        panel.add(createButton(show_hide_btn));
        panel.add(createButton(move_btn));
        panel.add(createButton(remove_btn));
        panel.revalidate();
        panel.repaint();
    }
    private JPanel navigation_panel() {
        JPanel NPanel = new JPanel();
        NPanel.setLayout(new BoxLayout(NPanel, BoxLayout.Y_AXIS));
        NPanel.setBackground(Color.lightGray);
        SetDefaultMenu(NPanel);

        back_btn.addActionListener(e -> {
            if (btn_num == 1 || btn_num == 2 || btn_num == 20 || btn_num == 30) {
                SetDefaultMenu(NPanel);
                NPanel.revalidate();
                NPanel.repaint();
            }
            else if (btn_num == 3 || btn_num == 4 || btn_num == 8 || btn_num == 9){
                btn_num = 1;
                SetCirclesMenu(NPanel);
            }
            else if (btn_num == 5 || btn_num == 6 || btn_num == 7 || btn_num == 10 || btn_num == 11 || btn_num == 12){
                btn_num = 2;
                SetQuadsMenu(NPanel);
            }
            else if (btn_num == 31 || btn_num == 32) {
                btn_num = 30;
                SetContainersMenu(NPanel);
            }
        });

        containers_btn.addActionListener(e->{
            btn_num = 30;
            SetContainersMenu(NPanel);
        });

        container_array_btn.addActionListener(e->{
            btn_num = 31;
            SetContainerMenu(NPanel);
        });

        container_list_btn.addActionListener(e->{
            btn_num = 32;
            SetContainerMenu(NPanel);
        });

        circles_btn.addActionListener(e->{
            btn_num = 1;
            SetCirclesMenu(NPanel);
        });
        quads_btn.addActionListener(e->{
            btn_num = 2;
            SetQuadsMenu(NPanel);
        });
        circle_btn.addActionListener(e->{
            btn_num = 3;
            SetQuadAndCircleMenu(NPanel);

        });
        ellipse_btn.addActionListener(e->{
            btn_num = 4;
            SetEllipseMenu(NPanel);
        });

        quad_btn.addActionListener(e->{
            btn_num = 5;
            SetQuadAndCircleMenu(NPanel);
        });
        romb_btn.addActionListener(e->{
            btn_num = 6;
            SetQuadAndCircleMenu(NPanel);
        });
        trap_btn.addActionListener(e->{
            btn_num = 7;
            SetQuadAndCircleMenu(NPanel);
        });

        show_hide_btn.addActionListener(e->{
            if (btn_num == 32 && List != null) {
                List.Operation(3, Canvas);
            }
            if (btn_num == 31 && Array != null){
                Array.Operation(3, Canvas);
            }
        });

        poly_btn.addActionListener(e->{
            btn_num = 20;
            SetPolymorphismMenu(NPanel);
        });

        add_btn.addActionListener(e -> {
            if (btn_num == 32) {
                if (List == null) {
                    List = new ContainerList();
                }
                List.Operation(5, Canvas);
            }
            if (btn_num == 31) {
                if (Array == null) {
                    Array = new ContainerArray();
                }
                Array.Operation(5, Canvas);
            }
        });

        circles_show_hide_btn.addActionListener(e->{
            if (array != null) {
                for (int i = 0; i < 30; ++i) {
                    if(array[i] instanceof TCircle && array[i].isVisible()){
                        ((TCircle) array[i]).Show(false);
                    }
                    else if (array[i] instanceof TCircle && !(array[i].isVisible())){
                        ((TCircle) array[i]).Show(true);
                    }
                }
            }
            frame.setFocusable(true);
            frame.requestFocus();
        });
        quads_show_hide_btn.addActionListener(e->{
            if (array != null) {
                for (int i = 0; i < 30; ++i) {
                    if(array[i] instanceof TQuadrangle && array[i].isVisible()){
                        ((TQuadrangle) array[i]).Show(false);
                    }
                    else if (array[i] instanceof TQuadrangle && !(array[i].isVisible())){
                        ((TQuadrangle) array[i]).Show(true);
                    }
                }
            }
            frame.setFocusable(true);
            frame.requestFocus();
        });
        circles_move_btn.addActionListener(e->{
            int ch1 = -30 + (int) (Math.random() * 50);
            int ch2 = -30 + (int) (Math.random() * 50);
            if (array != null) {
                for (int i = 0; i < 30; ++i) {
                    if(array[i] instanceof TCircle){
                        ((TCircle) array[i]).Move(ch1, ch2);
                    }
                }
            }
            frame.setFocusable(true);
            frame.requestFocus();
        });

        quads_move_btn.addActionListener(e->{
            int ch1 = -30 + (int) (Math.random() * 50);
            int ch2 = -30 + (int) (Math.random() * 50);
            if (array != null) {
                for (int i = 0; i < 30; ++i) {
                    if(array[i] instanceof TQuadrangle){
                        ((TQuadrangle) array[i]).Move(ch1, ch2);
                    }
                }
            }
            frame.setFocusable(true);
            frame.requestFocus();
        });

        circles_csize_btn.addActionListener(e -> {
            if (array != null) {
                for (int i = 0; i < 30; ++i) {
                    int r = -50 + (int) (Math.random() * 250);
                    if (array[i] instanceof TEllipse) {
                        ((TEllipse) array[i]).ChangeRadius(r + 50);
                    }
                    else if (array[i] instanceof TCircle) {
                        ((TCircle) array[i]).ChangeRadius(r + 50);
                    }
                }
            }
        });

        quads_csize_btn.addActionListener(e -> {
            if (array != null) {
                for (int i = 0; i < 30; ++i) {
                    int x = -25 + (int) (Math.random() * 50);
                    int y = -25 + (int) (Math.random() * 50);
                    if (array[i] instanceof TQuadrangle) {
                        ((TQuadrangle) array[i]).ChangeSize(x, y);
                    }
                    else if (array[i] instanceof TRomb) {
                        ((TRomb) array[i]).ChangeSize(x, y);
                    }
                    else if (array[i] instanceof TTrapeze) {
                        ((TTrapeze) array[i]).ChangeSize(x, y);
                    }
                }
            }
            frame.setFocusable(true);
            frame.requestFocus();
        });

        array_btn.addActionListener(e -> {
            if (btn_num == 3){
                JOptionPane.showMessageDialog(frame, "Выбран массив окружностей");
                NPanel.remove(array_btn);
                btn_num = 8;
            }
            else if (btn_num == 4) {
                JOptionPane.showMessageDialog(frame, "Выбран массив эллипсов");
                NPanel.remove(array_btn);
                btn_num = 9;
            }
            else if (btn_num == 5) {
                JOptionPane.showMessageDialog(frame, "Выбран массив произвольных четырехугольников");
                NPanel.remove(array_btn);
                btn_num = 10;
            }
            else if (btn_num == 6) {
                JOptionPane.showMessageDialog(frame, "Выбран массив ромбов");
                NPanel.remove(array_btn);
                btn_num = 11;
            }
            else if (btn_num == 7) {
                JOptionPane.showMessageDialog(frame, "Выбран массив трапеций");
                NPanel.remove(array_btn);
                btn_num = 12;
            }
            NPanel.revalidate();
            NPanel.repaint();
        });

        create_btn.addActionListener(e -> {
            if (btn_num == 32) {
                if (List == null) {
                    List = new ContainerList();
                    List.Operation(1, Canvas);
                }
            }
            if (btn_num == 31) {
                if (Array == null) {
                    Array = new ContainerArray();
                    Array.Operation(1, Canvas);
                }
            }
            else if (btn_num == 20) {
                if (array == null) {
                    array = new TFigure[30];
                    for (int i = 0; i < 30; i++) {
                        int ch1 = 1 + (int) (Math.random() * 5);
                        if (ch1 == 1) {
                            ch1 = (int) (Math.random() * 500);
                            int ch2 = (int) (Math.random() * 300);
                            int ch3 = (int) (Math.random() * 200);
                            array[i] = new TCircle(ch1, ch2, ch3, Color.BLACK);
                        } else if (ch1 == 2) {
                            ch1 = (int) (Math.random() * 500);
                            int ch2 = (int) (Math.random() * 300);
                            int ch3 = (int) (Math.random() * 200);
                            int ch4 = (int) (Math.random() * 100);
                            array[i] = new TEllipse(ch1, ch2, ch3, ch4, Color.RED);
                        } else if (ch1 == 3) {
                            ch1 = (int) (Math.random() * 500);
                            int ch2 = (int) (Math.random() * 500);
                            int ch3 = (int) (Math.random() * 500);
                            int ch4 = (int) (Math.random() * 500);
                            int ch5 = (int) (Math.random() * 500);
                            int ch6 = (int) (Math.random() * 500);
                            int ch7 = (int) (Math.random() * 500);
                            int ch8 = (int) (Math.random() * 500);
                            array[i] = new TQuadrangle(ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, Color.MAGENTA);
                        } else if (ch1 == 4) {
                            ch1 = (int) (Math.random() * 500);
                            int ch2 = (int) (Math.random() * 500);
                            int ch3 = 100 + (int) (Math.random() * 500);
                            int ch4 = 100 + (int) (Math.random() * 250);
                            array[i] = new TRomb(ch1, ch2, ch3, ch4, Color.CYAN);
                        } else if (ch1 == 5) {
                            ch1 = (int) (Math.random() * 500);
                            int ch2 = (int) (Math.random() * 500);
                            int ch3 = 100 + (int) (Math.random() * 500);
                            int ch4 = 100 + (int) (Math.random() * 250);
                            int ch5 = 10 + (int) (Math.random() * 50);
                            array[i] = new TTrapeze(ch1, ch2, ch3, ch4, ch5, Color.GREEN);
                        }
                        ((TFigure) array[i]).Show(true);
                        Canvas.add(array[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                    JOptionPane.showMessageDialog(frame, "Массив случайных фигур создан");
                }
            }
            else if (btn_num == 3) {
                if (circle == null) {
                    int ch1 = (int) (Math.random() * 500);
                    int ch2 = (int) (Math.random() * 500);
                    int ch3 = (int) (Math.random() * 250);
                    circle = new TCircle(ch1, ch2, ch3, Color.GREEN);
                    ((TCircle) circle).Show(true);
                    Canvas.add(circle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 8) {
                if (circles == null) {
                    circles = new TCircle[10];
                    for (int i=0; i<10; i++) {
                        int ch1 = (int) (Math.random() * 500);
                        int ch2 = (int) (Math.random() * 500);
                        int ch3 = (int) (Math.random() * 250);
                        circles[i] = new TCircle (ch1, ch2, ch3, Color.GREEN);
                        circles[i].Show(true);
                        Canvas.add(circles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 4) {
                if (ellipse == null) {
                    int ch1 = (int) (Math.random() * 500);
                    int ch2 = (int) (Math.random() * 300);
                    int ch3 = (int) (Math.random() * 200);
                    int ch4 = (int) (Math.random() * 100);
                    ellipse = new TEllipse(ch1, ch2, ch3, ch4, Color.RED);
                    ((TEllipse) ellipse).Show(true);
                    Canvas.add(ellipse, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 9) {
                if (ellipses == null) {
                    ellipses = new TEllipse[10];
                    for (int i=0; i<10; i++) {
                        int ch1 = (int) (Math.random() * 500);
                        int ch2 = (int) (Math.random() * 300);
                        int ch3 = (int) (Math.random() * 200);
                        int ch4 = (int) (Math.random() * 100);
                        ellipses[i] = new TEllipse (ch1, ch2, ch3, ch4, Color.RED);
                        ellipses[i].Show(true);
                        Canvas.add(ellipses[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 5) {
                if (quadrangle == null) {
                    int ch1 = (int) (Math.random() * 500);
                    int ch2 = (int) (Math.random() * 500);
                    int ch3 = (int) (Math.random() * 500);
                    int ch4 = (int) (Math.random() * 500);
                    int ch5 = (int) (Math.random() * 500);
                    int ch6 = (int) (Math.random() * 500);
                    int ch7 = (int) (Math.random() * 500);
                    int ch8 = (int) (Math.random() * 500);
                    quadrangle = new TQuadrangle(ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8, Color.CYAN);
                    ((TQuadrangle) quadrangle).Show(true);
                    Canvas.add(quadrangle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 10) {
                if (quadrangles == null) {
                    quadrangles = new TQuadrangle[10];
                    for (int i=0; i<10; i++) {
                        int ch1 = (int) (Math.random() * 500);
                        int ch2 = (int) (Math.random() * 500);
                        int ch3 = (int) (Math.random() * 500);
                        int ch4 = (int) (Math.random() * 500);
                        int ch5 = (int) (Math.random() * 500);
                        int ch6 = (int) (Math.random() * 500);
                        int ch7 = (int) (Math.random() * 500);
                        int ch8 = (int) (Math.random() * 500);
                        quadrangles[i] = new TQuadrangle (ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, Color.CYAN);
                        quadrangles[i].Show(true);
                        Canvas.add(quadrangles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 6) {
                if (romb == null) {
                    int ch1 = (int) (Math.random() * 500);
                    int ch2 = (int) (Math.random() * 500);
                    int ch3 = 100 + (int) (Math.random() * 500);
                    int ch4 = 100 + (int) (Math.random() * 250);
                    romb = new TRomb(ch1, ch2, ch3, ch4, Color.BLACK);
                    ((TRomb) romb).Show(true);
                    Canvas.add(romb, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 11) {
                if (rombs == null) {
                    rombs = new TRomb[10];
                    for (int i=0; i<10; i++) {
                        int ch1 = (int) (Math.random() * 500);
                        int ch2 = (int) (Math.random() * 500);
                        int ch3 = 100 + (int) (Math.random() * 500);
                        int ch4 = 100 + (int) (Math.random() * 250);
                        rombs[i] = new TRomb(ch1, ch2, ch3, ch4, Color.BLACK);
                        rombs[i].Show(true);
                        Canvas.add(rombs[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 7) {
                if (trapeze == null) {
                    int ch1 = (int) (Math.random() * 500);
                    int ch2 = (int) (Math.random() * 500);
                    int ch3 = 100 + (int) (Math.random() * 500);
                    int ch4 = 100 + (int) (Math.random() * 250);
                    int ch5 = 10 + (int) (Math.random() * 50);
                    trapeze = new TTrapeze(ch1, ch2, ch3, ch4, ch5, Color.MAGENTA);
                    ((TTrapeze) trapeze).Show(true);
                    Canvas.add(trapeze, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 12) {
                if (trapezes == null) {
                    trapezes = new TTrapeze[10];
                    for (int i=0; i<10; i++) {
                        int ch1 = (int) (Math.random() * 500);
                        int ch2 = (int) (Math.random() * 500);
                        int ch3 = 100 + (int) (Math.random() * 500);
                        int ch4 = 100 + (int) (Math.random() * 250);
                        int ch5 = 10 + (int) (Math.random() * 50);
                        trapezes[i] = new TTrapeze(ch1, ch2, ch3, ch4, ch5, Color.MAGENTA);
                        trapezes[i].Show(true);
                        Canvas.add(trapezes[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            frame.setFocusable(true);
            frame.requestFocus();
        });

        remove_btn.addActionListener(e -> {
            if (btn_num == 32 && List != null) {
                List.Operation(4, Canvas);
                List = null;
            }
            if (btn_num == 31 && Array != null) {
                Array.Operation(4, Canvas);
                Array = null;
            }

            if (btn_num == 3) {
                if (circle != null) {
                    Canvas.remove(circle);
                    circle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 4) {
                if (ellipse != null) {
                    Canvas.remove(ellipse);
                    ellipse = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 5) {
                if (quadrangle != null) {
                    Canvas.remove(quadrangle);
                    quadrangle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 6) {
                if (romb != null) {
                    Canvas.remove(romb);
                    romb = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 7) {
                if (trapeze != null) {
                    Canvas.remove(trapeze);
                    trapeze = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 8) {
                if (circles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(circles[i]);
                        circles[i] = null;
                    }
                    circles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 9) {
                if (ellipses != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(ellipses[i]);
                        ellipses[i] = null;
                    }
                    ellipses = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 10) {
                if (quadrangles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(quadrangles[i]);
                        quadrangles[i] = null;
                    }
                    quadrangles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 11) {
                if (rombs != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(rombs[i]);
                        rombs[i] = null;
                    }
                    rombs = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 12) {
                if (trapezes != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(trapezes[i]);
                        trapezes[i] = null;
                    }
                    trapezes = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 20) {
                if (array != null) {
                    for (int i = 0; i < 30; i++) {
                        Canvas.remove(array[i]);
                        array[i] = null;
                    }
                    array = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            frame.setFocusable(true);
            frame.requestFocus();
        });

        rotate_btn.addActionListener(e -> {
            if (btn_num == 4) {
                if (ellipse != null) {
                    ((TEllipse) ellipse).Turn();
                    ((TEllipse) ellipse).Show(true);
                    Canvas.add(ellipse, BorderLayout.CENTER);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 9) {
                if (ellipses != null) {
                    for (int i = 0; i < 10; i++){
                        ellipses[i].Turn();
                        ellipses[i].Show(true);
                        Canvas.add(ellipses[i], BorderLayout.CENTER);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
        });

        csize_btn.addActionListener(e -> {
            int x1 = -25 + (int) (Math.random() * 50);
            int y1 = -25 + (int) (Math.random() * 50);
            if (btn_num == 3) {
                if (circle != null) {
                    int r = -50 + (int) (Math.random() * 250);
                    ((TCircle) circle).ChangeRadius(r + 50);
                    ((TCircle) circle).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 5) {
                if (quadrangle != null) {
                    ((TQuadrangle) quadrangle).ChangeSize(x1, y1);
                    ((TQuadrangle) quadrangle).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 6) {
                if (romb != null) {
                    ((TRomb) romb).ChangeSize(x1, y1);
                    ((TRomb) romb).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 7) {
                if (trapeze != null) {
                    ((TTrapeze) trapeze).ChangeSize(x1, y1);
                    ((TTrapeze) trapeze).Show(true);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 8) {
                if (circles != null) {
                    for (int i = 0; i < 10; i++) {
                        int r = -50 + (int) (Math.random() * 250);
                        circles[i].ChangeRadius(r + 50);
                        circles[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 10) {
                if (quadrangles != null) {
                    for (int i = 0; i < 10; i++) {
                        quadrangles[i].ChangeSize(x1, y1);
                        quadrangles[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 11) {
                if (rombs != null) {
                    for (int i = 0; i < 10; i++) {
                        rombs[i].ChangeSize(x1, y1);
                        rombs[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
            else if (btn_num == 12) {
                if (trapezes != null) {
                    for (int i = 0; i < 10; i++) {
                        trapezes[i].ChangeSize(x1, y1);
                        trapezes[i].Show(true);
                        Canvas.revalidate();
                        Canvas.repaint();
                    }
                }
            }
        });

        move_btn.addActionListener(e -> {
            int ch1 = -30 + (int) (Math.random() * 50);
            int ch2 = -30 + (int) (Math.random() * 50);
            if (btn_num == 32 && List != null) {
                List.Operation(2, Canvas);
            }
            if (btn_num == 31 && Array != null) {
                Array.Operation(2, Canvas);
            }
            if (btn_num == 3) {
                if (circle != null) {
                    ((TCircle) circle).Move(ch1, ch2);
                    ((TCircle) circle).Show(true);
                    Canvas.add(circle, BorderLayout.CENTER);
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            else if (btn_num == 8) {
                if (circles != null) {
                    for (int i=0; i<10; i++) {
                        circles[i].Move(ch1, ch2);
                        circles[i].Show(true);
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 4) {
                if (ellipse  != null) {
                    ((TEllipse) ellipse ).Move(ch1, ch2);
                    ((TEllipse) ellipse ).Show(true);
                    Canvas.add(ellipse , BorderLayout.CENTER);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 9) {
                if (ellipses != null) {
                    for (int i = 0; i < 10; i++) {
                        ellipses[i].Move(ch1, ch2);
                        ellipses[i].Show(true);
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 5) {
                if (quadrangle != null) {
                    ((TQuadrangle) quadrangle).Move(ch1,ch2);
                    ((TQuadrangle) quadrangle).Show(true);
                    Canvas.add(quadrangle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 10) {
                if (quadrangles != null) {
                    for (int i = 0; i < 10; i++) {
                        quadrangles[i].Move(ch1, ch2);
                        quadrangles[i].Show(true);
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 6) {
                if (romb != null) {
                    ((TRomb) romb).Move(ch1, ch2);
                    ((TRomb) romb).Show(true);
                    Canvas.add(romb, BorderLayout.CENTER);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 11) {
                if (rombs != null) {
                    for (int i = 0; i < 10; i++) {
                        rombs[i].Move(ch1, ch2);
                        rombs[i].Show(true);
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 7) {
                if (trapeze != null) {
                    ((TTrapeze) trapeze).Move(ch1, ch2);
                    ((TTrapeze) trapeze).Show(true);
                    Canvas.add(trapeze, BorderLayout.CENTER);
                    Canvas.repaint();
                }
            }
            else if (btn_num == 12) {
                if (trapezes != null) {
                    for (int i=0; i<10; i++) {
                        trapezes[i].Move(ch1, ch2);
                        trapezes[i].Show(true);
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
        });

        return NPanel;
    }

    private void MoveArray(int x, int y) {
        if (array != null) {
            for (int i = 0; i < 30; ++i) {
                if (array[i] instanceof TCircle) {
                    ((TCircle) array[i]).Move(x, y);
                    Canvas.add(array[i], BorderLayout.CENTER);
                }
                if (array[i] instanceof TEllipse) {
                    ((TEllipse) array[i]).Move(x, y);
                    Canvas.add(array[i], BorderLayout.CENTER);
                }
                if (array[i] instanceof TQuadrangle) {
                    ((TQuadrangle) array[i]).Move(x, y);
                    Canvas.add(array[i], BorderLayout.CENTER);
                }
                if (array[i] instanceof TRomb) {
                    ((TRomb) array[i]).Move(x, y);
                    Canvas.add(array[i], BorderLayout.CENTER);
                }
                if (array[i] instanceof TTrapeze) {
                    ((TTrapeze) array[i]).Move(x, y);
                    Canvas.add(array[i], BorderLayout.CENTER);
                }
            }

        }
        frame.setFocusable(true);
        frame.requestFocus();
    }

    public static void main(String[] argc) {
        SwingUtilities.invokeLater(Main::new);
    }
}
