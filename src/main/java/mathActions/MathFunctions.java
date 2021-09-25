package mathActions;

import entities.NumberRepo;
import entities.SomeNumber;

public class MathFunctions {
    public static float countSum(NumberRepo repo){
        float sum =0;
        for(SomeNumber o : repo.numberList){
            sum+= o.getNumber();
        }
        return sum;
    }
    public static float countDiff(NumberRepo repo){
        int counter = 0;
        float res =0;
        for(SomeNumber o : repo.numberList){

            if(counter ==0){
                res = o.getNumber();
            }
            else {
                res -= o.getNumber();
            }
            counter++;
        }
        return res;
    }
    public static float countMulti(NumberRepo repo){
        float res =1;
        for(SomeNumber o : repo.numberList){
            res*= o.getNumber();
        }
        return res;
    }
    public static float countDiv(NumberRepo repo){
        int counter = 0;
        float res =0;
        for(SomeNumber o : repo.numberList){

            if(counter ==0){
                res = o.getNumber();
            }
            else {
                res /= o.getNumber();
            }
            counter++;
        }
        return res;
    }
}
