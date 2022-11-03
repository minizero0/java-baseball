package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {

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
        
    }
}
