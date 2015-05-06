package com.gildedrose;

import static com.gildedrose.ItemsRepository.AGED_BRIE;
import static com.gildedrose.ItemsRepository.BACKSTAGE_PASSES;
import static com.gildedrose.ItemsRepository.CONJURED_MANA_CAKE;
import static com.gildedrose.ItemsRepository.ELIXIR_OF_THE_MONGOOSE;
import static com.gildedrose.ItemsRepository.PLUS5_DEXTERITY_VEST;
import static com.gildedrose.ItemsRepository.SULFURAS;
import static com.gildedrose.QualityAssertionBuilder.forItem;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseTest {

	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;
	private static final int EXCEEDING_DAYS_LIMIT = 50;

	private GildedRose gildedRose;
	private Item item;

	@Parameter(value = 0)
	public String itemName;
	@Parameter(value = 1)
	public int expectedQuality;
	@Parameter(value = 2)
	public int daysRemaining;

	@Before
	public void init() {
		ItemsRepository itemsRepository = new ItemsRepository();
		gildedRose = new GildedRose(itemsRepository);
		item = itemsRepository.getItemByName(itemName);
		checkAssertionSellIn();
	}

	private void checkAssertionSellIn() {
		if (daysRemaining > item.getSellIn()) {
			throw new IllegalArgumentException("Misconfigured quality assertion : expected sellin is out of range ("
					+ daysRemaining + "), as item's sellIn is " + item.getSellIn());
		}
	}

	@Parameters(name = "\"{0}\" : expectedQuality={1}, daysRemaining={2} ")
	public static Collection<Object[]> getQualityAssertions() {
		return Arrays.asList(new Object[][] {//
				forItem(CONJURED_MANA_CAKE).expectQuality(6).whenRemainingDaysAre(3),//
						forItem(CONJURED_MANA_CAKE).expectQuality(4).whenRemainingDaysAre(2),//
						forItem(CONJURED_MANA_CAKE).expectQuality(2).whenRemainingDaysAre(1),//
						forItem(CONJURED_MANA_CAKE).expectQuality(MIN_QUALITY).whenRemainingDaysAre(0),//
						forItem(CONJURED_MANA_CAKE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(1),//
						forItem(CONJURED_MANA_CAKE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(2),//
						forItem(CONJURED_MANA_CAKE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(3),//
						forItem(CONJURED_MANA_CAKE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(EXCEEDING_DAYS_LIMIT),//

						forItem(BACKSTAGE_PASSES).expectQuality(20).whenRemainingDaysAre(15),//
						forItem(BACKSTAGE_PASSES).expectQuality(22).whenRemainingDaysAre(13),//
						forItem(BACKSTAGE_PASSES).expectQuality(25).whenRemainingDaysAre(10),//
						forItem(BACKSTAGE_PASSES).expectQuality(27).whenRemainingDaysAre(9),//
						forItem(BACKSTAGE_PASSES).expectQuality(31).whenRemainingDaysAre(7),//
						forItem(BACKSTAGE_PASSES).expectQuality(35).whenRemainingDaysAre(5),//
						forItem(BACKSTAGE_PASSES).expectQuality(38).whenRemainingDaysAre(4),//
						forItem(BACKSTAGE_PASSES).expectQuality(41).whenRemainingDaysAre(3),//
						forItem(BACKSTAGE_PASSES).expectQuality(47).whenRemainingDaysAre(1),//
						forItem(BACKSTAGE_PASSES).expectQuality(50).whenRemainingDaysAre(0),//
						forItem(BACKSTAGE_PASSES).expectQuality(MIN_QUALITY).whenExceedingDaysAre(1),//
						forItem(BACKSTAGE_PASSES).expectQuality(MIN_QUALITY).whenExceedingDaysAre(10),//
						forItem(BACKSTAGE_PASSES).expectQuality(MIN_QUALITY).whenExceedingDaysAre(20),//
						forItem(BACKSTAGE_PASSES).expectQuality(MIN_QUALITY).whenExceedingDaysAre(EXCEEDING_DAYS_LIMIT),//

						forItem(SULFURAS).expectQuality(80).whenRemainingDaysAre(0),//
						forItem(SULFURAS).expectQuality(80).whenExceedingDaysAre(5),//
						forItem(SULFURAS).expectQuality(80).whenExceedingDaysAre(10),//
						forItem(SULFURAS).expectQuality(80).whenExceedingDaysAre(20),//
						forItem(SULFURAS).expectQuality(80).whenExceedingDaysAre(EXCEEDING_DAYS_LIMIT),//

						forItem(ELIXIR_OF_THE_MONGOOSE).expectQuality(7).whenRemainingDaysAre(5),//
						forItem(ELIXIR_OF_THE_MONGOOSE).expectQuality(4).whenRemainingDaysAre(2),//
						forItem(ELIXIR_OF_THE_MONGOOSE).expectQuality(2).whenRemainingDaysAre(0),//
						forItem(ELIXIR_OF_THE_MONGOOSE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(1),//
						forItem(ELIXIR_OF_THE_MONGOOSE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(10),//
						forItem(ELIXIR_OF_THE_MONGOOSE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(20),//
						forItem(ELIXIR_OF_THE_MONGOOSE).expectQuality(MIN_QUALITY).whenExceedingDaysAre(EXCEEDING_DAYS_LIMIT),//

						forItem(AGED_BRIE).expectQuality(0).whenRemainingDaysAre(2),//
						forItem(AGED_BRIE).expectQuality(2).whenRemainingDaysAre(0),//
						forItem(AGED_BRIE).expectQuality(10).whenExceedingDaysAre(4),//
						forItem(AGED_BRIE).expectQuality(22).whenExceedingDaysAre(10),//
						forItem(AGED_BRIE).expectQuality(42).whenExceedingDaysAre(20),//
						forItem(AGED_BRIE).expectQuality(MAX_QUALITY).whenExceedingDaysAre(30),//
						forItem(AGED_BRIE).expectQuality(MAX_QUALITY).whenExceedingDaysAre(24),//
						forItem(AGED_BRIE).expectQuality(MAX_QUALITY).whenExceedingDaysAre(EXCEEDING_DAYS_LIMIT),//

						forItem(PLUS5_DEXTERITY_VEST).expectQuality(20).whenRemainingDaysAre(10),//
						forItem(PLUS5_DEXTERITY_VEST).expectQuality(10).whenRemainingDaysAre(0),//
						forItem(PLUS5_DEXTERITY_VEST).expectQuality(8).whenExceedingDaysAre(1),//
						forItem(PLUS5_DEXTERITY_VEST).expectQuality(MIN_QUALITY).whenExceedingDaysAre(5),//
						forItem(PLUS5_DEXTERITY_VEST).expectQuality(MIN_QUALITY).whenExceedingDaysAre(10),//
						forItem(PLUS5_DEXTERITY_VEST).expectQuality(MIN_QUALITY).whenExceedingDaysAre(EXCEEDING_DAYS_LIMIT),//
				});
	}

	@Test
	public void should_item_quality_be_equal_to_expected_when_aging() {
		System.out.println("\nItem : " + itemName);
		degradeUntilSellInIs(daysRemaining);
		Assert.assertEquals(expectedQuality, item.getQuality());
	}

	private void degradeUntilSellInIs(int sellIn) {
		System.out.println("Aging until item sellIn is " + sellIn);
		int iterationsCount = item.getSellIn() - sellIn;
		for (int i = 0; i < iterationsCount; i++) {
			log();
			gildedRose.updateQuality();
		}
		log();
	}

	private void log() {
		System.out.println("Quality=" + item.quality + "\t; sellIn=" + item.sellIn);
	}
}
