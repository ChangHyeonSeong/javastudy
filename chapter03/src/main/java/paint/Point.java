package paint;

public class Point {
       private int x;
       private int y;
       
    public void draw() {   
    	System.out.println("점[x=" + this.x + " y=" + this.y + "]");
    }
    
	public void show() {
		System.out.println("점[x=" + this.x + " y=" + this.y + "]을 그렸습니다.");
	}
	
	public void show(boolean visible) {
	    if(visible) {
	    	//System.out.println("점[x=" + this.x + " y=" + this.y + "]을 그렸습니다.");
	    	show();
	    }else {
	    	System.out.println("점[x=" + this.x + " y=" + this.y + "]을 지웠습니다.");
	    }
	}
    
//	public void disapear() {
//		System.out.println("점[x=" + this.x + " y=" + this.y + "]을 지웠습니다");
//	}
    
    
       
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}




       
       
}
