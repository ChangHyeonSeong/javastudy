package com.douzone.paint.point;


public class ColorPoint extends Point {
     private String color;
    
     
    public ColorPoint(int x, int y, String color) {
    	super(x, y);
    	//setX(x);
    	//setY(y);
    	
    	
    	this.color = color;
    }
	public String getColor() {
		return color;
	}

	@Override //어노테이션 컴파일러가 오버라이딩가능한지검사 외부에서 사용 스프링부트에서 많이사용
	public void show() {
		System.out.println("점[x=" + getX() + ", y=" + getY() + ", color = " + getColor() + "]을 그렸습니다.");
	}

	public void setColor(String color) {
		this.color = color;
	}
     
}
