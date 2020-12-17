import java.util.ArrayList;
import java.util.List;

public class FizzBuzzKata {
    public List<String> execute() {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            String result = "";
            if(isFizz(i)){
                result += "Fizz";
            }
            if(isBuzz(i)){
                result += "Buzz";
            }
            if(result.isEmpty()){
                result = String.valueOf(i);
            }
            resultList.add(result);
        }
        return resultList;
    }

    private boolean isFizz(int number) {
        return isDivisibleBy(number, 3) || String.valueOf(number).contains("3");
    }

    private boolean isBuzz(int number) {
        return isDivisibleBy(number, 5) || String.valueOf(number).contains("5");
    }

    private boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}
