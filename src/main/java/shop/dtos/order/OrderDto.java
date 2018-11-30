package shop.dtos.order;

import shop.dtos.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDto implements DTO {
    @NotEmpty
    private String address;
    @NotNull
    private List<IdQuantityDto> quantities;



    public OrderDto() {
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<IdQuantityDto> getQuantities() {
        return quantities;
    }
    public void setQuantities(List<IdQuantityDto> quantities) {
        this.quantities = quantities;
    }
    public Map<Integer, Integer> getMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for(IdQuantityDto pair : this.quantities) {
            map.put(pair.getId(), pair.getQuantity());
        }
        return map;
    }
}
