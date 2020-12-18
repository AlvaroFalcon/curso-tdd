import java.math.BigDecimal;
import java.math.MathContext;

public class CoffeeMachine {
    DrinkMaker drinkMaker;
    private double providedMoney;
    private static final double COFFEE_COST = 0.6;
    private static final double TEA_COST = 0.4;
    private static final double CHOCOLATE_COST = 0.5;
    private static final double ORANGE_JUICE_COST = 0.6;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void makeCoffee(SugarQuantity sugarQuantity, boolean extraHot) {
        makeDrink(sugarQuantity, COFFEE_COST, extraHot ? "Ch" : "C");
    }

    private void makeDrink(SugarQuantity sugarQuantity, double coffeeCost, String c) {
        if (hasEnoughMoney(coffeeCost)) {
            drinkMaker.execute(constructOrder(c, sugarQuantity));
        } else {
            sendErrorMessage(coffeeCost);
        }
    }

    public void makeTea(SugarQuantity sugarQuantity, boolean extraHot) {
        makeDrink(sugarQuantity, TEA_COST, extraHot ? "Th": "T");
    }

    public void makeChocolate(SugarQuantity sugarQuantity, boolean extraHot) {
        makeDrink(sugarQuantity, CHOCOLATE_COST, extraHot ? "Hh" : "H");
    }

    private void sendErrorMessage(double cost){
        BigDecimal drinkCostBigDecimal = new BigDecimal(cost);
        BigDecimal providedMoneyBigDecimal = new BigDecimal(providedMoney);
        var result = drinkCostBigDecimal.subtract(providedMoneyBigDecimal,new MathContext(1));
        drinkMaker.execute("M:" + result.doubleValue());
    }

    private String constructOrder(String command, SugarQuantity quantity){
        return command+":"+getSugarAndStick(quantity.getQuantity());
    }

    private boolean hasEnoughMoney(double cost) {
        return providedMoney >= cost;
    }


    public void displayMessage(String message) {
        drinkMaker.execute("M:"+message);
    }

    private String getSugarAndStick(int sugarQuantity) {
        return sugarQuantity > 0 ? sugarQuantity + ":0" : ":";
    }

    public void setCash(double money) {
        providedMoney = money;
    }

    public void makeOrangeJuice(SugarQuantity sugarQuantity) {
        makeDrink(sugarQuantity, ORANGE_JUICE_COST, "O");
    }

    public static enum SugarQuantity{
        NONE(0),
        ONE(1),
        TWO(2);

        public int getQuantity() {
            return quantity;
        }

        private final int quantity ;

        SugarQuantity(int i) {
            quantity = i;
        }
    }
}
