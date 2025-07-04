package com.aftab.ProductService.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aftab.ProductService.dtos.FakeStoreRequestDto;
import com.aftab.ProductService.dtos.FakeStoreResponseDto;
import com.aftab.ProductService.exceptions.ProductNotFoundException;
import com.aftab.ProductService.models.Product;

@Service
public class FakeStoreProductService implements ProductService {
    
    RestTemplate restTemplate;

    /**
     * Constructor for FakeStoreProductService.
     *
     * @param restTemplate the RestTemplate to be used for making HTTP requests
     */
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductById(long id) throws ProductNotFoundException {
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreResponseDto responseDto =
        restTemplate.getForObject(url,FakeStoreResponseDto.class);

        if(responseDto == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return responseDto != null ? responseDto.toProduct() : null;
      
    }

    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        FakeStoreResponseDto[] responseDtos =
            restTemplate.getForObject(url, FakeStoreResponseDto[].class);

        if (responseDtos == null) {
            return List.of();
        }

        return Arrays.stream(responseDtos)
                     .map(FakeStoreResponseDto::toProduct)
                     .collect(Collectors.toList());
    }

    public Product createProduct(Product product) {
      
        FakeStoreRequestDto fakeStoreRequestDto = new FakeStoreRequestDto(product);
        

      FakeStoreResponseDto fakeStoreResponseDto =  restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreRequestDto, FakeStoreResponseDto.class);
        return fakeStoreResponseDto.toProduct(); // Placeholder return statement
    }

    public Product updateProduct(long id, Product product) throws ProductNotFoundException {
        FakeStoreRequestDto updatedFakeStoreRequestDto = new FakeStoreRequestDto(product);
        
       HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<FakeStoreRequestDto> requestEntity =
                new HttpEntity<>(updatedFakeStoreRequestDto, headers);

        ResponseEntity<FakeStoreResponseDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestEntity,
                FakeStoreResponseDto.class
        );

        return responseEntity.getBody().toProduct();
    }

    

}
