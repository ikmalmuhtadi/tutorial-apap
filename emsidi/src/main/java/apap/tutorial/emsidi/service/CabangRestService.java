package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;

import java.util.List;

import apap.tutorial.emsidi.rest.CabangDetail;
import reactor.core.publisher.*;

public interface CabangRestService {
    CabangModel createCabang(CabangModel cabang);
    List<CabangModel> retrieveListCabang();
    CabangModel getCabangByNoCabang(Long noCabang);
    CabangModel updateCabang(Long noCabang, CabangModel cabangUpdate);
    void deleteCabang(Long noCabang);
    Mono<String> getStatus(Long noCabang);
    Mono<CabangDetail> postStatus();
}
