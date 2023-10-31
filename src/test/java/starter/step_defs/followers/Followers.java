package starter.step_defs.followers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.followers.FollowersAPI;

public class Followers {
    @Given("Follow user with id {string}")
    public void followUserWithId(String id) {
        FollowersAPI.setFollowingUsersById(id);
    }

    @When("Send request post follow user")
    public void sendRequestPostFollowUser() {
        SerenityRest.when().post(FollowersAPI.POST_FOLLOW);
    }

    @Given("Unfollow user with id {string}")
    public void unfollowUserWithId(String id) {
        FollowersAPI.setFollowingUsersById(id);
    }

    @When("Send request delete unfollow user")
    public void sendRequestDeleteUnfollowUser() {
        SerenityRest.when().delete(FollowersAPI.DELETE_UNFOLLOW);
    }
}
