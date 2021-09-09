package tv;

public class TV {
	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		if(on) {
			this.power = on;
			System.out.println("Power On");
		}
		else {
			this.power = on;
			System.out.println("Power Off");
		}
	}
	
	public void channel(int channel) {
		if(channel >= 1 && channel <= 255 ) {
			this.channel = channel;
		}
		else {
			System.out.println("없는채널입니다.");
		}
	}
	
	public void channel(boolean up) {
		//channel (channel + (up ? :           삼항연산자
		if(up){
			if(this.channel == 255) {
			     this.channel = 1;
			}
			else {
				this.channel += 1;
			}
		}
		else {
			if(this.channel == 1) {
			     this.channel = 255;
			}
			else {
				this.channel -= 1;
			}
		}
		
	   
	}
	
	public void volume(int volume) {
		if(volume >= 0 && volume <= 100) {
			this.volume = volume;
		}
		else {
			System.out.println("볼륨은 0에서  100까지 설정 가능 합니다. ");
		}
	}
	
	public void volume(boolean up) {
		if(up) {
			if(this.volume < 100) {
				this.volume += 1;
			}
		}
		else {
			if(this.volume > 0) {
				this.volume -= 1;
			}
		}
	}
	
	public void status() {
	       System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
	
	
}
