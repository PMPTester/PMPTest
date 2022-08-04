import org.junit.Assert;
import org.junit.Test;

public class GiftCardTest {

    @Test
    public void testTwentyFiveDollarGiftCard() {
        GiftCard giftCard = new GiftCard();
        String match = giftCard.findPair("src\\main\\resources\\prices.txt", 2500);
        Assert.assertTrue("Candy Bar 500, Earmuffs 2000".equalsIgnoreCase(match));
    }

    @Test
    public void testTwentyThreeDollarGiftCard() {
        GiftCard giftCard = new GiftCard();
        String match = giftCard.findPair("src\\main\\resources\\prices.txt", 2300);
        Assert.assertTrue("Paperback Book 700, Headphones 1400".equalsIgnoreCase(match));
    }

    @Test
    public void testElevenDollarGiftCard() {
        GiftCard giftCard = new GiftCard();
        String match = giftCard.findPair("src\\main\\resources\\prices.txt", 1100);
        Assert.assertTrue(GiftCard.NOT_POSSIBLE.equalsIgnoreCase(match));
    }

}