package br.univille.projetofabsoftebooksjulia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.projetofabsoftebooksjulia.entity.PaymentMethod;
import br.univille.projetofabsoftebooksjulia.service.PaymentMethodService;
@RestController
@RequestMapping("/api/v1/paymentMethods")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService service;

    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getPaymentMethods(){
        var listaPaymentMethods = service.getAll();
        return new ResponseEntity<List<PaymentMethod>>(listaPaymentMethods, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentMethod> postPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return ResponseEntity.badRequest().build();
        }
        if(paymentMethod.getId() == 0){
            service.save(paymentMethod);
            return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> putPaymentMethod(@PathVariable long id, @RequestBody PaymentMethod paymentMethod) {
        if (id <= 0 || paymentMethod == null) {
            return ResponseEntity.badRequest().build();
        }
        var paymentMethodAntigo = service.getById(id);
        if (paymentMethodAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        paymentMethodAntigo.setType(paymentMethod.getType());
        service.save(paymentMethodAntigo);
        return new ResponseEntity<PaymentMethod>(paymentMethodAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentMethod> deletePaymentMethod(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var paymentMethodExcluir = service.getById(id);
        if(paymentMethodExcluir == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<PaymentMethod>(paymentMethodExcluir, HttpStatus.OK);
    }
}