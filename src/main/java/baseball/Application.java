package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);

    public static int check3Strike(String str){
        int answer = 0;
        if (str.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
             answer = sc.nextInt();
        }
        return answer;
    }

    //스트라이크 개수 체크
    public static String strikeCheck(int cnt){
        String str;
        switch (cnt){
            case 1:str="1스트라이크";break;
            case 2:str="2스트라이크";break;
            case 3:str="3스트라이크";break;
            default:str=null;
        }
        return str;
    }

    //볼 개수 체크
    public static String ballCheck(int cnt){
        String str;
        switch (cnt){
            case 1:str="1볼";break;
            case 2:str="2볼";break;
            case 3:str="3볼";break;
            default:str=null;
        }
        return str;
    }

    public static String numberCheck(int[] number, List<Integer> randNumber){
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < number.length; i++){
            if(number[i]==randNumber.get(i))
                cnt1++;
            else if(randNumber.contains(number[i]))
                cnt2++;
        }
        String str1 = strikeCheck(cnt1);
        String str2 = ballCheck(cnt2);
        if(str1==null&&str2==null)
            return "낫싱";
        else if(str2==null)
            return str1;
        else if (str1==null)
            return str2;
        else
            return str2 + " " + str1;
    }

    //입력받은 정수 배열로 변환
    public static int[] numberTrans(int number){
        int arr[] = new int[3];
        int i = 2;
        while(number > 0){
            arr[i] = number % 10;
            number/=10;
            i--;
        }
        return arr;
    }

    //컴퓨터 난수 생성 메소드
    public static List<Integer> randNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int rand = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(rand)){
                computer.add(rand);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randNumber = randNumber();
        while(true) {

            System.out.println(randNumber);
            System.out.print("숫자를 입력해주세요 : ");
            int number = sc.nextInt();
            int arr[] = numberTrans(number);
            String str = numberCheck(arr, randNumber);
            System.out.println(str);
            int answer = check3Strike(str);
            if(answer==1)
                randNumber = randNumber();
            else if(answer==2)
                break;


        }
    }
}
