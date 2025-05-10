import java.util.Scanner;

public class midterm_01 {
    public static void main(String[] args) {
        System.out.print("가위 바위 보 게임\n");
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        	menu();
        	
        	int user = select(sc);
        	if (user == 0)
        		break;
        	
        	int comp = (int)(Math.random() * 3) + 1;
        	String userC = Hand(user);
        	String compC = Hand(comp);
        	
        	System.out.println("사용자 vs 컴퓨터");
        	System.out.println(userC + "vs" + compC);
        	
        	Result(userC, compC);
        }
        sc.close();
    }


    public static void menu() {
    	System.out.println("--------------");
    	System.out.println("{1} 가위");
    	System.out.println("{2} 바위");
    	System.out.println("{3} 보");
    	System.out.println("{0} 종료");
    	System.out.println("--------------");
    }

    public static int select(Scanner sc) {
    	int choice = 0;
    	
    	System.out.print("선택: ");
    	choice = sc.nextInt();
    	
    	if (choice < 0 || choice > 3) {
    		System.out.println("선택지 중에서 하나를 골라주세요.\n");
    		System.out.print("선택: ");
    		choice = sc.nextInt();
    	}
    	return choice;
    }
    
    public static String Hand(int choice) {
    	if (choice == 1)
    		return "가위";
    	else if (choice == 2)
    		return "바위";
    	else
    		return "보";
    }

    public static void Result(String userC, String compC) {
    	if (userC == compC) {
    		System.out.println("비겼습니다");
    	}
    	else if (userC == "가위") {
    		if (compC == "보")
    			System.out.println("이겼습니다!");
    		else if (compC == "바위")
    			System.out.println("졌습니다..ㅠㅠ");
    		
    	}
    	
    	else if (userC == "바위") {
    		if (compC == "가위")
    			System.out.println("이겼습니다!");
    		else if (compC == "보")
    			System.out.println("졌습니다..ㅠㅠ");
    	}

    	else if (userC == "보") {
    		if (compC == "바위")
    			System.out.println("이겼습니다!");
    		else if (compC == "가위")
    			System.out.println("졌습니다..ㅠㅠ");
    	}
    }
}

