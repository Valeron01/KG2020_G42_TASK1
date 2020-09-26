package com.company;

import java.awt.*;
import java.util.Random;

public class Drawer extends Panel {
    Random r = new Random();

    @Override
    public void paint(Graphics gh) {
        Graphics2D g = (Graphics2D) gh;
        g.setColor(new Color(0x9CCEFF));
        g.fillRect(0, 0, getWidth(), getHeight() / 3);
        g.setColor(new Color(0x165A12));
        g.fillRect(0, getHeight() / 3, getWidth(), getHeight() / 3 * 2);

        for (int i = 0; i < 6; i++) {
            drawCloud(g, 190 + i * (190 + r.nextInt(100)), 100, 90, 40);
        }

        //drawFlowers(g, 100, 0, getHeight() / 3, getWidth(), getHeight());



        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 6; i++) {
                if (r.nextInt(2) == 1)
                    drawSpruce(g, i * 250 + 100, 450 - r.nextInt(200) + 200 * j, 5 - r.nextInt(2));
                else
                    drawApple(g, i * 350 + 100, 500 - r.nextInt(150) + 200 * j, 140, 160);
            }
        }
    }

    public void drawSpruce(Graphics2D g, int x, int y, int segments) {
        g.setColor(new Color(0x642b09));
        g.fillRect(x - 15, y - 20, 30, 40);
        int prevY = y - 20;
        for (int i = 0; i < segments; i++) {
            int[] yp = new int[3];
            int[] xp = new int[3];

            float c = ((float) (segments - i + 5) / (segments + 5));


            xp[0] = (int) (x - 130 * c);
            xp[1] = x;
            xp[2] = (int) (x + 130 * c);


            yp[0] = prevY;
            yp[1] = (int) (prevY - 80 * c);
            yp[2] = prevY;

            prevY -= 55 * c;
            g.setColor(new Color(0x008000));
            g.fillPolygon(xp, yp, 3);
            g.setColor(new Color(0x006000));
            g.drawPolygon(xp, yp, 3);
        }
    }

    public void drawApple(Graphics2D g, int x, int y, int r1, int r2) {
        y -= 250;
        g.setColor(new Color(0x642b09));
        g.fillRect(x - 15, y, 30, 250);

        int fc = 0x009A00;
        int tc = 0x006000;
        g.setColor(new Color((fc - r.nextInt(fc - tc) + 1000) & 0x00FF00));
        int count = 50;
        int t = 55;
        for (int i = 0; i < count; i++) {
            int cx = (int) (r1 * Math.cos(i * (2 * Math.PI / count))) + r.nextInt((int) (t * 0.8));
            int cy = (int) (r2 * Math.sin(i * (2 * Math.PI / count)));


            g.fillOval(x + cx - t, y - cy - t / 2, t, t);
        }

        g.fillOval(x - 15 - r1, y - r2, r1 * 2, r2 * 2);

        g.setColor(new Color(0xCE1200));

        for (int i = 0; i < 10; i++) {
            g.fillOval(x - r1 + r.nextInt((int) (r1 * 1.5)) + r1 / 5, y - r2 + r.nextInt((int) (r2 * 1.5)) + r2 / 5, 10, 10);
        }
    }

    public void drawCloud(Graphics2D g, int x, int y, int r, int r1) {
        g.setColor(new Color(0xADB2C3));
        g.fillOval(x - r, y - r1, 2*r, 2 * r1);

        int count = 25;
        int t = 40;
        for (int i = 0; i < count; i++) {
            int cx = (int) (r * Math.cos(i * (2 * Math.PI / count))) + this.r.nextInt((int) (t * 0.8));
            int cy = (int) (r1 * Math.sin(i * (2 * Math.PI / count)));


            g.fillOval(x + cx - t, y - cy - t / 2, t, t);
        }

    }

    public void drawFlowers(Graphics2D g, int count, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < count; i++) {
            int x = x1 + r.nextInt(x2 - x1);
            int y = y1 + r.nextInt(y2 - y1);

            int c = r.nextInt(0xFFFFFF);
            int r = 5 + this.r.nextInt(10);

            g.setColor(new Color(c));

            g.fillOval(x, y, r, r);
        }
    }
}
