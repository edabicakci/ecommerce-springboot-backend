package com.godoro.spring.enums;


public enum CartStatus {
    NEW(1, "new"),
    COMPLETED(2, "completed");
  
    private int number ;
    private String name;

   

    private CartStatus(int number, String name) {
        this.number = number;
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
      
}
