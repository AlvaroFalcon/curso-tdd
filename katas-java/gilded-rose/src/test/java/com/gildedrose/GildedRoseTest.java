package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {

  @Test
  public void quality_should_degrade_double_if_the_date_has_passed() {
    Item[] items = new Item[]{new Item("foo", 0, 30)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(28, app.items[0].quality);
    assertEquals(-1, app.items[0].sellIn);
  }

  @Test
  public void quality_should_not_be_negative() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
    assertEquals(-1, app.items[0].sellIn);
  }

  @Test
  public void aged_brie_should_increase_quality_over_time() {
    Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(1, app.items[0].quality);
    assertEquals(0, app.items[0].sellIn);
  }

  @Test
  public void item_quality_should_never_be_more_than_50() {
    Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(50, app.items[0].quality);
    assertEquals(0, app.items[0].sellIn);
  }

  @Test
  public void sulfuras_should_not_decrease_days_and_should_mantain_quality() {
    Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 20)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(20, app.items[0].quality);
    assertEquals(0, app.items[0].sellIn);
  }

  @Test
  public void backstage_passes_should_increase_quality() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 30, 30)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(31, app.items[0].quality);
    assertEquals(29, app.items[0].sellIn);
  }

  @Test
  public void backstage_passes_should_increase_quality_by_two_when_sellin_is_10_or_less() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(32, app.items[0].quality);
    assertEquals(9, app.items[0].sellIn);
  }

  @Test
  public void backstage_passes_should_increase_quality_by_three_when_sellin_is_5_or_less() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(33, app.items[0].quality);
    assertEquals(4, app.items[0].sellIn);
  }

  @Test
  public void backstage_passes_should_drop_quuality_to_0_when_the_sellin_is_over() {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
    assertEquals(-1, app.items[0].sellIn);
  }

  @Test
  public void fix_me_conjured() {
    Item[] items = new Item[]{new Item("Conjured", 0, 30)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertTrue(false);
  }


}
