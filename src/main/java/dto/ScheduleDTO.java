package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.DistributionCenter;
import model.Order;
import model.Resource;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    private DistributionCenter distributionCenter;
    private Order[] orders;
    private Resource resource;

}
