package mg.esakafo.taas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateOrderDto {
    private String clientName;
    private String contact;
    private String address;
    private String dish;
    private Long quantity;
}
