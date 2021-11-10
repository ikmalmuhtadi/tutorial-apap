package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


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


    @PostMapping(value = "/cabang/add", params = {"addRow"})
    public String addCabangTambahBaris(
            @ModelAttribute CabangModel cabang,
            BindingResult bindingResult,
            Model model
    ){
        List<MenuModel> listMenu = menuService.getListMenu();
        if(cabang.getListMenu()==null){
            cabang.setListMenu(new ArrayList<MenuModel>());
        }
        List<MenuModel> listMenuRow = cabang.getListMenu();
        listMenuRow.add(new MenuModel());
        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenu", listMenu);
        return "form-add-cabang";
    }

    @RequestMapping(value = "/cabang/add", method = RequestMethod.POST, params = {"deleteRow"})
    public String addMenuCabangDeleteBaris(
            @ModelAttribute CabangModel cabang,
            final BindingResult bindingResult,
            Model model,
            final HttpServletRequest request
    ){

        List<MenuModel> listMenu = menuService.getListMenu();

        final Integer numRow = Integer.valueOf(request.getParameter("deleteRow"));
        cabang.getListMenu().remove(numRow.intValue());
        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenu", listMenu);
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