package com.gildedrose;

public class QualityAssertionBuilder {

	private int quality;
	private final String itemName;

	public QualityAssertionBuilder(String itemName) {
		super();
		this.itemName = itemName;
	}

	public static QualityAssertionBuilder forItem(String itemName) {
		return new QualityAssertionBuilder(itemName);
	}

	public QualityAssertionBuilder expectQuality(int quality) {
		this.quality = quality;
		return this;
	}

	public Object[] whenRemainingDaysAre(int days) {
		return new Object[] { itemName, quality, days };
	}

	public Object[] whenExceedingDaysAre(int days) {
		return new Object[] { itemName, quality, -days };
	}
}
