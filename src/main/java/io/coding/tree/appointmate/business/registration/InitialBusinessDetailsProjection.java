package io.coding.tree.appointmate.business.registration;

import io.coding.tree.appointmate.business.Business;
import io.coding.tree.appointmate.business.BusinessId;
import io.coding.tree.appointmate.common.EmailAddress;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

public record InitialBusinessDetailsProjection(BusinessId businessId, EmailAddress email, String businessName,
                                               Optional<String> businessURLsuffix) {

    @Mapper(componentModel = ComponentModel.SPRING)
    public interface InitialBusinessDetailsMapper {

        @Mapping(target = "version", ignore = true)
        @Mapping(target = "phoneNumber", ignore = true)
        @Mapping(target = "businessHours", ignore = true)
        @Mapping(target = "staff", ignore = true)
        @Mapping(target = "serviceOfferings", ignore = true)
        @Mapping(target = "auditMetadata", ignore = true)
        Business toBusiness(InitialBusinessDetailsProjection initialBusinessDetailsProjection);
    }
}
