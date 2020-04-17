package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(4));
        circles.add(new Circle(10));
        circles.add(new Circle(30));
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2,8));
        rectangles.add(new Rectangle(4,23));
        rectangles.add(new Rectangle(2,10));
        rectangles.add(new Rectangle(34,24));
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(4,34,2));
        triangles.add(new Triangle(10,9,8));
        triangles.add(new Triangle(30,10,15));
        System.out.println("максимум круга: "+ getMaxPerim(circles));
        System.out.println("максимум прямоугольника: "+getMaxPerim(rectangles));
        System.out.println("максимум треугольника: "+getMaxPerim(triangles));
        System.out.println("максимум трех фигур: "+getMaxPerim(circles, rectangles, triangles));
        System.out.println("минимум круга: "+getMinPerim(circles));
        System.out.println("минимум прямоугольника: "+getMinPerim(rectangles));
        System.out.println("минимум треугольника: "+getMinPerim(triangles));
        System.out.println("минимум трех фигур: "+getMinPerim(circles, rectangles, triangles));



        //
        //        float maxp;
        //        maxp = Math.max(pc, Math.max(pt,pr));
    }

//    private static boolean getMinPerim(List<Circle> circles, List<Rectangle> rectangles) {
//    }

    static double getMaxPerim(List<? extends Perimeter>... figures) {
        double maxPerim = -1;
        for (List<? extends Perimeter > aFigList : figures)
            for (Perimeter aFig : aFigList)
                if (aFig.getPerimeter() > maxPerim) maxPerim = aFig.getPerimeter();
        return maxPerim;
    }

    static double getMinPerim(List<? extends Perimeter>... figures) {
        double minPerim = 10000000;
        for (List<? extends Perimeter > aFigList : figures)
            for (Perimeter aFig : aFigList)
                if (aFig.getPerimeter() < minPerim) minPerim = aFig.getPerimeter();
        return minPerim;
    }
}

interface Perimeter {
    double getPerimeter();
}

class Rectangle implements Perimeter {
    private double a;
    private double b;



    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

//    @Override
//    public String toString() {
//        return "Rectangle{" +
//                "a=" + a +
//                ", b=" + b +
//                '}';
//    }
}

class Circle implements Perimeter {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }


    }



  class Triangle   implements Perimeter {
      private double a,b,c;

      public Triangle(double a,double b,double c) {
          this.a = a;
          this.b = b;
          this.c = c;
      }

      @Override
      public double getPerimeter() {
          return a+b+c;
      }
  }