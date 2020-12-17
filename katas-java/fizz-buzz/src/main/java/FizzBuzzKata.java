import java.util.ArrayList;
import java.util.List;

public class FizzBuzzKata {
    public List<String> execute() {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if(isFizzBuzz(i)) {
                resultList.add("FizzBuzz");
            }else if(isFizz(i)){
                resultList.add("Fizz");
            }else if(isBuzz(i)){
                resultList.add("Buzz");
            }else{
                resultList.add(String.valueOf(i));
            }
        }
        return resultList;
    }

    private boolean isFizz(int number) {
        return isDivisibleBy(number, 3);
    }

    private boolean isBuzz(int number) {
        return isDivisibleBy(number, 5);
    }

    private boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }

    private boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}
