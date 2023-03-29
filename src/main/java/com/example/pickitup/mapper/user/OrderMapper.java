package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
//    주문 전체 리스트
    public List<OrderVO> getList(Criteria criteria);
//    주문 등록
    public void insert(OrderVO orderVO);

//    주문한 내용 보여주기, 가격, 상품명 등등
    public OrderVO getDetail(@Param("userNum")Long userNum, @Param("productNum")Long productNum);

//    주문 취소
    public boolean delete(Long num);

//
    public int countOrder();
    public int countProductOrder(@Param("productNum") Long productNum);

    public List<OrderVO> boughtItem(Long userNum);






}


