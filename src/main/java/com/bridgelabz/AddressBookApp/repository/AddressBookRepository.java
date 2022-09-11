package com.bridgelabz.AddressBookApp.repository;

import com.bridgelabz.AddressBookApp.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<ContactData, Integer> {
    @Query(value = "SELECT * FROM contact_data e WHERE e.name = :name", nativeQuery = true)
    List<ContactData> findUsingName(@Param("name") String name);

}
