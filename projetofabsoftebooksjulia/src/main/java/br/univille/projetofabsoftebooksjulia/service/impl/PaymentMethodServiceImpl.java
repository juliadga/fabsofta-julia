package br.univille.projetofabsoftebooksjulia.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projetofabsoftebooksjulia.entity.PaymentMethod;
import br.univille.projetofabsoftebooksjulia.entity.User;
import br.univille.projetofabsoftebooksjulia.repository.PaymentMethodRepository;
import br.univille.projetofabsoftebooksjulia.service.PaymentMethodService;
@SuppressWarnings("unused")
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository repository;
    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }
    @Override
    public List<PaymentMethod> getAll() {
        return repository.findAll();
    }
    @Override
    public PaymentMethod getById(long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}