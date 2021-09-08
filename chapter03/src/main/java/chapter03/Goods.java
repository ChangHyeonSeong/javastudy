package chapter03;

public class Goods {
	public static int countOfGoods = 0;
    private String name;
    private int price;
    private int countStock;
    private int countSold;
    
    public Goods() {
    	//Goods.countOfGoods = Goods.countOfGoods +1 ;
    	countOfGoods = countOfGoods +1 ; //위코드와 같다 같은 클래스 내에선 생략가능
    }
    
    public void showInfo() {
    	System.out.println("name:" + name + 
    			                 ", pricae:" + price + 
    			                 ", countStock" + countStock + 
    			                 ", countSold:" + countSold);
    }
    
    public int calcDiscountPrice(int parcentage) {
    	return price * parcentage / 100;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
}
