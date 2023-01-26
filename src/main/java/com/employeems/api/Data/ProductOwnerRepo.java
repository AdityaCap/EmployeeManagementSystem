package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;



import com.employeems.api.model.ProductOwner;

public interface ProductOwnerRepo extends JpaRepository<ProductOwner,Integer> {

}

