package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService {
    private List<KebunSafariModel> listKebunSafari;

    //constructor
    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari) {
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList() {
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari) {
        if (idKebunSafari != null) {
            for (int i = 0; i < listKebunSafari.size(); i++) {
                KebunSafariModel temp1  = listKebunSafari.get(i);
                if(temp1.getIdKebunSafari().equals(idKebunSafari)) {
                    return temp1;
                }
            }
        }
        return null;
    }

    @Override
    public String updateNomorTeleponById(String idKebunSafari, String noTelepon) {
        if(idKebunSafari != null) {
            for (int i = 0; i < listKebunSafari.size(); i++) {
                KebunSafariModel temp = listKebunSafari.get(i);
                if (temp.getIdKebunSafari().equals(idKebunSafari)) {
                    temp.setNoTelepon(noTelepon);
                    return temp.getIdKebunSafari();
                }
            }
        }
        return null;
    }

    @Override
    public String deleteKebunSafariById(String idKebunSafari) {
        if(idKebunSafari != null) {
            for (int i = 0; i < listKebunSafari.size(); i++) {
                KebunSafariModel temp = listKebunSafari.get(i);
                if (temp.getIdKebunSafari().equals(idKebunSafari)) {
                    listKebunSafari.remove(i);
                    return idKebunSafari;
                }
            }
        }
        return null;
    }
}
