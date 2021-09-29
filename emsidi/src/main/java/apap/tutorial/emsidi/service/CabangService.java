package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.List;

public interface CabangService {
    void addCabang(CabangModel cabang);
    boolean updateCabang(CabangModel cabang);
    List<CabangModel> getCabangList();
    List<CabangModel> getSortedCabangList();
    CabangModel getCabangByNoCabang(Long noCabang);
    CabangModel getCabangByNamaCabang(String namaCabang);
    boolean deleteCabang(CabangModel cabang);
}
