package com.gildedrose;

public class GenericItem implements ItemType {

    private Item item;

    public GenericItem(Item item) {

        this.item = item;
    }

    @Override
    public void calculateQuality() {
        item.sellIn = item.sellIn - 1;
        if (canDecreaseQuality()) {
            decreaseQuality();
        }
        if (canDecreaseQualityTwice()) {
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        item.quality = item.quality - 1;
    }

    private boolean canDecreaseQualityTwice() {
        return item.sellIn < 0 && canDecreaseQuality();
    }

    private boolean canDecreaseQuality() {
        return item.quality > 0;
    }
}
