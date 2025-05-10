import java.util.Scanner;
import java.util.Random;

public class midterm_02 {

	public static void main(String[] args) {
		System.out.println("가위바위보 하나빼기!");
			gameStart();
	}

	public static void gameStart() {
	    Scanner sc = new Scanner(System.in);
	    Random random = new Random();

	    while (true) {
	        System.out.println("-- 가위(1), 바위(2), 보(3) 중 두 개 입력 (종료: 0) --");

	        int gs1, gs2;

	        // 첫 입력 유효성 검사
	        while (true) {
	            System.out.print("입력1: ");
	            gs1 = sc.nextInt();
	            if (gs1 == 0) {
	                System.out.println("게임을 종료합니다.");
	                System.exit(0);
	            }
	            if (gs1 < 1 || gs1 > 3) {
	                System.out.println("1, 2, 3 중에서 입력하세요.");
	                continue;
	            }
	            break;
	        }

	        // 두 번째 입력 유효성 검사
	        while (true) {
	            System.out.print("입력2: ");
	            gs2 = sc.nextInt();
	            if (gs2 == 0) {
	                System.out.println("게임을 종료합니다.");
	                System.exit(0);
	            }
	            if (gs2 < 1 || gs2 > 3) {
	                System.out.println("1, 2, 3 중에서 입력하세요.");
	                continue;
	            }
	            break;
	        }

	        // 컴퓨터 선택
	        int com1 = random.nextInt(3) + 1;
	        int com2 = random.nextInt(3) + 1;

	        System.out.println("당신이 낸 것: " + gs1 + ", " + gs2);
	        System.out.println("컴퓨터가 낸 것: " + com1 + ", " + com2);

	        // 사용자 하나 선택
	        int userChoice;
	        while (true) {
	            System.out.println("하나 빼기! (남길 번호 입력, 종료: 0)");
	            System.out.print("입력: ");
	            userChoice = sc.nextInt();

	            if (userChoice == 0) {
	                System.out.println("게임을 종료합니다.");
	                System.exit(0);
	            }

	            if (userChoice != gs1 && userChoice != gs2) {
	                System.out.println("두 값 중 하나만 선택하세요.");
	                continue;
	            }
	            break;
	        }

	        // 컴퓨터도 하나 랜덤 선택
	        int[] comChoices = {com1, com2};
	        int comChoice = comChoices[random.nextInt(2)];

	        System.out.println("당신의 선택: " + convert(userChoice));
	        System.out.println("컴퓨터의 선택: " + convert(comChoice));

	        // 승부 판단
	        int result = judge(userChoice, comChoice);
	        if (result == 1) {
	            System.out.println("당신의 승리!");
	        } else if (result == -1) {
	            System.out.println("컴퓨터의 승리!");
	        } else {
	            System.out.println("비겼습니다!");
	        }

	        System.out.println();
	    }
	}
	
	public static int judge(int user, int com) {
	    if (user == com) return 0;
	    if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
	        return 1;
	    } else {
	        return -1;
	    }
	}
	

	public static String convert(int num) {
	    switch(num) {
	        case 1: return "가위";
	        case 2: return "바위";
	        case 3: return "보";
	        default: return "알 수 없음";
	    }
	}
}