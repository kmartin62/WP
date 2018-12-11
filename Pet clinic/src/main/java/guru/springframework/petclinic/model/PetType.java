package guru.springframework.petclinic.model;

/**
 * Created by @kmartin62
 */
public class PetType extends BaseEntitiy{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
