package com.example.library.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }

    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }

}
