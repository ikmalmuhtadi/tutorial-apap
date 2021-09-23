package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.List;

public interface CabangService {
    void addCabang(CabangModel cabang);
    void updateCabang(CabangModel cabang);
    List<CabangModel> getCabangList();
    List<CabangModel> getSortedCabangList();
    CabangModel getCabangByNoCabang(Long noCabang);
    boolean deleteCabang(CabangModel cabang);
}
