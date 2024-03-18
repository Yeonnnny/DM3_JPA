package color;

public class MyColorTest {

	public static void main(String[] args) {

		MyColor color = MyColor.남색;
		System.out.println("========");
		System.out.println(color);
		
		
		// 전체 데이터를 배열로 반환
		MyColor[] colors = MyColor.values();
		for (MyColor c : colors) {
			System.out.println(c);
			System.out.println(c.getColor());
		}
		System.out.println("==================");
		
		
		MyColor c = MyColor.valueOf("주황"); // enum(열거형) 데이터만 가져옴  
		// valueof(문자열) : 문자열을 전달하면 문자열과 맞아 떨어지는 값을 enum 타입으로 반환
		System.out.println(c);
		System.out.println(c.getColor()); // c에 해당하는 값을 가져옴
		System.out.println(MyColor.valueOf("노랑").getColor());
		
		
		System.out.println("========"); 
		
		int index = MyColor.valueOf("빨강").ordinal(); // ordinal() : 순서값을 가져오기 위한 함수
		System.out.println("빨강의 인덱스 : "+index);
	
		System.out.println();

		MyColor c2 = MyColor.valueOf("보라"); // enum 데이터만 가져옴
		switch (c2) {
			case 빨강: System.out.println("빨강을 선택함");break;
			case 노랑: System.out.println("노랑을 선택함");break;
			case 초록: System.out.println("초록을 선택함");break;
			case 파랑: System.out.println("파랑을 선택함");break;
			case 남색: System.out.println("남색을 선택함");break;
			case 보라: System.out.println("보라를 선택함");break;
		}
		
	}

}
