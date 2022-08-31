package mg.esakafo.taas.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mg.esakafo.taas.model.statusOrder.StatusOrder;

@AllArgsConstructor
@Getter
@Setter
public class UpdateOrderDto {
    private String clientName;
    private String contact;
    private String address;
    private Long dish;
    private Long quantity;
    @Enumerated(EnumType.STRING)
    private StatusOrder status;
}
