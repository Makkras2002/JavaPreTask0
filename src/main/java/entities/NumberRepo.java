package entities;

import java.util.ArrayList;
import java.util.List;

public class NumberRepo {
    public List<SomeNumber> numberList = new ArrayList<>();
    public void addNumber(SomeNumber number){
        numberList.add(number);
    }
    public void clearList(){
        numberList.clear();
    }
}
