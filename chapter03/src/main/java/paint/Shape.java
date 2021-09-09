package paint;

public abstract class Shape implements Drawable{
     private String linecolor;
     private String fillColor;
     
     //public abstract void draw();

	public String getLinecolor() {
		return linecolor;
	}

	public void setLinecolor(String linecolor) {
		this.linecolor = linecolor;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
}
