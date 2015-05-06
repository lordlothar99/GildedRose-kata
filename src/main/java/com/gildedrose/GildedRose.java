package com.gildedrose;

import static com.gildedrose.controllers.QualityControllersEnum.controllerByItemName;

import com.gildedrose.controllers.IQualityController;

public class GildedRose {

	private final ItemsRepository itemsRepository;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ItemsRepository itemsRepository = new ItemsRepository();
		GildedRose gildedRose = new GildedRose(itemsRepository);
		gildedRose.updateQuality();
	}

	public GildedRose(ItemsRepository itemsRepository) {
		super();
		this.itemsRepository = itemsRepository;
	}

	public void updateQuality() {
		for (Item item : itemsRepository.getItems()) {
			IQualityController qualityController = controllerByItemName(item.name);
			qualityController.updateQuality(item);
		}
	}
}