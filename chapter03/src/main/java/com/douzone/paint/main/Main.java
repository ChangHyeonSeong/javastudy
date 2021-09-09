package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rectangle;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
        Point point1 = new Point(10, 10);
        point1.setX(10);
        point1.setY(10);
        
        //drawPoint(point1);
        //point1.disapear();
        point1.show();
        point1.show(false);
        
        Point point2 = new ColorPoint(100, 200, "red");
        //point2.setX(100);
       // point2.setY(200);
        //((ColorPoint)point2).setColor("red");  //다운캐스팅
       // drawPoint(point2);
        draw(point2);
        
        point2.show(false);
        point2.show(true);
        
        Triangle triangle = new Triangle();
        //drawTriangle(triangle);
        //drawShape(triangle);
        draw(triangle);
        
        Rectangle rectangle = new Rectangle();
        //drawRectangle(rectangle);
        //drawShape(rectangle);
	    draw(rectangle);
	    
	    Circle circle = new Circle();
	    //drawCircle(circle);
	    //drawShape(circle);
	    draw(circle);
	    
	    GraphicText text = new GraphicText("HelloWorld");
	    text.draw();
	    
		// instanceof test
	    System.out.println(circle instanceof Object);
	    System.out.println(circle instanceof Shape);
	    System.out.println(circle instanceof Circle);
	    //오류: class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
	    //System.out.println(circle instanceof Rectangle);
	    
	    //interface는 hierachy와 상관없이 instanceof 연산자를 사용할 수 있다.
	    System.out.println(circle instanceof Drawable);
	    System.out.println(circle instanceof Runnable);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	public static void drawcolorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	//코드 중복 발생
	
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawRectangle(Rectangle Rectangle) {
//		Rectangle.draw();
//	}
//	
//	public static void drawCircle(Circle circle) {
//		circle.draw();
//	}
   //코드 중복
	

}
