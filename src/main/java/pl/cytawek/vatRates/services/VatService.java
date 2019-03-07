package pl.cytawek.vatRates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.cytawek.vatRates.dtos.RateDto;
import pl.cytawek.vatRates.dtos.VatDto;
import pl.cytawek.vatRates.entieties.VatEntity;
import pl.cytawek.vatRates.mappers.VatDtoToVatEntity;
import pl.cytawek.vatRates.repositories.VatRepositories;

@Service
public class VatService {

    final VatRepositories vatRepositories;

    @Autowired
    public VatService(VatRepositories vatRepositories) {
        this.vatRepositories = vatRepositories;
    }

    public boolean saveVat (VatDto vatDto){
        VatEntity vatEntity = VatDtoToVatEntity.convert(vatDto);
        return vatRepositories.save(vatEntity) != null;
    }

    public VatDto getCurrentVat (){
        RestTemplate restTemplate = getRestTemplate();
        VatDto vatDto = restTemplate.getForObject("https://jsonvat.com/", VatDto.class);
        saveVat(vatDto);
        return vatDto;
    }

    public int compareCountryCode (VatDto vatDto, String cityCodeFromUser){
        for (int i = 0; i <vatDto.getRate().size() ; i++) {
            if(cityCodeFromUser.equals(vatDto.getRate().get(i).getCode()))
                return i;
            /// TODO: 17.02.2019 nie powinniśmy zwracać tu 0
        }
        return 0;
    }


    public RateDto getCountryName (String countryCode){
        if(!countryCode.equals(getCountryName(countryCode))){
            return null;
        }
        return getCountryName(countryCode);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
