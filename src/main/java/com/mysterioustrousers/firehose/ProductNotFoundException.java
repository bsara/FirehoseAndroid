package com.mysterioustrousers.firehose;



public class ProductNotFoundException extends Exception {

  private Product _product;



  public ProductNotFoundException(Product product) {
    super();

    if (product == null) {
      throw new IllegalArgumentException("product cannot be null!");
    }

    _product = product;
  }


  public Product getProduct() {
    return _product;
  }


  @Override
  public String getMessage() {
    return String.format("The product '%s' with ID of '%d' could not be found!", _product.getName(), _product.getId());
  }
}