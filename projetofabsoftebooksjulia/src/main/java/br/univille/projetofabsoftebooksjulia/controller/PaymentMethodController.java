package br.univille.projetofabsoftebooksjulia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.univille.projetofabsoftebooksjulia.entity.PaymentMethod;
import br.univille.projetofabsoftebooksjulia.repository.PaymentMethodRepository;
@RestController
@RequestMapping("/api/v1/users")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodRepository repository;

    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getPaymentMethods() {
        var paymentMethods = repository.findAll();
        return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentMethod> postPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return ResponseEntity.badRequest().build();
        }
        var savedPaymentMethod = repository.save(paymentMethod);
        return new ResponseEntity<>(savedPaymentMethod, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> putPaymentMethod(@PathVariable long id, @RequestBody PaymentMethod paymentMethod) {
        if (id <= 0 || paymentMethod == null) {
            return ResponseEntity.badRequest().build();
        }
        var existingPaymentMethod = repository.findById(id);
        if (existingPaymentMethod.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var paymentMethodToUpdate = existingPaymentMethod.get();
        paymentMethodToUpdate.setType(paymentMethod.getType());
        var updatedPaymentMethod = repository.save(paymentMethodToUpdate);
        return new ResponseEntity<>(updatedPaymentMethod, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentMethod> deletePaymentMethod(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var paymentMethodToDelete = repository.findById(id);
        if (paymentMethodToDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return new ResponseEntity<>(paymentMethodToDelete.get(), HttpStatus.OK);
    }
}