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
        drawPoint(point2);
        
        point2.show(false);
        point2.show(true);
	}
	
	public static void drawPoint(Point point) {
		point.show();
	}
//	public static void drawcolorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	//코드 중복 발생

}