package prob2;

public class MusicPhone extends Phone {

	@Override
	public void execute(String function) {
		if(function.equals("음악")) {
			playmusic();
			return;
		}
		super.execute(function);
	}

	private void playmusic() {
		System.out.println("MP3 플레이어에서 음악재생");
	}

}
