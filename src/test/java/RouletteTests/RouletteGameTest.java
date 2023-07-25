package RouletteTests;
import com.github.zipcodewilmington.casino.games.gamblingGames.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
public class RouletteGameTest {
    @Test
    // Test case: Betting an amount greater than the balance
    public void testBettingAmountGreaterThanBalance() {
        RouletteGame game = new RouletteGame();
        //Given
        game.balance = 500;
        //When
        game.evaluateResult("Relax, YOU DON'T HAVE ENOUGH MONEY! HIT THE ATM ASAP!");;
        //Then
    }
    @Test
    // Test case: Betting 0 to quit the game
    public  void testBettingZeroToQuit() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 0;
        // When
        game.evaluateResult("THANK YOU FOR PLAYING! SPEND ALL YOUR MONEY!!!!");
        // Then
    }
    @Test
    // Test case: Winning the bet
    public  void testWinningBet() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 50;
        // When
        game.evaluateResult("even");
        // Then
        // Expected output: "GREAT GUESS! YOU WON  DOLLARS!"
        // Expected balance after winning: 1050
    }
    @Test
    // Test case: Losing the bet
    public  void testLosingBet() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 25;
        //When
        // Assume the random spin number is odd and the prediction is "even"
        game.evaluateResult("even");
        // When
        // Expected output: "SORRY MAYBE NEXT TIME! YOU LOST 75 DOLLARS"
        // Expected balance after losing: 975
    }
}














