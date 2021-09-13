package prob6;

public class RectTriangle extends Shape {

	public RectTriangle(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	@Override
	public double getArea() {
		return getHeight() * getWidth() / 2;
	}

	@Override
	public double getPerimeter() {
		return getHeight() + getWidth() + Math.sqrt(Math.pow(getHeight(), 2) + Math.pow(getWidth(), 2));
	}

}
