package paint;

public class Main {

	public static void main(String[] args) {
        Point point1 = new Point();
        point1.setX(10);
        point1.setY(10);
        
        //drawPoint(point1);
        //point1.disapear();
        point1.show();
        point1.show(false);
        
        Point point2 = new ColorPoint();
        point2.setX(100);
        point2.setY(200);
        ((ColorPoint)point2).setColor("red");  //다운캐스팅
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
