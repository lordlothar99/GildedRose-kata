package com.gildedrose;

import static com.gildedrose.ItemBuilder.item;

import java.util.ArrayList;

public class ItemsRepository {

	public static final int MAX_QUALITY = 50;
	public static final int MIN_QUALITY = 0;
	public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
	public static final String AGED_BRIE = "Aged Brie";
	public static final String PLUS5_DEXTERITY_VEST = "+5 Dexterity Vest";
	private final ArrayList<Item> items;

	public ItemsRepository() {
		items = new ArrayList<Item>();
		items.add(item(PLUS5_DEXTERITY_VEST).withSellIn(10).withQuality(20).build());
		items.add(item(AGED_BRIE).withSellIn(2).withQuality(0).build());
		items.add(item(ELIXIR_OF_THE_MONGOOSE).withSellIn(5).withQuality(7).build());
		items.add(item(SULFURAS).withSellIn(0).withQuality(80).build());
		items.add(item(BACKSTAGE_PASSES).withSellIn(15).withQuality(20).build());
		items.add(item(CONJURED_MANA_CAKE).withSellIn(3).withQuality(6).build());
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public Item getItemByName(String name) {
		for (Item item : items) {
			if (item.name.equals(name)) {
				return item;
			}
		}
		throw new IllegalArgumentException("Unknown item " + name);
	}
}
