package com.hackathon.aasp.repository;

import com.hackathon.aasp.model.Profissional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfissionalRepository extends MongoRepository<Profissional, String> {
}
