package com.gildedrose;

public class BackStagePass implements ItemType {

    private Item item;

    public BackStagePass(Item item) {
        this.item = item;
    }

    @Override
    public void calculateQuality() {
        item.sellIn = item.sellIn - 1;
        if (canIncreaseQuality()) {
            increaseQuality();

            if (item.sellIn < 11) {
                if (canIncreaseQuality()) {
                    increaseQuality();
                }
            }

            if (item.sellIn < 6) {
                if (canIncreaseQuality()) {
                    increaseQuality();
                }
            }

            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }

    private void increaseQuality() {
        item.quality = item.quality + 1;
    }

    private boolean canIncreaseQuality() {
        return item.quality < 50;
    }
}
