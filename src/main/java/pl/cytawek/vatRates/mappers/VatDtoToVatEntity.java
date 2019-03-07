package pl.cytawek.vatRates.mappers;

import pl.cytawek.vatRates.dtos.VatDto;
import pl.cytawek.vatRates.entieties.VatEntity;

import javax.swing.text.html.parser.Entity;

public class VatDtoToVatEntity {
    public static VatEntity convert (VatDto vatDto){
        VatEntity vatEntity = new VatEntity();
        vatEntity.setCountryName(vatDto.getRate().get(0).getName());
        vatEntity.setCountryCode(vatDto.getRate().get(0).getCode());
        vatEntity.setParking((Double) vatDto.getRate().get(0).getPeriodDtos().get(0).getAdditionalProperties().get("parking"));
        vatEntity.setSuperReduced((Double) vatDto.getRate().get(0).getPeriodDtos().get(0).getAdditionalProperties().get("super_reduced"));
        vatEntity.setReduced1((Double) vatDto.getRate().get(0).getPeriodDtos().get(0).getAdditionalProperties().get("reduced1"));
        vatEntity.setReduced2((Double) vatDto.getRate().get(0).getPeriodDtos().get(0).getAdditionalProperties().get("reduced2"));
        vatEntity.setStandard((Double) vatDto.getRate().get(0).getPeriodDtos().get(0).getAdditionalProperties().get("standard"));
        vatEntity.getReduced((Double) vatDto.getRate().get(i).getPeriodDtos().get(0).getRatesDto().getReduced().get("reduced"));
        return vatEntity;
    }

}
