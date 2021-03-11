package p1.phone.service;

import p1.phone.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    void remove(Integer id);
}
