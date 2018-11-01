package hellocucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class IsItFriday {

  static String isItFriday(String today) {
    if (today.equals("Friday")) {
      return "TGIF";
    }
    return "Nope";
  }
}

public class Stepdefs {

  private String today;
  private String actualAnswer;

  private int length;

  @Given("^today is \"([^\"]*)\"$")
  public void today_is(String today) throws Exception {
    this.today = today;
  }

  @When("^I ask whether it's Friday yet$")
  public void i_ask_whether_it_s_Friday_yet() {
    this.actualAnswer = IsItFriday.isItFriday(today);
  }

  @Then("^I should be told \"([^\"]*)\"$")
  public void i_should_be_told(String expectedAnswer) {
    assertEquals(expectedAnswer, actualAnswer);
  }


  @When("^the Maker starts a game$")
  public void the_Maker_starts_a_game() throws Exception {
    throw new PendingException();
  }

  @Then("^the Maker waits for a Breaker to join$")
  public void the_Maker_waits_for_a_Breaker_to_join() throws Exception {
    throw new PendingException();
  }

  @Given("^the Maker has started a game with the word \"([^\"]*)\"$")
  public void the_Maker_has_started_a_game_with_the_word(String string) {
    this.length = string.length();
  }

  @When("^the Breaker joins the Maker's game$")
  public void the_Breaker_joins_the_Maker_s_game() {
    throw new PendingException();
  }

  @Then("^the Breaker must guess a word with (\\d+) characters$")
  public void the_Breaker_must_guess_a_word_with_characters(int length) {
    assertEquals(this.length, length);
  }
}