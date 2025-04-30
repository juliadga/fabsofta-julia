package br.univille.projetofabsoftebooksjulia.service;
import java.util.List;
import br.univille.projetofabsoftebooksjulia.entity.PaymentMethod;
import br.univille.projetofabsoftebooksjulia.entity.User;
@SuppressWarnings("unused")
public interface PaymentMethodService {
List<PaymentMethod> getAll();
    PaymentMethod getById(long id);
    void delete(long id);
    PaymentMethod save(PaymentMethod paymentMethod);
}