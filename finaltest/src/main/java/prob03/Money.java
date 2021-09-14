package prob03;

import java.util.Objects;

public class Money {
    
	private int amount; 	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Object add(Object money) {
		Object object =  new Money(this.amount  + ((Money)money).getAmount());
		return  object;
	}

	public Object minus(Object money) {
		Object object =  new Money(this.amount  - ((Money)money).getAmount());
		return  object;
	}

	public Object multiply(Money money) {
		Object object =  new Money(this.amount  * ((Money)money).getAmount());
		return  object;
	}
	public Object devide(Money money) {
		Object object =  new Money(this.amount  / ((Money)money).getAmount());
		return  object;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount) ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
//		if(!(obj instanceof Money)) {
//			return false;
//		}else {
//			if(getAmount() == ((Money)obj).getAmount()) {
//				return true;
//			}
//		}
		return getAmount() == ((Money)obj).getAmount();
	}

	
	
	
	
}
