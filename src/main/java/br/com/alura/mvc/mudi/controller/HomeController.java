package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public HomeController(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("orders", purchaseOrderRepository.findAll());
        return "home";
    }
}
