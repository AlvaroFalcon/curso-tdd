package com.gildedrose;

public class AgedBrie implements ItemType {

    private Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void calculateQuality() {
        item.sellIn = item.sellIn - 1;
        if (qualityBelowMax()) {
            increaseQuality();
        }
        if (canIncreaseQualityTwice()) {
            increaseQuality();
        }
    }

    private void increaseQuality() {
        item.quality = item.quality + 1;
    }

    private boolean canIncreaseQualityTwice() {
        return item.sellIn < 0 && qualityBelowMax() && item.quality > 0;
    }

    private boolean qualityBelowMax() {
        return item.quality < 50;
    }
}
