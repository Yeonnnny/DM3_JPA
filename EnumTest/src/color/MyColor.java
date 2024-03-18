package color;

public enum MyColor {
	빨강("RED"), 주황("ORANGE"), 노랑 ("YELLOW")
	,초록("GREEN"), 파랑("BLUE"), 남색("DARKBLUE"), 보라("PUPPLE");
		
	// 한글과 영어를 같이 쓰려면, 생성자를 만들어줘야 함
	private String color;
	
	private MyColor(String color) { // 생성자가 private임
		System.out.println("생성자:"+color);
		this.color=color;
	}
	
	public String getColor() { // 별칭을 사용하기 위한 함수
		return color;
	}
	
}
