package mg.esakafo.taas.mapper.Rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class RestOrder {
    private Long id;
    private String ref;
    private String category;
    private String dish;
    private Long quantity;
    private String clientName;
    private String contact;
    private String address;
    private String orderDate;
    private String status;
}
