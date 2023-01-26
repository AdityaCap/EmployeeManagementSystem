package com.employeems.api.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.api.Data.ProductOwnerRepo;
import com.employeems.api.Service.ProductOwnerService;
import com.employeems.api.model.ProductOwner;

@RestController
@RequestMapping("/api/productOwner")
public class ProductOwnerController {

	@Autowired
	private ProductOwnerService productOwnerService;

	@Autowired
	private ProductOwnerRepo productOwnerRepo;

	@PostMapping("/add")

	/*
	 * public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
	 * employeeService.addEmployee(employee); return
	 * ResponseEntity.status(HttpStatus.OK).body("Employee Added"); }
	 * 
	 */

	public ResponseEntity<String> addProductOwner(@RequestBody ProductOwner productOwner) {

		productOwnerService.addProductOwner(productOwner);

		return ResponseEntity.status(HttpStatus.OK).body("ProductOwner Added");
	}

	@GetMapping("/getall")
	public List<ProductOwner> getAllProductOwner() {
		List<ProductOwner> list = productOwnerService.getAll();
		return list;
	}

	@PostMapping("/one/{po_id}")
	public ResponseEntity<Object> getProductOwnerById(@PathVariable("po_id") int po_id) {
		Optional<ProductOwner> optional = productOwnerService.getById(po_id);
		if (!optional.isPresent()) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		}
		ProductOwner productOwner = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(productOwner);
	}

	@DeleteMapping("/delete/{po_id}")
	public void deleteProductOwner(@PathVariable("po_id") int po_id) {
		productOwnerService.deleteProductOwnerById(po_id);
		System.out.println("ProductOwner Deleted Successfully");
	}

//	@PutMapping("/update/{po_id}")
//	public ResponseEntity<ProductOwner> updateProductOwner(@PathVariable int po_id,@RequestBody ProductOwner productOwner) {
//		Object productOwnerRepo;
//		ProductOwner updateProductOwner = ((Object) productOwnerRepo).getById(po_id)
//                .orElseThrow(() -> new ResourceNotFoundException("ProductOwner not exist with id: " + po_id));
//
//        
//
//        ((CrudRepository<ProductOwner, Integer>) productOwnerRepo).save(updateProductOwner);
//
//        return ResponseEntity.ok(updateProductOwner);

	@PutMapping("/edit/{po_id}")
	public ResponseEntity<String> editProductOwner(@PathVariable("po_id") int po_id,
			@RequestBody ProductOwner productOwnerNew) {
		/* Step 1: check if this id given is valid by fetching the record from DB */
		Optional<ProductOwner> optional = productOwnerService.getById(po_id);

		if (!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
		}

		ProductOwner productOwnerDB = optional.get(); // User given employee value

		/* Step 2: Set New value to DB value */

		if (productOwnerNew.getPo_name() != null)
			productOwnerDB.setPo_name(productOwnerNew.getPo_name());
		if (productOwnerNew.getPo_city() != null)
			productOwnerDB.setPo_city(productOwnerNew.getPo_city());

		/* Save updated employeeDB value in DB */
		productOwnerService.addProductOwner(productOwnerDB);
		return ResponseEntity.status(HttpStatus.OK).body("ProductOwner record Updated..");

	}
}
