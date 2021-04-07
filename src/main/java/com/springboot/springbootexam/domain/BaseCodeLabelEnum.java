package com.springboot.springbootexam.domain;

/** 기본 CodeLabelEnum
 * @author : swd
* */
public interface BaseCodeLabelEnum {
    
    /** 코드 리턴.
     * @author : swd
     * @create_at : 2021-04-08
     * @update_at : -
     * @return String
     * */
    String code();

    /** 라벨(코드명)을 리턴.
     * @author : swd
     * @create_at : 2021-04-08
     * @update_at : -
     * @return String
     * */
    String label();
    
}
