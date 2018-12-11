package guru.springframework.petclinic.model;

import java.io.Serializable;

/**
 * Created by @kmartin62
 */
public class BaseEntitiy implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
