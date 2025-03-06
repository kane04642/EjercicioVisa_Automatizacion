package stepsdefinitions.pet;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.http.HttpStatus;
import org.example.models.pet.BodyPet;
import org.example.models.pet.Category;
import org.example.models.pet.Tag;
import org.example.questions.StatusResponse;
import org.example.tasks.pet.PutPet;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class StepsPutPets {
    @When("Daniel consumes the pet update service {string} {string} {string}{string}{string}{string}{string}")
    public void danielConsumesThePetUpdateService(String id, String name, String id_category, String name_category, String id_tag, String name_tag, String status) {
        OnStage.theActorCalled("actorCloud").describedAs(("Daniel can create a new pet"));
        List<String> photoUrls = Arrays.asList("string");
        // Crear el objeto Tag
        Tag tag = new Tag();
        tag.setId(Integer.parseInt(id_tag));
        tag.setName(name_tag);
        // Lista de tags
        List<Tag> tags = Arrays.asList(tag);

        // Crear el objeto Category
        Category category = new Category();
        category.setId(Integer.parseInt(id_category));
        category.setName(name_category);

        BodyPet body =new BodyPet();
        body.setId(Integer.parseInt(id));
        body.setName(name);
        body.setCategory(category);
        body.setPhotoUrls(photoUrls);
        body.setTags(tags);
        body.setStatus(status);

        OnStage.theActorInTheSpotlight().attemptsTo(
                PutPet.putPet(body)
        );
    }

    @Then("Daniel should see the successful update of a new pet")
    public void danielShouldSeeTheSuccessfulUpdateOfANewPet() {
        OnStage.theActorCalled("actorCloud").describedAs(("Daniel puede consultar"));
        OnStage.theActorInTheSpotlight().should(
                seeThat(new StatusResponse(), equalTo(HttpStatus.SC_OK))
        );
    }
}
