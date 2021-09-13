package prob6;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	@Override
	public void resize(double s) {
		setHeight(getHeight() * s);
		setWidth(getWidth() * s);
	}

	@Override
	public double getArea() {
		return getHeight() * getWidth();
	}

	@Override
	public double getPerimeter() {
		return (getHeight() + getWidth()) *2;
	}

}
