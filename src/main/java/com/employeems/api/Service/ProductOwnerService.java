package com.employeems.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.api.Data.ProductOwnerRepo;
import com.employeems.api.model.ProductOwner;

@Service
public class ProductOwnerService {
	@Autowired
    private  ProductOwnerRepo productOwnerRepo;
    public   void addProductOwner(ProductOwner productOwner) 
    {
    	productOwnerRepo.save(productOwner);
    }
    public  List<ProductOwner> getAll() 
    {	        
    	return productOwnerRepo.findAll();
    }
	//public Object getAllProductOwner() {
		// TODO Auto-generated method stub
		//productOwnerRepo List<ProductOwner> list = productOwnerService.getAllProductOwner();
	//	return list;
	//}
	public List<ProductOwner> getAllProductOwner() {
		// TODO Auto-generated method stub
		return null;
	}
	public Optional<ProductOwner> getById(int id) {
		Optional<ProductOwner> optional=productOwnerRepo.findById(id);
		if(optional==null)
			return null;
		return optional;
	}
	
	public void deleteProductOwnerById(int po_id) 
	{			
		productOwnerRepo.deleteById(po_id);			
	}

}

