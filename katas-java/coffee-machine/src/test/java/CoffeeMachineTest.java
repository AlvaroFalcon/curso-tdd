import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMachineTest {
  CoffeeMachine coffeMachine;
  DrinkMaker drinkMaker;

  @BeforeEach
  void setUp() {
    drinkMaker = mock(DrinkMaker.class);
    coffeMachine = new CoffeeMachine(drinkMaker);
  }

  @Test
  public void make_coffee_with_sugar() {
    coffeMachine.setCash(0.6);

    coffeMachine.makeCoffee(CoffeeMachine.SugarQuantity.ONE, false);

    verify(drinkMaker, times(1)).execute("C:1:0");
  }

  @Test
  public void make_coffee_with_no_sugar() {
    coffeMachine.setCash(0.6f);

    coffeMachine.makeCoffee(CoffeeMachine.SugarQuantity.NONE, false);

    verify(drinkMaker, times(1)).execute("C::");
  }

  @Test
  public void make_tea_with_sugar() {
    coffeMachine.setCash(0.4f);

    coffeMachine.makeTea(CoffeeMachine.SugarQuantity.ONE, false);

    verify(drinkMaker, times(1)).execute("T:1:0");
  }

  @Test
  public void make_tea_with_no_sugar() {
    coffeMachine.setCash(0.4f);

    coffeMachine.makeTea(CoffeeMachine.SugarQuantity.NONE, false);

    verify(drinkMaker, times(1)).execute("T::");
  }

  @Test
  public void make_chocolate_with_sugar() {
    coffeMachine.setCash(0.5f);

    coffeMachine.makeChocolate(CoffeeMachine.SugarQuantity.ONE, false);

    verify(drinkMaker, times(1)).execute("H:1:0");
  }

  @Test
  public void make_chocolate_with_no_sugar() {
    coffeMachine.setCash(0.5f);

    coffeMachine.makeChocolate(CoffeeMachine.SugarQuantity.NONE, false);

    verify(drinkMaker, times(1)).execute("H::");
  }

  @Test
  public void display_message_in_the_machine() {
    coffeMachine.displayMessage("Esta rico");

    verify(drinkMaker, times(1)).execute("M:Esta rico");
  }

  @Test
  public void return_money_left_if_theres_not_enough_money_to_make_drink() {
    coffeMachine.setCash(0.4);
    coffeMachine.makeChocolate(CoffeeMachine.SugarQuantity.NONE, false);

    verify(drinkMaker, times(1)).execute("M:0.1");
  }

  @Test
  public void should_make_the_drink_if_the_provided_money_is_enough() {
    coffeMachine.setCash(0.5);

    coffeMachine.makeChocolate(CoffeeMachine.SugarQuantity.NONE, false);

    verify(drinkMaker, times(1)).execute("H::");
  }

  @Test
  public void should_make_orange_juice() {
    coffeMachine.setCash(0.6);

    coffeMachine.makeOrangeJuice(CoffeeMachine.SugarQuantity.NONE);

    verify(drinkMaker, times(1)).execute("O::");
  }

  @Test
  public void should_make_extra_hot_drink() {
    coffeMachine.setCash(0.6);

    coffeMachine.makeCoffee(CoffeeMachine.SugarQuantity.NONE, true);

    verify(drinkMaker, times(1)).execute("Ch::");

    coffeMachine.makeTea(CoffeeMachine.SugarQuantity.NONE, true);

    verify(drinkMaker, times(1)).execute("Th::");

    coffeMachine.makeChocolate(CoffeeMachine.SugarQuantity.TWO, true);

    verify(drinkMaker, times(1)).execute("Hh:2:0");
  }
}
