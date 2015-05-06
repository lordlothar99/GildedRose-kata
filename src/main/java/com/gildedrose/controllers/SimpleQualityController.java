package com.gildedrose.controllers;

import com.gildedrose.Item;

public class SimpleQualityController extends AbstractQualityController {

	private final int normalQualityVariation;
	private final int outdatedQualityVariation;

	public SimpleQualityController(int normalQualityVariation, int outdatedQualityVariation) {
		this.normalQualityVariation = normalQualityVariation;
		this.outdatedQualityVariation = outdatedQualityVariation;
	}

	@Override
	protected void updateQualityNormal(Item item) {
		updateQuality(item, normalQualityVariation);
	}

	@Override
	protected void updateQualityOutdated(Item item) {
		updateQuality(item, outdatedQualityVariation);
	}
}
