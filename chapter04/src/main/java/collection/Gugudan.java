package collection;

public class Gugudan {
      private int left;
      private int right;
      
      public Gugudan(int left, int right) {
    	  this.left = left;
    	  this.right = right;
      }

	@Override
	public String toString() {
		return "Gugudan " + "[left=" +getLeft()  +", right=" + getRight() + "]" ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
		return left * right == other.left * other.right;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
      
      
}
