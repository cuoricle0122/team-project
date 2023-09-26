package org.teamproject.hotelreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teamproject.hotelreservation.entities.Configs;

public interface ConfigsRepository extends JpaRepository<Configs, String> {
}