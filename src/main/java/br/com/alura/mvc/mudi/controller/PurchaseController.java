package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.CreatePurchase;
import br.com.alura.mvc.mudi.model.PurchaseOrder;
import br.com.alura.mvc.mudi.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("purchase")
public class PurchaseController {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseController(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @GetMapping("form")
    public String getPurchaseForm(CreatePurchase createPurchase) {
        return "purchase/form";
    }

    @PostMapping("new")
    public String createPurchase(@Valid CreatePurchase newProduct, BindingResult result) {
        if(result.hasErrors()) {
            return "purchase/form";
        }

        PurchaseOrder purchaseOrder = newProduct.toPurchaseOrder();
        purchaseOrderRepository.save(purchaseOrder);

        return "home";
    }


}
