package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.List;

import apap.tutorial.emsidi.rest.PegawaiDetail;
import reactor.core.publisher.*;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);
    List<PegawaiModel> retrieveListPegawai();
    PegawaiModel  getPegawaiByNoPegawai(Long noPegawai);
    PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate);
    void deletePegawai(Long noPegawai);
//    PegawaiModel prediksiUmurByNama(Long noPegawai);
    PegawaiModel getUmurPegawai(Long noPegawai);
    List<PegawaiModel> retrieveListPegawaibyJenisKelamin(int jenisKelamin);
//    Mono<PegawaiDetail> postStatus();
}
