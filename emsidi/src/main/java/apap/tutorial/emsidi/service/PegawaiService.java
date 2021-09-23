package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);

    boolean updatePegawai(PegawaiModel pegawai);

    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);

    boolean deletePegawai(PegawaiModel pegawai);
}
