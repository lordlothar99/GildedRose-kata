package com.gildedrose;

public class ItemBuilder {

	private final String name;
	private int sellIn;
	private int quality;

	private ItemBuilder(String name) {
		super();
		this.name = name;
	}

	public static ItemBuilder item(String name) {
		return new ItemBuilder(name);
	}

	public ItemBuilder withSellIn(int sellIn) {
		this.sellIn = sellIn;
		return this;
	}

	public ItemBuilder withQuality(int quality) {
		this.quality = quality;
		return this;
	}

	public Item build() {
		return new Item(name, sellIn, quality);
	}
}
