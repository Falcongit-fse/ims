package com.inventory.inventory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.inventory.ProductApplication;
import com.inventory.controller.ProductController;
import com.inventory.entity.Product;
import com.inventory.service.MyUserDetailsService;
import com.inventory.service.ProductService;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes=ProductApplication.class)

public class InventoryApplicationTests {	
	@InjectMocks
	ProductController controller;
    @Mock
    ProductService service;
    
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getAllProductsTest() {
    	Product product1=new Product(1,"Iphone","Finished Product",20,60000.0d,20);
    	Product product2=new Product(2,"Samusung","Finished Product",1,60000.0d,0);
    	List<Product> productList=new ArrayList<Product>();
    	productList.add(product1);
        productList.add(product2);
    	when(service.getAllProducts()).thenReturn(productList);
    	assertEquals(2, controller.getAllProducts().size());
    }
    @Test
    public void getProductByIdTest() {
    	Product product=new Product(1,"Iphone","Finished Product",20,60000.0d,20);
    	//System.out.println("service="+service);
    	when(service.getProductById(product.getProductId())).thenReturn(product);
    	//System.out.println("controller="+controller);
    	
    	Product actualProduct=controller.getProductById(product.getProductId());
    	//System.out.println("actualProduct=>"+actualProduct);
    	assertEquals(product.getProductName(), actualProduct.getProductName());
    }
    @Test
    public void createProductTest() {
    	Product product=new Product(2,"IPad","Finished Product",1,60000.0d,0);
    	ResponseEntity<String> responseEntity = new ResponseEntity<String>("Product stored successfully!!", HttpStatus.CREATED);
    	when(service.createProduct(product)).thenReturn(responseEntity);
    	ResponseEntity<String> result = controller.createProduct(product);
    	assertEquals("Product stored successfully!!", result.getBody());
    }
    @Test
    public void updateProductTest() {
    	Product product=new Product(2,"IPad","Finished Product",2,60000.0d,0);
    	ResponseEntity<String> responseEntity = new ResponseEntity<String>("Product updated successfully!!", HttpStatus.OK);
    	when(service.updateProduct(product)).thenReturn(responseEntity);
    	ResponseEntity<String> result = controller.updateProduct(product);
    	assertEquals("Product updated successfully!!", result.getBody());
    }
    @Test
    public void deleteProductTest() {
    	Product product=new Product(13,"IPad","Finished Product",2,60000.0d,0);
    	ResponseEntity<String> responseEntity = new ResponseEntity<String>("Product deleted successfully!!", HttpStatus.OK);
    	when(service.deleteProduct(product.getProductId())).thenReturn(responseEntity);
    	ResponseEntity<String> result = controller.deleteProduct(product.getProductId());
    	assertEquals("Product deleted successfully!!", result.getBody());
    }
    @Test
    public void loadUserByUsernameTest() {
    	User user = new User("susmitha", "susmitha123", new ArrayList<>());
    	MyUserDetailsService userService=new MyUserDetailsService();
    	UserDetails userDetails=userService.loadUserByUsername("susmitha");
    	assertEquals(userDetails, user);
    	
    }
    
    @Test
    public void getProductIdTest() {           
        Integer productId=1;
        Product product=new Product();
        product.setProductId(productId);
        assertEquals(product.getProductId(), productId);
    }
    @Test
    public void getProductNameTest() {           
        String productName="Mobile";
        Product product=new Product();
        product.setProductName(productName);;
        assertEquals(product.getProductName(), productName);
    }
    @Test
    public void getProductTypeTest() {           
        String productType="Finished Product";
        Product product=new Product();
        product.setProductType(productType);
        assertEquals(product.getProductType(), productType);
    }
    @Test
    public void getProductQuantityTest() {           
        Integer productQuantity=10;
        Product product=new Product();
        product.setProductQuantity(productQuantity);;
        assertEquals(product.getProductQuantity(), productQuantity);
    }
    @Test
    public void getProductPriceTest() {           
        Double productPrice=10000.0;
        Product product=new Product();
        product.setProductPrice(productPrice);
        assertEquals(product.getProductPrice(), productPrice);
    }
    @Test
    public void getProductSoldTest() {           
        Integer productSold=10;
        Product product=new Product();
        product.setProductsSold(productSold);
        assertEquals(product.getProductsSold(), productSold);
    }

}
