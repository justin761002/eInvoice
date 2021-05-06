package com.justin761002.invoice.persistence.repository;

import com.justin761002.invoice.persistence.model.WinningListEntity;
import org.springframework.data.repository.CrudRepository;

public interface WinningListRepository extends CrudRepository<WinningListEntity, String> {
}
