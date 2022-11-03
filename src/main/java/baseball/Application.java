package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);

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
        System.out.print("숫자를 입력해주세요 : ");
        int number = sc.nextInt();




    }
}
