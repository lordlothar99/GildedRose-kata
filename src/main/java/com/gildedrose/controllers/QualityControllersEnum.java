package com.gildedrose.controllers;

import static com.gildedrose.ItemsRepository.AGED_BRIE;
import static com.gildedrose.ItemsRepository.BACKSTAGE_PASSES;
import static com.gildedrose.ItemsRepository.CONJURED_MANA_CAKE;
import static com.gildedrose.ItemsRepository.ELIXIR_OF_THE_MONGOOSE;
import static com.gildedrose.ItemsRepository.PLUS5_DEXTERITY_VEST;
import static com.gildedrose.ItemsRepository.SULFURAS;

public enum QualityControllersEnum {

	AGED_BRIE_VAR(AGED_BRIE, new SimpleQualityController(1, 2)), //
	BACKSTAGE_PASSES_VAR(BACKSTAGE_PASSES, new BackstageQualityController()), //
	CONJURED_MANA_CAKE_VAR(CONJURED_MANA_CAKE, new SimpleQualityController(-2, -4)), //
	ELIXIR_OF_THE_MONGOOSE_VAR(ELIXIR_OF_THE_MONGOOSE, new SimpleQualityController(-1, -2)), //
	PLUS5_DEXTERITY_VEST_VAR(PLUS5_DEXTERITY_VEST, new SimpleQualityController(-1, -2)), //
	SULFURAS_VAR(SULFURAS, new SulfurasQualityController()), //
	;

	private final String itemName;
	private final IQualityController qualityController;

	private QualityControllersEnum(String itemName, IQualityController qualityController) {
		this.itemName = itemName;
		this.qualityController = qualityController;
	}

	public static IQualityController controllerByItemName(String itemName) {
		for (QualityControllersEnum qualityControllerEnum : values()) {
			if (itemName.equals(qualityControllerEnum.itemName)) {
				return qualityControllerEnum.qualityController;
			}
		}
		return null;
	}
}
