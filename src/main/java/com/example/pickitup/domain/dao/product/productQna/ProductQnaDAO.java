package com.example.pickitup.domain.dao.product.productQna;

import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.mapper.product.productQna.ProductQnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProductQnaDAO {

    private  final ProductQnaMapper productQnaMapper;

    // QnA 전체 목록
    public List<ProductQnaVO> getList(Long productNum){
        return productQnaMapper.getList(productNum);
    }

    // QnA 상세보기 --> productNum 이 아니라 Num을 가져와야하는거아님?
    public ProductQnaVO read(Long num){
        return productQnaMapper.getDetail(num);
    }


    // QnA 등록
    public void register(ProductQnaVO productQnaVO){
        productQnaMapper.insert(productQnaVO);
    }

    // QnA 수정
    public boolean update(ProductQnaVO productQnaVO){
        return productQnaMapper.update(productQnaVO);
    }

    // QnA 삭제
    public boolean remove(Long num){
        return productQnaMapper.delete(num);
    }



}
