package stepsdefinitions.pet;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.tasks.pet.DeletePet;

public class StepsDeletePets {

    @When("Daniel consumes the pet delete service {string}")
    public void danielConsumesThePetDeleteService(String idPet) {
        OnStage.theActorCalled("actorCloud").describedAs(("Daniel can create a new pet"));
        OnStage.theActorInTheSpotlight().attemptsTo(
                DeletePet.deletePet(idPet)
        );
    }
}
