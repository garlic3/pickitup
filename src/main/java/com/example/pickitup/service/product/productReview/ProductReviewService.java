package com.example.pickitup.service.product.productReview;

import com.example.pickitup.domain.dao.product.productReview.ProductReviewDAO;
import com.example.pickitup.domain.dao.product.productReview.ProductReviewFileDAO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductReviewService {

    private final ProductReviewDAO productReviewDAO;
    private final ProductReviewFileDAO productReviewFileDAO;

    // 리뷰 리스트 -> 수정
    public List<ProductReviewVO> getList(Long productNum){
        return productReviewDAO.getList(productNum);
    }

    // 리뷰 상세보기 -> 수정
//    public ProductReviewVO read(Long num){
//        return productReviewDAO.read(num);
//    }

    // 리뷰 작성하기
    @Transactional(rollbackFor = Exception.class)
    public void insert(ProductReviewVO productReviewVO){
        productReviewDAO.insert(productReviewVO);
        if(productReviewVO.getFileList() != null) {
            productReviewVO.getFileList().forEach(productReviewFileVO -> {
                productReviewFileVO.setProductReviewNum(productReviewVO.getProductNum());
                productReviewFileDAO.register(productReviewFileVO);
            });
        }
    }

    // 리뷰 수정하기
    public boolean update(ProductReviewVO productReviewVO){
        return productReviewDAO.update(productReviewVO);
    }

    // 리뷰 삭제하기
    public boolean delete(Long num){
        return productReviewDAO.remove(num);
    }


    //리뷰 갯수
    public int count(Long productNum){
        return productReviewDAO.count(productNum);
    }

}
