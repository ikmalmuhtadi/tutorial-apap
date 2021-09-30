package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import apap.tutorial.emsidi.service.PegawaiService;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CabangController {
    private int counterBaris;
    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Qualifier("menuServiceImpl")
    @Autowired
    MenuService menuService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model){
        counterBaris = 1;
        List<MenuModel> listMenu = menuService.getListMenu();
        model.addAttribute("cabang", new CabangModel());
        model.addAttribute("listMenu", listMenu);
        model.addAttribute("counter", counterBaris);
        return "form-add-cabang";
    }

    @GetMapping("/cabang/add/tambah-baris")
    public String addCabangFormTambahBaris(
            @ModelAttribute CabangModel cabang,
            Model model) {
        List<MenuModel> listMenu = menuService.getListMenu();
        model.addAttribute("listMenu", listMenu);
        model.addAttribute("counter", counterBaris += 1);
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @GetMapping("/cabang/add/delete-baris")
    public String addCabangFormDeleteBaris(
            @ModelAttribute CabangModel cabang,
            Model model) {
        List<MenuModel> listMenu = menuService.getListMenu();
        model.addAttribute("listMenu", listMenu);
        model.addAttribute("counter", counterBaris -= 1);
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangForm(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang= cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/viewall-sorted")
    public String listCabangSorted(Model model){
        List<CabangModel> listCabangSorted= cabangService.getSortedCabangList();
        model.addAttribute("listCabangSorted", listCabangSorted);
        return "viewall-cabang-sorted";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ){
        CabangModel cabang=cabangService.getCabangByNoCabang(noCabang);

        List<PegawaiModel> listPegawai= cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        return "view-cabang";
    }
    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute( "cabang", cabang);
        return "form-update-cabang" ;
    }
    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.updateCabang(cabang);
        model.addAttribute( "noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @GetMapping("/cabang/delete/{noCabang}")
    public String deleteCabang(
            @PathVariable Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        boolean flagDelete = cabangService.deleteCabang(cabang);

        if(flagDelete == true) {
            model.addAttribute("noCabang", cabang.getNoCabang());
            return "delete-cabang";
        }
        return "error";
    }

}