package com.gildedrose;

import java.util.Arrays;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		Arrays.stream(items).map(this::getItemType).forEach(ItemType::calculateQuality);

	}

	private ItemType getItemType(Item item) {
		if(isSulfuras(item.name)){
			return new Sulfuras(item);
		}
		if(isAgedBrie(item.name)){
			return new AgedBrie(item);
		}
		if(isConcertTicker(item.name)){
			return new BackStagePass(item);
		}

		return new GenericItem(item);

	}

	private boolean isSulfuras(String itemName) {
		return itemName.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean isAgedBrie(String itemName) {
		return itemName.equals("Aged Brie");
	}

	private boolean isConcertTicker(String itemName) {
		return itemName.equals("Backstage passes to a TAFKAL80ETC concert");
	}

}
