package mg.esakafo.taas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateDishDto {
    private String name;
    private Float price;
    private Long category;
    private Long orderNumber;
    private Long quantity;
}
