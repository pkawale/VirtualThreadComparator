package com.example.virtual_thread.repo;


import com.example.virtual_thread.data.MessageTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageTableRepository extends JpaRepository<MessageTable, Long> {
}
