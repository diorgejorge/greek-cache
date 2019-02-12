package bean;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

import static java.util.Objects.requireNonNull;

@Builder
@Entity
@NoArgsConstructor
@ToString
public class Cache implements Serializable {
    @Id
    private String key;
    private String value;

    @JsonbCreator
    public Cache(@JsonbProperty("key") String key,@JsonbProperty("value") String value){
        this.key = requireNonNull(key,"key is required");
        this.value = requireNonNull(value);
    }
}
