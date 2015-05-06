package com.gildedrose.controllers;

import static com.gildedrose.ItemsRepository.MAX_QUALITY;
import static com.gildedrose.ItemsRepository.MIN_QUALITY;
import static java.lang.Math.max;
import static java.lang.Math.min;

import com.gildedrose.Item;

public abstract class AbstractQualityController implements IQualityController {

	@Override
	public final void updateQuality(Item item) {
		updateSellIn(item);
		if (isOutDated(item)) {
			updateQualityOutdated(item);
		} else {
			updateQualityNormal(item);
		}
	}

	protected abstract void updateQualityOutdated(Item item);

	protected abstract void updateQualityNormal(Item item);

	private void updateSellIn(Item item) {
		item.setSellIn(item.getSellIn() - 1);
	}

	private boolean isOutDated(Item item) {
		return item.getSellIn() < 0;
	}

	protected void updateQuality(Item item, int qualityVariation) {
		item.setQuality(max(MIN_QUALITY, min(MAX_QUALITY, item.getQuality() + qualityVariation)));
	}
}
