package com.gildedrose.controllers;

import static com.gildedrose.ItemsRepository.MIN_QUALITY;

import com.gildedrose.Item;

public class BackstageQualityController extends AbstractQualityController {

	@Override
	protected void updateQualityNormal(Item item) {
		updateQuality(item, 1);
		if (isSellinBelow(item, 10)) {
			updateQuality(item, 1);
		}
		if (isSellinBelow(item, 5)) {
			updateQuality(item, 1);
		}
	}

	private boolean isSellinBelow(Item item, int threshold) {
		return item.getSellIn() < threshold;
	}

	@Override
	protected void updateQualityOutdated(Item item) {
		item.setQuality(MIN_QUALITY);
	}
}
