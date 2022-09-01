package mg.esakafo.taas.mapper.Rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class RestDish {
    private Long id;
    private String name;
    private Float price;
    private String category;
    private Long orderNumber;
    private Long quantity;
    private String url;
}
