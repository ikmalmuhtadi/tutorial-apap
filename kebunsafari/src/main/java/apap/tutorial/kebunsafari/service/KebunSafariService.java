package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import java.util.List;

public interface KebunSafariService {
    //method untuk menambahkan KebunSafari baru
    void addKebunSafari(KebunSafariModel kebunSafari);

    //method untuk mendapatkan seluruh daftar kebunSafari
    List<KebunSafariModel> getKebunSafariList();

    //method untuk mendapatkan data sebuah KebunSafari berdasarkan ID yang dimiliki
    KebunSafariModel getKebunSafariByIdKebunSafari (String idKebunSafari);

    String updateNomorTeleponById(String idKebunSafari, String noTelepon);

    String deleteKebunSafariById(String idKebunSafari);

}
